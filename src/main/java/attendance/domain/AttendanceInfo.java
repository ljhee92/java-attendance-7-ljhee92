package attendance.domain;

import java.time.LocalDate;
import java.time.LocalTime;

public class AttendanceInfo {
    private final LocalDate attendanceDate;
    private final LocalTime attendanceTime;
    private final AttendanceStatus attendanceStatus;

    private AttendanceInfo(LocalDate attendanceDate, LocalTime attendanceTime, AttendanceStatus attendanceStatus) {
        this.attendanceDate = attendanceDate;
        this.attendanceTime = attendanceTime;
        this.attendanceStatus = attendanceStatus;
    }

    public static AttendanceInfo of(LocalDate attendanceDate, LocalTime attendanceTime, AttendanceStatus attendanceStatus) {
        return new AttendanceInfo(attendanceDate, attendanceTime, attendanceStatus);
    }

    public LocalDate getAttendanceDate() {
        return attendanceDate;
    }

    public LocalTime getAttendanceTime() {
        return attendanceTime;
    }

    public AttendanceStatus getAttendanceStatus() {
        return attendanceStatus;
    }

    @Override
    public String toString() {
        return "AttendanceInfo{" +
                "attendanceDate=" + attendanceDate +
                ", attendanceTime=" + attendanceTime +
                '}';
    }
}
