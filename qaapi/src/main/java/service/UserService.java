package service;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import pl.jsystems.qa.qaapi.model.MyUser;
import pl.jsystems.qa.qaapi.model.UserAzure;
import pl.jsystems.qa.qaapi.specification.Specification;

import javax.jws.soap.SOAPBinding;

public class UserService {


    public static final String MY_USER_URL = "/5a6b69ec3100009d211b8aeb";
    public static final String POST_URL = "/5a690a1b2e000051007a73cb";


    public static MyUser getMyUser() {
        return RestAssured.given()
                .spec(Specification.requestSpecBuilder())
                .when()
                .get("MY_USER_URL")
                .then()
                .assertThat()
                .statusCode(200)
                .extract()
                .body()
                .jsonPath()
                .getObject("", MyUser.class);
    }

    public static String [] postMyUser(MyUser myUser) {
        return RestAssured.given()
                .spec(Specification.requestSpecBuilder())
                .when()
                .body(myUser)
                .get(POST_URL)
                .andReturn()
                .then()
                .assertThat()
                .statusCode(201)
                .extract()
                .as (String[].class);
    }

//    public static Response getGeneric() {
//        return RestAssured.given()
//                .spec(Specification.requestSpecBuilder())
//                .when()
//                .get("/5b05bf3f3200007100ebfa04")
//                .andReturn();
//
//
//    }
    public static Response getGeneric(String path) {
        return RestAssured.given()
                .spec(Specification.requestSpecBuilder())
                .when()
                .get(path)
                .andReturn();


    }

    public static UserAzure getUserAzureById(int id) {
        return RestAssured.given()
                .spec(Specification.fakeAzureSpecBuilder())
                .when()
                .get("/api/Users/{id}", id)
                .andReturn()
                .then()
                .assertThat()
                .statusCode(200)
                .extract()
                .body()
                .as(UserAzure.class);


    }
}
