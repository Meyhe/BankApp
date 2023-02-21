package org.bankApp.mapper;

import org.bankApp.dto.CustomerDTO;
import org.bankApp.model.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);

    CustomerDTO customerToCostomerDTO (Customer customer);
}
