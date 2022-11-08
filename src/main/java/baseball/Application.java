package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {

    private static List<Integer> computer = new ArrayList<>();

    private static void startGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        generateRandomNumber();
    }

    private static void generateRandomNumber() {
        computer.clear();
        while(computer.size() < 3) {
            int randomNUmber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNUmber)) {
                computer.add(randomNUmber);
            }
        }
    }

    private static void getUserNumber() {
        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();
        List<Integer> userNumber = Utils.convertStringToInteger(input);
    }

    public static void main(String[] args) {
        startGame();
    }
}
