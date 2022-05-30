package com.zara.product.infrastructure.adapter.rest;

import static io.restassured.RestAssured.get;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.zara.product.base.AbstractControllerTest;
import com.zara.product.base.LocalDateTimeDeserializer;
import com.zara.product.base.TestDataProvider;
import com.zara.product.service.api.v1.queries.getpricedetails.GetPriceDetailsQueryResult;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDateTime;

import static com.zara.product.base.AbstractControllerTest.Resources.V1_GET_PRICE_ENDPOINT;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.zara.product.base.LocalDateTimeSerializer;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
public class PriceControllerTest extends AbstractControllerTest {

    private static final String TEST1 = "data/Test1.json";
    private static final String TEST2 = "data/Test2.json";
    private static final String TEST3 = "data/Test3.json";
    private static final String TEST4 = "data/Test4.json";
    private static final String TEST5 = "data/Test5.json";

    private Gson gson;

    @BeforeEach
    public void setUp() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(LocalDateTime.class, new LocalDateTimeSerializer());
        gsonBuilder.registerTypeAdapter(LocalDateTime.class, new LocalDateTimeDeserializer());
        gson = gsonBuilder.setPrettyPrinting().create();

    }

    @Test
    void shouldBeReturnPriceTest1() {
        //given
        JsonObject test1Json = TestDataProvider.getRequestJson(TEST1);
        //when
        GetPriceDetailsQueryResult result = get(V1_GET_PRICE_ENDPOINT.build().toString().replace("replaceApplicationDate", "2020-06-14 10:00:00")).then()
                .assertThat()
                .statusCode(HttpStatus.OK.value())
                .extract()
                .as(GetPriceDetailsQueryResult.class);

        // then
        GetPriceDetailsQueryResult expected = gson.fromJson(test1Json, GetPriceDetailsQueryResult.class);
        assertEquals(expected.getCurrency(), result.getCurrency());
        assertEquals(expected.getPrice(), result.getPrice());
        assertEquals(expected.getPriceList(), result.getPriceList());
        assertEquals(expected.getPriority(), result.getPriority());
        assertEquals(expected.getBrandId(),result.getBrandId());
        assertEquals(expected.getProductId(),result.getProductId());
        assertEquals(expected.getStartDate(),result.getStartDate());
        assertEquals(expected.getEndDate(), result.getEndDate());
    }

    @Test
    void shouldBeReturnPriceTest2() {
        //given
        JsonObject test1Json = TestDataProvider.getRequestJson(TEST2);
        //when
        GetPriceDetailsQueryResult result = get(V1_GET_PRICE_ENDPOINT.build().toString().replace("replaceApplicationDate", "2020-06-14 16:00:00")).then()
                .assertThat()
                .statusCode(HttpStatus.OK.value())
                .extract()
                .as(GetPriceDetailsQueryResult.class);

        // then
        GetPriceDetailsQueryResult expected = gson.fromJson(test1Json, GetPriceDetailsQueryResult.class);
        assertEquals(expected.getCurrency(), result.getCurrency());
        assertEquals(expected.getPrice(), result.getPrice());
        assertEquals(expected.getPriceList(), result.getPriceList());
        assertEquals(expected.getPriority(), result.getPriority());
        assertEquals(expected.getBrandId(),result.getBrandId());
        assertEquals(expected.getProductId(),result.getProductId());
        assertEquals(expected.getStartDate(),result.getStartDate());
        assertEquals(expected.getEndDate(), result.getEndDate());
    }

    @Test
    void shouldBeReturnPriceTest3() {
        //given
        JsonObject test1Json = TestDataProvider.getRequestJson(TEST3);
        //when
        GetPriceDetailsQueryResult result = get(V1_GET_PRICE_ENDPOINT.build().toString().replace("replaceApplicationDate", "2020-06-14 21:00:00")).then()
                .assertThat()
                .statusCode(HttpStatus.OK.value())
                .extract()
                .as(GetPriceDetailsQueryResult.class);

        // then
        GetPriceDetailsQueryResult expected = gson.fromJson(test1Json, GetPriceDetailsQueryResult.class);
        assertEquals(expected.getCurrency(), result.getCurrency());
        assertEquals(expected.getPrice(), result.getPrice());
        assertEquals(expected.getPriceList(), result.getPriceList());
        assertEquals(expected.getPriority(), result.getPriority());
        assertEquals(expected.getBrandId(),result.getBrandId());
        assertEquals(expected.getProductId(),result.getProductId());
        assertEquals(expected.getStartDate(),result.getStartDate());
        assertEquals(expected.getEndDate(), result.getEndDate());
    }

    @Test
    void shouldBeReturnPriceTest4() {
        //given
        JsonObject test1Json = TestDataProvider.getRequestJson(TEST4);
        //when
        GetPriceDetailsQueryResult result = get(V1_GET_PRICE_ENDPOINT.build().toString().replace("replaceApplicationDate", "2020-06-15 10:00:00")).then()
                .assertThat()
                .statusCode(HttpStatus.OK.value())
                .extract()
                .as(GetPriceDetailsQueryResult.class);

        // then
        GetPriceDetailsQueryResult expected = gson.fromJson(test1Json, GetPriceDetailsQueryResult.class);
        assertEquals(expected.getCurrency(), result.getCurrency());
        assertEquals(expected.getPrice(), result.getPrice());
        assertEquals(expected.getPriceList(), result.getPriceList());
        assertEquals(expected.getPriority(), result.getPriority());
        assertEquals(expected.getBrandId(),result.getBrandId());
        assertEquals(expected.getProductId(),result.getProductId());
        assertEquals(expected.getStartDate(),result.getStartDate());
        assertEquals(expected.getEndDate(), result.getEndDate());
    }

    @Test
    void shouldBeReturnPriceTest5() {
        //given
        JsonObject test1Json = TestDataProvider.getRequestJson(TEST5);
        //when
        GetPriceDetailsQueryResult result = get(V1_GET_PRICE_ENDPOINT.build().toString().replace("replaceApplicationDate", "2020-06-16 21:00:00")).then()
                .assertThat()
                .statusCode(HttpStatus.OK.value())
                .extract()
                .as(GetPriceDetailsQueryResult.class);

        // then
        GetPriceDetailsQueryResult expected = gson.fromJson(test1Json, GetPriceDetailsQueryResult.class);
        assertEquals(expected.getCurrency(), result.getCurrency());
        assertEquals(expected.getPrice(), result.getPrice());
        assertEquals(expected.getPriceList(), result.getPriceList());
        assertEquals(expected.getPriority(), result.getPriority());
        assertEquals(expected.getBrandId(),result.getBrandId());
        assertEquals(expected.getProductId(),result.getProductId());
        assertEquals(expected.getStartDate(),result.getStartDate());
        assertEquals(expected.getEndDate(), result.getEndDate());
    }
}
