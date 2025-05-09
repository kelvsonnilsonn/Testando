package DIPExemple;

import DIPExemple.Factorys.ServiceFactory;
import DIPExemple.Interfaces.AudioInterface;
import DIPExemple.Interfaces.MessageInterface;
import DIPExemple.Interfaces.NotificationInterface;
import DIPExemple.Interfaces.StorageInterface;

public class Application {
    private final MessageInterface messageService;
    private final AudioInterface audioService;
    private final NotificationInterface notificationService;
    private final StorageInterface storageService;

    public Application(ServiceFactory factory){
        this.messageService = factory.createMessageService();
        this.audioService = factory.createAudioService();
        this.notificationService = factory.createNotificationService();
        this.storageService = factory.createStorageService();
    }

    public void run(){
        messageService.sendTelegramMessage();
        messageService.sendWhatsappMessage();
        messageService.sendXMessage();

        audioService.sendAudio();

        notificationService.sendEmail();
        notificationService.sendSMS();

        storageService.storeFile();
    }
}
