package Slack;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;

public class SlackMessenger {

    private static String webHookUrl = "https://hooks.slack.com/services/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";
    //private static String oAuthToken = "xoxb-3197806576022-3232800810896-wgyHoAP117JzGDIGtfics9c7";
    //private static String channel = "epameducation";

    public static void main(String[] args) {
        SlackMessageBuilder builder = new SlackMessageBuilder("#CD5C5C");
        String message = builder
                .addHeader("My headeeee...eer ")
                .addText("1111111111")
                .buildMessage();

        sendMessage(message);

        System.out.println(message);
    }

    public static void sendMessage(String message) {
        given()
                .baseUri(webHookUrl)
                .header("Content-type", "application/json")
                .contentType(ContentType.JSON)
                .body(message)
                .post();
    }


    /*public static void main(String[] args) {

        SlackMessageBuilder messanger = new SlackMessageBuilder();

        String message = messanger
                .addHeader("My header")
                .addDivader()
                .addText("this is simple text")
                .addHeader("My header 22")
                .addHeader("My header 2244444")
                .addText("-----------------------")
                .buildMessage();

        System.out.println(message);

        sendMessage(message);

    }*/


   /* public static void sendMessage(String message) {
        StringBuilder builder = new StringBuilder();
        builder.append(message);

        Payload payload = Payload.builder().channel(channel).text(builder.toString()).build();
        try {
            WebhookResponse response = Slack.getInstance().send(webHookUrl, payload);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/
}
