package api.endpoints;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.ResourceBundle;

import api.payloads.user;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class userendpoints2 {

	// method created for getting URL's from properties file
	static ResourceBundle getURL() {
		ResourceBundle routes = ResourceBundle.getBundle("routes"); // Load properties file // name of the properties
																	// file
		return routes;
	}

	public static Response createuser(user payload) {
		String post_url = getURL().getString("post_url");

		Response response = given().contentType(ContentType.JSON).accept(ContentType.JSON).body(payload)

				.when().post(post_url);

		return response;

	}

	public static Response readuser(String UserName) {

		String get_url = getURL().getString("get_url");

		Response response = given().pathParam("username", UserName).when().get(get_url);

		return response;
	}

	public static Response Updateuser(String UserName, user payload) {

		String update_url = getURL().getString("update_url");

		Response response = given().contentType(ContentType.JSON).accept(ContentType.JSON).body(payload)
				.pathParam("username", UserName)

				.when().put(update_url);

		return response;
	}

	public static Response deleteuser(String UserName) {

		String delete_url = getURL().getString("delete_url");
		Response response = given().accept(ContentType.JSON).pathParam("username", UserName).when().delete(delete_url);

		return response;
	}

}
