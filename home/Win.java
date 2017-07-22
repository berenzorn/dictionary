package home;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class Win extends JFrame {
    private JPanel panel1;
    private JTextField textField1;
    private JTextField textField2;
    private JButton startButton;
    private JButton button1;
    private JButton button2;
    private final JFrame frame = new JFrame("Dictionary builder");

    Win() {

        final Dictionary d = new Dictionary();

        button1.addActionListener(actionEvent -> {
            FileDialog fd = new FileDialog(frame, "Choose file", FileDialog.LOAD);
            fd.setDirectory("C:\\");
            fd.setFile("*.*");
            fd.setVisible(true);
            String fName = fd.getDirectory()+fd.getFile();
            d.setName(fName);
            if (!fName.equals("nullnull"))
                textField1.setText(fName);
            else
                textField1.setText(">");
            textField2.setText("");
        });

        startButton.addActionListener(actionEvent -> {
            String fName = d.getName();

            if (!fName.equals("nullnull")) {
                try { d.sort(fName); }
                catch (IOException e) { textField2.setText("File not found."); }
            textField2.setText("File " + fName + ".out created."); }
        });

        button2.addActionListener(actionEvent -> {
            frame.setVisible(false);
            frame.dispose();
        });
    }

    void construct()
    {
        frame.setContentPane(panel1);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
