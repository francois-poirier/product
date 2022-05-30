package com.zara.product.infrastructure.adapter.repository.mapper;

import com.zara.product.domain.Price;
import com.zara.product.service.api.v1.queries.getpricedetails.GetPriceDetailsQueryResult;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PriceMapper {

    @Mapping(target = "currency", source = "curr")
    GetPriceDetailsQueryResult toDto(Price price);
}
