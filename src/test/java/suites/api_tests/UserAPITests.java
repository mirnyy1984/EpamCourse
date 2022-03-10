package suites.api_tests;

import annotations.TestType;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class UserAPITests extends APITest {

    @TestType(testType = "api", testDescription = "test verify user first name")
    @Test
    protected void test_1_checkUserFirstName() {
        given()
                .baseUri("https://reqres.in/api/")
                .basePath("users/2")
                .contentType(ContentType.JSON)
                .when().get() .then().statusCode(200)
                .body("data.first_name", equalTo("Jane"));
    }

    @TestType(testType = "api", testDescription = "test verify ui presents")
    @Test
    protected void test_2_checkUserLastName() {
        given()
                .baseUri("https://reqres.in/api/")
                .basePath("users/2")
                .contentType(ContentType.JSON)
                .when().get()
                .then().statusCode(200)
                .body("data.last_name", equalTo("Weaver"));
    }


    @TestType(testType = "api", testDescription = "test verify ui presents 33333")
    @Test
    protected void test_3_only_for_testing() {
        given()
                .baseUri("https://reqres.in/api/")
                .basePath("users/2")
                .contentType(ContentType.JSON)
                .when().get()
                .then().statusCode(200)
                .body("data.last_name", equalTo("Weaver"));
    }


    @TestType(testType = "api", testDescription = "test verify ui presents 44444")
    @Test
    protected void test_4_only_for_testing() {
        given()
                .baseUri("https://reqres.in/api/")
                .basePath("users/2")
                .contentType(ContentType.JSON)
                .when().get()
                .then().statusCode(200)
                .body("data.last_name", equalTo("Weave"));
    }


    @TestType(testType = "api", testDescription = "test verify ui presents 5555")
    @Test
    protected void test_5_only_for_testing() {
        given()
                .baseUri("https://reqres.in/api/")
                .basePath("users/2")
                .contentType(ContentType.JSON)
                .when().get()
                .then().statusCode(200)
                .body("data.last_name", equalTo("Weaver"));
    }
}
