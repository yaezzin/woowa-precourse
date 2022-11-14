package lotto.utils;

public class ValidateUtil {

    public static void checkNumberType(String money) {
        for (int i = 0; i < money.length(); i++) {
            if (!Character.isDigit(money.charAt(i))) {
                System.out.println("금액은 숫자만 입력 가능합니다.");
                throw new IllegalArgumentException("[ERROR] 금액은 숫자만 입력 가능합니다.");
            }
        }
    }


}
