package steps;

import actions.requestClass;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import io.restassured.module.jsv.JsonSchemaValidator;

import java.io.File;

public class validateSteps {
    @Then("return status {int}")
    public void returnStatus(int arg0) {
        Assert.assertEquals(requestClass.response.getStatusCode(), arg0, "Status correto");
    }

    @And("return message {string}")
    public void returnMessage(String arg0) {
        Assert.assertEquals(requestClass.response.getBody().jsonPath().get("message"), arg0);
    }

    @And("return false response body")
    public void returnEmptyResponseBody() {
        Assert.assertEquals(requestClass.response.getBody().asPrettyString(), "false");
    }

    @And("return correct json schema")
    public void returnCorrectJsonSchema() {
        requestClass.
                response.
                then().
                assertThat().
                body(JsonSchemaValidator.matchesJsonSchema(new File("/Users/leonardomincola/Documents/QA tools/RestAssuredCucumber/src/test/java/schema/booksSchema.json")));
    }
}