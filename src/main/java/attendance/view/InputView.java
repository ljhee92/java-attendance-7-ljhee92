package attendance.view;

import attendance.domain.Crew;
import attendance.domain.Function;
import attendance.util.ErrorMessage;
import attendance.util.InputReader;
import attendance.util.OutputWriter;
import camp.nextstep.edu.missionutils.DateTimes;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.TextStyle;
import java.util.Locale;

public class InputView implements InputReader, OutputWriter {
    public Function selectFunction() {
        displayFormat("오늘은 %d월 %d일 %s입니다. 기능을 선택해 주세요.", DateTimes.now().getMonthValue(),
                DateTimes.now().getDayOfMonth(), DateTimes.now().getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.KOREAN));
        for (Function function : Function.values()) {
            displayFormat("%s. %s", function.getSelectName(), function.getOptionName());
        }
        return Function.getFunctionFrom(inputMessage());
    }

    public String selectCrew() {
        displayNewLine();
        displayMessageByLine("닉네임을 입력해 주세요.");
        String input = inputMessage();
        validateBlank(input);
        return input;

    }

    private void validateBlank(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT_FORMAT_EXCEPTION.getMessage());
        }
    }

    public LocalTime inputTime() {
        displayMessageByLine("등교 시간을 입력해 주세요.");
        String input = inputMessage();
        validateBlank(input);
        validateTime(input);
        return LocalTime.parse(input);
    }

    private void validateTime(String input) {
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
            simpleDateFormat.setLenient(false);
            simpleDateFormat.parse(input);
        } catch (ParseException parseException) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT_FORMAT_EXCEPTION.getMessage());
        }
    }
}
