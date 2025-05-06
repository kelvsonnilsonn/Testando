package SOLIDExercises.RHSystem.Factorys;

import SOLIDExercises.RHSystem.Interfaces.RHReportInterface;

import SOLIDExercises.RHSystem.Services.ReportGenerators.RoleReport;
import SOLIDExercises.RHSystem.Services.ReportGenerators.SalaryReport;

public class DefaultReportGeneratorFactory implements RHReportGeneratorFactory {

    @Override
    public RHReportInterface createRoleRGenerator() {
        return new RoleReport();
    }

    @Override
    public RHReportInterface createSalaryRGenerator() {
        return new SalaryReport();
    }
}
