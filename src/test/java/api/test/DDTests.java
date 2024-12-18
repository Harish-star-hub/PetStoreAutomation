package api.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.userendpoints;
import api.payloads.user;
import api.utilities.DataProviders;
import io.restassured.response.Response;

public class DDTests {

	Faker faker;

	@Test(priority = 1, dataProvider = "Data", dataProviderClass = DataProviders.class)
	public void testPostuser(String userID, String userName, String fname, String lname, String useremail, String pwd,
			String ph) {
		user userPayload = new user();

		userPayload.setId(Integer.parseInt(userID));
		userPayload.setUsername(userName);
		userPayload.setFirstName(fname);
		userPayload.setLastName(lname);
		userPayload.setEmail(useremail);
		userPayload.setPassword(pwd);
		userPayload.setPhone(ph);

		Response response = userendpoints.createuser(userPayload);
		Assert.assertEquals(response.getStatusCode(), 200);

	}

	@Test(priority = 2, dataProvider = "UserNames", dataProviderClass = DataProviders.class)
	public void testgetUserByName(String userName) {
		Response response = userendpoints.readuser(userName);
		Assert.assertEquals(response.getStatusCode(), 200);

	}

	@Test(priority = 3, dataProvider = "UserNames", dataProviderClass = DataProviders.class)
	public void testDeleteUserByName(String userName) {
		Response response = userendpoints.deleteuser(userName);
		Assert.assertEquals(response.getStatusCode(), 200);

	}

}
