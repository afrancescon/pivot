package org.apache.pivot.wtk.validation;

import org.apache.pivot.collections.ArrayList;

public class AndValidators implements Validator {

    private final ArrayList<Validator> validators = new ArrayList<>();

    public AndValidators() {
    }

    @Override
    public boolean isValid(String text) {

        for (Validator validator : validators) {

            if (!validator.isValid(text)) {
                return false;
            }

        }

        return true;

    }

    public ArrayList<Validator> getValidators() {
        return validators;
    }

}
