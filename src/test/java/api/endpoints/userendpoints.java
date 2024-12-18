package api.endpoints;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import api.payloads.user;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class userendpoints {

	public static Response createuser(user payload) {

		Response response = given().contentType(ContentType.JSON).accept(ContentType.JSON).body(payload)

				.when().post(Routes.posturl);

		return response;

	}

	public static Response readuser(String UserName) {

		Response response = given().pathParam("username", UserName)
				.when().get(Routes.geturl);

		return response;
	}

	public static Response Updateuser(String UserName, user payload) {

		Response response = given().contentType(ContentType.JSON).accept(ContentType.JSON).body(payload)
				.pathParam("username", UserName)

				.when().put(Routes.updateurl);

		return response;
	}

	public static Response deleteuser(String UserName) {

		Response response = given().accept(ContentType.JSON).pathParam("username", UserName).when()
				.delete(Routes.deleteurl);

		return response;
	}

}
