package home;

import java.util.*;

class FileSort {
    private static char[] cyrillic = {'�','�','�','�','�','�','�','�','�','�','�','�','�','�','�',
            '�','�','�','�','�','�','�','�','�','�','�','�','�','�','�','�','�','�'};

    List<String> sort(Set<String> arrayStrings) {

        Set<String> arrayWords = new HashSet<>();
        Set<String> minusWords = new HashSet<>();
        Set<String> plusWords = new HashSet<>();

// ��������� ������ �� �����
        for (String stringCount : arrayStrings)
        {
            String[] words = stringCount.split(" ");
            Collections.addAll(arrayWords, words);
        }

// �������� � ������ ������ �� �����������
        for (String minus : arrayWords)
            for (int j = 0; j < minus.length(); j++)
                if (minus.charAt(j) == '-')
                    minusWords.add(minus);

// ������� ����� � ��������
        for (String minus : minusWords)
            arrayWords.remove(minus);

        minusWords.clear();

        for (String wordsCount : arrayWords) {
            char[] buffer = wordsCount.toCharArray();
            List<Character> arrayBuffer = new ArrayList<>();

// ������ � ������ �����, ������ ����� � ����, ���� �� ���� �����
            for (char aBuffer : buffer)
                arrayBuffer.add(aBuffer);
// �������� � ������ ������ �� �����������
// ������� ����� � �������� ���������
            for (int i = 0; i < arrayBuffer.size(); i++) {
                boolean ok = false;
                for (char aCyrillic : cyrillic)
                    if (arrayBuffer.get(i).equals(aCyrillic))
                        ok = true;
// ���� ����� ������� - ��, ���� ��� - ��������
                if (!ok)
                    arrayBuffer.remove(i--);
            }

// ������������ ���� � �������� ������� ������� � ������ �����
            char[] new_buffer = new char[arrayBuffer.size()];
            for (int i = 0; i < arrayBuffer.size(); i++)
                new_buffer[i] = arrayBuffer.get(i);
            plusWords.add(String.valueOf(new_buffer));
            minusWords.add(wordsCount);

// ������ ����� � �����, ����� ��������
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
