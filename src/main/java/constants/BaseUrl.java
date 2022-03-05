package constants;

import java.util.Arrays;
import java.util.Objects;

public enum BaseUrl {

    PROD("https://www.jetbrains.com/ru-ru/");

    public final String url;

    BaseUrl(String url) {
        this.url = url;
    }

    public static String getBaseUrl(String label) {


        BaseUrl baseUrl = Arrays.stream(BaseUrl.values()).filter(itemLabel -> itemLabel.toString().equals(label))
                .findAny()
                .orElse(null);

        return Objects.requireNonNull(baseUrl).url;
    }
}
