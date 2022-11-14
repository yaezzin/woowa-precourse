package lotto.service;

import camp.nextstep.edu.missionutils.Console;
import lotto.utils.ValidateUtils;
import org.junit.jupiter.params.shadow.com.univocity.parsers.annotations.Validate;

import java.util.ArrayList;
import java.util.List;

public class LottoService {

    public void startLottoGame() {
        // 사용자의 입력을 받음
        inputUserPay();

    }

    private static int inputUserPay() {
        System.out.println("구입금액을 입력해 주세요");
        String money = Console.readLine().trim();

        ValidateUtils.checkNumberType(money);
        ValidateUtils.checkUnit(Integer.parseInt(money));

        return Integer.parseInt(money);
    }

    private static List<Integer> inputLottoNumbers() {
        String inputList = Console.readLine().trim();
        String[] inputs = inputList.split(",");

        ValidateUtils.checkSeparator(inputs.length);
        ValidateUtils.checkInputSize(inputs.length, 6);

        List<Integer> answer = new ArrayList<>();
        for (String input : inputs) {
            int lottoNumber = Integer.parseInt(input);
            ValidateUtils.checkNumberRange(lottoNumber);
            ValidateUtils.checkDuplicatedRange(answer, lottoNumber);
        }
        return answer;
    }

    public static int inputBonusLottoNumber() {
        String bonus = Console.readLine().trim();
        ValidateUtils.checkNumberType(bonus);
        ValidateUtils.checkInputSize(bonus.length(), 1);
        ValidateUtils.checkNumberRange(Integer.parseInt(bonus));
        return Integer.parseInt(bonus);
    }
}
