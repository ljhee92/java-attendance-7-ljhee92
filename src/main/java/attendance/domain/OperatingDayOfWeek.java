package attendance.domain;

import attendance.util.ErrorMessage;
import camp.nextstep.edu.missionutils.DateTimes;

import java.time.format.TextStyle;
import java.util.Locale;

public enum OperatingDayOfWeek {
    MON(1, "월"),
    TUE(2, "화"),
    WED(3, "수"),
    THU(4, "목"),
    FRI(5, "금")
    ;

    private final int number;
    private final String korean;

    OperatingDayOfWeek(int number, String korean) {
        this.number = number;
        this.korean = korean;
    }

    public int getNumber() {
        return number;
    }

    public String getKorean() {
        return korean;
    }

    public static boolean checkOperatingDayOfWeek() {
        String today = DateTimes.now().getDayOfWeek().getDisplayName(TextStyle.SHORT, Locale.KOREAN).toUpperCase();
        for (OperatingDayOfWeek operatingDayOfWeek : OperatingDayOfWeek.values()) {
            if (operatingDayOfWeek.korean.equals(today)) {
                return true;
            }
        }
        return false;
    }
}
