package SOLIDExercises.RHSystem.Services.ReportsType;

import SOLIDExercises.RHSystem.Interfaces.RHReportSenderInterface;

public class EmailReportService implements RHReportSenderInterface {

    @Override
    public void sendReport(String report){
        System.out.println("[E-MAIL] " + report);
    }

}
