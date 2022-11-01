package onboarding;

import java.util.*;

public class Problem6 {

    private static List<String> pairedWords = new ArrayList<>(); // 두개씩 닉네임을 짝지어서 저장하는 리스트
    private static Set<String> duplicate = new HashSet<>(); // 중복을 저장하는 리스트

    public static List<String> solution(List<List<String>> forms) {
        List<String> strings = pairNicknameByTwo(forms);
        return isDuplicated(forms, strings);
    }

    private static List<String> pairNicknameByTwo(List<List<String>> forms) {
        for (int i = 0; i < forms.size(); i++) {
            String nickname = forms.get(i).get(1);
            for (int j = 0; j < nickname.length() - 1; j++) {
                pairedWords.add(nickname.substring(j, j + 2));
            }
        }
        return pairedWords;
    }

    private static List<String> isDuplicated(List<List<String>> forms, List<String> words) {
        for (int i = 0; i < forms.size(); i++) {
            String procEmail = forms.get(i).get(0);

            for (int j = i + 1; j < forms.size(); j++) { // 2번째부터 비교해서 나감
                String email = forms.get(j).get(0);

                for (String word : words) {
                    if (email.contains(word)) {
                        duplicate.add(procEmail);
                        duplicate.add(email);
                        break;
                    }
                    break;
                }
            }
            break;
        }
        List<String> answer = new ArrayList<>(duplicate);
        Collections.sort(answer);
        return answer;
    }

}
