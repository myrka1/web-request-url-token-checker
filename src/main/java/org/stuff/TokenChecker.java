package org.stuff;
/*
    This class checks if the csrf token is valid. For the csrf token to be valid it must
    be of length 8 or more and it cannot contain non-alphanumeric characters.
 */
public class TokenChecker {

    public static boolean checkCSRF(String csrfToken) {
        //must be 8 or more in length
        //non alpha chars not allowed
        //System.out.println("TOKEN CHECKER CSRF: " + csrfToken);
        return csrfToken.length() >= 8 && isAlphanumeric(csrfToken);
    }

    private static boolean isAlphanumeric(String token) {
        return token != null && token.matches("[a-zA-Z0-9]+");
    }
}
