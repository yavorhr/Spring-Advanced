package bg.softuni.hateoas.repository;

import bg.softuni.hateoas.model.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping
public interface StudentsRepository extends JpaRepository<StudentEntity, Long> {

}
