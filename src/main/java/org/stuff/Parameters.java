package org.stuff;

import java.util.List;

public class Parameters {
    private String token;
    private String csrfToken;
    private List<String> parameters;

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
}
