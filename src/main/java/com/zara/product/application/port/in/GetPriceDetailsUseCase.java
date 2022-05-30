package com.zara.product.application.port.in;

import com.zara.product.service.api.v1.queries.getpricedetails.GetPriceDetailsQuery;
import com.zara.product.service.api.v1.queries.getpricedetails.GetPriceDetailsQueryResult;


public interface GetPriceDetailsUseCase {
    GetPriceDetailsQueryResult getPrice(GetPriceDetailsQuery getPriceDetailsQuery);
}
