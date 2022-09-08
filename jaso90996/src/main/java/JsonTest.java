import java.io.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonTest {
    public static void main(String[] args) throws Exception {
        File file = new File("test.json");
        JSONParser parser = new JSONParser();
        JSONObject json = (JSONObject)parser.parse(new FileReader(file));
        JSONArray data = (JSONArray)json.get("data");
        System.out.println(sum(data));
    }

    private static double sum(JSONArray ja) {
        double sum = 0;
        for(int i = 0; i < ja.size(); i++)
            sum += ((Number)ja.get(i)).doubleValue();
        return sum;
    }
}
