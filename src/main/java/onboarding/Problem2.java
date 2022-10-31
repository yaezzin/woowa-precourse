package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        while (true) {
            String decodeString = decodeString(cryptogram);
            if (cryptogram.equals(decodeString)) {
                   break;
            }
            cryptogram = decodeString;
        }
        return cryptogram;
    }

    private static String decodeString(String cryptogram) {
        for (int i = 0; i< cryptogram.length() - 1; i++) {
            if (cryptogram.charAt(i) == cryptogram.charAt(i+1)) {
                cryptogram = removeDuplicatedCharacter(cryptogram);
            }
        }
        return cryptogram;
    }

    private static String removeDuplicatedCharacter(String cryptogram) {
        return cryptogram.replaceAll("(([a-z])\\2{1,})", "");
    }

}
