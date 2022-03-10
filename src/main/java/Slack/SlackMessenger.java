package Slack;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;

public class SlackMessenger {

    private static String webHookUrl = "https://hooks.slack.com/services/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";


    public static void sendMessage(String message) {
        given()
                .baseUri(webHookUrl)
                .header("Content-type", "application/json")
                .contentType(ContentType.JSON)
                .body(message)
                .post();
    }
}
