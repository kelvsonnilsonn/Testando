package SOLIDExercises.RHSystem.Services.ReportsType;

import SOLIDExercises.RHSystem.Interfaces.RHReportSenderInterface;

public class APIReportService implements RHReportSenderInterface {

    @Override
    public void sendReport(String report){
        System.out.println("[API] " + report);
    }

}
