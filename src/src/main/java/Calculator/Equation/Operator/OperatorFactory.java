package Calculator.Equation.Operator;

public class OperatorFactory {

    public static IOperator getOperator(String name){
        switch (name){
            case "add":
                return new Adder();
            default:
                return null;
        }
    }
}
