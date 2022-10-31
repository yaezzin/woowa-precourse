package onboarding;

import java.util.List;

class Problem1 {

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        if (pobi.size() != 2 || crong.size() != 2) {
            return WrongListSizeException();
        }

        return answer;
    }

    private static Integer WrongListSizeException() {
        return -1;
    }

}