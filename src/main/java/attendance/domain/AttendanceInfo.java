package attendance.domain;

import java.time.LocalDate;
import java.time.LocalTime;

public class AttendanceInfo {
    private final LocalDate attendanceDate;
    private final LocalTime attendanceTime;

    private AttendanceInfo(LocalDate attendanceDate, LocalTime attendanceTime) {
        this.attendanceDate = attendanceDate;
        this.attendanceTime = attendanceTime;
    }

    public static AttendanceInfo of(LocalDate attendanceDate, LocalTime attendanceTime) {
        return new AttendanceInfo(attendanceDate, attendanceTime);
    }

    @Override
    public String toString() {
        return "AttendanceInfo{" +
                "attendanceDate=" + attendanceDate +
                ", attendanceTime=" + attendanceTime +
                '}';
    }
}
