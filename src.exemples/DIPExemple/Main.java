package DIPExemple;

import DIPExemple.Factorys.DefaultServiceFactory;
import DIPExemple.Factorys.ServiceFactory;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        ServiceFactory factory = new DefaultServiceFactory();
        Application app = new Application(factory);
        app.run();
    }
}