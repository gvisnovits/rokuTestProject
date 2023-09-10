package tests.helloworld;

import ServerRequests.JsonBodyRequests.CreateSession;
import ServerRequests.JsonBodyResponse.ElementActiveResponse;
import com.google.gson.Gson;
import config.Config;

public class SerializationTests {

    public static void main(String[] args) {
//        serializeExample();
        deserializeExample();
    }

    private static void serializeExample() {
        CreateSession createSession = new CreateSession(Config.ROKU_IP);
        Gson gson = new Gson();
        gson.toJson(createSession);
        String json = gson.toJson(createSession);
        System.out.println(json);
    }

    private static void deserializeExample() {
        String returnStatement = "";
        Gson gson = new Gson();
        ElementActiveResponse elementActiveResponse = gson.fromJson(returnStatement, ElementActiveResponse.class);
    }
}
