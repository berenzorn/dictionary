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
        if (args.length == 0) {
            Win w = new Win();
            w.construct();
        }
        else {
            Dictionary d = new Dictionary();
            d.sort(args[0]);
        }
    }
}
