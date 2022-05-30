package com.zara.product.infrastructure.adapter.repository;

import com.zara.product.application.port.out.LoadPricePort;
import com.zara.product.domain.Price;
import com.zara.product.infrastructure.adapter.repository.jpa.PriceRepository;
import com.zara.product.infrastructure.adapter.repository.mapper.PriceMapper;
import com.zara.product.service.api.v1.queries.getpricedetails.GetPriceDetailsQueryResult;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@Transactional
@RequiredArgsConstructor
public class PriceRepositoryAdapter implements LoadPricePort {

    private final PriceRepository priceRepository;
    private final PriceMapper priceMapper;

    @Override
    public GetPriceDetailsQueryResult getPrice(LocalDateTime applicationDate, Integer productId, Integer brandId) {
        final List<Price> candidatePrices = priceRepository.findByStartDateLessThanEqualAndEndDateGreaterThanEqualAndBrandIdAndProductId(applicationDate, applicationDate,brandId,productId);
        return priceMapper.toDto(filterPricesByPriority(candidatePrices));
    }
    private Price filterPricesByPriority(final List<Price> candidatePrices) {
        return candidatePrices.stream().max(Comparator.comparing(Price::getPriority))
                .orElseThrow(NoSuchElementException::new);
    }
}
