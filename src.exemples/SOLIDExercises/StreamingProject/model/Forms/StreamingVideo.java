package SOLIDExercises.StreamingProject.model.Forms;

import SOLIDExercises.StreamingProject.model.Media;

import java.time.Duration;

public class StreamingVideo extends Media {
    public StreamingVideo(int id, Duration duration){
        super(id, duration);
    }

    @Override
    public void play() {
        System.out.println("Rodando VIDEO.");
    }

}
