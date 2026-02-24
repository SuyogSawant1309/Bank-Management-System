package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;
import java.sql.*;

public class BalanceEnquiry extends JFrame implements ActionListener{

    JButton back;
    String pinnumber;
    public BalanceEnquiry(  String pinnumber) {
        setLayout(null);
        this.pinnumber = pinnumber;

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 800);
        add(image);

        back = new JButton("Back");
        back.setBounds(393, 451, 150, 25);
//        back.setFont(new Font("System", Font.BOLD, 10));
        back.addActionListener(this);
        image.add(back);

        Conn c = new Conn();
        int balance = 0;
        try {
            ResultSet rs = c.s.executeQuery("select * from bank where pin = '" + pinnumber + "'");
            while (rs.next()) {
                if (rs.getString("type").equals("deposit")) {
                    balance += Integer.parseInt(rs.getString("amount"));
                } else {
                    balance -= Integer.parseInt(rs.getString("amount"));
                }

            }
        } catch(Exception e){
                System.out.println(e);
            }

            JLabel text = new JLabel("Your Current Account Balance is ");
            JLabel text1 = new JLabel(""+balance);
            text1.setFont(new Font("System", Font.BOLD, 18));
            text1.setBounds(220, 350, 400, 30);
            text1.setForeground(Color.black);
            text.setForeground(Color.black);
            text.setFont(new Font("System", Font.BOLD, 18));
            text.setBounds(220, 300, 400, 30);
            image.add(text);
            image.add(text1);


            setSize(900, 900);
            setLocation(300, 0);
            setUndecorated(false);
            setVisible(true);

        }


    public void actionPerformed(ActionEvent ae){
         setVisible(false);
         new Transactions(pinnumber).setVisible(true);

    }

    public static void main() {
        new BalanceEnquiry("");
    }

}
