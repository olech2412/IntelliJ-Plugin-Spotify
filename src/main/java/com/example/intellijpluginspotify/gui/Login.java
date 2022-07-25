package com.example.intellijpluginspotify.gui;

import com.example.intellijpluginspotify.Account;
import com.example.intellijpluginspotify.utils.Notifier;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Arrays;
import java.util.Base64;

public class Login extends JFrame {
    private JPanel LoginPanel;
    private JLabel Header;
    private JTextField usernameTextField;
    private JPasswordField passwortPasswordField;
    private JButton login;
    private JButton close;

    public Login() {
        setContentPane(LoginPanel);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Spotify Login");
        setSize(600, 300);
        setResizable(false);
        setVisible(true);


        close.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });


        login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    login(usernameTextField.getText(), String.valueOf(passwortPasswordField.getPassword()));
                } catch (FileNotFoundException ex) {
                    throw new RuntimeException(ex);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                } catch (ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
    }

    public static Account login(String username, String password) throws IOException, ClassNotFoundException {
        Notifier notifier = new Notifier();
        notifier.notifyInfo(null, password);
        byte[] decoded = Base64.getDecoder().decode(password);
        Account account = new Account(username, decoded);

        File file = new File("C:\\IntelliJPluginSpotify\\plugin.settings");
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(account);
        objectOutputStream.close();

        FileInputStream fileInputStream = new FileInputStream("C:\\IntelliJPluginSpotify\\plugin.settings");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

        Account account1 = (Account) objectInputStream.readObject();
        String encoded = Base64.getEncoder().encodeToString(account1.getPassword());
        notifier.notifyInfo(null,account1.getUsername() + " " + encoded);

        return account;
    }


}
