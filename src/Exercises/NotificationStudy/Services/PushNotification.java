package Exercises.NotificationStudy.Services;

import Exercises.NotificationStudy.Interfaces.NSNotificationInterface;

public class PushNotification implements NSNotificationInterface {

    @Override
    public void sendNotification(String message){
        System.out.println(message);
    }
}
