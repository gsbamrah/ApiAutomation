package GetRequest;

import com.jayway.restassured.response.Response;
import org.json.JSONArray;
import org.json.JSONException;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.jayway.restassured.RestAssured.get;


/**
 * Created by gurpreetsingh on 2/27/2016.
 */
public class ResponseAsJsonArray {

    @Test
    public void getRequest() throws JSONException {

            //make get request to fetch capital of norway
            Response resp = get("http://restcountries.eu/rest/v1/name/norway");

            //Fetching response in JSON
            JSONArray jsonResponse = new JSONArray(resp.asString());


        //Fetching value of capital parameter
            String capital = jsonResponse.getJSONObject(0).getString("capital");

            //Asserting that capital of Norway is Oslo
            Assert.assertEquals(capital, "Oslo");
        }

    }

