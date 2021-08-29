package com.cybertek.utilities;

import org.junit.jupiter.api.BeforeAll;


import static io.restassured.RestAssured.baseURI;

public class SpartanAuthTestBase {
    @BeforeAll
    public static void init() {
        beseURL = "http://52.87.224.201:7000";
    }
}