package com.practiceproblem.mergetwojson;

import org.json.JSONObject;

public class MergeTwoJSON {
    public static void main(String[] args) {

        // First JSON object
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", "rahul");
        jsonObject.put("age", 19);

        // Second JSON object
        JSONObject jsonObject2 = new JSONObject();
        jsonObject2.put("email", "rahul@gmail.com");
        jsonObject2.put("phone", 968653838);

        // Merge jsonObject into jsonObject2
        for (String key : jsonObject.keySet()) {
            jsonObject2.put(key, jsonObject.get(key));
        }

        // Print merged JSON
        System.out.println(jsonObject2.toString(4)); // Pretty print with indentation
    }
}
