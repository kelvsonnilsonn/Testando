package Exercises.NotificationStudy;

import Exercises.NotificationStudy.Factorys.DefaultNotificationFactory;
import Exercises.NotificationStudy.Factorys.NSNotificationFactory;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        NSNotificationFactory factory = new DefaultNotificationFactory();
        NSApplication app = new NSApplication(factory);

        Scanner scan = new Scanner(System.in);

        app.run(scan);
    }
}
