package com.example.intellijpluginspotify;

import com.example.intellijpluginspotify.gui.Login;
import com.example.intellijpluginspotify.utils.Notifier;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class Controller extends AnAction {
    Notifier notifier = new Notifier();

    @Override
    public void actionPerformed(AnActionEvent e) {
        try {
            checkFile();
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
        try {
            tryToLogin();
        } catch (IOException | ClassNotFoundException ex) {
            throw new RuntimeException(ex);
        }
        openController();

    }

    private void openController() {
    }

    private void tryToLogin() throws IOException, ClassNotFoundException {
        Login login = new Login();
        BufferedReader br = new BufferedReader(new FileReader("C:\\IntelliJPluginSpotify\\plugin.settings"));
        login.showWindow(br.readLine() == null);
    }


    private void checkFile() throws IOException {
        try {
            if (!Files.exists(Path.of("C:\\Program Files\\IntelliJPluginSpotify\\"))) {
                Files.createDirectory(Path.of("C:\\IntelliJPluginSpotify"));
            }
        } catch (IOException ignored) {

        }

        File file = new File("C:\\IntelliJPluginSpotify\\plugin.settings");
        if (!file.exists()) {
            file.createNewFile();
        }

    }

}
