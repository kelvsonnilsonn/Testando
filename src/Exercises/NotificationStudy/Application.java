package Exercises.NotificationStudy;

import Exercises.NotificationStudy.Factorys.NotificationFactory;
import Exercises.NotificationStudy.Interfaces.NotificationInterface;

import java.util.Scanner;

public class Application {
    private final NotificationInterface emailSender;
    private final NotificationInterface smsSender;
    private final NotificationInterface pushSender;

    public Application(NotificationFactory factory){
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
