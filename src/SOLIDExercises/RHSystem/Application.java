package SOLIDExercises.RHSystem;

import SOLIDExercises.RHSystem.Factorys.ReportGeneratorFactory;
import SOLIDExercises.RHSystem.Factorys.ReportSenderFactory;
import SOLIDExercises.RHSystem.Interfaces.ReportInterface;
import SOLIDExercises.RHSystem.Interfaces.ReportSenderInterface;

public class Application {
    private final ReportSenderInterface reportAPI;
    private final ReportSenderInterface reportPDF;
    private final ReportSenderInterface reportEMAIL;

    private final ReportInterface roleReport;
    private final ReportInterface salaryReport;

    private String generatedReport;

    public Application(ReportSenderFactory senderFactory, ReportGeneratorFactory generatorFactory){
        this.reportAPI = senderFactory.createAPIReporter();
        this.reportPDF = senderFactory.createPDFReporter();
        this.reportEMAIL = senderFactory.createEMAILReporter();

        this.roleReport = generatorFactory.createRoleRGenerator();
        this.salaryReport = generatorFactory.createSalaryRGenerator();
    }

    public void run(int optionGenerator, int optionSender){
        generateReport(optionGenerator);
        sendReport(optionSender);
    }

    private void generateReport(int option){
        switch (option){
            case 1 :
                setReportInString(roleReport.generateReport());
                break;
            case 2 :
                setReportInString(salaryReport.generateReport());
                break;
            default :
                break;
        }
    }

    private void sendReport(int option){
        switch (option){
            case 1 :
                reportAPI.sendReport(generatedReport);
                break;
            case 2 :
                reportPDF.sendReport(generatedReport);
                break;
            case 3 :
                reportEMAIL.sendReport(generatedReport);
                break;
            default :
                break;
        }
    }

    private void setReportInString(String report){
        this.generatedReport = report;
    }
}
