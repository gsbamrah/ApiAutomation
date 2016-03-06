package GetRequest;

import com.jayway.restassured.response.Response;
import org.json.JSONException;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.jayway.restassured.RestAssured.get;

/**
 * Created by gurpreetsingh on 2/27/2016.
 */
public class RestAssuredApi {

    @Test
    public void getRequest() throws JSONException, IOException {

        String url="http://localhost:8080/greeting?";
        String RequestParam="name";
        String Paramvalue="User";

        //make get request to fetch capital of norway
        Response resp = get(url+RequestParam+"="+Paramvalue);

        JSONObject jsonResponse = new JSONObject(resp.asString());

        //Fetching value of capital parameter
        String capital = jsonResponse.getString("content");

        //Asserting that capital of Norway is Oslo
        Assert.assertEquals(capital, "Hello, User!");



        }


    }
