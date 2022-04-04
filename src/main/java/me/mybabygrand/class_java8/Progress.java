package me.mybabygrand.class_java8;

import java.time.Duration;

public class Progress {
    private Duration studyDuration;
    private boolean finished;

    public Duration getStudyDuration() {
        return studyDuration;
    }

    public void setStudyDuration(Duration studyDuration) {
        this.studyDuration = studyDuration;
    }

    public Progress(Duration studyDuration, boolean finished) {
        this.studyDuration = studyDuration;
        this.finished = finished;
    }
}


