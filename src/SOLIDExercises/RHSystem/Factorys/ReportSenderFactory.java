package SOLIDExercises.RHSystem.Factorys;

import SOLIDExercises.RHSystem.Interfaces.ReportSenderInterface;

public interface ReportSenderFactory {
    ReportSenderInterface createAPIReporter();
    ReportSenderInterface createPDFReporter();
    ReportSenderInterface createEMAILReporter();
}
