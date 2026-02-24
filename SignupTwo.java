package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.util.*;
import java.awt.event.*;

public class SignupTwo extends JFrame implements ActionListener{

    JLabel additionalDetails, religion, category, income, education, qualification, occupation, panno, aadharno, senior, existing;
    JTextField pannoTextField,  aadharnoTextField;
    JRadioButton yes, no;
    ButtonGroup seniorgroup, existinggroup;
    JButton next;
    JComboBox Religion, Category, Income, Education, Occupation;
    String Formno;

    SignupTwo(String Formno) {
        this.Formno = Formno;
        setLayout(null);

        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");

        additionalDetails = new JLabel(" Page 2 : Additional Details ");
        additionalDetails.setFont(new Font("Raleway",Font.BOLD,23));
        additionalDetails.setBounds(270,40,400,40);
        add(additionalDetails);

        religion = new JLabel("Religion : ");
        religion.setFont(new Font("Raleway",Font.BOLD,20));
        religion.setBounds(100,140,100,30);
        add(religion);

        String valReligion[] = {"Hindu" , "Muslim" , "Sikh" , "Christian", "Other"};
        Religion = new JComboBox(valReligion);
        Religion.setBounds(300,140,400,30);
        Religion.setBackground(Color.WHITE);
        add(Religion);

        category = new JLabel("Category : ");
        category.setFont(new Font("Raleway",Font.BOLD,20));
        category.setBounds(100,190,200,30);
        add(category);

        String valCategory[] = {"General", "OBC", "SC", "ST", "Other"};
        Category = new JComboBox(valCategory);
        Category.setBounds(300,190,400,30);
        Category.setBackground(Color.WHITE);
        add(Category);

        income = new JLabel("Income : ");
        income.setFont(new Font("Raleway",Font.BOLD,20));
        income.setBounds(100,240,200,30);
        add(income);

        String valIncome[] = {"Null", "< 1,50,000", "< 2,50,000", "< 5,00,000", "upto 10,00,000"};
        Income = new JComboBox(valIncome);
        Income.setBounds(300,240,400,30);
        Income.setBackground(Color.WHITE);
        add(Income);

        education = new JLabel("Educational ");
        qualification = new JLabel("Qualification : ");
        education.setFont(new Font("Raleway",Font.BOLD,20));
        education.setBounds(100,290,300,30);
        qualification.setFont(new Font("Raleway",Font.BOLD,20));
        qualification.setBounds(100,320,300,30);
        add(education);
        add(qualification);

        String valEducation[] = {"Non-Graduate", "Graduate", "Post-Graduation", "Doctrate", "Others"};
        Education = new JComboBox(valEducation);
        Education.setBounds(300,320,400,30);
        Education.setBackground(Color.WHITE);
        add(Education);

        occupation = new JLabel("Occupation : ");
        occupation.setFont(new Font("Raleway",Font.BOLD,20));
        occupation.setBounds(100,390,200,30);
        add(occupation);

        String valOccupation [] = {"Salaried", "Self-Employed", "Business", "Student", "Retired", "Other"};
        Occupation = new JComboBox(valOccupation);
        Occupation.setBounds(300,390,400,30);
        Occupation.setBackground(Color.WHITE);
        add(Occupation);

        panno = new JLabel("Pan Number : ");
        panno.setFont(new Font("Raleway",Font.BOLD,20));
        panno.setBounds(100,440,150,30);
        add(panno);

        pannoTextField = new JTextField();
        pannoTextField.setBounds(300, 440, 400, 30);
        pannoTextField.setFont(new Font("Arial", Font.BOLD, 14));
        add(pannoTextField);

        aadharno = new JLabel("Aadhar Number : ");
        aadharno.setFont(new Font("Raleway",Font.BOLD,20));
        aadharno.setBounds(100,490,200,30);
        add(aadharno);

        aadharnoTextField = new JTextField();
        aadharnoTextField.setBounds(300, 490, 400, 30);
        aadharnoTextField.setFont(new Font("Arial", Font.BOLD, 14));
        add(aadharnoTextField);

        senior = new JLabel("Senior Citizen : ");
        senior.setFont(new Font("Raleway",Font.BOLD,20));
        senior.setBounds(100,540,200,30);
        add(senior);

        yes = new JRadioButton("Yes");
        yes.setBounds(300,540,100,30);
        yes.setBackground(Color.WHITE);
        add(yes);

        no = new JRadioButton("No");
        no.setBounds(400,540,100,30);
        no.setBackground(Color.WHITE);
        add(no);

        seniorgroup = new ButtonGroup();
        seniorgroup.add(yes);
        seniorgroup.add(no);

        existing = new JLabel("Existing Account : ");
        existing.setFont(new Font("Raleway",Font.BOLD,20));
        existing.setBounds(100,590,200,30);
        add(existing);

        yes = new JRadioButton("Yes");
        yes.setBounds(300,590,100,30);
        yes.setBackground(Color.WHITE);
        add(yes);

        no = new JRadioButton("No");
        no.setBounds(400,590,100,30);
        no.setBackground(Color.WHITE);
        add(no);

        existinggroup = new ButtonGroup();
        existinggroup.add(yes);
        existinggroup.add(no);

        next = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway",Font.BOLD,14));
        next.setBounds(425,660,100,30);
        next.addActionListener(this);
        add(next);

        getContentPane().setBackground(Color.WHITE);

        setSize(850, 800);
        setLocation(350, 0);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e){
        String sreligion = (String) Religion.getSelectedItem();
        String scategory = (String) Category.getSelectedItem();
        String sincome = (String) Income.getSelectedItem();
        String seducation = (String) Education.getSelectedItem();
        String soccupation = (String) Occupation.getSelectedItem();
        String spanno = pannoTextField.getText();
        String saadharno = aadharnoTextField.getText();
        String ssenior = null;
        if(yes.isSelected()){
            ssenior = "Yes";
        } else if (no.isSelected()) {
            ssenior = "No";
        }
        String sexisting = null;
        if(yes.isSelected()){
            sexisting = "Yes";
        } else if (no.isSelected()) {
            sexisting = "No";
        }





        try{
            if(religion.equals("")) {
                JOptionPane.showMessageDialog(null, "Name is Required");
            } else {
                Conn c = new Conn();
                String query = "insert into signup2 values('"+Formno+"' , '"+sreligion+"' , '"+scategory+"' , '"+sincome+"' , '"+seducation+"' , '"+soccupation+"' , '"+spanno+"' , '"+saadharno+"' , '"+ssenior+"' , '"+sexisting+"')";
                c.s.executeUpdate(query);

            }

            //Signup3 Object
              setVisible(false);
              new SignupThree(Formno).setVisible(true);

        }
        catch(Exception e1){
            System.out.println(e1);
        }

    }

    public static void main(String[] args) {
        new SignupTwo("");
    }
}
