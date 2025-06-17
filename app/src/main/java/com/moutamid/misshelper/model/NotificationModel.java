package com.moutamid.misshelper.model;

public class NotificationModel {
    private String notificationTitle;
    private String notificationDetails;
    private String notificationTime;
    private int icon;

    int colorResId;


    public NotificationModel(String notificationTitle, int icon, String notificationDetails, String notificationTime, int colorResId) {
        this.notificationTitle = notificationTitle;
        this.notificationDetails = notificationDetails;
        this.notificationTime = notificationTime;
        this.icon = icon;
        this.colorResId = colorResId;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public String getNotificationTitle() {
        return notificationTitle;
    }

    public void setNotificationTitle(String notificationTitle) {
        this.notificationTitle = notificationTitle;
    }

    public String getNotificationDetails() {
        return notificationDetails;
    }

    public void setNotificationDetails(String notificationDetails) {
        this.notificationDetails = notificationDetails;
    }

    public String getNotificationTime() {
        return notificationTime;
    }

    public void setNotificationTime(String notificationTime) {
        this.notificationTime = notificationTime;
    }

    public int getColorResId() {
        return colorResId;
    }

    public void setColorResId(int colorResId) {
        this.colorResId = colorResId;
    }
}
