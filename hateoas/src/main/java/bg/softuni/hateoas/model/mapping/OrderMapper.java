package bg.softuni.hateoas.model.mapping;

import bg.softuni.hateoas.model.dto.OrderDTO;
import bg.softuni.hateoas.model.entity.OrderEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrderMapper {
    default OrderDTO mapEntityToDTO(OrderEntity order) {

        if ( order == null ) {
            return null;
        }

        OrderDTO orderDto = new OrderDTO();

        orderDto.setId( order.getId() );
        orderDto.setStudentId(order.getStudent().getId());
        orderDto.setCourseId(order.getCourse().getId());

        return orderDto;
    }
}
