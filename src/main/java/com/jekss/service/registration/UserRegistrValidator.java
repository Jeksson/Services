package com.jekss.service.registration;

import java.util.regex.Pattern;

/**
 * Created by jekss on 23.10.15.
 */
public class UserRegistrValidator {
    private static Pattern pattern;

    private static final String LOGIN_AND_NAME_PATTERN = "^[a-zA-Z0-9_-]{3,30}$";
    private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";


    public static boolean emailValidation(final String email){
        pattern = Pattern.compile(EMAIL_PATTERN);
        return pattern.matcher(email).matches();
    }

    public static boolean loginValidation(final String login){
        pattern = Pattern.compile(LOGIN_AND_NAME_PATTERN);
        return pattern.matcher(login).matches();
    }
     public static boolean nameValidation(final String name){
         pattern = pattern.compile(LOGIN_AND_NAME_PATTERN);
         return  pattern.matcher(name).matches();
     }
}
