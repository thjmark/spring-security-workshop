package de.intern.springsecurityworkshop;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class InfoControllerTestIT {

	@LocalServerPort
	private Integer port;
	
	
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		 Response response = given(new RequestSpecBuilder().build())
				 	.baseUri("http://localhost:"+port)
				    .accept("application/json")
	                .auth().basic("Fred","fred")
	                .get("/api/info");
		 
		 response.then().assertThat().statusCode(200)
		 				.and()
		 				.body("text",is("Hallo Chef."));
	}

}
