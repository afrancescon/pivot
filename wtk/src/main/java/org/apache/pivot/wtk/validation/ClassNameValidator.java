package org.apache.pivot.wtk.validation;

public class ClassNameValidator implements Validator {

    @Override
    public boolean isValid(String text) {

        if (text.length() == 0) {
            return true;
        }

        try {

            // Class for name
            Class.forName(text);

            return true;

        } catch (Throwable ex) {
            return false;
        }

    }

}
