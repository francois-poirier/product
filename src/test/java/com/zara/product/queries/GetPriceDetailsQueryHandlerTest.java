package com.zara.product.queries;

import com.zara.product.application.port.out.LoadPricePort;
import com.zara.product.service.api.v1.queries.getpricedetails.GetPriceDetailsQuery;
import com.zara.product.service.api.v1.queries.getpricedetails.GetPriceDetailsQueryResult;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class GetPriceDetailsQueryHandlerTest {

    public static final LocalDateTime APPLICATION_DATE = LocalDateTime.now();
    public static final int PRICE_LIST = 1;
    public static final int PRIORITY = 1;
    public static final int BRAND_ID = 1;
    public static final int PRODUCT_ID = 1;
    public static final String CURRENCY_EUR = "EUR";
    public static final BigDecimal PRICE = BigDecimal.ONE;
    private LoadPricePort loadPricePort;
    private GetPriceDetailsQueryHandler sut;

    @BeforeEach
    public void setUp() {
        this.loadPricePort = Mockito.mock(LoadPricePort.class);
        this.sut = new GetPriceDetailsQueryHandler(loadPricePort);
    }

    @Test
    void shouldBeGetPriceDetails() {
        // given
        final GetPriceDetailsQuery query = getGetPriceDetailsQuery();
        final GetPriceDetailsQueryResult getPriceDetailsQueryResult = getGetPriceDetailsQueryResult();
        when(loadPricePort.getPrice(APPLICATION_DATE,PRODUCT_ID,BRAND_ID)).thenReturn(getPriceDetailsQueryResult);
        // when
        final GetPriceDetailsQueryResult result = this.sut.getPrice(query);
        // then
        assertEquals(getPriceDetailsQueryResult,result);
    }

    private GetPriceDetailsQuery getGetPriceDetailsQuery() {
        return GetPriceDetailsQuery.builder()
                                   .applicationDate(APPLICATION_DATE)
                                   .brandId(BRAND_ID)
                                   .productId(PRODUCT_ID)
                                   .build();
    }

    private GetPriceDetailsQueryResult getGetPriceDetailsQueryResult() {
        return GetPriceDetailsQueryResult.builder()
                .startDate(APPLICATION_DATE)
                .endDate(APPLICATION_DATE.plusDays(1L))
                .brandId(BRAND_ID)
                .productId(PRODUCT_ID)
                .currency(CURRENCY_EUR)
                .priceList(PRICE_LIST)
                .priority(PRIORITY)
                .price(PRICE)
                .build();
    }

}
