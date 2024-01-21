package org.stuff;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class Main {
    private static ArrayList<String> results = new ArrayList<>();
    public static void main(String[] args) {
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
        List<String> responses = getResponses(validAuthTokens,requests);
        System.out.println(responses.toString());
    }

    //method to check url and returns list
    public static List<String> getResponses(List<String> valid_auth_tokens,
                                            List<List<String>> requests) {

        List<String> responses = new ArrayList<>();

        for(int i = 0; i < requests.size(); i++) {
            Request current = parameters(requests.get(i).get(0),requests.get(i).get(1));

            //send request to check each one
            if(current.getType().equals("GET") && valid_auth_tokens.contains(current.getToken())) {
                responses.add("VALID");
                for(String x : current.getParameters()) {
                    responses.add(x);
                }
            }
            else if(current.getType().equals("POST") &&
                    valid_auth_tokens.contains(current.getToken())
                    && current.getCsrfToken() != null
                    && TokenChecker.checkCSRF(current.getCsrfToken()))
            {
                responses.add("VALID");
                for(String x : current.getParameters()) {
                    responses.add(x);
                }
            }
            else responses.add("INVALID");
        }
        return responses;
    }

    //url breakdown returns Request object
    public static Request parameters(String type, String url) {
        Request newRequest = new Request();

        int startX = url.indexOf('?');
        if(startX != -1) {
            String query = url.substring(startX + 1); //separates the parameter section(Tokens too) from rest of url

            String[] diffParameters = query.split("&"); //query part is split into different parameters
            for(String str : diffParameters) {
                String[] sections = str.split("="); //splits each parameter into value and key, ex token and actual token
                if(sections.length == 2) {
                    if(sections[0].equals("token")) newRequest.setToken(sections[1]);
                    else if(sections[0].equals("csrf")) newRequest.setCsrfToken(sections[1]);
                    else {
                        newRequest.addToList(sections[0]);
                        newRequest.addToList(sections[1]);
                    }
                }
            }
            newRequest.setType(type); //sets type of request
        }
        return newRequest;
    }



}