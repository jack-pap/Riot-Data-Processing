import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class readJSONData {



  public static void main(String[] args) {
    //JSON parser object to parse read file
    JSONParser jsonParser = new JSONParser();

    try (FileReader reader = new FileReader("rp_purchase_history.json"))
    {
      //Read JSON file
      Object obj = jsonParser.parse(reader);

      JSONArray purchaseList = (JSONArray) obj;

      double totalAmount = 0;

      for (Object consumer : purchaseList) {
        String price = ((JSONObject) consumer).get("amount").toString();
        totalAmount += Double.parseDouble(price);
      }
      System.out.println("Your total amount spent in League of Legends is: " + totalAmount);
      File total = new File("totalAmount.txt");
      FileWriter fileWriter = new FileWriter(total);
      fileWriter.write("Your total amount spent in League of Legends is: " + totalAmount);
      fileWriter.close();


    } catch (IOException | ParseException e) {
      e.printStackTrace();
    }
  }

}
