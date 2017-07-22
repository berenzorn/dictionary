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
        while (reader.ready())
            arrayStrings.add(reader.readLine());
        input.close();
        return arrayStrings;
    }
}
