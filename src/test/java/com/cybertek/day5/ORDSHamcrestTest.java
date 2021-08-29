package com.cybertek.day5;

import com.cybertek.day2.HrGetRequests;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ORDSHamcrestTest extends HrGetRequests {

    @DisplayName("GET request to Employees IT_PROG endpoint and chaining")
    @Test
    public void employeesTest(){

       int statusCode = given().accept(ContentType.JSON)
                .and().queryParam("q", "{\job_id\": \"IT_PROG\"}")
                .when()
                .get("/employees")
                .then()
                .statusCode(200)
                    .body("items.job_id", everyItem(equalsTo("IT_PROG")))
                    .extract().jsonPath();

       assertThat(jsonPath.getList("items.first_name"), hasSize(5));

       assertthat(jsonPath.getList("items.first_name"), containsInRelativeOrder("Alexander", ""))


    }
}
