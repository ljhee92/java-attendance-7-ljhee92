package attendance.view;

import attendance.domain.AttendanceDTO;
import attendance.util.OutputWriter;

import java.time.format.TextStyle;
import java.util.Locale;

public class OutputView implements OutputWriter {
    public void displayAttendanceInfo(AttendanceDTO attendanceDTO) {
        displayNewLine();
        displayFormat("%s월 %s일 %s %s (출석)", attendanceDTO.localDate().getMonthValue(),
                attendanceDTO.localDate().getDayOfMonth(),
                attendanceDTO.localDate().getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.KOREAN),
                attendanceDTO.localTime());
    }
}
