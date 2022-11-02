package ssv.com.udemy.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import ssv.com.udemy.domain.Customer;
import ssv.com.udemy.dto.CustomerDTO;

@Mapper
public interface CustomerMapper {

    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);

    CustomerDTO customerToCustomerDTO(Customer customer);

    Customer customerDtoToCustomer(CustomerDTO customerDTO);
}