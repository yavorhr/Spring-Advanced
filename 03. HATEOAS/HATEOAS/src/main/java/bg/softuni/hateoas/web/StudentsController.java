package bg.softuni.hateoas.web;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import bg.softuni.hateoas.model.dto.OrderDTO;
import bg.softuni.hateoas.model.dto.StudentDTO;
import bg.softuni.hateoas.model.entity.OrderEntity;
import bg.softuni.hateoas.model.entity.StudentEntity;
import bg.softuni.hateoas.model.mapping.OrderMapper;
import bg.softuni.hateoas.model.mapping.StudentMapper;
import bg.softuni.hateoas.repository.StudentsRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/students")
@RestController
public class StudentsController {

    private final StudentsRepository studentsRepository;
    private final StudentMapper studentMapper;
    private final OrderMapper orderMapper;

    public StudentsController(StudentsRepository studentsRepository,
                              StudentMapper studentMapper, OrderMapper orderMapper) {
        // WARNING: Normally we never inject repos in the controllers,
        // we do this just for test and fun here.
        this.studentsRepository = studentsRepository;
        this.studentMapper = studentMapper;
        this.orderMapper = orderMapper;
    }

    @GetMapping
    public ResponseEntity<CollectionModel<EntityModel<StudentDTO>>> getStudents() {
        List<EntityModel<StudentDTO>> allStudents = studentsRepository.
                findAll().
                stream().
                map(studentMapper::mapEntityToDTO).
                map(dto -> EntityModel.of(dto, createStudentLinks(dto))).
                collect(Collectors.toList());

        return ResponseEntity.ok(CollectionModel.of(allStudents));
    }

    @GetMapping("/{id}/orders")
    public ResponseEntity<CollectionModel<EntityModel<OrderDTO>>> getOrders(@PathVariable("id") Long id) {
        StudentEntity student = studentsRepository.
                findById(id).orElseThrow();

        List<EntityModel<OrderDTO>> orders = student.
                getOrders().
                stream().

                // map(this::map)
                // change with orderMapper
                        map(orderMapper::mapEntityToDTO).

                map(EntityModel::of).
                collect(Collectors.toList());

        return ResponseEntity.ok(CollectionModel.of(orders));
    }

    private OrderDTO map(OrderEntity order) {
        return new OrderDTO().setId(order.getId()).setStudentId(order.getStudent().getId()).
                setCourseId(order.getCourse().getId());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EntityModel<StudentDTO>> getStudentsByID(@PathVariable("id") Long id) {
        StudentDTO student = studentsRepository.
                findById(id).
                map(studentMapper::mapEntityToDTO).
                orElseThrow();

        return ResponseEntity.ok(
                EntityModel.of(student, createStudentLinks(student))
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<EntityModel<StudentDTO>> update(
            @PathVariable Long id,
            StudentDTO studentDTO) {

        //IMPLEMENTATION NOT IMPORTANT for the demo

        return ResponseEntity.ok().build();
    }

    private Link[] createStudentLinks(StudentDTO studentDTO) {
        List<Link> result = new ArrayList<>();

        Link selfLink = linkTo(methodOn(StudentsController.class).
                getStudentsByID(studentDTO.getId())).withSelfRel();
        result.add(selfLink);

        Link updateLink = linkTo(methodOn(StudentsController.class).
                update(studentDTO.getId(), studentDTO)).withRel("update");
        result.add(updateLink);

        Link orderLink = linkTo(methodOn(StudentsController.class).
                getOrders(studentDTO.getId())).withRel("orders");
        result.add(orderLink);

        return result.toArray(new Link[0]);
    }

}
