package exercises.NotificationStudy.Factorys;

import exercises.NotificationStudy.Interfaces.NSNotificationInterface;

public interface NSNotificationFactory {
    NSNotificationInterface createEmailNotification();
    NSNotificationInterface createSMSNotification();
    NSNotificationInterface createPushNotification();
}
