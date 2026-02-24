package bank.management.system;
import javax.swing.*;
import  java.awt.*;
import java.awt.event.*;

public class Transactions extends JFrame implements ActionListener {

    JButton deposit, withdrawal, fastcash, ministatement, pinchange, balance, exit;
    JLabel image, text;
    String pinnumber;

    Transactions(String pinnumber){
        this.pinnumber = pinnumber;

        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        image = new JLabel(i3);
        image.setBounds(0,0,900,800);
        add(image);

        text = new JLabel("Please select your Transaction");
        text.setBounds(260,285,700,40);
        text.setForeground(new Color(0, 102, 204));
        text.setFont(new Font("System",Font.BOLD,16));
        image.add(text);

        deposit = new JButton("Deposit");
        deposit.setBounds(210, 367, 150, 25);
        deposit.addActionListener(this);
        image.add(deposit);

        withdrawal = new JButton("Cash Withdrawal");
        withdrawal.setBounds(210, 395, 150, 25);
        withdrawal.addActionListener(this);
        image.add(withdrawal);

        fastcash = new JButton("Fast Cash");
        fastcash.setBounds(210, 423, 150, 25);
        fastcash.addActionListener(this);
        image.add(fastcash);

        ministatement = new JButton("Mini Statement");
        ministatement.setBounds(393, 367, 150, 25);
        ministatement.addActionListener(this);
        image.add(ministatement);

        pinchange = new JButton("Pin Change");
        pinchange.setBounds(393, 395, 150, 25);
        pinchange.addActionListener(this);
        image.add(pinchange);

        balance = new JButton("Balance Enquiry");
        balance.setBounds(393, 423, 150, 25);
        balance.addActionListener(this);
        image.add(balance);

        exit = new JButton("Exit");
        exit.setBounds(393, 451, 150, 25);
        exit.addActionListener(this);
        image.add(exit);

        setSize(900,900);
        setLocation(300, 0);
        setUndecorated(false);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == exit){
            System.exit(0);
        } else if (e.getSource() == deposit) {
            setVisible(false);
            new Deposit(pinnumber).setVisible(true);
        } else if (e.getSource() == withdrawal) {
            setVisible(false);
            new Withdrawal(pinnumber).setVisible(true);
        } else if (e.getSource() == fastcash) {
            setVisible(false);
            new FastCash(pinnumber).setVisible(true);
        } else if (e.getSource() == pinchange) {
            setVisible(false);
            new PinChange(pinnumber).setVisible(true);
        } else if (e.getSource() == balance) {
            setVisible(false);
            new BalanceEnquiry(pinnumber).setVisible(true);
        }else if(e.getSource() == ministatement){
            new MiniStatement(pinnumber).setVisible(true);
        }
    }

    public static void main(String[] args) {
        new Transactions("");

    }

}
