package Exercises.NotificationStudy;

import Exercises.NotificationStudy.Factorys.DefaultNotificationFactory;
import Exercises.NotificationStudy.Factorys.NotificationFactory;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        NotificationFactory factory = new DefaultNotificationFactory();
        Application app = new Application(factory);

        Scanner scan = new Scanner(System.in);

        app.run(scan);
    }
}
