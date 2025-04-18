package Exercises.NotificationStudy.Factorys;

import Exercises.NotificationStudy.Interfaces.NotificationInterface;
import Exercises.NotificationStudy.Services.EmailNotification;
import Exercises.NotificationStudy.Services.PushNotification;
import Exercises.NotificationStudy.Services.SMSNotification;

public class DefaultNotificationFactory implements NotificationFactory{

    @Override
    public NotificationInterface createEmailNotification(){
        return new EmailNotification();
    }

    @Override
    public NotificationInterface createSMSNotification(){
        return new SMSNotification();
    }

    @Override
    public NotificationInterface createPushNotification(){
        return new PushNotification();
    }
}
