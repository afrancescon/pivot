package org.apache.pivot.wtk.validation;

import java.util.regex.Pattern;

public class EmailValidator implements Validator {

    private static final Pattern EMAIL_PATTERN = Pattern.compile("^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$");

    public EmailValidator() {
    }

    @Override
    public boolean isValid(String text) {
        return text.length() == 0 || EMAIL_PATTERN.matcher(text).matches();
    }

}
