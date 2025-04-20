package Exercises.NotificationStudy.Factorys;

import Exercises.NotificationStudy.Interfaces.NSNotificationInterface;
import Exercises.NotificationStudy.Services.EmailNotification;
import Exercises.NotificationStudy.Services.PushNotification;
import Exercises.NotificationStudy.Services.SMSNotification;

public class DefaultNotificationFactory implements NSNotificationFactory {

    @Override
    public NSNotificationInterface createEmailNotification(){
        return new EmailNotification();
    }

    @Override
    public NSNotificationInterface createSMSNotification(){
        return new SMSNotification();
    }

    @Override
    public NSNotificationInterface createPushNotification(){
        return new PushNotification();
    }
}
