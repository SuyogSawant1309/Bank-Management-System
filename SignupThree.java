package bank.management.system;

import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.*;

public class SignupThree extends JFrame implements ActionListener {

    // savingac = r1 , recurringac = r2 , currentac = r3, Fixed Deposit ac = r4
    JRadioButton r1, r2, r3, r4;


    JCheckBox s1, s2, s3, s4, s5, s6, declarationtxt;
    //ATM CARD = s1, Internet Banking = s2, Mobile Banking = s3, EMAIL & SMS Alerts = s4, Cheque Book = s5, E-Statement = s6

    JLabel l1, type, cardno, cardnotxt,  cardtxt, pin, pintxt, pinnotxt, service;

    JButton submit, cancel;

    String formno;

    SignupThree(String formno){
        this.formno = formno;
        setLayout(null);

        l1 = new JLabel(" Page 3 : Account Details ");
        l1.setFont(new Font("Raleway",Font.BOLD,23));
        l1.setBounds(270,40,400,40);
        add(l1);

        type = new JLabel(" Account Type ");
        type.setFont(new Font("Raleway",Font.BOLD,22));
        type.setBounds(50,140,200,30);
        add(type);

        r1 = new JRadioButton("Saving Account");
        r1.setFont(new Font("Raleway",Font.BOLD,16));
        r1.setBounds(50,185,200,20);
        r1.setBackground(Color.WHITE);
        add(r1);

        r2 = new JRadioButton("Recurring Account");
        r2.setFont(new Font("Raleway",Font.BOLD,16));
        r2.setBounds(50,220,180,20);
        r2.setBackground(Color.WHITE);
        add(r2);

        r3 = new JRadioButton("Current Account");
        r3.setFont(new Font("Raleway",Font.BOLD,16));
        r3.setBounds(300,185,150,20);
        r3.setBackground(Color.WHITE);
        add(r3);

        r4 = new JRadioButton("Fixed Deposit Account");
        r4.setFont(new Font("Raleway",Font.BOLD,16));
        r4.setBounds(300,220,230,20);
        r4.setBackground(Color.WHITE);
        add(r4);

        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(r1);
        buttonGroup.add(r2);
        buttonGroup.add(r3);
        buttonGroup.add(r4);

        cardno = new JLabel("Card Number  ");
        cardno.setFont(new Font("Raleway",Font.BOLD,22));
        cardtxt = new JLabel("Your 16 Digit Card Number ");
        cardtxt.setFont(new Font("Raleway",Font.BOLD,13));
        cardno.setBounds(50,280,400,40);
        cardtxt.setBounds(50,310,400,40);

        cardnotxt = new JLabel("XXXX-XXXX-XXXX-4184");
        cardnotxt.setFont(new Font("Raleway",Font.BOLD,22));
        cardnotxt.setBounds(300,280,330,40);

        add(cardno);
        add(cardtxt);
        add(cardnotxt);

        pin = new JLabel("PIN:");
        pin.setFont(new Font("Raleway",Font.BOLD,22));
        pintxt = new JLabel("Your 4 Digit Password");
        pintxt.setFont(new Font("Raleway",Font.BOLD,13));
        pin.setBounds(50,360,400,40);
        pintxt.setBounds(50,390,400,40);
        pinnotxt = new JLabel("XXXX");
        pinnotxt.setFont(new Font("Raleway",Font.BOLD,22));
        pinnotxt.setBounds(300,360,200,40);
        add(pin);
        add(pintxt);
        add(pinnotxt);

        service = new JLabel("Service Required:");
        service.setFont(new Font("Raleway",Font.BOLD,22));
        service.setBounds(50,440,200,40);
        add(service);

        s1 = new JCheckBox("ATM CARD");
        s1.setFont(new Font("Raleway",Font.BOLD,18));
        s1.setBounds(50,490,200,40);
        s1.setBackground(Color.WHITE);
        add(s1);

        s2 = new JCheckBox("Internet Banking");
        s2.setFont(new Font("Raleway",Font.BOLD,18));
        s2.setBounds(300,490,200,40);
        s2.setBackground(Color.WHITE);
        add(s2);

        s3 = new JCheckBox("Mobile Banking");
        s3.setFont(new Font("Raleway",Font.BOLD,18));
        s3.setBounds(50,530,200,40);
        s3.setBackground(Color.WHITE);
        add(s3);

        s4 = new JCheckBox("EMAIL & SMS Alerts");
        s4.setFont(new Font("Raleway",Font.BOLD,18));
        s4.setBounds(300,530,250,40);
        s4.setBackground(Color.WHITE);
        add(s4);

        s5 = new JCheckBox("Cheque Book");
        s5.setFont(new Font("Raleway",Font.BOLD,18));
        s5.setBounds(50,570,200,40);
        s5.setBackground(Color.WHITE);
        add(s5);

        s6 = new JCheckBox("E-Statement");
        s6.setFont(new Font("Raleway",Font.BOLD,18));
        s6.setBounds(300,570,200,40);
        s6.setBackground(Color.WHITE);
        add(s6);

        declarationtxt = new JCheckBox("I hereby declares that the above entered details are correct to the best of my knowledge");
        declarationtxt.setFont(new Font("Raleway",Font.BOLD,12));
        declarationtxt.setBounds(50,640,550,40);
        declarationtxt.setBackground(Color.WHITE);
        add(declarationtxt);

        submit = new JButton("Submit");
        submit.setFont(new Font("Raleway",Font.BOLD,13));
        submit.setBounds(200,690,100,30);
        submit.setForeground(Color.WHITE);
        submit.setBackground(Color.BLACK);
        submit.addActionListener(this);
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setFont(new Font("Raleway",Font.BOLD,13));
        cancel.setBounds(350,690,100,30);
        cancel.setForeground(Color.WHITE);
        cancel.setBackground(Color.BLACK);
        cancel.addActionListener(this);
        add(cancel);

        getContentPane().setBackground(Color.WHITE);

        setSize(850, 800);
        setLocation(350, 0);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource ()==submit){
            String accountType = null;
            if(r1.isSelected()){
                accountType = "Saving Account";
            }
            else if (r2.isSelected()){
                accountType = "Current Account";
            }
            else if (r3.isSelected()){
                accountType = "Recurring Deposit Account";
            }
            else if (r4.isSelected()){
                accountType = "Fixed Deposit Account";
            }

            Random random = new Random();
            String cardnumber = "" + Math.abs((random.nextLong() % 90000000L) + 5040936000000000L);
            String pinnumber = "" + Math.abs((random.nextLong() % 9000L) + 1000L);

            String facility = "";
            if(s1.isSelected()){
                facility = facility + "ATM Card";
            }else if(s2.isSelected()){
                facility = facility + "Internet Banking";
            } else if (s3.isSelected()) {
                facility = facility + "Mobile Banking";
            }else if(s4.isSelected()){
                facility = facility + "E-Mail & SMS Alerts";
            }else if(s5.isSelected()){
                facility = facility + "Cheque Book";
            }else if(s6.isSelected()){
                facility = facility + "E-Statement";
            }

            try{
                if(accountType.equals("")){
                    JOptionPane.showMessageDialog(null, "Account Type is Saving Account");
                }else{
                    Conn conn = new Conn();
                    String query1 = "insert into signup3 values('"+formno+"','"+accountType+"','"+cardnumber+"','"+pinnumber+"','"+facility+"')";
                    String query2 = "insert into login values('"+formno+"','"+cardnumber+"','"+pinnumber+"')";
                    conn.s.executeUpdate(query1);
                    conn.s.executeUpdate(query2);

                    JOptionPane.showMessageDialog(null, "Card Number : "+cardnumber+"\nPin : "+pinnumber);
                }
            } catch (Exception e) {
                System.out.println(e);
            }

        } else if (ae.getSource() == cancel) {
            setVisible(false);
            new Login().setVisible(true);

        }
    }



    public static void main(String[] args) {
        new SignupThree("");


    }
}
