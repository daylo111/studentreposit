import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.util.Scanner;

import java.util.Iterator;

public class JsonParser {
    public static void parseJSOn(String url) throws ParseException {
        Client client = Client.create();
        WebResource webResource = client.resource(url);

        ClientResponse clientResponse = webResource.accept("application/json").get(ClientResponse.class);
        if(clientResponse.getStatus()!=200){
            throw new RuntimeException("Error"+clientResponse.toString());
        }
        JSONArray jsonArray = (JSONArray) new JSONParser().parse(clientResponse.getEntity(String.class));

        Iterator<Object> it =jsonArray.iterator();

        while(it.hasNext()){
            JSONObject jsonObject = (JSONObject)it.next();
            System.out.println(jsonObject.get("name"));
            System.out.println(jsonObject.get("gpa"));
            System.out.println(jsonObject.get("email"));
            System.out.println(jsonObject.get("gender"));
        }

    }
    public static void main(String[] args) throws ParseException {
        parseJSOn("https://hccs-advancejava.s3.amazonaws.com/student.json");
    }

}