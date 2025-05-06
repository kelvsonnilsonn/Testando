package SOLIDExercises.RHSystem;

import SOLIDExercises.RHSystem.Factorys.DefaultReportGeneratorFactory;
import SOLIDExercises.RHSystem.Factorys.DefaultReportSenderFactory;
import SOLIDExercises.RHSystem.Factorys.RHReportGeneratorFactory;
import SOLIDExercises.RHSystem.Factorys.RHReportSenderFactory;

public class Main {
    public static void main(String[] args) {
        RHReportGeneratorFactory generatedFactory = new DefaultReportGeneratorFactory();
        RHReportSenderFactory senderFactory = new DefaultReportSenderFactory();
        RHApplication app = new RHApplication(senderFactory, generatedFactory);

        app.run(1, 2);
    }
}
