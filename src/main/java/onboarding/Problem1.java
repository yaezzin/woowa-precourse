package onboarding;

import java.util.List;

class Problem1 {

    static final int MIN_PAGE = 1;
    static final int MAX_PAGE = 400;

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        if (pobi.size() != 2 || crong.size() != 2) {
            return WrongListSizeException();
        }

        Integer pobiLeftPage = pobi.get(0);
        Integer pobiRightPage = pobi.get(1);
        Integer crongLeftPage = crong.get(0);
        Integer crongRightPage = crong.get(1);

        if (!isPageRange(pobiLeftPage) || !isPageRange(pobiRightPage) || !isPageRange(crongLeftPage) || !isPageRange(crongRightPage)) {
            return WrongPageRangeException();
        }

        return answer;
    }

    private static boolean isPageRange(Integer page) {
        if (page > MAX_PAGE && page < MIN_PAGE) {
            return false;
        }
        return true;
    }

    private static Integer WrongListSizeException() {
        return -1;
    }

    private static Integer WrongPageRangeException() {
        return -1;
    }

}