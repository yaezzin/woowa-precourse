package lotto.utils;

import java.util.List;

public class ValidateUtils {

    public static void checkNumberType(String money) {
        for (int i = 0; i < money.length(); i++) {
            if (!Character.isDigit(money.charAt(i))) {
                System.out.println("금액은 숫자만 입력 가능합니다.");
                throw new IllegalArgumentException("[ERROR] 금액은 숫자만 입력 가능합니다.");
            }
        }
    }

    public static void checkUnit(int money) {
        if (money % 1000 != 0) {
            System.out.println("금액은 1,000원 단위로만 입력 가능합니다.");
            throw new IllegalArgumentException("[ERROR] 금액은 1,000원 단위로만 입력 가능합니다.");
        }
    }

    public static void checkSeparator(int size) {
        if (size == 1) {
            System.out.println("로또 번호는 구분자(',')를 이용하여 입력합니다.");
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 구분자(',')를 이용하여 입력합니다.");
        }
    }

    public static void checkInputSize(int size) {
        if (size != 6) {
            System.out.println("로또 번호는 6개만 입력합니다.");
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 6개만 입력합니다.");
        }
    }

    public static void checkNumberRange(int number) {
        if (number < 1 || number > 45) {
            System.out.println("로또 번호는 1 ~ 45 범위의 값만 입력합니다.");
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1 ~ 45 범위의 값만 입력합니다.");
        }
    }

    public static void checkDuplicatedRange(List<Integer> numberList, int number) {
        if (numberList.contains(number)) {
            System.out.println("중복된 로또 번호는 입력할 수 없습니다");
            throw new IllegalArgumentException("[ERROR] 중복된 당첨 번호는 입력할 수 없습니다.");
        }
    }
}
