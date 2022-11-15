package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.utils.ValidateUtils;
import org.junit.jupiter.params.shadow.com.univocity.parsers.annotations.Validate;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static lotto.domain.LottoWinType.matchGameScoreAndLottoWinType;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        ValidateUtils.checkNumberRange(numbers);
        ValidateUtils.checkInputSize(numbers.size(), 6);
        ValidateUtils.checkDuplicatedRange(numbers);
    }

    private static List<List<Integer>> makeLottoNumbers(int change) {
        List<List<Integer>> lottoNumberList= new ArrayList<>();
        List<Integer> lotto;

        for (int i = 1; i <= change; i++) {
            lotto = makeRandomLottoNumbers();
            lottoNumberList.add(lotto);
            System.out.println(lotto);
        }
        return lottoNumberList;
    }

    private static List<Integer> makeRandomLottoNumbers() {
        List<Integer> numbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));
        numbers.sort(Comparator.naturalOrder());
        return numbers;
    }

    private static LottoWinType checkSameNumber(List<Integer> lotto, List<Integer> winLotto, int bonusLotto) {
        int answerCount = 0;
        int bonusCount = 0;

        for (Integer number : lotto) {
            if (winLotto.contains(number)) {
                answerCount++;
            }
            if (number == bonusLotto) {
                bonusCount++;
            }
        }
        return matchGameScoreAndLottoWinType(answerCount, bonusCount);
    }
}
