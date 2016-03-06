package GetRequest;

import com.jayway.restassured.response.Response;
import org.json.JSONException;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static com.jayway.restassured.RestAssured.get;

/**
 * Created by gurpreetsingh on 2/27/2016.
 */
public class ResponseAsJson {

    @Test
    public void getRequest() throws JSONException, IOException {

        //make get request to fetch capital of norway
        Response resp = get("http://localhost:8080/greeting?name=User");

        //Fetching response in JSON

       BufferedReader br=new BufferedReader(new InputStreamReader(resp.asInputStream()));
     String   str=br.readLine();
          char arr[]=str.toCharArray();
        Assert.assertEquals(arr[1],"Hello, User!");
    }
}
