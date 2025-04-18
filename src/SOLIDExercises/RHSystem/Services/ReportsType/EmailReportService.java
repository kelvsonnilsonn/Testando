package SOLIDExercises.RHSystem.Services.ReportsType;

import SOLIDExercises.RHSystem.Interfaces.ReportSenderInterface;

public class EmailReportService implements ReportSenderInterface {

    @Override
    public void sendReport(String report){
        System.out.println("[E-MAIL] " + report);
    }

}
