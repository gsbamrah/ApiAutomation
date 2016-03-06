package PostRequest;

/**
 * Created by gurpreetsingh on 2/28/2016.
 *
 * java.net.ProtocolException: cannot write to a URLConnection if doOutput=false - call setDoOutput(true)
 */

import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
public class Post {


           @Test
           public  void PostRequest()  throws  Exception
           {
            URL url = new URL("http://www.java2s.com");
               HttpURLConnection conn= (HttpURLConnection) url.openConnection();
              conn.setRequestMethod("POST");
            conn.setDoOutput(true);
            OutputStreamWriter writer = new OutputStreamWriter(conn.getOutputStream());

            writer.write("value=1&anotherValue=1");
            writer.flush();
            String line;
            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            writer.close();
            reader.close();

        }
    }
