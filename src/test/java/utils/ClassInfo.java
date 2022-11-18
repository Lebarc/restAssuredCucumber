package utils;

public class ClassInfo {

    private ClassInfo() {
    }

    private Boolean resultScenario;
    private Boolean resultFeature = true;
    private String logMessage;

    private static ClassInfo classInfoInstance;

    public String getLogMessage() {
        return logMessage;
    }

    public void setLogMessage(String value) {
        logMessage = value;
    }

    public Boolean getResultScenario() {
        return resultScenario;
    }

    public boolean setResultScenario(Boolean value) {
        resultScenario = value;
        resultFeature = value;
        return false;
    }

    public static ClassInfo GetInstance() {
        if (classInfoInstance == null) {
            classInfoInstance = new ClassInfo();
        }
        return classInfoInstance;
    }
}