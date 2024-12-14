package attendance.util;

import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;

public enum ErrorMessage {
    FILE_READ_EXCEPTION("파일 읽기에 실패했습니다. 경로를 확인해주세요."),
    INVALID_INPUT_FORMAT_EXCEPTION("잘못된 형식을 입력하였습니다."),
    NOT_EXIST_NICKNAME_EXCEPTION("등록되지 않은 닉네임입니다."),
    NOT_SCHOOL_DAY_EXCEPTION("은 등교일이 아닙니다."),
    FUTURE_DATE_EXCEPTION("아직 수정할 수 없습니다."),
    NOT_OPEN_HOUR_EXCEPTION("캠퍼스 운영 시간에만 출석이 가능합니다."),
    ALREADY_ATTENDANCE_EXCEPTION("이미 출석을 확인하였습니다. 필요한 경우 수정 기능을 이용해 주세요.")
    ;

    private static final String prefix = "[ERROR] ";

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return prefix + message;
    }

    public String getMessageByDate(LocalDate localDate) {
        return prefix + String.format("%d월 %d일 %s", localDate.getMonthValue(), localDate.getDayOfMonth(),
                localDate.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.KOREAN) + message);
    }
}
