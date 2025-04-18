package SOLIDExercises.RHSystem.Services.ReportsType;

import SOLIDExercises.RHSystem.Interfaces.ReportSenderInterface;

public class APIReportService implements ReportSenderInterface {

    @Override
    public void sendReport(String report){
        System.out.println("[API] " + report);
    }

}
