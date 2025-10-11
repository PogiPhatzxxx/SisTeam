import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoginFrame extends JFrame implements ActionListener, MouseListener {
    public static String idnum;

    JButton loginbtn;
    JLabel leftlabel, rightlabel;
    JPanel left, right, bg;
    JTextField textfield;
    ImageIcon leftimage, rightimage;

    LoginFrame() {

        // login frame
        this.setTitle("ASTIG-CAL");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(950, 600);
        this.setLayout(null);
        this.setResizable(false);
        this.setLocationRelativeTo(null);

        leftimage = new ImageIcon("img1.png");
        leftlabel = new JLabel(leftimage);
        leftlabel.setBounds(0, 0, 560, 600);
        this.add(leftlabel);

        rightimage = new ImageIcon("img2.png");
        rightlabel = new JLabel(rightimage);
        rightlabel.setBounds(32, -10, 320, 320);
        right = new JPanel();
        right.setSize(390, 600);
        right.setBounds(560, 0, 390, 600);
        right.setLayout(null);
        right.setBackground(Color.WHITE);
        right.add(rightlabel);
        this.add(right);

        textfield = new JTextField(); // TextField
        textfield.setBounds(60, 280, 260, 50);
        textfield.setFont(new Font("Arial", Font.PLAIN, 14));
        textfield.setText("Enter your ID No.");
        textfield.addMouseListener(this);
        textfield.addActionListener(this);
        right.add(textfield);

        loginbtn = new JButton("Login"); // Button
        loginbtn.setBounds(60, 350, 260, 50);
        loginbtn.setFont(new Font("Arial", Font.BOLD, 18));
        loginbtn.setForeground(Color.WHITE);
        loginbtn.setBackground(new Color(0, 102, 204));
        loginbtn.setFocusable(false);
        loginbtn.addActionListener(this);
        right.add(loginbtn);

        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginbtn) {
            idnum = textfield.getText();
            if (textfield.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please Enter ID ", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                this.dispose();
                new MainMenu();
                JOptionPane.showMessageDialog(null, "Welcome " + idnum, "", JOptionPane.INFORMATION_MESSAGE);
            }
        }

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == textfield) {
            textfield.setText(null);
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub

    }

}
