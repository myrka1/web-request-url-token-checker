package org.stuff;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        //System.out.println("Hello world!");
        //creation of parameters
        //list of tokens
        List<String> validAuthTokens = new ArrayList<>() {
            {
                add("ah37j2ha483u");
                add("safh34ywb0p5");
                add("ba34wyi8t902");
            }
        };
        /* validAuthTokens.add("ah37j2ha483u");
        validAuthTokens.add("safh34ywb0p5");
        validAuthTokens.add("ba34wyi8t902"); */
        List<String> request1 = new ArrayList<>() {{
            add("GET");
            add("https://example.com/?token=347sd6yk8iu2&name=alex");
        }};
        List<String> request2 = new ArrayList<>() {{
            add("GET");
            add("https://example.com/?token=safh34ywb0p5&name=sam");
        }};
        List<String> request3 = new ArrayList<>() {{
            add("POST");
            add("https://example.com/?token=safh34ywb0p5&name=alex");
        }};
        List<String> request4 = new ArrayList<>() {{
            add("POST");
            add("https://example.com/?token=safh34ywb0p5&csrf=ak2sh32dy&name=riley&name=alex");
        }};
        //list of request lists
        List<List<String>> requests = new ArrayList<>() {{
            add(request1);
            add(request2);
            add(request3);
            add(request4);
        }};
    }

    //method to check url and returns list
    public static List<String> getResponses(List<String> valid_auth_tokens,
                                            List<List<String>> requests) {
        List<String> responses = new ArrayList<>();
        return responses;
    }

    //url breakdown returns map
    public static Map<String,String> parameters(String url) {
        Map<String,String> queryParameters = new HashMap<>();

        int startX = url.indexOf('?');
        if(startX != -1) {
            String query = url.substring(startX + 1); //separates the parameter section(Tokens too) from rest of url

            String[] diffParameters = query.split("&"); //query part is split into different parameters
            for(String str : diffParameters) {
                String[] sections = str.split("="); //splits each parameter into value and key, ex token and actual token
                if(sections.length == 2) {
                    queryParameters.put(sections[0],sections[1]);
                }
            }
        }
        return queryParameters;
    }
}