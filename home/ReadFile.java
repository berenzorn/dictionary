package home;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

class ReadFile {

    Set<String> read(String name) throws IOException {

        Set<String> arrayStrings = new HashSet<>();

        FileReader input = new FileReader(name);
        BufferedReader reader = new BufferedReader(input);
// Читаем файлик построчно в сет
        while (true) {
            String currentString = reader.readLine();
            if (currentString == null) break;
            else {
                currentString = currentString.toLowerCase();
                arrayStrings.add(currentString);
            }
        }
        input.close();
        return arrayStrings;
    }

}
