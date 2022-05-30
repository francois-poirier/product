package com.zara.product.service.api.v1.queries.getpricedetails;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
@Data
@Builder
public class GetPriceDetailsQueryResult {
    @SerializedName("brand_id")
    @JsonProperty("brand_id")
    private Integer brandId;

    @SerializedName("start_date")
    @JsonProperty("start_date")
    private LocalDateTime startDate;

    @SerializedName("end_date")
    @JsonProperty("end_date")
    private LocalDateTime endDate;

    @SerializedName("price_list")
    @JsonProperty("price_list")
    private Integer priceList;

    @SerializedName("product_id")
    @JsonProperty("product_id")
    private Integer productId;

    @JsonProperty("priority")
    private Integer priority;

    @JsonProperty("price")
    private BigDecimal price;

    @JsonProperty("currency")
    private String currency;
}
