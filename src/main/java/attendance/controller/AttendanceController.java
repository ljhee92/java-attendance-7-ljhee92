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
            run(selectedFunction, crews, attendanceInfos);
        }
    }

    private void run(Function selectedFunction, Crews crews, AttendanceInfos attendanceInfos) {
        if (selectedFunction == Function.ATTENDANCE) {
            processSelectOne(crews, attendanceInfos);
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

    public void processSelectOne(Crews crews, AttendanceInfos attendanceInfos) {
        crews.checkContains(inputView.selectCrew());
    }
}
