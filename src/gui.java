import javax.swing.*;
import java.awt.*;

public class gui {
    public static void main(String args[]){
        JFrame frame = new JFrame("LinEqSysSolv - GUI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300,300);

        JPanel panel = new JPanel();
        JLabel entercoeffs = new JLabel("Enter Coefficients");
        JButton addbtn = new JButton("Add");
        JTextField tf = new JTextField(32);
        panel.add(entercoeffs); // Adds Button to content pane of frame
        panel.add(tf);
        panel.add(addbtn); // Adds Button to content pane of frame
        frame.getContentPane().add(BorderLayout.CENTER, panel);
        frame.setVisible(true);

        addbtn.addActionListener(e -> {System.out.println("addbtn");});
     }
}
