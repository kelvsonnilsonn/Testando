package SOLIDExercises.RHSystem;

import SOLIDExercises.RHSystem.Factorys.DefaultReportGeneratorsFactory;
import SOLIDExercises.RHSystem.Factorys.DefaultReportSendersFactory;
import SOLIDExercises.RHSystem.Factorys.ReportGeneratorFactory;
import SOLIDExercises.RHSystem.Factorys.ReportSenderFactory;

public class Main {
    public static void main(String[] args) {
        ReportGeneratorFactory generatedFactory = new DefaultReportGeneratorsFactory();
        ReportSenderFactory senderFactory = new DefaultReportSendersFactory();
        Application app = new Application(senderFactory, generatedFactory);

        app.run(1, 1);
    }
}
