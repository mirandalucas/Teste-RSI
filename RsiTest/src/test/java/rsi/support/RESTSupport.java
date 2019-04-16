package rsi.support;

import static com.jayway.restassured.RestAssured.given;

import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Header;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;

public class RESTSupport {

	private static Response response;
	private static Header header;

	public static Response getResponse() {
		return response;
	}

	private static void setResponse(Response response) {
		RESTSupport.response = response;
	}

	private static RequestSpecification buildBaseRequestSpecification() {

		RequestSpecification rs = given().when().contentType(ContentType.JSON).accept(ContentType.JSON);
		addHeader(getHeader(), rs);
		return rs;
	}

	private static void addHeader(Header h, RequestSpecification rs) {
		if (h != null) {
			rs.header(h);
		}
	}

	private static Header getHeader() {
		return header;
	}

	public static void executeGet(String endpoint, Integer statusCode) {
		response = buildBaseRequestSpecification().accept("*/*").get(endpoint).then().statusCode(statusCode).extract()
				.response();
		printLog(response.getBody().asString(), endpoint, "");
		setResponse(response);
	}

	public static Response executeGet(String endpoint) {
		response = buildBaseRequestSpecification().accept("*/*").get(endpoint).then().extract().response();
		printLog(response.getBody().asString(), endpoint, "");
		return response;
	}

	private static void printLog(String response, String url, String json) {
		System.out.println("");
		System.out.println("====================================");
		System.out.println("");
		System.out.println("Endpoint => " + url);
		System.out.println("");
		System.out.println("Body - Request => " + json);
		System.out.println("");
		System.out.println("Response => " + response);
	}

	public static Integer getResponseCode() {
		return response.getStatusCode();
	}

	public static <T> T key(String field) {
		return response.getBody().jsonPath().get(field);
	}
}
