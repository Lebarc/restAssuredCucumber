package steps;

import io.cucumber.java.en.And;
import org.json.simple.JSONObject;
import org.testng.Assert;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

public class authenticationStets {

    private final String baseUrl = "https://bookstore.toolsqa.com";
    private RequestSpecification request;
    private JSONObject requestParams;
    private Response response;

    @Given("get call de API {string}")
    public void getCallDeURL(String arg0) {
        RestAssured.baseURI = baseUrl + arg0;
        request = RestAssured.given();
        requestParams = new JSONObject();
    }

    @And("pass de credential userName {string} and password {string}")
    public void passDeCredentialUserNameAndPassword(String arg0, String arg1) {
        requestParams.put("userName", arg0);
        requestParams.put("password", arg1);
        request.header("Content-Type", "application/json");
        request.body(requestParams.toJSONString());
        response = request.post("/login");
    }

    @When("call {string}")
    public void call(String arg0) {
        response = request.post(arg0);
    }

    @Then("return status {int}")
    public void returnStatus(int arg0) {
        Assert.assertEquals(response.getStatusCode(), arg0);
    }

    @And("return message {string}")
    public void returnMessage(String arg0) {
        Assert.assertEquals(response.getBody().jsonPath().get("message"), arg0);
    }

    @And("return false response body")
    public void returnEmptyResponseBody() {
        Assert.assertEquals(response.getBody().asPrettyString(), "false");
    }
}
