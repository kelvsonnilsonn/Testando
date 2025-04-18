package Services;

import Interfaces.MessageInterface;

public class MessageService implements MessageInterface {
    @Override
    public void sendWhatsappMessage(){
        System.out.println("[MESSAGESERVICE] Enviando messagem por whatsapp.");
    }

    @Override
    public void sendTelegramMessage() {
        System.out.println("[MESSAGESERVICE] Enviando messagem por telegram.");
    }

    @Override
    public void sendXMessage(){
        System.out.println("[MESSAGESERVICE] Enviando messagem por X.");
    }
}
