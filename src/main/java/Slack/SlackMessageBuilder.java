package Slack;

public class SlackMessageBuilder {

    private StringBuilder messageBuilder = new StringBuilder();
    private String attachmentColor;

    public SlackMessageBuilder(String attachmentColor) {
        this.attachmentColor = attachmentColor;
        //messageBuilder.append(createBaseMessageTemplate());
        messageBuilder.append(createAttachmentTemplate());
    }


    public SlackMessageBuilder addDivider() {
        String devider = "\n{\n" +
                "\t\t\t\"type\": \"divider\"\n" +
                "\t\t}, \n";

        addSection(devider);
        return this;
    }


    public SlackMessageBuilder addHeader(String text) {
        String header = "\n{\n" +
                "\t\t\t\"type\": \"header\",\n" +
                "\t\t\t\"text\": {\n" +
                "\t\t\t\t\"type\": \"plain_text\",\n" +
                "\t\t\t\t\"text\":  " + "\"" + text + "\"" + ",\n" +
                "\t\t\t\t\"emoji\": true\n" +
                "\t\t\t}\n" +
                "\t\t}, \n";

        addSection(header);
        return this;
    }

    public SlackMessageBuilder addText(String text) {
        String result = "\n{\n" +
                "\t\t\t\"type\": \"section\",\n" +
                "\t\t\t\"text\": {\n" +
                "\t\t\t\t\"type\": \"plain_text\",\n" +
                "\t\t\t\t\"text\":  " + "\"" + text + "\"" + ",\n" +
                "\t\t\t\t\"emoji\": true\n" +
                "\t\t\t}\n" +
                "\t\t}, \n";

        addSection(result);
        return this;
    }

    public String buildMessage() {
        return messageBuilder.toString();
    }

    private String addSection(String text) {
        int index = messageBuilder.indexOf("]");
        return messageBuilder.insert(index, text).toString();
    }

    private String createBaseMessageTemplate() {
        String templateBase = "{\n" +
                "\"text\": \"Test results report.\",\n" +
                "\t\"blocks\": []\n" +
                "}";

        return templateBase;
    }

    private String createAttachmentTemplate() {
        String templateBase = "{\n" +
                "  \"attachments\": [\n" +
                "    {\n" +
                "      \"color\":  " + "\"" + attachmentColor + "\"" + ",\n" +
                "      \"blocks\": []\n" +
                "    }\n" +
                "  ]\n" +
                "}";

        return templateBase;
    }
}
