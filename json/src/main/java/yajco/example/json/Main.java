package yajco.example.json;

import yajco.example.json.model.JsonValue;

import java.io.InputStream;

public class Main {
    public static void main(String[] args) throws Exception {
        try (InputStream stream = Main.class.getResourceAsStream("/input.json")) {
            if (stream == null) throw new RuntimeException("input.json not found");
            JsonValue jsonFile = new JsonReader().parse(stream);
            System.out.println(jsonFile);
        }
    }
}
