package SOLIDExercises.RHSystem.Factorys;

import SOLIDExercises.RHSystem.Interfaces.RHReportSenderInterface;

public interface RHReportSenderFactory {
    RHReportSenderInterface createAPIReporter();
    RHReportSenderInterface createPDFReporter();
    RHReportSenderInterface createEMAILReporter();
}
