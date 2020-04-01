/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/**
 *
 * @author Hp
 */
class LoginData extends JFrame implements ActionListener{
    private JTextField tfUsername, tfPass;
    private JButton btnLogin;
    private JLabel lUsername, lPass, lTitle;
    
    public LoginData(){
        setTitle("Login");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);
        
        tfUsername = new JTextField(10);
        tfPass = new JTextField(10);
        lUsername = new JLabel("Username");
        lPass = new JLabel("Password");
        lTitle = new JLabel("LOGIN");
        btnLogin = new JButton("LOGIN");
        
        setLayout(new BorderLayout());
        add(lTitle, "North");
        add(lUsername);
        add(tfUsername);
        add(lPass);
        add(tfPass);
        add(btnLogin);
        tfUsername.addActionListener(this);
        tfPass.addActionListener(this);
        btnLogin.addActionListener(this);
        
        pack();
        
    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == btnLogin){
            if(tfUsername.getText() == "Admin" && tfPass.getText() == "123"){
                new DataViewInput();
            }
            else{
                
            }
        }
    }
}
public class Login{
    public static void main(String[] args){
        new LoginData();
    }
}
