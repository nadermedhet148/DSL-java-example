import Calculator.Calculator;

public class DSLController {

    private  Calculator calculator  = new Calculator();
    private  CalculatorDataModel model;

    public DSLController(CalculatorDataModel model){
        Calculator calculator;
        this.model = model;
    }
    public void run (){
        model.getFields().forEach(field -> {
            this.calculator.addField(field);
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

