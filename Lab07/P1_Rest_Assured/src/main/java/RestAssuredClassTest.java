import org.junit.Test;

import java.util.ArrayList;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class RestAssuredClassTest {

    final static String url="https://jsonplaceholder.typicode.com/todos";

    @Test
    public void testTodos(){

        given().when().get(url).then().assertThat().statusCode(200);
    }

    @Test
    public void testTitle4(){

        String expected4 = "et porro tempora";

        given().when().get(url + "/4").then().assertThat().statusCode(200).and().body("title",equalTo(expected4)).and().body("id",equalTo(4));
    }

    @Test
    public void testGet198WhenTodos(){

        String expected4 = "et porro tempora";

        given().when().get(url).then().assertThat().statusCode(200).and().body("id", hasItems(198,199));
    }
}
