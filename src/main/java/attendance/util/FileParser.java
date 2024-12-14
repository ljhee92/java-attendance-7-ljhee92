package attendance.util;

import attendance.domain.AttendanceInfo;
import attendance.domain.AttendanceStatus;
import attendance.domain.Crew;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FileParser {
    private static final String FILE_PATH = "src/main/resources/attendances.csv";
    private static final int CREW_INDEX = 0;
    private static final int INFO_INDEX = 1;
    private static final int DATE_INDEX = 0;
    private static final int TIME_INDEX = 1;
    private static final List<String> contentsByFile = ResourceReader.readFile(FILE_PATH);

    private FileParser() {}

    public static List<Crew> initCrews() {
        List<String> names = new ArrayList<>();
        List<Crew> crews = new ArrayList<>();

        for (String line : contentsByFile) {
            String name = line.split(",")[CREW_INDEX];
            if (!names.contains(name)) {
                names.add(name);
            }
        }

        for (String name : names) {
            Crew crew = Crew.of(name);
            crews.add(crew);
        }

        return crews;
    }

    public static Map<Crew, List<AttendanceInfo>> initAttendanceInfos() {
        Map<Crew, List<AttendanceInfo>> attendanceInfos = new HashMap<>();
        List<Crew> crews = initCrews();

        for (Crew crew : crews) {
            List<AttendanceInfo> attendanceInfosByCrew = new ArrayList<>();
            for (String line : contentsByFile) {
                String[] list = line.split(",");
                String name = list[CREW_INDEX];
                if (name.equals(crew.getName())) {
                    LocalDate date = LocalDate.parse(list[INFO_INDEX].split(" ")[DATE_INDEX]);
                    LocalTime time = LocalTime.parse(list[INFO_INDEX].split(" ")[TIME_INDEX]);
                    AttendanceInfo attendanceInfo = AttendanceInfo.of(date, time, AttendanceStatus.of(date, time));
                    attendanceInfosByCrew.add(attendanceInfo);
                }
            }
            attendanceInfos.put(crew, attendanceInfosByCrew);
        }

        return attendanceInfos;
    }
}
