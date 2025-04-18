package Factorys;

import Interfaces.AudioInterface;
import Interfaces.MessageInterface;
import Interfaces.NotificationInterface;
import Interfaces.StorageInterface;

public interface ServiceFactory {
    MessageInterface createMessageService();
    AudioInterface createAudioService();
    NotificationInterface createNotificationService();
    StorageInterface createStorageService();
}
