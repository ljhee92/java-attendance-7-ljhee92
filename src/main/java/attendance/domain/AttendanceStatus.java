package attendance.domain;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.TextStyle;
import java.util.Locale;

public enum AttendanceStatus {
    ATTENDANCE("출석"),
    PERCEPTION("지각"),
    ABSENCE("결석")
    ;

    private final String status;

    AttendanceStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public static AttendanceStatus of(LocalDate localDate, LocalTime localTime) {
        if (localDate.getDayOfWeek().getDisplayName(TextStyle.SHORT, Locale.KOREAN).equals(OperatingDayOfWeek.MON.getKorean())) {
            if (!localTime.isBefore(TrainingTime.START_TIME_OF_MON.getLocalTime())
                    && !localTime.isAfter(TrainingTime.END_TIME.getLocalTime())) {
                return ATTENDANCE;
            }

            if (Duration.between(localTime, TrainingTime.START_TIME_OF_MON.getLocalTime()).toMinutes() > 5) {
                return PERCEPTION;
            }

            return ABSENCE;
        }

        if (!localTime.isBefore(TrainingTime.START_TIME.getLocalTime())
                && !localTime.isAfter(TrainingTime.END_TIME.getLocalTime())) {
            return ATTENDANCE;
        }

        if (Duration.between(localTime, TrainingTime.START_TIME.getLocalTime()).toMinutes() > 5) {
            return PERCEPTION;
        }

        return ABSENCE;
    }
}
