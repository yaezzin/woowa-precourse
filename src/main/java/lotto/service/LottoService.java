package lotto.service;

import camp.nextstep.edu.missionutils.Console;

import lotto.domain.*;
import lotto.utils.ValidateUtils;

import java.util.ArrayList;
import java.util.List;

import static lotto.domain.GameView.printProfitRange;
import static lotto.domain.GameView.printWinLottoStats;
import static lotto.domain.Lotto.makeLottoNumbers;


public class LottoService {

    public void startLottoGame() {
        User user = getUserLottoListByPay();
        Lotto userLottoNumbers = inputLottoNumbers();
        int bonusNumber = inputBonusLottoNumber();
        GameScore score = user.getGameScore(userLottoNumbers, bonusNumber);
        printProfitRange(score.getProfitRate());
        printWinLottoStats(score);
    }

    private User getUserLottoListByPay() {
        int userPay = inputUserPay();
        int lottoCount = getLottoCount(userPay);
        List<Lotto> lotto = makeLottoNumbers(lottoCount);
        return User.of(userPay, lotto);
    }

    private static int inputUserPay() {
        System.out.println("구입금액을 입력해 주세요");
        String money = Console.readLine().trim();
        ValidateUtils.checkNumberType(money);
        ValidateUtils.checkUnit(Integer.parseInt(money));
        return Integer.parseInt(money);
    }

    private static int getLottoCount(int money) {
        int change = 0;
        change = money / 1000;
        System.out.println(change + "개를 구매했습니다.");
        return change;
    }

    private static Lotto inputLottoNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String inputList = Console.readLine().trim();
        String[] inputs = inputList.split(",");

        ValidateUtils.checkSeparator(inputs.length);
        ValidateUtils.checkInputSize(inputs.length, 6);

        List<Integer> answer = new ArrayList<>();
        for (String input : inputs) {
            int lottoNumber = Integer.parseInt(input);
            ValidateUtils.checkNumberRange(lottoNumber);
            ValidateUtils.checkDuplicatedRange(answer, lottoNumber);
            answer.add(lottoNumber);
        }
        return Lotto.of(answer);
    }

    private static int inputBonusLottoNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        String bonus = Console.readLine().trim();
        ValidateUtils.checkNumberType(bonus);
        ValidateUtils.checkInputSize(bonus.length(), 1);
        ValidateUtils.checkNumberRange(Integer.parseInt(bonus));
        return Integer.parseInt(bonus);
    }
}
