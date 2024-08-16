package data;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;

import java.io.FileReader;
import java.io.IOException;

public class CheckoutData {
    public String firstName,lastName,Mobile,street1,street2,city,postcode,comment;

    public void testData() throws IOException, ParseException {
        String srcFile = System.getProperty("user.dir")+"/src/test/java/data/checkoutData.json";
        File file = new File(srcFile);

        JSONParser parser = new JSONParser();
        JSONArray jsonArray = (JSONArray) parser.parse(new FileReader(file));

        for (Object object : jsonArray){
            JSONObject person = (JSONObject) object;
            firstName = (String) person.get("firstName");
            lastName = (String) person.get("lastName");
            Mobile = (String) person.get("mobile");
            street1 = (String) person.get("street1");
            street2 = (String)  person.get("street2");
            city = (String) person.get("city");
            postcode = (String) person.get("postcode");
            comment = (String) person.get("comment");
        }
    }
}
