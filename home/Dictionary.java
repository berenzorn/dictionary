package home;

import java.io.IOException;

class Dictionary {

    private static String fileName;

    void setName(String name) {
        fileName = name;
    }

    String getName() {
        return fileName;
    }

    void sort(String name) throws IOException {
        ReadFile rf = new ReadFile();
        FileSort fs = new FileSort();
        GetOut go = new GetOut();
        go.out(name, fs.sort(rf.read(name)));
    }

    public static void main(String[] args) throws IOException {
        if (!args[0].isEmpty()) {
            fileName = args[0];
            Dictionary d = new Dictionary();
            d.sort(fileName);
        }
        else {
            Win w = new Win();
            w.construct();
        }
    }
}
