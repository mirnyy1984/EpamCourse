package testrail;

public enum TestRailCredentials {
    TESTRAIL_ACCOUNT_URL("https://myepamcourse.testrail.io"),
    USER_NAME("levashov.vitaliy@gmail.com"),
    USER_PASS("Epamcourse2022!"),
    PROJECT_ID("3");

    private String credential;

    TestRailCredentials(String credential) {
        this.credential = credential;
    }

    public String getCredential() {
        return credential;
    }
}
