package Calculator.Equation.Operators;

public class OperatorFactory {

    public static IOperator getOperator(String name){
        switch (name){
            case "add":
                return new Adder();
            case "sub":
                return new Subtracter();
            case "multiply":
                return new Multiplier();
            case "divide":
                return new Divider();
            default:
                return null;
        }
    }
}
