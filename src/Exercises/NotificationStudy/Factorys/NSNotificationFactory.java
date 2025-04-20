package Exercises.NotificationStudy.Factorys;

import Exercises.NotificationStudy.Interfaces.NSNotificationInterface;

public interface NSNotificationFactory {
    NSNotificationInterface createEmailNotification();
    NSNotificationInterface createSMSNotification();
    NSNotificationInterface createPushNotification();
}
