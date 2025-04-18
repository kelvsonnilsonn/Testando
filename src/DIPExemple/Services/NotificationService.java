package DIPExemple.Services;

import DIPExemple.Interfaces.NotificationInterface;

public class NotificationService implements NotificationInterface {
    @Override
    public void sendSMS(){
        System.out.println("[NOTIFICATIONSERVICE] Notificando por SMS");
    }

    @Override
    public void sendEmail(){
        System.out.println("[NOTIFICATIONSERVICE] Notificando por E-MAIL");
    }
}
