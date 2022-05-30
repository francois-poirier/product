package com.zara.product.service.api.v1.queries.getpricedetails;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class GetPriceDetailsQuery {

    private LocalDateTime applicationDate;
    private Integer brandId;
    private Integer productId;

}
