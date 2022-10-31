package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;

        if (!isNumberRange(number)) {
            return -1;
        }
        return answer;
    }

    private static boolean isNumberRange(int number) {
        if (number < 1 || number > 10000) {
            return false;
        }
        return true;
    }
}
