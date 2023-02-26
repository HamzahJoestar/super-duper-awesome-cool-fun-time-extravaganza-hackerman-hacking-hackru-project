import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class NJTransitFAQParser{
    public static void main(String[] args) {
        try{
            //Read NJ Transit JSON file into string
            String jsonStr = new String(Files.readAllBytes(Paths.get("nj-transitfaq.json")));

            //Parse JSON string into objects
            JSONObject jsonObj = new JSONObject(jsonStr);

            //get the faqs array from the JSON object
            JSONArray faqsArr = jsonObj.getJSONArray("faqs");

            //loop through the faqs array and print each FAQ question and answer
            for(int i =0; i<faqsArr.length(); i++){
                JSONObject faqObj = faqsArr.getJSONObject(i);
                String question = faqObj.getString("q");
                String answer = faqObj.getString("a");
                System.out.println("Question: " + question);
                System.out.println("Answer: " + answer);
            }
 
        } catch (IOException | JSONException e){
            e.printStackTrace();
        }
    }
}
