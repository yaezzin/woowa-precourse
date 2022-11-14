package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Application {

    private static int inputUserPay() {
        System.out.println("구입금액을 입력해 주세요");
        String money = Console.readLine().trim();
        return Integer.parseInt(money);
    }

    public static void main(String[] args) {
    }
}
