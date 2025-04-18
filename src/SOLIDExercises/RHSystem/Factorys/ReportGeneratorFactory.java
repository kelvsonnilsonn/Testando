package SOLIDExercises.RHSystem.Factorys;

import SOLIDExercises.RHSystem.Interfaces.ReportInterface;

public interface ReportGeneratorFactory {
    ReportInterface createRoleRGenerator();
    ReportInterface createSalaryRGenerator();
}
