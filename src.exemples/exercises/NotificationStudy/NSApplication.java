package exercises.NotificationStudy;

import exercises.NotificationStudy.Factorys.NSNotificationFactory;
import exercises.NotificationStudy.Interfaces.NSNotificationInterface;

import java.util.Scanner;

public class NSApplication {
    private final NSNotificationInterface emailSender;
    private final NSNotificationInterface smsSender;
    private final NSNotificationInterface pushSender;

    public NSApplication(NSNotificationFactory factory){
        this.emailSender = factory.createEmailNotification();
        this.smsSender = factory.createSMSNotification();
        this.pushSender = factory.createPushNotification();
    }

    public void run(Scanner scan){
        int option = scan.nextInt();
        switch (option){
            case 1 :
                emailSender.sendNotification("ABACATE");
                break;
            case 2 :
                smsSender.sendNotification("ABACATE2");
                break;
            case 3 :
                pushSender.sendNotification("A");
        }
    }
}
