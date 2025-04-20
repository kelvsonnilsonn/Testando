package SOLIDExercises.RHSystem;

import SOLIDExercises.RHSystem.Factorys.RHReportGeneratorFactory;
import SOLIDExercises.RHSystem.Factorys.RHReportSenderFactory;
import SOLIDExercises.RHSystem.Interfaces.RHReportInterface;
import SOLIDExercises.RHSystem.Interfaces.RHReportSenderInterface;

public class RHApplication {
    private final RHReportSenderInterface reportAPI;
    private final RHReportSenderInterface reportPDF;
    private final RHReportSenderInterface reportEMAIL;

    private final RHReportInterface roleReport;
    private final RHReportInterface salaryReport;

    private String generatedReport;

    public RHApplication(RHReportSenderFactory senderFactory, RHReportGeneratorFactory generatorFactory){
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
