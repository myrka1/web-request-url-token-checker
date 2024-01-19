package org.stuff;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Map.Entry;

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

        //token checker(list of auth tokens,token to check);
        getResponses(validAuthTokens,requests);
    }

    //method to check url and returns list
    public static List<String> getResponses(List<String> valid_auth_tokens,
                                            List<List<String>> requests) {
        List<String> responses = new ArrayList<>();
        Map<String,String> parameters = new HashMap<>();

        for(int i = 0; i < requests.size(); i++) {
            //for(int k = 0; k < requests.size(); k++) {
                parameters = parameters(requests.get(i).get(1));
                mapPrinter(parameters);
            //}

        }

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
                String temp = "+";
                if(sections.length == 2) {
                    if(queryParameters.containsKey(sections[0])) {
                        temp += "+";
                        queryParameters.put(sections[0]+temp,sections[1]);
                    }
                    else {
                        queryParameters.put(sections[0],sections[1]);
                    }
                }
            }
        }
        return queryParameters;
    }

    public static String validTokenChecker(List<String> authTokens,String token) {
        for(String key : authTokens) {
            if(token.equals(key)) return key;
        }

        return "hell0";
    }

    public static void mapPrinter(Map<String,String> stuff) {
        System.out.println("MAP SIZE: " + stuff.size());
        for(Map.Entry<String, String> entry : stuff.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            System.out.println("Key: " + key + ", Value: " + value);
        }
    }
}