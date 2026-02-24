package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Withdrawal extends JFrame implements ActionListener{

    JButton withdraw, back;
    JTextField amttxt;
    JLabel text;
    String pinnumber;

    Withdrawal(String pinnumber) {

        this.pinnumber = pinnumber;

        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);

        text = new JLabel("Enter the amount you want to withdraw");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        text.setBounds(230, 330, 400, 20);
        image.add(text);

        withdraw = new JButton("Withdraw ");
        withdraw.setBounds(400, 470, 150, 25);
        withdraw.setFont(new Font("System", Font.BOLD, 16));
        withdraw.addActionListener(this);
        image.add(withdraw);

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
        if(e.getSource() == withdraw){
            String number = amttxt.getText();
            Date date = new Date();
            if(number.equals("")){
                JOptionPane.showMessageDialog(null, "Please enter the amount you want to withdraw");
            }else {
                try {
                    Conn conn = new Conn();
                    String query = "insert into bank values('" + pinnumber + "','" + date + "', 'Withdrawal','" + number + "')";
                    conn.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Rs " + number + " Withdraw Successfully");
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
        new  Withdrawal("");

    }
}
