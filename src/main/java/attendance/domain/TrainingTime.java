package attendance.domain;

import java.time.LocalTime;

public enum TrainingTime {
    START_TIME_OF_MON(LocalTime.of(13, 0, 0)),
    START_TIME(LocalTime.of(10, 0, 0)),
    END_TIME(LocalTime.of(18, 0, 0))
    ;

    private final LocalTime localTime;

    TrainingTime(LocalTime localTime) {
        this.localTime = localTime;
    }

    public LocalTime getLocalTime() {
        return localTime;
    }
}
