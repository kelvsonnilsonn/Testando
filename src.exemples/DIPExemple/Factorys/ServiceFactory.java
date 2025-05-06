package DIPExemple.Factorys;

import DIPExemple.Interfaces.AudioInterface;
import DIPExemple.Interfaces.MessageInterface;
import DIPExemple.Interfaces.NotificationInterface;
import DIPExemple.Interfaces.StorageInterface;

public interface ServiceFactory {
    MessageInterface createMessageService();
    AudioInterface createAudioService();
    NotificationInterface createNotificationService();
    StorageInterface createStorageService();
}
