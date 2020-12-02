package model.validator;

import java.util.regex.Pattern;

public class DataValidator {
    private static final String NAME_REGEX = "^([A-Z][a-z]{2,20})|([А-Я][а-я]{2,20})$";
    private static final String SURNAME_REGEX = "^([A-Z][a-z]{2,30})|([А-Я][а-я]{2,30})$";
    private static final String EMAIL_REGEX = "^([a-z0-9_.-]+)@([a-z0-9_.-]+)\\.([a-z]{2,5})$";
    private static final String PASSWORD_REGEX = "^([A-Za-z0-9_-]{8,40})$";

    public static boolean isNameCorrect(String username) {
        return (Pattern.matches(NAME_REGEX, username));
    }

    public static boolean isSurnameCorrect(String surname) {
        return Pattern.matches(SURNAME_REGEX, surname);
    }

    public static boolean isEmailCorrect(String email) {
        return Pattern.matches(EMAIL_REGEX, email);
    }

    public static boolean isPasswordCorrect(String password) {
        return Pattern.matches(PASSWORD_REGEX, password);
    }
}
