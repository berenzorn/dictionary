package home;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.io.IOException;

//import static home.Dictionary.filename;
import static home.Dictionary.filename;
import static home.Dictionary.frame;

public class Win extends JFrame{
    JPanel panel1;
    JTextField textField1;
    private JButton button1;
    private JButton startButton;
    JFormattedTextField formattedTextField1;

    Win() {

        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                FileDialog fd = new FileDialog(frame, "Choose file", FileDialog.LOAD);
                Dictionary.filename = null;
                fd.setDirectory("C:\\");
                fd.setFile("*.*");
                fd.setVisible(true);
                Dictionary.filename = fd.getDirectory()+fd.getFile();
                if (!Dictionary.filename.equals("C:\\null"))
                    textField1.setText(Dictionary.filename);
                else
                    textField1.setText(">");
                formattedTextField1.setText("");
            }
        });

        startButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                if (!Dictionary.filename.isEmpty()) {
                    try { Dictionary.sort(); }
                    catch (IOException e) { }
                }
                formattedTextField1.setText("File " + filename + ".out created.");
            }
        });
    }
}
