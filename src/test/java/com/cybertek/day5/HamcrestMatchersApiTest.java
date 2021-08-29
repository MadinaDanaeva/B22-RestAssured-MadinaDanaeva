package com.cybertek.day5;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class HamcrestMatchersApiTest {
    @DisplayName("OneSpartan with Hamcrest and chaining")
    @Test
    public void test1(){

        given().
                accept(ContentType.JSON)
                .and().pathParam("id",15)
                .when()
                .get("http://52.87.224.201:8000/api/spartans/{id}")
                .then()
                .statusCode(200)
                .and().assertThat()
                .contentType("application/json")
                .and()
                .body("id",equalTo(15),
                        "name",is("Meta"),
                        "gender",is("Female"),
                        "phone",is(1938695106));

    }
    @DisplayName("CBTraining Teacher request with chaining and matchers")
    @Test
    public void teacherData(){
        given()
                .accept(ContentType.JSON)
                .and()
                .pathParam("id", 10423)

                .when()
                    .get("http://api.cybertektraining.com/teacher/{id}")

                .then()
                .statusCode(200)
                .and()
                .contentType("application/json;charset=UTF-8")
                .and()
                .header("Content-Length", is ("236"))
                .and()
                .header("Date", notNullValue())
                .and().assertThat()
                .body("teachers[0].firstName", is ("Alexander"))
                .body("teachers[0].lastName", is("Syrup"))
                .body("teacher[0].gender", equalTo("male"));
    }

    @DisplayName("GET request to teacher/all and chaining")
    @Test
    public void teachersTest(){
        given()
                .accept(ContentType.JSON)

                .when()
                .get("http://api.cybertektraining.com/teacher/all")

                .then()
                    .statusCode(200)
                    .and()
                    .body("teachers.firstName", hasItems("Alexander", "Darleen", "Sean", "Jamal"));




    }



}
