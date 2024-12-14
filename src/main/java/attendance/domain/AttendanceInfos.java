package attendance.domain;

import attendance.util.FileParser;

import java.util.List;
import java.util.Map;

public class AttendanceInfos {
    private final Map<Crew, List<AttendanceInfo>> attendanceInfos;

    private AttendanceInfos(Map<Crew, List<AttendanceInfo>> attendanceInfos) {
        this.attendanceInfos = attendanceInfos;
    }

    public static AttendanceInfos initAttendanceInfos() {
        return new AttendanceInfos(FileParser.initAttendanceInfos());
    }

    @Override
    public String toString() {
        return "AttendanceInfos{" +
                "attendanceInfos=" + attendanceInfos +
                '}';
    }
}
