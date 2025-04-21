package SOLIDExercises.StreamingProject.services;

import SOLIDExercises.StreamingProject.interfaces.IMediaStorage;
import SOLIDExercises.StreamingProject.model.Media;

public class MediaStorage implements IMediaStorage {

    @Override
    public void load(Media midia) {
        System.out.println("Carregando: " + midia.getId()); // id será o endereço no storage, então só precisa buscar.
    }

    @Override
    public void save(Media midia) {
        System.out.println("Salvando " + midia.getId());
    }
}
