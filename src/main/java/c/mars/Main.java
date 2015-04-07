package c.mars;

import com.google.gson.Gson;

public class Main {

    public static void main(String[] args) {
        String json = new Gson().toJson(new R("ok"));
        System.out.println(json);
        String repacked = new Gson().toJson(new R(json));
        System.out.println(repacked);
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
