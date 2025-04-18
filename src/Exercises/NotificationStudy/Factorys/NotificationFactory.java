package Exercises.NotificationStudy.Factorys;

import Exercises.NotificationStudy.Interfaces.NotificationInterface;

public interface NotificationFactory {
    NotificationInterface createEmailNotification();
    NotificationInterface createSMSNotification();
    NotificationInterface createPushNotification();
}
