package attendance.domain;

import camp.nextstep.edu.missionutils.DateTimes;

import java.time.LocalTime;

public enum OperatingHour {
    START_TIME_OF_MON(LocalTime.of(13, 0, 0)),
    START_TIME(LocalTime.of(9, 0, 0)),
    END_TIME(LocalTime.of(18, 0, 0))
    ;

    private final LocalTime localTime;

    OperatingHour(LocalTime localTime) {
        this.localTime = localTime;
    }

    public LocalTime getLocalTime() {
        return localTime;
    }

    public static boolean checkOperatingHour(LocalTime inputTime) {
        LocalTime time = DateTimes.now().toLocalTime();
        for (OperatingHour operatingHour : OperatingHour.values()) {
            if (operatingHour.localTime.equals(time) && operatingHour.localTime.equals(inputTime)) {
                return true;
            }
        }
        return false;
    }
}
