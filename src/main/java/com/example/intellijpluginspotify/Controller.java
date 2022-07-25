package com.example.intellijpluginspotify;

import com.example.intellijpluginspotify.gui.Login;
import com.example.intellijpluginspotify.utils.Notifier;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import org.bouncycastle.crypto.generators.BCrypt;


import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Base64;

public class Controller extends AnAction {
    Notifier notifier = new Notifier();

    @Override
    public void actionPerformed(AnActionEvent e) {
        try {
            checkFile();
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
        openLogin();
    openController();

    }

    private void openController() {
    }

    private void openLogin() {
        Login login = new Login();



    }

    private void checkFile() throws IOException {
        /**
        FileOutputStream fileOutputStream = new FileOutputStream("C:\\Program Files\\IntelliJPluginSpotify\\user.settings");
        notifier.notifyInfo(null,"C:\\Program Files\\IntelliJPluginSpotify\\user.settings");
         */

        try {
            if (!Files.exists(Path.of("C:\\Program Files\\IntelliJPluginSpotify\\"))) {
                Files.createDirectory(Path.of("C:\\IntelliJPluginSpotify"));
            }
        } catch (FileAlreadyExistsException e) {

        }

        File file = new File("C:\\IntelliJPluginSpotify\\plugin.settings");
        if(!file.exists()){
            file.createNewFile();
        }

        if(file.exists()){
            notifier.notifyInfo(null,"Found plugin.settings");
        }
        else{
            notifier.notifyInfo(null,"Cant find plugin.settings");
        }

    }



}
