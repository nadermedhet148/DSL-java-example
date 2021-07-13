import DSlParser.CalculatorDataModel;
import DSlParser.DSLController;
import DSlParser.DSLParser;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class ExternalDSL {
    public static void main(String[] args) throws Exception {
        File myObj = new File("/home/nader/Documents/projects/DSL/src/ExternalDSLEx.txt");
        Scanner myReader = new Scanner(myObj);
        ArrayList<String> dslRules = new  ArrayList<>();
        while (myReader.hasNextLine()) {
            String data = myReader.nextLine();
            dslRules.add(data);
        }
        myReader.close();

        DSLParser parser = new DSLParser(dslRules);
        CalculatorDataModel model = parser.loadRules();
        DSLController controller = new DSLController(model);
        controller.run();


    }
}