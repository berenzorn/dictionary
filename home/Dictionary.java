package home;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.*;

class Dictionary {

    private static char[] cyrillic = {'а','б','в','г','д','е','ё','ж','з','и','й','к','л','м','н',
            'о','п','р','с','т','у','ф','х','ц','ч','ш','щ','ъ','ы','ь','э','ю','я'};
    static String filename;
    private static Set<String> array_words = new LinkedHashSet<>();
    private static ArrayList<String> sorted_words = new ArrayList<>();
    static final JFrame frame = new JFrame("Dict converter");

    static void sort() throws IOException {
        clearList();
        readFile();
        fileSort();
        getOut();
    }

    private static void clearList() {
        array_words.clear();
        sorted_words.clear();
    }

    private static void readFile() throws IOException {

        Set<String> array_strings = new HashSet<>();

        FileReader input = new FileReader(filename);
        BufferedReader reader = new BufferedReader(input);
// Читаем файлик построчно в сет
        while (true) {
            String current_string = reader.readLine();
            if (current_string == null) break;
            else {
                current_string = current_string.toLowerCase();
                array_strings.add(current_string);
            }
        }
        input.close();
// Разбиваем строки на слова
        for (String string_count : array_strings)
        {
            String[] words = string_count.split(" ");
            Collections.addAll(array_words, words);
        }
    }

    private static void fileSort() {
// Работаем с каждым словом по отдельности
        Set<String> minus_words = new HashSet<>();
        Set<String> plus_words = new HashSet<>();
        boolean ok = false;

        for (String minus : array_words)
            for (int j = 0; j < minus.length(); j++)
                if (minus.charAt(j) == '-')
                    minus_words.add(minus);
// Убираем слова с минусами
        for (String minus : minus_words)
            array_words.remove(minus);

        minus_words.clear();

        for (String words_count : array_words) {
            char[] buffer = words_count.toCharArray();
            ArrayList<Character> array_buffer = new ArrayList<>();
// Стринг в массив чаров, массив чаров в лист, чтоб не было дырок
            for (char aBuffer : buffer) {
                array_buffer.add(aBuffer);
            }
// Работаем с каждой буквой по отдельности
// сверяем букву с массивом кириллицы
            for (int i = 0; i < array_buffer.size(); i++) {
                for (char aCyrillic : cyrillic)
                    if (array_buffer.get(i).equals(aCyrillic))
                        ok = true;
// Если буква русская - ок, если нет - выкинуть
                if (!ok)
                    array_buffer.remove(i--);
                else
                    ok = false;
            }
// Исправленный лист с русскими буквами обратно в массив чаров
            char[] new_buffer = new char[array_buffer.size()];
            for (int i = 0; i < array_buffer.size(); i++)
                new_buffer[i] = array_buffer.get(i);

            plus_words.add(String.valueOf(new_buffer));
            minus_words.add(words_count);
// Массив чаров в листы, слово заменить
        }
        for (String minus : minus_words)
            array_words.remove(minus);
        for (String plus : plus_words)
            array_words.add(plus);
        minus_words.clear();
        array_words.remove("");

        sorted_words.addAll(array_words);
        Collections.sort(sorted_words);
    }

    private static void getOut() throws IOException {
        String outFile = filename;
        outFile += ".out";
        FileWriter output = new FileWriter(outFile);
        for (int i = 0; i < array_words.size(); i++) {
            output.write(sorted_words.get(i));
            output.write(System.getProperty("line.separator"));
        }
        output.close();
    }

    public static void main(String[] args) throws IOException {
        Dictionary d = new Dictionary();
        frame.setContentPane(new Win().panel1);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
