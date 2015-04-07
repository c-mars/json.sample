package c.mars;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import jdk.nashorn.internal.parser.JSONParser;

import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        String json = new Gson().toJson(new R("ok"));
        System.out.println(json);
        Gson gson = new Gson();

        R r = gson.fromJson(json, R.class);
        if (r == null) {
            String repacked = new Gson().toJson(new R(json));
            System.out.println(repacked);
        } else {
            System.out.println("r: "+r.getStatus());
        }

        String[] jsons = {
                json,
                "a",
                "{b:c}",
                "{okey",
                "{\"c\":\"d\"}"
        };
        for (String s:jsons) {
            System.out.println(s + "->" + valid(s));
        }
//        JsonObject jsonObject = (JsonObject)new JSONParser().parse(json);
    }

    public static boolean valid(String json){
        Gson gson = new Gson();
        try {
            Object o = gson.fromJson(json, Object.class);
            String reversed = new GsonBuilder().setPrettyPrinting().create().toJson(o);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    private static class R {
        public R(String status) {
            this.status = status;
        }

        public String getStatus() {
            return status;
        }

        String status;
    }
}
