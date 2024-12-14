package attendance.controller;

import attendance.domain.AttendanceDTO;
import attendance.domain.AttendanceInfos;
import attendance.domain.Crew;
import attendance.domain.Crews;
import attendance.domain.Function;
import attendance.service.AttendanceService;
import attendance.service.InitService;
import attendance.view.InputView;
import attendance.view.OutputView;

import java.time.LocalTime;

public class AttendanceController {
    private final InputView inputView;
    private final OutputView outputView;
    private final InitService initService;
    private final AttendanceService attendanceService;

    public AttendanceController(InputView inputView, OutputView outputView,
                                InitService initService, AttendanceService attendanceService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.initService = initService;
        this.attendanceService = attendanceService;
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
        attendanceService.checkDate();
        String name = inputView.selectCrew();
        crews.checkContains(name);
        Crew crew = Crew.of(name);
        LocalTime attendanceTime = inputView.inputTime();
        attendanceService.checkTime(attendanceTime);
        AttendanceDTO attendanceDTO = attendanceService.attendance(crew, attendanceInfos, attendanceTime);
        outputView.displayAttendanceInfo(attendanceDTO);
    }
}
