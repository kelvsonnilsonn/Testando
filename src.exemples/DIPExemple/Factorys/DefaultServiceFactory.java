package DIPExemple.Factorys;

import DIPExemple.Interfaces.AudioInterface;
import DIPExemple.Interfaces.MessageInterface;
import DIPExemple.Interfaces.NotificationInterface;
import DIPExemple.Interfaces.StorageInterface;
import DIPExemple.Services.AudioService;
import DIPExemple.Services.MessageService;
import DIPExemple.Services.NotificationService;
import DIPExemple.Services.StorageService;

public class DefaultServiceFactory implements ServiceFactory{

    @Override
    public MessageInterface createMessageService(){
        return new MessageService();
    }

    @Override
    public AudioInterface createAudioService(){
        return new AudioService();
    }

    @Override
    public NotificationInterface createNotificationService(){
        return new NotificationService();
    }

    @Override
    public StorageInterface createStorageService(){
        return new StorageService();
    }

}
