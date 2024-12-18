package api.endpoints;

public class Routes {

	public static String baseurl = "https://petstore.swagger.io/v2";

	// user module

	public static String posturl = baseurl + "/user";
	public static String geturl = baseurl + "/user/{username}";
	public static String updateurl = baseurl + "/user/{username}";
	public static String deleteurl = baseurl + "/user/{username}";

}
