package bank.management.system;
import javax.swing.*;
import  java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;
import java.util.Date;


public class FastCash extends JFrame implements ActionListener {

//    JButton deposit, withdrawal, fastcash, ministatement, pinchange, balance, exit;
    JButton amt1, amt2, amt3, amt4, amt5, amt6, exit;
    JLabel image, text;
    String pinnumber;

    FastCash(String pinnumber){
        this.pinnumber = pinnumber;

        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        image = new JLabel(i3);
        image.setBounds(0,0,900,800);
        add(image);

        text = new JLabel("SELECT WITHDRAWAL AMOUNT");
        text.setBounds(260,285,700,40);
        text.setForeground(new Color(0, 102, 204));
        text.setFont(new Font("System",Font.BOLD,16));
        image.add(text);

        amt1 = new JButton("Rs 100");
        amt1.setBounds(210, 367, 150, 25);
        amt1.addActionListener(this);
        image.add(amt1);

        amt2 = new JButton("Rs 500");
        amt2.setBounds(210, 395, 150, 25);
        amt2.addActionListener(this);
        image.add(amt2);

        amt3 = new JButton("Rs 1000");
        amt3.setBounds(210, 423, 150, 25);
        amt3.addActionListener(this);
        image.add(amt3);

        amt4 = new JButton("Rs 2000");
        amt4.setBounds(393, 367, 150, 25);
        amt4.addActionListener(this);
        image.add(amt4);

        amt5 = new JButton("Rs 5000");
        amt5.setBounds(393, 395, 150, 25);
        amt5.addActionListener(this);
        image.add(amt5);

        amt6 = new JButton("Rs 10000");
        amt6.setBounds(393, 423, 150, 25);
        amt6.addActionListener(this);
        image.add(amt6);

        exit = new JButton("Back");
        exit.setBounds(393, 451, 150, 25);
        exit.addActionListener(this);
        image.add(exit);

        setSize(900,900);
        setLocation(300, 0);
        setUndecorated(false);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == exit){
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        } else {
            String amount = ((JButton)ae.getSource()).getText().substring(3);
            Conn c = new Conn();
            try{
                ResultSet rs = c.s.executeQuery("select * from bank where pin = '" +pinnumber+ "'");
                int balance = 0;
                while(rs.next()){
                    if (rs.getString("type").equals("deposit")){
                        balance += Integer.parseInt(rs.getString("amount"));
                    } else {
                        balance -= Integer.parseInt(rs.getString("amount"));
                    }

                }
                if(ae.getSource() != exit && balance < Integer.parseInt(amount)){
                    JOptionPane.showMessageDialog(null, "Insufficient Balance");
                    return ;
                }

                Date date = new Date();
                String query = "insert into bank values('"+pinnumber+"' , '"+date+"', 'Withdrawal', '"+amount+"')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Rs " + amount + " Debited Successfully");

                setVisible(false);
                new Transactions(pinnumber).setVisible(true);

            }
            catch(Exception e){
                System.out.println(e);
            }
        }
    }

    public static void main(String[] args) {
        new FastCash("");

    }

}
