package LibrarySystem.model.validateModels.CPF;

class CpfFormatter {

    private static String clearCPF(String cpf) {
        if (cpf == null) {
            throw new IllegalArgumentException("[ERRO] CPF não deve se null."); // fast-fail
        }

        return cpf.replaceAll("[^0-9]", "");
    }

    private static void validLength(String cpf) {
        if(cpf.length() != 11){
            throw new IllegalArgumentException("[ERRO] CPF deve conter tamanho fixo de 11 algarismos.");
        }
    }

    private static void validSequence(String cpf) {
        if(cpf.matches("(\\d)\\1{10}")){
            throw new IllegalArgumentException("[ERRO] CPF inválido.");
        }
    }

    public static String validateFormatter(String cpf){
        String clearedCPF = clearCPF(cpf);
        validLength(clearedCPF);
        validSequence(clearedCPF);

        return clearedCPF;
    }
}
