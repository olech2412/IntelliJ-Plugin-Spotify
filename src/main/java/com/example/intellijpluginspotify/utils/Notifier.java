package com.example.intellijpluginspotify.utils;

import com.intellij.notification.NotificationGroupManager;
import com.intellij.notification.NotificationType;
import com.intellij.openapi.project.Project;
import org.jetbrains.annotations.Nullable;

public class Notifier {

    public void notifyError(@Nullable Project project,
                                   String content) {
        NotificationGroupManager.getInstance()
                .getNotificationGroup("Spotify Plugin")
                .createNotification(content, NotificationType.ERROR)
                .notify(project);
    }

    public void notifyInfo(@Nullable Project project,
                                   String content) {
        NotificationGroupManager.getInstance()
                .getNotificationGroup("Spotify Plugin")
                .createNotification(content, NotificationType.INFORMATION)
                .notify(project);
    }

    public void notifyWarning(@Nullable Project project,
                                   String content) {
        NotificationGroupManager.getInstance()
                .getNotificationGroup("Spotify Plugin")
                .createNotification(content, NotificationType.WARNING)
                .notify(project);
    }


}
