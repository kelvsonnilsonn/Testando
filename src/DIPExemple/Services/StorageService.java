package DIPExemple.Services;

import DIPExemple.Interfaces.StorageInterface;

public class StorageService implements StorageInterface {
    @Override
    public void storeFile(){
        System.out.println("[STORAGESERVICE] Armazenando um arquivo");
    }
}
