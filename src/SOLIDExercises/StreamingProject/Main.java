package SOLIDExercises.StreamingProject;

import SOLIDExercises.StreamingProject.model.Forms.StreamingAudio;
import SOLIDExercises.StreamingProject.model.Forms.StreamingVideo;
import SOLIDExercises.StreamingProject.model.Media;

import java.time.Duration;

public class Main {
    public static void main(String[] args) {
        MediaPlayer player = new MediaPlayer();

        Media audio = new StreamingAudio(0, Duration.ofMinutes(3));
        Media video = new StreamingVideo(1, Duration.ofMinutes(3));

        player.playMidia(audio);
        player.playMidia(video);
    }
}
