package com.cybertek.day8;

import com.cybertek.utilities.SpartanAuthTestBase;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class SpartanWithAuthTests extends SpartanAuthTestBase {
    @DisplayName("GET /api/spartan as a public user (guest) expect 401")
    @Test
    public void test1(){
        given().accept(ContentType.JSON).
                when().
        get("/api/spartan")
                .then().statusCode(401)
                .log().all();
    }

    @DisplayName("GET /api/spartans as admin user expect 200")
    @Test
    public void test2(){
        given()
                .auth().basic("admin", "admin")
                .and().accept(ContentType.JSON)

                .when()
                .get("/api/spartans")
                .then()
                .statusCode(200)
                .log().all();
    }

    @DisplayName("DELETE  /spartans/{id} as editor user expected 403")
    @Test
    public void testEditorDelete(){
        RestAssured.given()
                .auth().basic("editor", "editor")
                .auth().accept(ContentType.JSON)
                .and().pathParam("id", 30)
                .when()
                .delete("/api/spartans/{id}")
                .then()
                .statusCode(403)
                .log().body();
    }
}
