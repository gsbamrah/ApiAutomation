package GetRequest; /**
 * Created by gurpreetsingh on 2/28/2016.
 */
import org.json.JSONObject;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;
public class HttpUrlConnectionMethod {



        @Test
        public void aptTesting() throws Exception {
            try {
                String url2="http://localhost:8080/greeting?";
                String RequestParam="name";
                String Paramvalue="User";
                URL url = new URL(url2+RequestParam+"="+Paramvalue);
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
               conn.setRequestMethod("GET");
              conn.setRequestProperty("Accept","application/json");

                if (conn.getResponseCode() != 200) {
                    throw new RuntimeException("HTTP error code : "
                    + conn.getResponseCode());
                }

                Scanner scan = new Scanner(url.openStream());
                String entireResponse = new String();
                while (scan.hasNext())
                    entireResponse += scan.nextLine();

                System.out.println("Response : "+entireResponse);

                scan.close();

                JSONObject obj = new JSONObject(entireResponse );
                String responseCode = obj.getString("content");
                System.out.println("status :" + responseCode);



                conn.disconnect();
            } catch (MalformedURLException e) {
                e.printStackTrace();

            } catch (IOException e) {

                e.printStackTrace();

            }

        }
    }
