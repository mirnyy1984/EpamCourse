package utils;

import java.time.Duration;

public class WebDriverConfig {

    private final Duration implicitlyWait;
    private final Duration pageLoadTimeout;
    private final Duration scriptTimeout;


    public WebDriverConfig() {
        this.pageLoadTimeout = pageLoadTimeout();
        this.implicitlyWait = implicitlyWait();
        this.scriptTimeout = scriptTimeout();
    }


    private Duration implicitlyWait() {
        return Duration.ofSeconds(30);
    }


    private Duration pageLoadTimeout() {
        return Duration.ofSeconds(60);
    }


    private Duration scriptTimeout() {
        return Duration.ofSeconds(60);
    }


    public Duration getPageLoadTimeout() {
        return pageLoadTimeout;
    }


    public Duration getImplicitlyWait() {
        return implicitlyWait;
    }


    public Duration getScriptTimeout() {
        return scriptTimeout;
    }

}
