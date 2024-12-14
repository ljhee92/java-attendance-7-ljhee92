package attendance.view;

import attendance.domain.Function;
import attendance.util.InputReader;
import attendance.util.OutputWriter;
import camp.nextstep.edu.missionutils.DateTimes;

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
}
