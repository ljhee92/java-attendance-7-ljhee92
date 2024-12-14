package attendance.service;

import attendance.domain.AttendanceDTO;
import attendance.domain.AttendanceInfo;
import attendance.domain.AttendanceInfos;
import attendance.domain.Crew;
import attendance.domain.Crews;
import attendance.domain.OperatingDayOfWeek;
import attendance.domain.OperatingHour;
import attendance.util.ErrorMessage;
import camp.nextstep.edu.missionutils.DateTimes;

import java.time.LocalTime;
import java.util.List;

public class AttendanceService {
    public void checkDate() {
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


    public AttendanceDTO attendance(Crew crew, AttendanceInfos attendanceInfos, LocalTime inputTime) {
        attendanceInfos.attendance(crew, inputTime);
        return getAttendanceDTO(attendanceInfos.getAttendanceInfosOf(crew), inputTime);
    }

    private AttendanceDTO getAttendanceDTO(List<AttendanceInfo> attendanceInfoByCrew, LocalTime inputTime) {
        return new AttendanceDTO(DateTimes.now().toLocalDate(), inputTime,
                attendanceInfoByCrew.getFirst().getAttendanceStatus().getStatus());
    }
}
