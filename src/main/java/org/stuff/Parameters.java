package org.stuff;
import java.util.ArrayList;
import java.util.List;

/*
    To store parameters of the url.
    This is assuming each request does not have more than one token or csrf at the same time.
    Other multiples of other parameters are alright.
 */

public class Parameters {
    private String token;
    private String csrfToken;
    private List<String> parameters;

    public Parameters() {
        this.token = null;
        this.csrfToken = null;
        this.parameters = new ArrayList<>();
    }

    //NO csrf token
    public Parameters(String token, List<String> parameters) {
        this.token = token;
        this.parameters = parameters;
    }

    //with csrf token
    public Parameters(String token, String csrfToken, List<String> parameters) {
        this.token = token;
        this.csrfToken = csrfToken;
        this.parameters = parameters;
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

}
