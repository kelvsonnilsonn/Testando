package exercises.NotificationStudy.Services;

import exercises.NotificationStudy.Interfaces.NSNotificationInterface;

public class EmailNotification implements NSNotificationInterface {

    @Override
    public void sendNotification(String message) {
        System.out.println(message);
    }

}
