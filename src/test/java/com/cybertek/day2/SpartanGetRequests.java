package com.cybertek.day2;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class SpartanGetRequests {
    String baseUrl = "http://52.87.224.201:8000";

//    Given Accept type application/json
//    When user send GET request to api/spartans end point
//    Then status code must 200
//    And response Content Type must be application/json
//    And response body should include spartan result

    @Test
    public void test1(){

        Response response = given().accept(ContentType.JSON)
                .when()
                .get(baseUrl + "/api/spartans");

        //printing status code from response object
        System.out.println("response.statusCode() = " + response.statusCode());

        //priting response content type from response object
        System.out.println("response.contentType() = " + response.contentType());

        //print whole result body
        response.prettyPrint();

        //how to do API testing then ?
        //verify status code is 200
        Assertions.assertEquals(response.statusCode(),200);

        //verify content type is application/json
        Assertions.assertEquals(response.contentType(),"application/json");

    }

    @DisplayName("Get request to /api/hello")
    @Test
    public void test3(){
        Response response = RestAssured.when().get(baseUrl + "/api/hello");

        Assertions.assertEquals(200, response.statusCode());

        Assertions.assertEquals("text/plain;charset=UTF-8", response.contentType());

        Assertions.assertTrue(response.headers().hasHeaderWithName("Data"));
        System.out.println("response.header(\"Content-Length\") = " + response.header("Content-Length"));
        System.out.println(response.header("Date"));

        Assertions.assertEquals("17", response.header("Content-Length"));
        Assertions.assertEquals("Hello From Sparta", response.body().asString());
    }
}