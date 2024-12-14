package attendance.domain;

import attendance.util.ErrorMessage;

public enum Function {
    ATTENDANCE("출석 확인", "1"),
    ATTENDANCE_EDIT("출석 수정", "2"),
    ATTENDANCE_CHECK("크루별 출석 기록 확인", "3"),
    WEEDING_CHECK("제적 위험자 확인", "4"),
    QUIT("종료", "Q")
    ;

    private final String optionName;
    private final String selectName;

    Function(String optionName, String selectName) {
        this.optionName = optionName;
        this.selectName = selectName;
    }

    public String getOptionName() {
        return optionName;
    }

    public String getSelectName() {
        return selectName;
    }

    public static Function getFunctionFrom(String selectName) {
        for (Function function : Function.values()) {
            if (function.selectName.equals(selectName)) {
                return function;
            }
        }
        throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT_FORMAT_EXCEPTION.getMessage());
    }
}
