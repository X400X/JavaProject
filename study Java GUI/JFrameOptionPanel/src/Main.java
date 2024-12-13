import javax.swing.*;

public class Main {
    public static void main(String[] args) {
//        JOptionPane.showMessageDialog(null, "This is some useless info", "title", JOptionPane.PLAIN_MESSAGE);
//        JOptionPane.showMessageDialog(null, "This is some useless info", "title", JOptionPane.INFORMATION_MESSAGE);
//        JOptionPane.showMessageDialog(null, "This is some useless info", "title", JOptionPane.QUESTION_MESSAGE);
//        JOptionPane.showMessageDialog(null, "This is some useless info", "title", JOptionPane.WARNING_MESSAGE);
//        JOptionPane.showMessageDialog(null, "This is some useless info", "title", JOptionPane.ERROR_MESSAGE);

//        while(true) {
//            JOptionPane.showMessageDialog(null, "ЭТО ВИРУС!", "ВИР", JOptionPane.WARNING_MESSAGE);
//        }

          //JOptionPane.showConfirmDialog(null, "Bro, do yuo even code", "my title", JOptionPane.YES_NO_CANCEL_OPTION);

          //int answer = JOptionPane.showConfirmDialog(null, "Bro, do yuo even code", "my title", JOptionPane.YES_NO_CANCEL_OPTION);
          //String name = JOptionPane.showInputDialog("What is yuo name?");

          String[] responses = {"No, you are awesome!", "Thank you!", "blush*"};
          ImageIcon imageIcon = new ImageIcon("logo.png");
          JOptionPane.showOptionDialog(
                  null,
                  "You are answer",
                  "secret messege",
                   JOptionPane.YES_NO_CANCEL_OPTION,
                   JOptionPane.INFORMATION_MESSAGE,
                   imageIcon,
                   responses,
                   0);

    }
}
