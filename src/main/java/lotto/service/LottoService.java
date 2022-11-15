package lotto.service;

import camp.nextstep.edu.missionutils.Console;

import lotto.domain.GameScore;
import lotto.domain.GameView;
import lotto.domain.LottoWinType;
import lotto.utils.ValidateUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static lotto.domain.GameScore.getGameScore;
import static lotto.domain.Lotto.checkSameNumber;
import static lotto.domain.Lotto.makeLottoNumbers;


public class LottoService {

    public void startLottoGame() {
        // 1. 사용자의 구매금액을 입력 받음
        int userPay = inputUserPay();

        // 2. 로또 개수를 출력
        int lottoCount = getLottoCount(userPay);

        // 3. 랜덤 숫자를 뽑음
        List<List<Integer>> randomLottoNumber = makeLottoNumbers(lottoCount);
        
        // 5. 로또 번호를 입력받음
        List<Integer> userLottoNumber = inputLottoNumbers();

        // 6. 보너스 번호를 입력받음
        int bonus = inputBonusLottoNumber();

        // 7. 게임 스코어 출력하기

        for (List<Integer> randomNumber : randomLottoNumber) {
            LottoWinType lottoWinType = checkSameNumber(userLottoNumber, randomNumber, bonus);
            int totalPrize = 0;
            totalPrize += lottoWinType.getMoney();
            GameScore gameScore = getGameScore(totalPrize, userPay, lottoWinType);
            GameView.printWinLottoStats(gameScore);
        }
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
        System.out.println(change + "개 를 구매했습니다.");
        return change;
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

    private static int inputBonusLottoNumber() {
        String bonus = Console.readLine().trim();
        ValidateUtils.checkNumberType(bonus);
        ValidateUtils.checkInputSize(bonus.length(), 1);
        ValidateUtils.checkNumberRange(Integer.parseInt(bonus));
        return Integer.parseInt(bonus);
    }
}
