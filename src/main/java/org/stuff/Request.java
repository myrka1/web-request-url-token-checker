package org.stuff;
import java.util.ArrayList;
import java.util.List;

/*
    To store parameters of the url.
    This is assuming each request does not have more than one token or csrf at the same time.
    Other multiples of other parameters are alright.
 */

public class Request {
    private String type; //type of request ex. POST
    private String token;
    private String csrfToken;
    private List<String> parameters;

    public Request() {
        this.type = null;
        this.token = null;
        this.csrfToken = null;
        this.parameters = new ArrayList<>();
    }

    //NO csrf token
    public Request(String token, List<String> parameters) {
        this.token = token;
        this.parameters = parameters;
    }

    //with csrf token
    public Request(String token, String csrfToken, List<String> parameters) {
        this.token = token;
        this.csrfToken = csrfToken;
        this.parameters = parameters;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getCsrfToken() {
        return csrfToken;
    }

    public void setCsrfToken(String csrfToken) {
        this.csrfToken = csrfToken;
    }

    public List<String> getParameters() {
        return parameters;
    }

    public void setParameters(List<String> parameters) {
        this.parameters = parameters;
    }

    public void addToList(String parameter) {
        parameters.add(parameter);
    }

    //print parameters list
    public static void printParameters(Request current) {
        System.out.println("Type: " + current.type);
        System.out.println("Token: " + current.getToken());
        System.out.println("csrf: " + current.getCsrfToken());
        List<String> list1 = current.getParameters();
        for(String x : list1) {
            System.out.print(x + " ");
        }
        System.out.println();
    }
}
