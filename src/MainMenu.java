import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainMenu extends JFrame implements ActionListener {

    JPanel mainpanel, navmenu;
    ImageIcon topimage, navbtnimg, logo2img;
    JLabel toplabel, navbtnlabel, logo2;
    JButton navbtn, settingsbtn, coursebtn;
    boolean isNavVisible = false;

    MainMenu() {
        // mainmenu frame
        this.setTitle("Main Menu");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(950, 600);
        this.setLayout(null);
        this.setResizable(false);
        this.getContentPane().setBackground(Color.yellow);
        this.setLocationRelativeTo(null);


        // stilogo
        topimage = new ImageIcon("stilogo.png");
        toplabel = new JLabel(topimage);
        toplabel.setBounds(9, 0, 85, 50);
        this.add(toplabel);

        // Main panel
        mainpanel = new JPanel();
        mainpanel.setBounds(0, 50, 950, 550);
        mainpanel.setBackground(Color.white);
        mainpanel.setLayout(null);
        this.add(mainpanel);

        // navbtnimg
        navbtnimg = new ImageIcon("navmenu.png");

        //logoimg
        logo2img = new ImageIcon("logo2.png");
        logo2 = new JLabel(logo2img);
        logo2.setBounds(0,20,250,250);

        navbtn = new JButton();
        navbtn.setBounds(5, 5, 50, 50);
        navbtn.setFont(new Font("Arial", Font.BOLD, 20));
        navbtn.setOpaque(false);
        navbtn.setContentAreaFilled(false);
        navbtn.setBorderPainted(false);
        navbtn.setFocusPainted(false);
        navbtn.setFocusable(false);
        navbtn.addActionListener(this);
        navbtn.setIcon(navbtnimg);
        mainpanel.add(navbtn);

        settingsbtn = new JButton("Settings");
        settingsbtn.setBounds(50, 230, 150, 50);
        settingsbtn.setFont(new Font("Arial", Font.BOLD, 18));
        settingsbtn.setForeground(Color.WHITE);
        settingsbtn.setBackground(new Color(0, 102, 204));
        settingsbtn.setFocusable(false);
        settingsbtn.addActionListener(this);

        coursebtn = new JButton("Course");
        coursebtn.setBounds(50, 290, 150, 50);
        coursebtn.setFont(new Font("Arial", Font.BOLD, 18));
        coursebtn.setForeground(Color.WHITE);
        coursebtn.setBackground(new Color(0, 102, 204));
        coursebtn.setFocusable(false);
        coursebtn.addActionListener(this);

        // Navmenu panel
        navmenu = new JPanel();
        navmenu.setBounds(0, 0, 250, 550);
        navmenu.setBackground(Color.gray);
        navmenu.setLayout(null);
        navmenu.setVisible(isNavVisible);
        navmenu.add(settingsbtn);
        navmenu.add(coursebtn);
        navmenu.add(logo2);
        mainpanel.add(navmenu);

        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == navbtn) {
            isNavVisible = !isNavVisible;
            navmenu.setVisible(isNavVisible);
        }
        if(e.getSource()==settingsbtn){
            new Settings();
        }
        if(e.getSource()==coursebtn){
            new Course();
        }

    }

}

