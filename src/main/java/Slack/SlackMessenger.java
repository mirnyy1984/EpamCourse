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
