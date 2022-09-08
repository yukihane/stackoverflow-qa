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
        JSONArray data1 = (JSONArray)json.get("data1");
        System.out.println(sum(data1));
        JSONArray data2 = (JSONArray)json.get("data2");
        System.out.println(sum(data2));
    }

    private static int sum(JSONArray ja) {
        int sum = 0;
        for(int i = 0; i < ja.size(); i++)
            sum += ((Integer)ja.get(i)).intValue();
        return sum;
    }
}
