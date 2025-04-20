package SOLIDExercises.RHSystem.Factorys;

import SOLIDExercises.RHSystem.Interfaces.RHReportInterface;

public interface RHReportGeneratorFactory {
    RHReportInterface createRoleRGenerator();
    RHReportInterface createSalaryRGenerator();
}
