package SOLIDExercises.RHSystem.Factorys;

import SOLIDExercises.RHSystem.Interfaces.ReportInterface;

import SOLIDExercises.RHSystem.Services.ReportGenerators.RoleReport;
import SOLIDExercises.RHSystem.Services.ReportGenerators.SalaryReport;

public class DefaultReportGeneratorsFactory implements ReportGeneratorFactory {

    @Override
    public ReportInterface createRoleRGenerator() {
        return new RoleReport();
    }

    @Override
    public ReportInterface createSalaryRGenerator() {
        return new SalaryReport();
    }
}
