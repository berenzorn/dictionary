package home;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

class GetOut {

    void out(String name, List<String> sortedWords) throws IOException {
        String outFile = name + ".out";
        String s = System.getProperty("line.separator");
        FileWriter output = new FileWriter(outFile);
        for (String sortedWord : sortedWords)
            output.write(sortedWord + s);
        output.close();
    }

}
