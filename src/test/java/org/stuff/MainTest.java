package org.stuff;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class MainTest {

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void main() {
        List<String> validAuthTokens = new ArrayList<>() {
            {
                add("ah37j2ha483u");
                add("safh34ywb0p5");
                add("ba34wyi8t902");
            }
        };
        List<String> request4 = new ArrayList<>() {{
            add("POST");
            add("https://example.com/?token=safh34ywb0p5&csrf=ak2sh32dy&name=chris&name=alex");
        }};
        List<List<String>> requests = new ArrayList<>();
        requests.add(request4);
    }

    @Test
    public void getResponses() {
    }

    @Test
    public void parameters() {
        /*String url = "https://example.com/?token=safh34ywb0p5&csrf=ak2sh32dy&name=riley&name=alex";
        Map<String,String> testMap = Main.parameters(url);
        for (Map.Entry<String, String> entry : testMap.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            if(key.equals("token")) assertEquals("safh34ywb0p5", value);
            if(key.equals("csrf")) assertEquals("ak2sh32dy", value);
            if(key.equals("name")) assertTrue(value.equals("riley") || value.equals("alex"));

        }
        /*String url1 = "https://example.com/?token=abc&name=John";
        Map<String, String> params1 = YourClassName.parameters(url1);
        assertEquals(2, params1.size());
        assertEquals("abc", params1.get("token"));
        assertEquals("John", params1.get("name"));

        // Test case 2: URL without parameters
        String url2 = "https://example.com/";
        Map<String, String> params2 = YourClassName.parameters(url2);
        assertEquals(0, params2.size());*/

    }
}