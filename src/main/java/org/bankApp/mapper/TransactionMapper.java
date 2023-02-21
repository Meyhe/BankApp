package org.bankApp.mapper;

import org.bankApp.dto.TransactionDTO;
import org.bankApp.model.Transaction;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface TransactionMapper {

    TransactionMapper INSTANCE = Mappers.getMapper(TransactionMapper.class);

    TransactionDTO transactionToTransactionDTO (Transaction transaction);
}
