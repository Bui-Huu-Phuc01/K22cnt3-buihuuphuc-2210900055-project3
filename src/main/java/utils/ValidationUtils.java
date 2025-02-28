package utils;

import java.util.regex.Pattern;

public class ValidationUtils {

    private static final String PHONE_REGEX = "^[0-9]{10,15}$";
    private static final String EMAIL_REGEX = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";

    public static boolean isValidPhone(String phone) {
        return phone != null && Pattern.matches(PHONE_REGEX, phone);
    }

    public static boolean isValidEmail(String email) {
        return email != null && Pattern.matches(EMAIL_REGEX, email);
    }

    public static boolean isNotEmpty(String str) {
        return str != null && !str.trim().isEmpty();
    }
}
