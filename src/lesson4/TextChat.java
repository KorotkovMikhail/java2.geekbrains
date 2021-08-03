package lesson4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;


public class TextChat extends JFrame{
    JPanel jpN = new JPanel(new GridLayout());
    JPanel jpS = new JPanel(new GridLayout());

    JButton jSend = new JButton("Отправить");
    JTextArea jtexta = new JTextArea();
    JScrollPane jsp = new JScrollPane(jtexta);
    JTextField jtextf = new JTextField();

    JMenuBar menu = new JMenuBar();
    JMenu file = new JMenu("Выход");
    JMenuItem fileExit = new JMenuItem("Выход");

    PrintWriter pw = new PrintWriter(new FileWriter("1.txt"));

    TextChat() throws IOException {
        super("тестовый чат");
        setSize(300, 500);
        setMinimumSize(new Dimension(600, 500));

        jtexta.setLineWrap(true);
        jtexta.setEditable(false);

        jSend.addActionListener(e -> sendMessage());
        jtextf.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) sendMessage();
            }
        });

        jpN.add(jsp);
        jpS.add(jtextf);
        jpS.add(jSend);

        add(jpN);
        add("South", jpS);

        setJMenuBar(menu);
        menu.add(file);
        file.add(fileExit);
        fileExit.addActionListener(e -> System.exit(0));

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    void sendMessage() {
        String out = jtextf.getText();
        jtexta.append(getTime() + ": " + out + "\n");
        pw.append(getTime()).append(": ").append(out).append("\n");
        pw.flush();
        jtextf.setText("");
        jtextf.grabFocus();
    }

    public String getTime() {
        return new SimpleDateFormat("HH:mm:ss").format(new Date());
    }

}
