package attendance.config;

import attendance.controller.AttendanceController;
import attendance.service.AttendanceService;
import attendance.service.InitService;
import attendance.view.InputView;
import attendance.view.OutputView;

public class AppConfig {
    public AttendanceController attendanceController() {
        return new AttendanceController(inputView(), outputView(), fileService(), attendanceService());
    }

    private InputView inputView() {
        return new InputView();
    }

    private OutputView outputView() {
        return new OutputView();
    }

    private InitService fileService() {
        return new InitService();
    }

    private AttendanceService attendanceService() {
        return new AttendanceService();
    }
}
