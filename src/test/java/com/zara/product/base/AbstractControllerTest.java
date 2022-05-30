package com.zara.product.base;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public abstract class AbstractControllerTest {
    @LocalServerPort
    private int port;

    @BeforeEach
    void setUpBeforeEach() {
        RestAssured.port = this.port;
    }

    public enum Resources {
        V1_GET_PRICE_ENDPOINT("/api/v1/prices?applicationDate=replaceApplicationDate&productId=35455&brandId=1");
        private final String endpoint;

        Resources(String endpoint) {
            this.endpoint = endpoint;
        }

        public String build() {
            return endpoint;
        }
    }
}
