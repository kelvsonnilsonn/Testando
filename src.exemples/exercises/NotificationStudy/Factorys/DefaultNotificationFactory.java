package exercises.NotificationStudy.Factorys;

import exercises.NotificationStudy.Interfaces.NSNotificationInterface;
import exercises.NotificationStudy.Services.EmailNotification;
import exercises.NotificationStudy.Services.PushNotification;
import exercises.NotificationStudy.Services.SMSNotification;

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
