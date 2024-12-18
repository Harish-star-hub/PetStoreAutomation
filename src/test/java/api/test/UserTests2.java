package api.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.userendpoints;
import api.endpoints.userendpoints2;
import api.payloads.user;
import io.restassured.response.Response;

public class UserTests2 {

	Faker faker;
	user userPayload;

	public Logger logger;

	@BeforeClass
	public void setup() {
		faker = new Faker();
		userPayload = new user();

		userPayload.setId(faker.idNumber().hashCode());
		userPayload.setUsername(faker.name().username());
		userPayload.setFirstName(faker.name().firstName());
		userPayload.setLastName(faker.name().lastName());
		userPayload.setEmail(faker.internet().safeEmailAddress());
		userPayload.setPassword(faker.internet().password(5, 10));
		userPayload.setPhone(faker.phoneNumber().cellPhone());

		// logger
		logger = LogManager.getLogger(this.getClass());

	}

	@Test(priority = 1)
	public void testPostUser() {

		logger.info("************creating user************");

		Response response = userendpoints2.createuser(userPayload);
		response.then().log().all();

		logger.info("************created user************");

	}

	@Test(priority = 2)
	public void testreaduser() {

		Response response = userendpoints2.readuser(this.userPayload.getUsername());
		response.then().log().all();

	}

	@Test(priority = 3)
	public void testupdateUser() {

		// update the payload data

		userPayload.setFirstName(faker.name().firstName());
		userPayload.setLastName(faker.name().lastName());
		userPayload.setEmail(faker.internet().safeEmailAddress());

		Response response = userendpoints2.Updateuser(this.userPayload.getUsername(), userPayload);
		response.then().log().all();

		// get details after updation

		Response responseafterupdate = userendpoints2.readuser(this.userPayload.getUsername());
		responseafterupdate.then().log().all();

	}

	@Test(priority = 4)
	public void testdeleteuser() {

		Response response2 = userendpoints2.deleteuser(this.userPayload.getUsername());
		response2.then().log().all();

	}

}
