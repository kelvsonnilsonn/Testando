package Exercises.NotificationStudy.Services;

import Exercises.NotificationStudy.Interfaces.NSNotificationInterface;

public class SMSNotification implements NSNotificationInterface {

    @Override
    public void sendNotification(String message) {
        System.out.println(message);
    }

}
