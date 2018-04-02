package home;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class FileSort {
    List<String> sort(Set<String> arrayStrings) {

        Set<String> arrayWords = new HashSet<>();
        Set<String> newWords = new HashSet<>();
//        строки разбиваем на слова
        for (String stringCount : arrayStrings)
            Collections.addAll(arrayWords, stringCount.split(" "));
//        чистим слова от мусора
        Pattern p = Pattern.compile("[А-ЯЁёа-я][А-ЯЁёа-я-]+");
        for (String minus : arrayWords) {
            Matcher m = p.matcher(minus);
            if (m.find())
                newWords.add(m.group());
        }
        newWords.remove("");
        newWords.remove("-");
//        чистые слова - в лист для сортировки
        List<String> sortedWords = new ArrayList<>();
        sortedWords.addAll(newWords);
        Collections.sort(sortedWords);
        return sortedWords;
    }
}
