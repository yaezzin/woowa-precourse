package bridge;

import static bridge.ErrorMessage.INPUT_NUMBER_RANGE_ERROR;

public class ValidateUtils {

    public static void validateNumberRange(int number) {
        if (number < 3 || number > 20) {
            throw new IllegalArgumentException(INPUT_NUMBER_RANGE_ERROR);
        }
    }
}
