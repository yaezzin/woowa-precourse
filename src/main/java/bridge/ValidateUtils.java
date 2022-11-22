package bridge;

import static bridge.ErrorMessage.*;

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
            throw new IllegalArgumentException(VALIDATE_INTEGER_TYPE_ERROR);
        }
    }

    public static void validateMoveType(String move) {
        if (!move.equals("U") && !move.equals("D")) {
            throw new IllegalArgumentException(INPUT_MOVE_TYPE_ERROR);
        }
    }
}
