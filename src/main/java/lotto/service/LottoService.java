package lotto.service;

import camp.nextstep.edu.missionutils.Console;
import lotto.utils.ValidateUtils;

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

        ValidateUtils.checkSaparator(input.length);
        ValidateUtils.checkInputSize(input.length);

        List<Integer> answer = new ArrayList<>();
        for (String input : inputs) {
            int lottoNumber = Integer.parseInt(input);
            ValidateUtils.checkNumberRange(lottoNumber);
            ValidateUtils.checkDuplicatedRange(answer, lottoNumber);
        }
        return answer;
    }

}
