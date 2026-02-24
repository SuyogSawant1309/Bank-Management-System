package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.*;
import java.awt.event.ActionListener;

public class PinChange extends JFrame implements ActionListener{

    JLabel text, npin, rpin;
    JPasswordField pin, repin;
    JButton back, change;
    String pinnumber;

    PinChange(String pinnumber) {

        this.pinnumber = pinnumber;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);

        text = new JLabel("CHANGE YOUR PIN");
        text.setForeground(Color.white);
        text.setFont(new Font("System", Font.BOLD, 16));
        text.setBounds(293, 295, 200, 35);
        image.add(text);

        npin = new JLabel("New Pin:");
        npin.setForeground(Color.white);
        npin.setFont(new Font("System", Font.BOLD, 16));
        npin.setBounds(210, 340, 150, 30);
        image.add(npin);

        pin = new JPasswordField();
        pin.setForeground(Color.black);
        pin.setFont(new Font("Raleway", Font.BOLD, 16));
        pin.setBounds(380, 345, 150, 23);
        image.add(pin);

        rpin = new JLabel("Re-Enter New PIN:");
        rpin.setForeground(Color.white);
        rpin.setFont(new Font("System", Font.BOLD, 16));
        rpin.setBounds(210, 380, 200, 30);
        image.add(rpin);

        repin = new JPasswordField();
        repin.setForeground(Color.black);
        repin.setFont(new Font("Raleway", Font.BOLD, 16));
        repin.setBounds(380, 385, 150, 23);
        image.add(repin);

        change = new JButton("CHANGE");
        change.setBounds(430, 448, 100, 23);
        change.setFont(new Font("System", Font.BOLD, 10));
        change.addActionListener(this);
        image.add(change);

        back = new JButton("Back");
        back.setBounds(430, 476, 100, 23);
        back.setFont(new Font("System", Font.BOLD, 10));
        back.addActionListener(this);
        image.add(back);

        setSize(900,900);
        setLocation(300, 0);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == change) {
            try {
                String npin = pin.getText();
                String rpin = repin.getText();

                if (!npin.equals(rpin)) {
                    JOptionPane.showMessageDialog(null, "Entered PIN does not match");
                    return;
                }

                if(npin.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please enter PIN");
                    return;
                }

                if(rpin.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please Re-Enter new PIN");
                    return;
                }

                Conn conn = new Conn();
                String query1 = "update bank set pin = '"+rpin+"' where pin='"+pinnumber+"'";
                String query2 = "update login set pin = '"+rpin+"' where pin='"+pinnumber+"'";
                String query3 = "update signup3 set pin = '"+rpin+"' where pin='"+pinnumber+"'";

                conn.s.executeUpdate(query1);
                conn.s.executeUpdate(query2);
                conn.s.executeUpdate(query3);

                JOptionPane.showMessageDialog(null, "PIN has been changed successfully");

                setVisible(false);
                new Transactions(rpin).setVisible(true);

            } catch (Exception e1) {
                System.out.println(e1);
            }
        }

        else if (e.getSource() == back) {
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }

        else {
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }

    }

    public static void main(String[] args) {

        new PinChange("").setVisible(true);
    }
}
