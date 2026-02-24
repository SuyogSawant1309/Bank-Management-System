package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Deposit extends JFrame implements ActionListener{

    JButton deposit, back;
    JTextField amttxt;
    JLabel text;
    String pinnumber;

    Deposit(String pinnumber) {

        this.pinnumber = pinnumber;

        setLayout(null);

            ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
            Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
            ImageIcon i3 = new ImageIcon(i2);
            JLabel image = new JLabel(i3);
            image.setBounds(0, 0, 900, 900);
            add(image);

            text = new JLabel("Enter the amount you want to deposit");
            text.setForeground(new Color(0, 102, 204));
            text.setFont(new Font("System", Font.BOLD, 16));
            text.setBounds(240, 330, 400, 20);
            image.add(text);

            deposit = new JButton("Deposit");
            deposit.setBounds(400, 470, 150, 25);
            deposit.setFont(new Font("System", Font.BOLD, 16));
            deposit.addActionListener(this);
            image.add(deposit);

            back = new JButton("Back");
            back.setBounds(400, 500, 150, 25);
            back.setFont(new Font("System", Font.BOLD, 16));
            back.addActionListener(this);
            image.add(back);

            amttxt = new JTextField();
            amttxt.setBounds(213, 360, 333, 25);
            image.add(amttxt);

        setSize(900, 900);
        setLocation(300, 0);
        setUndecorated(false);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == deposit){
            String number = amttxt.getText();
            Date date = new Date();
            if(number.equals("")){
                JOptionPane.showMessageDialog(null, "Please enter the amount you want to deposit");
            }else {
                try {
                    Conn conn = new Conn();
                    String query = "insert into bank values('" + pinnumber + "','" + date + "', 'deposit','" + number + "')";
                    conn.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Rs " + number + " Deposited Successfully");
                    setVisible(false);
                    new Transactions(pinnumber).setVisible(true);
                }
                catch(Exception ex) {
                    System.out.println(ex);
                }
            }

        }else if(e.getSource() == back){
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);

        }

    }

    public static void main(String[] args) {
        new  Deposit("");

    }
}
