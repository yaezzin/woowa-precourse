package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {

    private static List<Integer> computer = new ArrayList<>();
    private static int strike = 0;
    private static int ball = 0;

    public Computer() {
        init();
    }

    private void init() {
        this.computer = generateRandomNumber();
    }

    public static List<Integer> generateRandomNumber() {
        computer.clear();
        while(computer.size() < 3) {
            int randomNUmber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNUmber)) {
                computer.add(randomNUmber);
            }
        }
        return computer;
    }

}
