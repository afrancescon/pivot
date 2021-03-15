package org.apache.pivot.wtk.validation;

public class EmailsValidator extends EmailValidator {

    private String separator;

    public EmailsValidator() {
        this.separator = separator;
    }

    public EmailsValidator(String separator) {
        this.separator = separator;
    }

    public String getSeparator() {
        return separator;
    }

    public void setSeparator(String separator) {
        this.separator = separator;
    }

    @Override
    public boolean isValid(String text) {

        // Split emails
        String[] emails = text.split(separator);

        for (String email : emails) {

            if (!super.isValid(email)) {
                return false;
            }

        }

        return true;

    }

}
