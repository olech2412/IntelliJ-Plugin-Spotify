package com.example.intellijpluginspotify.gui;

import com.example.intellijpluginspotify.Account;
import com.example.intellijpluginspotify.utils.Notifier;

import javax.swing.*;
import java.io.*;
import java.util.Base64;

public class Login extends JFrame {
    private JPanel LoginPanel;
    private JLabel Header;
    private JTextField usernameTextField;
    private JPasswordField passwortPasswordField;
    private JButton login;
    private JButton close;

    private final Notifier notifier = new Notifier();

    public Login() {
        setContentPane(LoginPanel);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Spotify Login");
        setSize(600, 300);
        setResizable(false);

        close.addActionListener(e -> setVisible(false));


        login.addActionListener(e -> {
            if(usernameTextField.getText().isEmpty() || passwortPasswordField.getPassword().length == 0) {
                JOptionPane.showMessageDialog(null, "Please enter a username and password");
            } else {
                try {
                    createAccount(usernameTextField.getText(), String.valueOf(passwortPasswordField.getPassword()));
                    login();
                } catch (IOException | ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
    }

    public void showWindow(boolean show) {
        setVisible(show);
    }

    public static void login() throws IOException, ClassNotFoundException {
        try {
            FileInputStream fileInputStream = new FileInputStream("C:\\IntelliJPluginSpotify\\plugin.settings");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

            Account account1 = (Account) objectInputStream.readObject();
            String encoded = Base64.getEncoder().encodeToString(account1.getPassword());
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Fehler aufgetreten: " + e.getMessage() + "" + e.getCause() + "\n" +
                    "Wahrscheinlich wurde die \"plugin.settings\" Datei manipuliert. Loeschen Sie die Datei und legen Sie ihren Account erneut an."
            );
        }
    }

    public static void createAccount(String username, String password) throws IOException {
        byte[] decoded = Base64.getDecoder().decode(password);
        Account account = new Account(username, decoded);

        File file = new File("C:\\IntelliJPluginSpotify\\plugin.settings");
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(account);
        objectOutputStream.close();
    }
}
