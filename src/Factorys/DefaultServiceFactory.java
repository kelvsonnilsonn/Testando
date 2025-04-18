package Factorys;

import Interfaces.AudioInterface;
import Interfaces.MessageInterface;
import Interfaces.NotificationInterface;
import Interfaces.StorageInterface;
import Services.AudioService;
import Services.MessageService;
import Services.NotificationService;
import Services.StorageService;

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
