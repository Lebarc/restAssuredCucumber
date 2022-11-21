package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import org.json.simple.JSONObject;

import actions.requestClass;

public class requestSteps {

    @Given("get call de API {string}")
    public void getCallDeURL(String arg0) {
        RestAssured.baseURI = requestClass.baseUrl + arg0;
        requestClass.request = RestAssured.given();
        requestClass.requestParams = new JSONObject();
    }

    @When("call {string} {string}")
    public void call(String arg0, String arg1) {
        switch (arg0) {
            case "get":
                requestClass.response = requestClass.request.get(arg1);
                break;
            case "post":
                requestClass.response = requestClass.request.post(arg1);
                break;
        }
    }
}
