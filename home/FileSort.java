package home;

import java.util.*;

class FileSort {
    private static char[] cyrillic = {'а','б','в','г','д','е','ё','ж','з','и','й','к','л','м','н',
            'о','п','р','с','т','у','ф','х','ц','ч','ш','щ','ъ','ы','ь','э','ю','я'};

    List<String> sort(Set<String> arrayStrings) {

        Set<String> arrayWords = new HashSet<>();
        Set<String> minusWords = new HashSet<>();
        Set<String> plusWords = new HashSet<>();

// Разбиваем строки на слова
        for (String stringCount : arrayStrings)
        {
            String[] words = stringCount.split(" ");
            Collections.addAll(arrayWords, words);
        }

// Работаем с каждым словом по отдельности
        for (String minus : arrayWords)
            for (int j = 0; j < minus.length(); j++)
                if (minus.charAt(j) == '-')
                    minusWords.add(minus);

// Убираем слова с минусами
        for (String minus : minusWords)
            arrayWords.remove(minus);

        minusWords.clear();

        for (String wordsCount : arrayWords) {
            char[] buffer = wordsCount.toCharArray();
            List<Character> arrayBuffer = new ArrayList<>();

// Стринг в массив чаров, массив чаров в лист, чтоб не было дырок
            for (char aBuffer : buffer)
                arrayBuffer.add(aBuffer);
// Работаем с каждой буквой по отдельности
// сверяем букву с массивом кириллицы
            for (int i = 0; i < arrayBuffer.size(); i++) {
                boolean ok = false;
                for (char aCyrillic : cyrillic)
                    if (arrayBuffer.get(i).equals(aCyrillic))
                        ok = true;
// Если буква русская - ок, если нет - выкинуть
                if (!ok)
                    arrayBuffer.remove(i--);
            }

// Исправленный лист с русскими буквами обратно в массив чаров
            char[] new_buffer = new char[arrayBuffer.size()];
            for (int i = 0; i < arrayBuffer.size(); i++)
                new_buffer[i] = arrayBuffer.get(i);
            plusWords.add(String.valueOf(new_buffer));
            minusWords.add(wordsCount);

// Массив чаров в листы, слово заменить
        }
        for (String minus : minusWords)
            arrayWords.remove(minus);
        for (String plus : plusWords)
            arrayWords.add(plus);

        minusWords.clear();
        arrayWords.remove("");

        List<String> sortedWords = new ArrayList<>();

        sortedWords.addAll(arrayWords);
        Collections.sort(sortedWords);
        return sortedWords;
    }
}
