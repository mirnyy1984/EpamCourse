package utils.test_methods_definer;

public class TestMethodItem {

    private String name;
    private String modifier;
    private String testType;
    private String testDescription;

    public TestMethodItem(String name, String modifier, String testType, String testDescription) {
        this.name = name;
        this.modifier = modifier;
        this.testType = testType;
        this.testDescription = testDescription;
    }


    public String getTestType() {
        return testType;
    }


    @Override
    public String toString() {
        return "TestMethodItem{" +
                "name='" + name + '\'' +
                ", modifier='" + modifier + '\'' +
                ", testType='" + testType + '\'' +
                ", testDescription='" + testDescription + '\'' +
                '}';
    }
}
