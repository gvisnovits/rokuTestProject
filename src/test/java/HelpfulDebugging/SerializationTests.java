package HelpfulDebugging;

import ServerRequests.ElementUsingEnum;
import ServerRequests.JsonBodyRequests.ElementRequest;
import ServerRequests.JsonBodyResponse.CommonResponses;
import com.google.gson.Gson;

public class SerializationTests {

    public static void main(String[] args) {
        serializeExample();
//        deserializeExample();
    }

    private static void serializeExample() {
        ElementRequest elementRequest = new ElementRequest(ElementUsingEnum.TEXT, "Hello World!");
        Gson gson = new Gson();
        gson.toJson(elementRequest);
        String json = gson.toJson(elementRequest);
        System.out.println(json);
    }

    private static void deserializeExample() {
        String returnStatement = "";
        Gson gson = new Gson();
        CommonResponses commonResponses = gson.fromJson(returnStatement, CommonResponses.class);
    }
}
