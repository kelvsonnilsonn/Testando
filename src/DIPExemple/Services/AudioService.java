package DIPExemple.Services;

import DIPExemple.Interfaces.AudioInterface;

public class AudioService implements AudioInterface {
    @Override
    public void sendAudio(){
        System.out.println("[AUDIOSERVICE] Enviando Audio");
    }
}
