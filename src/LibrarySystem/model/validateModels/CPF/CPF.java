package LibrarySystem.model.validateModels.CPF;

public class CPF {  // tell, don't ask
    private final String cpf;

    public CPF(String cpf){
        validate(cpf);

        this.cpf = cpf;
    }

    public String getCpf(){ return this.cpf; }

    private void validate(String cpf){

        String clearedCpf = CpfFormatter.validateFormatter(cpf);
        CalculateCpfDigits.validateDigits(clearedCpf);

    }
}