package home;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class FileSort {
    List<String> sort(Set<String> arrayStrings) {

        Set<String> arrayWords = new HashSet<>();
        Set<String> newWords = new HashSet<>();
        StringBuilder sb = new StringBuilder();

        for (String stringCount : arrayStrings)
            sb.append(" ").append(stringCount);

        sb.deleteCharAt(0);
        String[] words = sb.toString().split(" ");
        Collections.addAll(arrayWords, words);

        Pattern p = Pattern.compile("[À-ß¨¸à-ÿ][À-ß¨¸à-ÿ-]+");
        for (String minus : arrayWords) {
            Matcher m = p.matcher(minus);
            if (m.find())
                newWords.add(m.group());
        }

        newWords.remove("");
        newWords.remove("-");

        List<String> sortedWords = new ArrayList<>();

        sortedWords.addAll(newWords);
        Collections.sort(sortedWords);
        return sortedWords;
    }
}
