package com.cybertek.day2;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.junit.jupiter.api.Assertions.*;

public class HrGetRequests {


    //BeforeAll is a annotation equals to @BeforeClass in TestNG, we sue with static method name
    @BeforeAll
    public static void init(){
        baseURI = "http://52.87.224.201:8000/ords/hr";


    }
    @DisplayName("Get request to /regions")
    @Test
    public void test1(){
        Response response = get("/regions");
        System.out.println(response.statusCode());
    }

    @DisplayName("Get request to /regions/2")
    @Test
    public void test2(){
        Response response = given().accept(ContentType.JSON)
                                .when()
                                        .get("/regions/2");
        assertEquals(200, response.statusCode());
        assertEquals("application/json", response.contentType());
        response.prettyPrint();
        assertEquals(response.body().asString().contains("Americas"), true);
    }



}
