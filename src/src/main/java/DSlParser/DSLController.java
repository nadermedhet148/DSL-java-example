package DSlParser;

import Calculator.Calculator;
import Calculator.Field.Field;
import Calculator.Field.FieldBuilder;

import java.io.IOException;

public class DSLController {

    private  Calculator calculator  = new Calculator();
    private  CalculatorDataModel model;

    public DSLController(CalculatorDataModel model){
        Calculator calculator;
        this.model = model;
    }
    public void run (){
        model.getFields().forEach(field -> {
            try {
                this.calculator.addField(new FieldBuilder(field).loadValue());
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        model.getEquations().forEach(eq -> {
            this.calculator.addEquation(eq);
        });

        model.getCalculations().forEach(equationName -> {
            Float result = this.calculator.calcEquation(equationName);
            System.out.println("result for " + equationName + " equal : " + result );
        });
    }
}

