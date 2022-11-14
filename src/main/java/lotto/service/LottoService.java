package lotto.service;

import camp.nextstep.edu.missionutils.Console;
import lotto.utils.ValidateUtil;

public class LottoService {

    private static int inputUserPay() {
        System.out.println("구입금액을 입력해 주세요");
        String money = Console.readLine().trim();
        ValidateUtil.checkNumberType(money);
        return Integer.parseInt(money);
    }



}
