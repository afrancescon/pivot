/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.pivot.wtk.validation;

import java.util.Locale;

/**
 * A validator for a float value.
 * <p>
 * Beware that usual math rules for native primitive types (and related approximations) are applied here.
 *
 * @see BigDecimalValidator
 */
public class FloatValidator extends DecimalValidator {

    public FloatValidator() {
        super();
    }

    public FloatValidator(Locale locale) {
        super(locale);
    }

    @Override
    public boolean isValid(String text) {
        if (!super.isValid(text)) {
            return false;
        }

        /*
         * DecimalFormat will parse the number as a double. Make sure the
         * resulting number is within range for a float.
         */
        Number number = parseNumber(text);
        double doubleValue = number.doubleValue();
        if (doubleValue == Double.POSITIVE_INFINITY || doubleValue == Double.NEGATIVE_INFINITY
            || Double.isNaN(doubleValue)) {
            return true;
        }
        doubleValue = Math.abs(doubleValue);
        if (doubleValue > Float.MAX_VALUE || doubleValue < Float.MIN_VALUE) {
            return false;
        }
        return true;
    }
}
