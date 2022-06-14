import javax.swing.*;
import java.awt.*;

public class gui {
    public static void main(String args[]){
        makeUI(0);
     }

     public static void makeUI(int iteration){
        
        JFrame frame = new JFrame("LinEqSysSolv - GUI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800,400);
        
        JPanel panel = new JPanel();
        JLabel entercoeffs = new JLabel("Enter Coefficients");
        JButton addbtn = new JButton("Add");
        JTextField tf = new JTextField(32);
        JTextField tf2 = new JTextField(32);
        panel.add(entercoeffs); // Adds Button to content pane of frame
        panel.add(tf);
        panel.add(addbtn); // Adds Button to content pane of frame
        if(iteration == 1) panel.add(tf2);
        frame.getContentPane().add(BorderLayout.CENTER, panel);
        frame.setVisible(true);

        addbtn.addActionListener(e -> {makeUI(1);}); //System.out.println(tf.getText());
     }
}
