package com.zara.product.application.port.out;

import com.zara.product.service.api.v1.queries.getpricedetails.GetPriceDetailsQueryResult;

import java.time.LocalDateTime;

public interface LoadPricePort {

    GetPriceDetailsQueryResult getPrice(LocalDateTime applicationDate, Integer productId, Integer brandId);
}
