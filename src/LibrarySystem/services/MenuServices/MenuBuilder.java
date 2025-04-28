package LibrarySystem.services.MenuServices;

import LibrarySystem.Interfaces.MenuInterface;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public abstract class MenuBuilder implements MenuInterface {
    protected final List<String> prompts;
    protected final Scanner scan;

    protected MenuBuilder(Scanner scan, String... prompts){
        this.scan = scan;
        this.prompts = Arrays.asList(prompts);
    }

    @Override
    public String[] collectData(){
        String[] data = new String[prompts.size()];
        for(int i = 0; i<prompts.size(); i++){
            System.out.print(prompts.get(i));
            data[i] = scan.nextLine();
        }
        return data;
    }
}
