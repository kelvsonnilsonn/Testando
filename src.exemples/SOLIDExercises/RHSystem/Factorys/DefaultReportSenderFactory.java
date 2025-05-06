package SOLIDExercises.RHSystem.Factorys;

import SOLIDExercises.RHSystem.Interfaces.RHReportSenderInterface;

import SOLIDExercises.RHSystem.Services.ReportsType.APIReportService;
import SOLIDExercises.RHSystem.Services.ReportsType.EmailReportService;
import SOLIDExercises.RHSystem.Services.ReportsType.PDFReportService;

public class DefaultReportSenderFactory implements RHReportSenderFactory {

    @Override
    public RHReportSenderInterface createAPIReporter() {
        return new APIReportService();
    }

    @Override
    public RHReportSenderInterface createEMAILReporter(){
        return new EmailReportService();
    }

    @Override
    public RHReportSenderInterface createPDFReporter(){
        return new PDFReportService();
    }

}
