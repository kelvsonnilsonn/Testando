package SOLIDExercises.StreamingProject.interfaces;

import SOLIDExercises.StreamingProject.model.Media;

public interface IMediaStorage {
    void load(Media midia);
    void save(Media midia);
}
