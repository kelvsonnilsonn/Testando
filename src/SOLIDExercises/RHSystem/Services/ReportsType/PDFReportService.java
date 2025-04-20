package SOLIDExercises.RHSystem.Services.ReportsType;

import SOLIDExercises.RHSystem.Interfaces.RHReportSenderInterface;

public class PDFReportService implements RHReportSenderInterface {

    @Override
    public void sendReport(String report){
        System.out.println("[PDF] " + report);
    }
}
