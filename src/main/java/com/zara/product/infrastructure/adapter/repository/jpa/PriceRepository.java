package com.zara.product.infrastructure.adapter.repository.jpa;

import com.zara.product.domain.Price;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface PriceRepository extends CrudRepository<Price, Long> {

    List<Price> findByStartDateLessThanEqualAndEndDateGreaterThanEqualAndBrandIdAndProductId(
            LocalDateTime startDate,
            LocalDateTime endDate,
            Integer brandId,
            Integer productId);

}
