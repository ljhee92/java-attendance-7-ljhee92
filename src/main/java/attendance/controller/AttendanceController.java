package attendance.controller;

import attendance.domain.AttendanceInfos;
import attendance.domain.Crews;
import attendance.domain.Function;
import attendance.service.InitService;
import attendance.view.InputView;
import attendance.view.OutputView;

public class AttendanceController {
    private final InputView inputView;
    private final OutputView outputView;
    private final InitService initService;

    public AttendanceController(InputView inputView, OutputView outputView, InitService initService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.initService = initService;
    }

    public void start() {
        Crews crews = initService.getCrews();
        AttendanceInfos attendanceInfos = initService.getAttendanceInfos();
        while (true) {
            Function selectedFunction = inputView.selectFunction();
            if (selectedFunction.equals(Function.QUIT)) {
                break;
            }
            run(selectedFunction);
        }
    }

    private void run(Function selectedFunction) {
        if (selectedFunction == Function.ATTENDANCE) {
            System.out.println("1");
            return;
        }

        if (selectedFunction == Function.ATTENDANCE_EDIT) {
            System.out.println("2");
            return;
        }

        if (selectedFunction == Function.ATTENDANCE_CHECK) {
            System.out.println("3");
            return;
        }

        if (selectedFunction == Function.WEEDING_CHECK) {
            System.out.println("4");
            return;
        }
    }
}
