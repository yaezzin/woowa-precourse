package onboarding;

public class Problem4 {

    public static String solution(String word) {
        String answer = "";
        return answer;
    }

    private static boolean isUpperAlphabet(int asciiCode) {
        if (asciiCode >= 'A' && asciiCode <= 'Z') {
            return true;
        }
        return false;
    }

    private static boolean isLowerAlphabet(int asciiCode) {
        if (asciiCode >= 'a' && asciiCode <= 'z') {
            return true;
        }
        return false;
    }

}
