package bridge;

import static bridge.ErrorMessage.INPUT_NUMBER_RANGE_ERROR;
import static bridge.ErrorMessage.VALIDATE_INTEGER_TYPE;

public class ValidateUtils {

    public static void validateNumberRange(int number) {
        if (number < 3 || number > 20) {
            throw new IllegalArgumentException(INPUT_NUMBER_RANGE_ERROR);
        }
    }

    public static void validateNumberType(String number) {
        try {
            Integer.parseInt(number);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(VALIDATE_INTEGER_TYPE);
        }
    }
}
