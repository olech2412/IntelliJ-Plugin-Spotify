package com.example.intellijpluginspotify;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.diagnostic.Logger;
import com.intellij.openapi.project.Project;


import javax.swing.*;
import java.io.File;
import java.io.IOException;
public class Controller extends AnAction {
    Notifier notifier = new Notifier();
    @Override
    public void actionPerformed(AnActionEvent e) {
    checkFile();
    openLogin();
    openController();

    }

    private void openController() {
    }

    private void openLogin() {
        JFrame loginFrame = new JFrame("Spotify Login");
        loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        loginFrame.setVisible(true);

    }

    private void checkFile() {
        try{
            String homedirectory = System.getProperty("user.home") + File.separator + "Documents";
            File settingsFile = new File(homedirectory);
            if(settingsFile.createNewFile()){
                notifier.notifyWarning(null, "Cannot find Settings File -> create new one");
            }else{
                notifier.notifyInfo(null, "Found Settings File");
            }
        } catch (IOException e) {
            notifier.notifyError(null, e.getMessage());
        }
    }


}
