package SOLIDExercises.StreamingProject.model;

import java.time.Duration;

public abstract class Media {
    private int id;
    private Duration duration;

    public Media(int id, Duration duration){
        this.id = id;
        this.duration = duration;
    }

    public int getId(){ return this.id; }
    public Duration getDuration() { return this.duration; }

    public abstract void play();
}
