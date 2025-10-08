import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoginFrame extends JFrame implements ActionListener{

            JButton loginbtn;
            JLabel leftlabel, rightlabel, toplabel;
            JPanel left, right, bg;
            JTextField textfield;
            ImageIcon leftimage, rightimage, topimage;
            
    LoginFrame(){

            //login frame
            this.setTitle("STI-CALCULATOR");
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setSize(950, 600);
            this.setLayout(null);
            this.setResizable(false);
            this.getContentPane().setBackground(Color.yellow);
            this.setLocationRelativeTo(null);


            //images
            leftimage = new ImageIcon("image.png");
            rightimage = new ImageIcon("main.png");
            topimage = new ImageIcon("stilogo.png");

            //stilogo
            toplabel = new JLabel(topimage);                                    //Label
            toplabel.setBounds(9,0,85,50);
            this.add(toplabel);

            //left panel
            leftlabel = new JLabel(leftimage);                                  //Label
            leftlabel.setBounds(0,0,550,550);
            left = new JPanel();                                                //Panel
            left.setBounds(0, 50, 550, 550);
            left.add(leftlabel);
            left.setLayout(null);
            this.add(left);

            //right panel
            right = new JPanel();                                               //Panel
            right.setBounds(566, 50, 385, 550);
            right.setBackground(Color.white);
            right.setLayout(null);
            rightlabel = new JLabel(rightimage);                                //Label
            rightlabel.setBounds(30, -30, 320, 320);
            right.add(rightlabel);

            textfield = new JTextField();                                       //TextField
            textfield.setBounds(60, 260, 260, 50);
            textfield.setFont(new Font("Arial", Font.PLAIN, 14));
            textfield.setText("Enter Your Name");
            right.add(textfield);

            loginbtn = new JButton("Login");                               //Button 
            loginbtn.setBounds(60, 330, 260, 50);
            loginbtn.setFont(new Font("Arial", Font.BOLD, 18));
            loginbtn.setForeground(Color.WHITE);
            loginbtn.setBackground(new Color(0, 102, 204));
            loginbtn.setFocusable(false);
            loginbtn.addActionListener(this);
            right.add(loginbtn);
            this.add(right);

            this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==loginbtn){
            this.dispose();
            new MainMenu();
            JOptionPane.showMessageDialog(null, "Welcome "+ textfield.getText(), "", JOptionPane.INFORMATION_MESSAGE);
        }   
    }



}
