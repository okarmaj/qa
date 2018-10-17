package pl.jsystems.qa.qaapi;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pl.jsystems.qa.qaapi.model.MyUser;
import pl.jsystems.qa.qaapi.model.User;
import pl.jsystems.qa.qaapi.specification.Specification;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

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


}
