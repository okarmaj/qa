package service;

import io.restassured.RestAssured;
import pl.jsystems.qa.qaapi.model.MyUser;
import pl.jsystems.qa.qaapi.specification.Specification;

public class UserService {

    public static final String MY_USER_URL = "/5a6b69ec3100009d211b8aeb";

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
}
