package Exercises.NotificationStudy.Services;

import Exercises.NotificationStudy.Interfaces.NotificationInterface;

public class SMSNotification implements NotificationInterface {

    @Override
    public void sendNotification(String message) {
        System.out.println(message);
    }

}
