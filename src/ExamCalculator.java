import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class ExamCalculator extends JFrame implements ActionListener, MouseListener {
    JTextField textfield, subject;
    JButton submitBtn;
    JLabel result;
    JPanel historypanel;

    ArrayList<String> historyList = new ArrayList<>();
    ArrayList<String> subjects = new ArrayList<>();

    int resulthistoryY = 70, subjecthistoryY = 50;

    ExamCalculator() {
        // Settings
        this.setTitle("EXAM Calculator");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(950, 600);
        this.setLayout(null);
        this.setResizable(false);
        this.setLocationRelativeTo(null);

        ImageIcon topimg = new ImageIcon("img3.png");
        JLabel topimglabel = new JLabel(topimg);
        topimglabel.setBounds(11, -6, 70, 70);

        JPanel toppanel = new JPanel();
        toppanel.setSize(950, 50);
        toppanel.setBackground(Color.yellow);
        toppanel.setLayout(null);
        toppanel.add(topimglabel);
        this.add(toppanel);

        ImageIcon mainimg = new ImageIcon("img6.2.png");
        JLabel mainimglabel = new JLabel(mainimg);
        mainimglabel.setBounds(15, 15, 50, 50);

        // Mainpanel=======================================================
        JPanel mainpanel = new JPanel();
        mainpanel.setSize(500, 370);
        mainpanel.setLayout(null);
        mainpanel.setBounds(50, 116, 560, 370);
        mainpanel.setBackground(new Color(0, 102, 204));
        mainpanel.add(mainimglabel);
        this.add(mainpanel);

        JLabel text = new JLabel();
        text.setText("EXAM CALCULATOR");
        text.setFont(new Font("Arial", Font.BOLD, 24));
        text.setForeground(Color.white);
        text.setBounds(80, 15, 250, 50);
        mainpanel.add(text);

        subject = new JTextField(); // TextField
        subject.setBounds(160, 80, 200, 20);
        subject.setFont(new Font("Arial", Font.PLAIN, 14));
        subject.setText("Subject");
        subject.addMouseListener(this);
        subject.addActionListener(this);
        mainpanel.add(subject);

        JLabel label1 = new JLabel();
        label1.setText("Enter You Exam Score:");
        label1.setFont(new Font("Arial", Font.PLAIN, 14));
        label1.setForeground(Color.white);
        label1.setBounds(160, 100, 250, 50);
        mainpanel.add(label1);

        textfield = new JTextField(); // TextField
        textfield.setBounds(160, 140, 200, 50);
        textfield.setFont(new Font("Arial", Font.PLAIN, 14));
        textfield.setText("Enter here");
        textfield.addMouseListener(this);
        textfield.addActionListener(this);
        mainpanel.add(textfield);

        submitBtn = new JButton(">"); // Button
        submitBtn.setBounds(360, 140, 50, 50);
        submitBtn.setFont(new Font("Arial", Font.BOLD, 18));
        submitBtn.setForeground(Color.black);
        submitBtn.setBackground(Color.gray);
        submitBtn.setFocusable(false);
        submitBtn.addActionListener(this);
        mainpanel.add(submitBtn);

        JLabel label2 = new JLabel();
        label2.setText("Result: ");
        label2.setFont(new Font("Arial", Font.PLAIN, 14));
        label2.setForeground(Color.white);
        label2.setBounds(160, 190, 200, 50);
        mainpanel.add(label2);

        JPanel resultpanel = new JPanel();
        resultpanel.setBounds(160, 230, 250, 50);
        resultpanel.setBackground(Color.white);
        resultpanel.setLayout(null);
        mainpanel.add(resultpanel);

        result = new JLabel();
        result.setFont(new Font("Arial", Font.BOLD, 22));
        result.setForeground(Color.BLACK);
        result.setBounds(10, 0, 200, 50);
        resultpanel.add(result);

        // History Panel==========================================================
        historypanel = new JPanel();
        historypanel.setSize(245, 370);
        historypanel.setBounds(640, 116, 245, 370);
        historypanel.setBackground(Color.lightGray);
        historypanel.setLayout(null);
        this.add(historypanel);

        JPanel line = new JPanel();
        line.setSize(245, 2);
        line.setBounds(0, 50, 245, 2);
        line.setBackground(Color.BLACK);
        line.setLayout(null);
        historypanel.add(line);

        JLabel historylabel = new JLabel();
        historylabel.setText("HISTORY");
        historylabel.setFont(new Font("Arial", Font.BOLD, 24));
        historylabel.setForeground(Color.BLACK);
        historylabel.setBounds(70, 5, 250, 50);
        historypanel.add(historylabel);

        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submitBtn) {
            float ans = (Float.parseFloat(textfield.getText()) / 70) * 50;
            if (ans > 30) {
                result.setText(String.valueOf(ans));
            } else if (ans < 29.99) {
                result.setText(String.valueOf(ans));
                JOptionPane.showMessageDialog(null, "Tang Ina mo Mag Aral ka ng Mabuti BOBO",
                        "STUPID MESSAGE", JOptionPane.INFORMATION_MESSAGE);
            }

            subjects.add(subject.getText());
            historyList.add(String.valueOf(ans));

            if (historyList.size() > 1 && subjects.size() > 1) {
                String historyprevResult = historyList.get(historyList.size() - 2);
                String subjectprevResult = subjects.get(subjects.size() - 2);

                JLabel subjectLabel = new JLabel();
                subjectLabel.setText(subjectprevResult);
                subjectLabel.setFont(new Font("Arial", Font.PLAIN, 14));
                subjectLabel.setForeground(Color.black);
                subjectLabel.setBounds(20, subjecthistoryY, 200, 50);
                historypanel.add(subjectLabel);

                JLabel historyLabel = new JLabel();
                historyLabel.setText(historyprevResult);
                historyLabel.setFont(new Font("Arial", Font.PLAIN, 20));
                historyLabel.setForeground(Color.black);
                historyLabel.setBounds(20, resulthistoryY, 200, 50);
                historypanel.add(historyLabel);

                historypanel.repaint();

                resulthistoryY += 40;
                subjecthistoryY += 40;
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == textfield) {
            textfield.setText(null);
        }
        if (e.getSource() == subject) {
            subject.setText(null);
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