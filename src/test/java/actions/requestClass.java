package actions;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;

public class requestClass {

    public static final String baseUrl = "https://bookstore.toolsqa.com";
    public static RequestSpecification request;
    public static JSONObject requestParams;
    public static Response response;
}
