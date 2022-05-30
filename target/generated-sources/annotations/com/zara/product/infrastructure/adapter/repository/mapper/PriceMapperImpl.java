package com.zara.product.infrastructure.adapter.repository.mapper;

import com.zara.product.domain.Price;
import com.zara.product.service.api.v1.queries.getpricedetails.GetPriceDetailsQueryResult;
import com.zara.product.service.api.v1.queries.getpricedetails.GetPriceDetailsQueryResult.GetPriceDetailsQueryResultBuilder;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-05-30T15:25:15+0200",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.3 (Private Build)"
)
@Component
public class PriceMapperImpl implements PriceMapper {

    @Override
    public GetPriceDetailsQueryResult toDto(Price price) {
        if ( price == null ) {
            return null;
        }

        GetPriceDetailsQueryResultBuilder getPriceDetailsQueryResult = GetPriceDetailsQueryResult.builder();

        getPriceDetailsQueryResult.currency( price.getCurr() );
        getPriceDetailsQueryResult.brandId( price.getBrandId() );
        getPriceDetailsQueryResult.startDate( price.getStartDate() );
        getPriceDetailsQueryResult.endDate( price.getEndDate() );
        getPriceDetailsQueryResult.priceList( price.getPriceList() );
        getPriceDetailsQueryResult.productId( price.getProductId() );
        getPriceDetailsQueryResult.priority( price.getPriority() );
        getPriceDetailsQueryResult.price( price.getPrice() );

        return getPriceDetailsQueryResult.build();
    }
}
