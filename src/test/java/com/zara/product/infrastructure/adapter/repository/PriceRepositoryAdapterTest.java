package com.zara.product.infrastructure.adapter.repository;

import com.zara.product.domain.Price;
import com.zara.product.infrastructure.adapter.repository.jpa.PriceRepository;
import com.zara.product.infrastructure.adapter.repository.mapper.PriceMapper;
import com.zara.product.service.api.v1.queries.getpricedetails.GetPriceDetailsQueryResult;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class PriceRepositoryAdapterTest {

    public static final LocalDateTime APPLICATION_DATE = LocalDateTime.now();
    public static final int PRICE_LIST = 1;
    public static final int PRIORITY = 1;
    public static final int BRAND_ID = 1;
    public static final int PRODUCT_ID = 1;
    public static final String CURRENCY_EUR = "EUR";
    public static final BigDecimal PRICE = BigDecimal.ONE;
    public static final long ID = 1L;
    private PriceRepository priceRepositoryAdapter;
    private PriceMapper priceMapper;
    private PriceRepositoryAdapter sut;

    @BeforeEach
    public void setUp() {
        this.priceRepositoryAdapter = Mockito.mock(PriceRepository.class);
        this.priceMapper =  Mockito.mock(PriceMapper.class);
        this.sut = new PriceRepositoryAdapter(priceRepositoryAdapter , priceMapper);
    }


    @Test
    void shouldBeNotGetPrice() {
        // given
        final List<Price> emptyList = Collections.<Price>emptyList();
        when(priceRepositoryAdapter.findByStartDateLessThanEqualAndEndDateGreaterThanEqualAndBrandIdAndProductId(APPLICATION_DATE, APPLICATION_DATE, BRAND_ID,PRODUCT_ID)).thenReturn(emptyList);
        // when
        assertThrows(NoSuchElementException.class, () -> {
            this.sut.getPrice(APPLICATION_DATE,PRODUCT_ID,BRAND_ID);
        });
        // then
        verify(priceRepositoryAdapter).findByStartDateLessThanEqualAndEndDateGreaterThanEqualAndBrandIdAndProductId(APPLICATION_DATE, APPLICATION_DATE, BRAND_ID,PRODUCT_ID);
    }

    @Test
    void shouldBeGetPrice() {
        // given
        final Price price = getPrice();
        final List<Price> prices = getPrices(price);
        final GetPriceDetailsQueryResult getPriceDetailsQueryResult = getGetPriceDetailsQueryResult();
        when(priceRepositoryAdapter.findByStartDateLessThanEqualAndEndDateGreaterThanEqualAndBrandIdAndProductId(APPLICATION_DATE, APPLICATION_DATE, BRAND_ID,PRODUCT_ID)).thenReturn(prices);
        when(priceMapper.toDto(price)).thenReturn(getPriceDetailsQueryResult);
        // when
        GetPriceDetailsQueryResult result = this.sut.getPrice(APPLICATION_DATE,PRODUCT_ID,BRAND_ID);
        // then
        verify(priceRepositoryAdapter).findByStartDateLessThanEqualAndEndDateGreaterThanEqualAndBrandIdAndProductId(APPLICATION_DATE, APPLICATION_DATE, BRAND_ID,PRODUCT_ID);
        verify(priceMapper).toDto(price);
        assertEquals(getPriceDetailsQueryResult, result);
    }

    private Price getPrice() {
        return Price.builder()
                .id(ID)
                .startDate(APPLICATION_DATE)
                .endDate(APPLICATION_DATE.plusDays(1L))
                .brandId(BRAND_ID)
                .productId(PRODUCT_ID)
                .curr(CURRENCY_EUR)
                .priceList(PRICE_LIST)
                .priority(PRIORITY)
                .price(PRICE)
                .build();
    }
    private List<Price> getPrices(Price price) {
        return Arrays.asList(price);
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
