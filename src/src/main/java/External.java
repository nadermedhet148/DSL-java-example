import Calculator.Calculator;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class External {
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
        parser.loadRules();
        Calculator calculator = new Calculator();

        parser.getFields().forEach(field -> {
            calculator.addField(field);
        });

        parser.getEquations().forEach(eq -> {
            calculator.addEquation(eq);
        });

        parser.getCalculations().forEach(equationName -> {
            Float result = calculator.calcEquation(equationName);
            System.out.println("result for " + equationName + " equal : " + result );
        });

    }
}
