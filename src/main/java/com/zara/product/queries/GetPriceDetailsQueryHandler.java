package com.zara.product.queries;

import com.zara.product.application.port.in.GetPriceDetailsUseCase;
import com.zara.product.application.port.out.LoadPricePort;
import com.zara.product.service.api.v1.queries.getpricedetails.GetPriceDetailsQuery;
import com.zara.product.service.api.v1.queries.getpricedetails.GetPriceDetailsQueryResult;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;


@Component
@Transactional
@RequiredArgsConstructor
public class GetPriceDetailsQueryHandler implements GetPriceDetailsUseCase {

    private final LoadPricePort loadPricePort;

    @Override
    public GetPriceDetailsQueryResult getPrice(GetPriceDetailsQuery getPriceDetailsQuery) {
        return loadPricePort.getPrice(getPriceDetailsQuery.getApplicationDate(),getPriceDetailsQuery.getProductId(),getPriceDetailsQuery.getBrandId());
    }
}
