import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Settings extends JFrame implements ActionListener {

    Settings(){
        //Settings
        this.setTitle("Settings");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(350, 400);
        this.setLayout(new BorderLayout());
        this.setResizable(false);
        this.getContentPane().setBackground(Color.white);
        this.setLocationRelativeTo(null);

        JLabel text = new JLabel();
        text.setText("BURATT");
        text.setFont(new Font("Arial", Font.PLAIN, 14));
        this.add(text);


        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        
    }
}
