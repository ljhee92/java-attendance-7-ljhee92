package attendance.controller;

import attendance.domain.AttendanceInfos;
import attendance.domain.Crews;
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

    public void run() {
        Crews crews = initService.getCrews();
        AttendanceInfos attendanceInfos = initService.getAttendanceInfos();
    }
}
