package SOLIDExercises.StreamingProject.model.Forms;

import SOLIDExercises.StreamingProject.model.Media;

import java.time.Duration;

public class StreamingAudio extends Media {
    public StreamingAudio(int id, Duration duration){
        super(id, duration);
    }

    @Override
    public void play() {
        System.out.println("Rodando AUDIO.");
    }

}
