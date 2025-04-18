package SOLIDExercises.RHSystem.Factorys;

import SOLIDExercises.RHSystem.Interfaces.ReportSenderInterface;

import SOLIDExercises.RHSystem.Services.ReportsType.APIReportService;
import SOLIDExercises.RHSystem.Services.ReportsType.EmailReportService;
import SOLIDExercises.RHSystem.Services.ReportsType.PDFReportService;

public class DefaultReportSendersFactory implements ReportSenderFactory{

    @Override
    public ReportSenderInterface createAPIReporter() {
        return new APIReportService();
    }

    @Override
    public ReportSenderInterface createEMAILReporter(){
        return new EmailReportService();
    }

    @Override
    public ReportSenderInterface createPDFReporter(){
        return new PDFReportService();
    }

}
