package testrail;

import com.codepine.api.testrail.TestRail;
import com.codepine.api.testrail.model.*;
import org.testng.ITestResult;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

public class TestRailWorker {

    private TestRail testRail;
    private Project project;
    private Run run;

    public TestRailWorker(TestTRunType type) {
        init(type);
    }


    public void setResult(ITestResult result) {
        List<CaseField> caseFields = testRail.caseFields().list().execute();
        List<Case> cases = testRail.cases().list(project.getId(), caseFields).execute();

        List<ResultField> resultFields = testRail.resultFields().list().execute();

        cases.stream()
                .filter(test -> test.getTitle().equals(result.getMethod().getMethodName()))
                .findFirst()
                .ifPresent(test -> testRail.results().addForCase(run.getId(), test.getId(),
                        new Result().setStatusId(result.getStatus()), resultFields).execute());
    }


    public void closeWorker() {
        //testRail.runs().close(run.getId()).execute();
    }


    private void init(TestTRunType type) {
        testRail = TestRail.builder(
                        TestRailCredentials.TESTRAIL_ACCOUNT_URL.getCredential(),
                        TestRailCredentials.USER_NAME.getCredential(), TestRailCredentials.USER_PASS.getCredential())
                .build();

        project = testRail.projects().get(Integer.parseInt(TestRailCredentials.PROJECT_ID.getCredential())).execute();

        run = testRail.runs().add(project.getId(), new Run()
                        .setName(type.name() + "_" + new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss").format(new Date()))
                        .setIncludeAll(false))
                .execute();

        run.setCaseIds(getTestIds(type));
        testRail.runs().update(run).execute();
    }


    private List<Integer> getTestIds(TestTRunType type) {
        String uiTestCasesFilePath = "src/test/resources/ui_test_cases_id.properties";
        String apiTestCasesFilePath = "src/test/resources/api_test_cases_id.properties";
        String reflectionTestCasesFilePath = "src/test/resources/reflection_test_cases_id.properties";
        String resultTestFilePath = "";

        Properties properties = new Properties();
        FileInputStream inputStream = null;

        switch (type) {
            case UI -> resultTestFilePath = uiTestCasesFilePath;
            case API -> resultTestFilePath = apiTestCasesFilePath;
            case REFLECTION -> resultTestFilePath = reflectionTestCasesFilePath;
        }

        try {
            inputStream = new FileInputStream(resultTestFilePath);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try {
            properties.load(Objects.requireNonNull(inputStream));
        } catch (IOException e) {
            e.printStackTrace();
        }

        int[] testIds = Arrays.stream(properties.getProperty("test_ids").split(",")).mapToInt(Integer::parseInt).toArray();
        return Arrays.stream(testIds).boxed().toList();
    }
}
