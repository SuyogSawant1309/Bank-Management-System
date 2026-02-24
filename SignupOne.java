package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;

public class SignupOne extends JFrame implements ActionListener{

    long random;
   JLabel formno, personDetails, name, fname, dob, gender, email, marital, address, city, state, pincode;
   JTextField  nameTextField, fnameTextField, emailTextField, addressTextField,  cityTextField, stateTextField, pincodeTextField;
   JRadioButton male, female, married, unmarried, other;
   JDateChooser  dateChooser;
   ButtonGroup gendergroup, maritalgroup;
   JButton next;


    SignupOne() {

        setLayout(null);

        Random ran = new Random();
        random = Math.abs((ran.nextLong() % 9000L) + 1000L);

        formno = new JLabel("APPLICATION FORM NO. "+random);
        formno.setFont(new Font("Raleway",Font.BOLD,38));
        formno.setBounds(140,20,600,40);
        add(formno);

        personDetails = new JLabel(" Page 1 : Personal Details ");
        personDetails.setFont(new Font("Raleway",Font.BOLD,20));
        personDetails.setBounds(290,80,600,40);
        add(personDetails);

        name = new JLabel("Name : ");
        name.setFont(new Font("Raleway",Font.BOLD,20));
        name.setBounds(100,140,100,30);
        add(name);

        nameTextField = new JTextField();
        nameTextField.setBounds(300, 140, 400, 30);
        nameTextField.setFont(new Font("Arial", Font.BOLD, 14));
        add(nameTextField);

        fname = new JLabel("Father's Name : ");
        fname.setFont(new Font("Raleway",Font.BOLD,20));
        fname.setBounds(100,190,200,30);
        add(fname);

        fnameTextField = new JTextField();
        fnameTextField.setBounds(300, 190, 400, 30);
        fnameTextField.setFont(new Font("Arial", Font.BOLD, 14));
        add(fnameTextField);

        dob = new JLabel("Date of Birth : ");
        dob.setFont(new Font("Raleway",Font.BOLD,20));
        dob.setBounds(100,240,200,30);
        add(dob);

        dateChooser = new JDateChooser();
        dateChooser.setBounds(300,240,400,30);
        dateChooser.setForeground(Color.RED);
        add(dateChooser);

        gender = new JLabel("Gender : ");
        gender.setFont(new Font("Raleway",Font.BOLD,20));
        gender.setBounds(100,290,100,30);
        add(gender);

        male = new JRadioButton("Male");
        male.setBounds(300,290,100,30);
        male.setBackground(Color.WHITE);
        add(male);

        female = new JRadioButton("Female");
        female.setBounds(400,290,100,30);
        female.setBackground(Color.WHITE);
        add(female);

        gendergroup = new ButtonGroup();
        gendergroup.add(male);
        gendergroup.add(female);

        email = new JLabel("Email : ");
        email.setFont(new Font("Raleway",Font.BOLD,20));
        email.setBounds(100,340,100,30);
        add(email);

        emailTextField = new JTextField();
        emailTextField.setBounds(300, 340, 400, 30);
        emailTextField.setFont(new Font("Arial", Font.BOLD, 14));
        add(emailTextField);

        marital = new JLabel("Marital Status : ");
        marital.setFont(new Font("Raleway",Font.BOLD,20));
        marital.setBounds(100,390,200,30);
        add(marital);

        married = new JRadioButton("Married");
        married.setBounds(300,390,100,30);
        married.setBackground(Color.WHITE);
        add(married);

        unmarried = new JRadioButton("UnMarried");
        unmarried.setBounds(433,390,100,30);
        unmarried.setBackground(Color.WHITE);
        add(unmarried);

        other = new JRadioButton("Other");
        other.setBounds(600,390,100,30);
        other.setBackground(Color.WHITE);
        add(other);

        maritalgroup = new ButtonGroup();
        maritalgroup.add(married);
        maritalgroup.add(unmarried);
        maritalgroup.add(other);

        address = new JLabel("Address : ");
        address.setFont(new Font("Raleway",Font.BOLD,20));
        address.setBounds(100,440,100,30);
        add(address);

        addressTextField = new JTextField();
        addressTextField.setBounds(300, 440, 400, 30);
        addressTextField.setFont(new Font("Arial", Font.BOLD, 14));
        add(addressTextField);

        city = new JLabel("City : ");
        city.setFont(new Font("Raleway",Font.BOLD,20));
        city.setBounds(100,490,100,30);
        add(city);

        cityTextField = new JTextField();
        cityTextField.setBounds(300, 490, 400, 30);
        cityTextField.setFont(new Font("Arial", Font.BOLD, 14));
        add(cityTextField);

        state = new JLabel("State : ");
        state.setFont(new Font("Raleway",Font.BOLD,20));
        state.setBounds(100,540,100,30);
        add(state);

        stateTextField = new JTextField();
        stateTextField.setBounds(300, 540, 400, 30);
        stateTextField.setFont(new Font("Arial", Font.BOLD, 14));
        add(stateTextField);

        pincode = new JLabel("Pin Code : ");
        pincode.setFont(new Font("Raleway",Font.BOLD,20));
        pincode.setBounds(100,590,200,30);
        add(pincode);

        pincodeTextField = new JTextField();
        pincodeTextField.setBounds(300, 590, 400, 30);
        pincodeTextField.setFont(new Font("Arial", Font.BOLD, 14));
        add(pincodeTextField);

        next = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway",Font.BOLD,14));
        next.setBounds(450,660,100,30);
        next.addActionListener(this);
        add(next);

        getContentPane().setBackground(Color.WHITE);

        setSize(850, 800);
        setLocation(350, 0);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e){
        String Formno = ""+random; //converting from long to string data type
        String Name = nameTextField.getText();
        String Fname = fnameTextField.getText();
        String Dob = ((JTextField)dateChooser.getDateEditor().getUiComponent()).getText();
        String Gender = null;
        if(male.isSelected()){
            Gender = "Male";
        } else if (female.isSelected()) {
            Gender = "Female";
        }

        String Email = emailTextField.getText();
        String Marital = null;
        if(married.isSelected()){
            Marital = "Married";
        } else if (unmarried.isSelected()) {
            Marital = "Unmarried";
        }
        else if (other.isSelected()) {
            Marital = "Other";
        }

        String Address = addressTextField.getText();
        String City = cityTextField.getText();
        String State = stateTextField.getText();
        String Pincode = pincodeTextField.getText();

        try{
            String name = nameTextField.getText().trim();
            if(name.equals("")) {
                JOptionPane.showMessageDialog(null, "Name is Required");
            } else {
                Conn c = new Conn();
                String query = "insert into signup values('"+Formno+"' , '"+Name+"' , '"+Fname+"' , '"+Dob+"' , '"+Gender+"' , '"+Email+"' , '"+Marital+"' , '"+Address+"' , '"+City+"' , '"+State+"' , '"+Pincode+"')";
                c.s.executeUpdate(query);

                setVisible(false);
                new SignupTwo(Formno).setVisible(true);

            }

        }
        catch(Exception e1){
            System.out.println(e1);
        }

    }

    public static void main(String[] args) {
        new SignupOne();
    }
}
