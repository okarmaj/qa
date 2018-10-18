package pl.jsystems.qa.qaapi;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.awaitility.Awaitility;
import io.restassured.RestAssured;
//import io.restassured.mapper.ObjectMapper;
import io.restassured.path.json.JsonPath;
//import jdk.internal.org.objectweb.asm.TypeReference;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pl.jsystems.qa.qaapi.dbservice.UserDao;
import pl.jsystems.qa.qaapi.jdbservice.UserJdbiService;
import pl.jsystems.qa.qaapi.model.*;
import pl.jsystems.qa.qaapi.specification.Specification;
import service.UserService;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static com.jayway.awaitility.Awaitility.await;
import static com.sun.org.apache.xerces.internal.util.PropertyState.is;
import static org.hamcrest.MatcherAssert.assertThat;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.jupiter.api.Assertions.assertTrue;


@DisplayName("Api tests")
public class ApiTest {

    @Test

    @DisplayName("First rest assured tests")
    public void firstTest() {

        RestAssured.given()
                .spec(Specification.requestSpecBuilder())
//                .contentType("application/json")
                .when()
                .get("/5a6b69ec3100009d211b8aeb")
//                .get(" .get(\"http://www.mocky.io/v2/5a6b69ec3100009d211b8aeb\")")
                .then()
                .assertThat()
                .statusCode(200)
                .body("name", equalTo("Piotr"))
                .body("surname", equalTo("Kowalski"));



    }
    @Test

    @DisplayName("Second rest assured tests")
    public void secondTest() {

        RestAssured.given()
                .spec(Specification.requestSpecBuilder())
//                .contentType("application/json")
                .when()
                .get("/5a6b69ec3100009d211b8aeb")
//                .get(" .get(\"http://www.mocky.io/v2/5a6b69ec3100009d211b8aeb\")")
                .then()
                .assertThat()
                .statusCode(200)
                .body("name", equalTo("Piotr"))
                .body("surname", equalTo("Kowalski"));



    }

    @Test
    public void simpleTest() {

        JsonPath jsonPath = RestAssured.given()
                .spec(Specification.requestSpecBuilder())
                .when()
                .get("/5a6a58222e0000d0377a7789")
                .then()
                .assertThat()
                .statusCode(200)
                .extract()
                .body()
                .jsonPath();

        List<User> users = jsonPath.getList("", User.class);
        assertThat(users.get (0).imie, equalTo("Piotr"));
    }

    @Test
    public void jsonTest() {

        JsonPath jsonPath = RestAssured.given()
                .spec(Specification.requestSpecBuilder())
                .when()
                .get("/5a6b69ec3100009d211b8aeb")
                .then()
                .assertThat()
                .statusCode(200)
                .extract()
                .body()
                .jsonPath();

        MyUser users = jsonPath.getObject("", MyUser.class);
        assertThat(users.name, equalTo("Piotr"));
        assertThat(users.surname, equalTo ("Kowalski"));
    }
    @Test
    public void postUser(){

        String[] emptyTable = UserService.postMyUser(new MyUser("Adam","Majewski"));
//        List<String> emptyList = Arrays.asList(emptyTable)
        assertTrue(Arrays.asList(emptyTable).isEmpty());

    }

    @Test
    public void genericIntTest() throws IOException {

        Response response = UserService.getGeneric("/5b05bf3f3200007100ebfa04");

        UserGeneric<Integer> userGeneric = new ObjectMapper().readValue(
                response
                .then()
                .extract()
                .body()
                .asInputStream(), new TypeReference<UserGeneric<Integer>>(){}
        );

        assertThat(userGeneric.id, org.hamcrest.core.Is.is(1));
    }

    @Test
    public void genericStringTest() throws IOException {

        Response response = UserService.getGeneric("/5b05c83e3200009700ebfa2b");

        UserGeneric<String> userGeneric = new ObjectMapper().readValue(
                response
                        .then()
                        .extract()
                        .body()
                        .asInputStream(), new TypeReference<UserGeneric<String>>(){}
        );

        assertThat(userGeneric.id, equalTo("1a"));
    }


    @Test
    public void azureUser() {
        UserAzure userAzure = UserService.getUserAzureById(1);

        assertThat(userAzure.id, org.hamcrest.core.Is.is(1));
        assertThat(userAzure.userName, equalTo("User 1"));
        assertThat(userAzure.password, equalTo("Password1"));
    }

    @Test
    public void dbTest() {
        UserDBTest userDBTest = UserDao.getOneById(1);
        System.out.println(userDBTest);

    }




//    @Test
//    public void jdbiTest() {
//        assertThat(UserJdbiService.getTestUser(1L).getId(), is(1L));
//
//    }


}

