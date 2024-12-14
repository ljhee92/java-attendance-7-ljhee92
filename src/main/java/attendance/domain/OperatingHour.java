package attendance.domain;

import java.time.LocalTime;

public enum OperatingHour {
    START_TIME(LocalTime.of(8, 0, 0)),
    END_TIME(LocalTime.of(23, 0, 0))
    ;

    private final LocalTime localTime;

    OperatingHour(LocalTime localTime) {
        this.localTime = localTime;
    }

    public LocalTime getLocalTime() {
        return localTime;
    }

    public static boolean checkOperatingHour(LocalTime inputTime) {
        if (!inputTime.isBefore(START_TIME.localTime) && !inputTime.isAfter(END_TIME.localTime)) {
            return true;
        }

        return false;
    }
}
