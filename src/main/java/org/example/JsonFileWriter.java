package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.io.File;
import java.io.IOException;
public class JsonFileWriter {
    public static void addContacts(String name, String emailAddress, String phoneNumber, int age) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        ObjectNode jsonNode = objectMapper.createObjectNode();
        jsonNode.put("name", name);
        jsonNode.put("age", age);
        jsonNode.put("phoneNumber", phoneNumber);
        jsonNode.put("emailAddress", emailAddress);
        objectMapper.writeValue(new File("contacts-list.json"), jsonNode);
    }
}
