package com.zara.product.infrastructure.adapter.rest;

import com.zara.product.service.api.v1.queries.getpricedetails.GetPriceDetailsQuery;
import com.zara.product.service.api.v1.queries.getpricedetails.GetPriceDetailsQueryResult;
import com.zara.product.application.port.in.GetPriceDetailsUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/v1/prices")
@RequiredArgsConstructor
@Tag(name = "prices", description = "the prices API")
@Validated
public class PriceController {

    private final GetPriceDetailsUseCase getPriceDetailsUseCase;

    @Operation(summary = "Get price that match with the inputs fields",description = "Returns a single price", tags = { "prices" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation", content = @Content(schema = @Schema(implementation = GetPriceDetailsQueryResult.class))),
            @ApiResponse(responseCode = "404", description = "Price not found") })
    @GetMapping
    public ResponseEntity<GetPriceDetailsQueryResult> getPrice(@RequestParam(name = "applicationDate", required = true) @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") final LocalDateTime applicationDate,
                                                               @RequestParam(name = "productId", required = true) final Integer productId,
                                                               @RequestParam(name = "brandId", required = true) final Integer brandId){
        GetPriceDetailsQuery getPriceDetailsQuery = GetPriceDetailsQuery.builder()
                .applicationDate(applicationDate)
                .productId(productId)
                .brandId(brandId)
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(getPriceDetailsUseCase.getPrice(getPriceDetailsQuery));
    }
}
