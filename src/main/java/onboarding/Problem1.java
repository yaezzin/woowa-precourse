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

        if (!isPageOrder(crongLeftPage, crongRightPage) || !isPageOrder(pobiLeftPage, pobiRightPage)) {
            return WrongPageOrderException();
        }

        Integer pobiMaxScore = Integer.max(getMaxScore(pobiLeftPage), getMaxScore(pobiRightPage));
        Integer crongMaxScore = Integer.max(getMaxScore(crongLeftPage), getMaxScore(crongRightPage));

        return answer;
    }

    private static boolean isPageRange(Integer page) {
        if (page > MAX_PAGE && page < MIN_PAGE) {
            return false;
        }
        return true;
    }

    private static boolean isPageOrder(Integer leftPage, Integer rightPage) {
        if (leftPage % 2 == 0) {
            return false;
        }
        else if (rightPage != leftPage + 1) {
            return false;
        }
        return true;
    }

    private static Integer getMaxScore(Integer page) {
        return Integer.max(sumDigit(page), multiplyDigit(page));
    }

    private static Integer sumDigit(Integer page) {
        int sum = 0;
        while(page > 0) {
            sum += page % 10;
            page /= 10;
        }
        return sum;
    }

    private static Integer multiplyDigit(Integer page) {
        int multiple = 1;
        while (page > 0) {
            multiple *= page % 10;
            page /= 10;
        }
        return multiple;
    }

    private static Integer WrongListSizeException() {
        return -1;
    }

    private static Integer WrongPageRangeException() {
        return -1;
    }

}