package reporters.utils;

import java.util.Objects;

public class TestResultStatusDefiner {

    public static TestResultStatusType defineStatus(int status) {
        TestResultStatusType resultStatus = null;

        switch (status) {
            case 1 -> { resultStatus = TestResultStatusType.PASSED; }
            case 2 -> { resultStatus =TestResultStatusType.BLOCKED; }
            case 3 -> { resultStatus =TestResultStatusType.UNTESTED; }
            case 4 -> { resultStatus =TestResultStatusType.RETEST; }
            case 5 -> { resultStatus =TestResultStatusType.FAILED; }
        }

        return Objects.requireNonNull(resultStatus);
    }
}




