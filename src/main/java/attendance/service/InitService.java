package attendance.service;

import attendance.domain.AttendanceInfos;
import attendance.domain.Crews;

public class InitService {
    public Crews getCrews() {
        return Crews.initCrews();
    }

    public AttendanceInfos getAttendanceInfos() {
        return AttendanceInfos.initAttendanceInfos();
    }
}
