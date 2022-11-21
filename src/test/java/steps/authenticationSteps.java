package steps;

import io.cucumber.java.en.And;
import actions.requestClass;


public class authenticationSteps {

    @And("pass de credential userName {string} and password {string}")
    public void passDeCredentialUserNameAndPassword(String arg0, String arg1) {
        requestClass.requestParams.put("userName", arg0);
        requestClass.requestParams.put("password", arg1);
        requestClass.request.header("Content-Type", "application/json");
        requestClass.request.body(requestClass.requestParams.toJSONString());
        requestClass.response = requestClass.request.post("/login");
    }
}