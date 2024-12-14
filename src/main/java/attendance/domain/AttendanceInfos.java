package attendance.domain;

import attendance.util.FileParser;
import camp.nextstep.edu.missionutils.DateTimes;

import java.time.LocalTime;
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

    public void attendance(Crew crew, LocalTime inputTime) {
        List<AttendanceInfo> attendanceInfoByCrew = attendanceInfos.get(crew);
        attendanceInfoByCrew.add(AttendanceInfo.of(DateTimes.now().toLocalDate(), inputTime));
        attendanceInfos.put(crew, attendanceInfoByCrew);
    }

    @Override
    public String toString() {
        return "AttendanceInfos{" +
                "attendanceInfos=" + attendanceInfos +
                '}';
    }
}
