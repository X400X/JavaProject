import jdk.jshell.execution.LoaderDelegate;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class MyFrame extends JFrame implements ActionListener {
    JMenuBar menuBar;
    JMenu fmenu;
    JMenu emenu;
    JMenu hmenu;

    JMenuItem loadItem;
    JMenuItem saveItem;
    JMenuItem exitItem;
    ImageIcon loadIcon;
    ImageIcon saveIcon;
    ImageIcon exitIcon;

    MyFrame() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500, 500);
        this.setLayout(new FlowLayout());

        loadIcon = new ImageIcon("logo.png");
        saveIcon = new ImageIcon("logo1.png");
        exitIcon = new ImageIcon("logo2.png");

        menuBar = new JMenuBar();
        fmenu = new JMenu("File");
        emenu = new JMenu("Edit");
        hmenu = new JMenu("Help");

        loadItem = new JMenuItem("Load");
        saveItem = new JMenuItem("Save");
        exitItem = new JMenuItem("Exit");

        loadItem.addActionListener(this);
        saveItem.addActionListener(this);
        exitItem.addActionListener(this);

        loadItem.setIcon(loadIcon);
        saveItem.setIcon(saveIcon);
        exitItem.setIcon(exitIcon);

        //выбор клавиатурой
        fmenu.setMnemonic(KeyEvent.VK_F);   //Alt + F
        emenu.setMnemonic(KeyEvent.VK_E);
        hmenu.setMnemonic(KeyEvent.VK_H);
        loadItem.setMnemonic(KeyEvent.VK_L);   //l
        saveItem.setMnemonic(KeyEvent.VK_S);
        exitItem.setMnemonic(KeyEvent.VK_E);

        fmenu.add(loadItem);
        fmenu.add(saveItem);
        fmenu.add(exitItem);

        menuBar.add(fmenu);
        menuBar.add(emenu);
        menuBar.add(hmenu);

        this.setJMenuBar(menuBar);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loadItem) {
            System.out.println("*beep boop* you loader a file ");
        }
        if (e.getSource() == saveItem) {
            System.out.println("*beep boop* you saved a file ");
        }
        if (e.getSource() == exitItem) {
            System.out.println("*beep boop* you exited a file ");
        }
    }
}
