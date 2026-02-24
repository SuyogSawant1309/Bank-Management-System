package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;

public class MiniStatement extends JFrame implements ActionListener{

    String pinnumber;

    MiniStatement(String pinnumber){
        this.pinnumber = pinnumber;

        setTitle("Mini Statement");

        JLabel mini = new JLabel();
        mini.setBounds(20, 0, 400, 600);
        add(mini);

        JLabel bank = new JLabel("Indian Bank");
        bank.setBounds(150, 20, 100, 20);
        bank.setFont(new Font("System", Font.BOLD, 15));
        add(bank);

        JLabel card = new JLabel();
        card.setBounds(20, 50, 300, 20);
        add(card);

        JLabel balance = new JLabel("Balance");
        balance.setBounds(20, 510, 300, 20);
        balance.setFont(new Font("System", Font.BOLD, 15));
        add(balance);

        try{
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("select * from login where pin = '"+pinnumber+"'");
            while(rs.next()){
                card.setText("Card Number : "+rs.getString("cardnumber").substring(0, 4) + "XXXXXXXX" +rs.getString("cardnumber").substring(12, 16));
            }
        }
        catch(Exception e){
            System.out.println(e);
        }

        try{
            Conn conn = new Conn();
            int bal = 0;
            ResultSet rs = conn.s.executeQuery("select * from bank where pin = '"+pinnumber+"'");
            while(rs.next()){
                mini.setText(mini.getText() + "<html>" + rs.getString("date") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("amount") + "<br><br><html>");
                if(rs.getString("type").equals("deposit")){
                    bal += Integer.parseInt(rs.getString("amount"));
                } else {
                    bal -= Integer.parseInt(rs.getString("amount"));
                }
            }
            balance.setText("Your Current Account Balance is "+bal);
        } catch(Exception e){
            System.out.println(e);
        }

        setSize(400, 600);
        setLocation(20, 20);
        getContentPane().setBackground(Color.white);
        setLayout(null);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent e){
    }

    static void main() {
        new MiniStatement("");

    }
}
