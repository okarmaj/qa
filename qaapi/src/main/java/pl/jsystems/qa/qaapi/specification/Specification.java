package pl.jsystems.qa.qaapi.specification;


import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.*;
import pl.jsystems.qa.qaapi.configuration.Configuration;


public class Specification {

    public static RequestSpecification requestSpecBuilder() {
        return new RequestSpecBuilder()

                .setContentType(ContentType.JSON)
                .setBaseUri(Configuration.BASE_URL)
                .setBasePath("/v2")
                .build();
    }

    public static RequestSpecification fakeAzureSpecBuilder() {
        return new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .setBaseUri("http://fakerestapi.azurewebsites.net")
                .build();
    }
}
