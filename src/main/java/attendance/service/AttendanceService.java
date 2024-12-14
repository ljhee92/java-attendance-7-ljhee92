package attendance.service;

import attendance.domain.OperatingDayOfWeek;
import attendance.domain.OperatingHour;
import attendance.util.ErrorMessage;
import camp.nextstep.edu.missionutils.DateTimes;

import java.time.LocalTime;

public class AttendanceService {
    public void checkDateAndTime() {
        if (!OperatingDayOfWeek.checkOperatingDayOfWeek()) {
            throw new IllegalArgumentException
                    (ErrorMessage.NOT_SCHOOL_DAY_EXCEPTION.getMessageByDate(DateTimes.now().toLocalDate()));
        }
    }

    public void checkTime(LocalTime inputTime) {
        if (!OperatingHour.checkOperatingHour(inputTime)) {
            throw new IllegalArgumentException(ErrorMessage.NOT_OPEN_HOUR_EXCEPTION.getMessage());
        }
    }

    public void
}
