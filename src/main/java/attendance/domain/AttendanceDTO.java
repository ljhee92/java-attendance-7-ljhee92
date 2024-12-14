package attendance.domain;

import java.time.LocalDate;
import java.time.LocalTime;

public record AttendanceDTO(LocalDate localDate, LocalTime localTime, String attendanceStatus) {
}
