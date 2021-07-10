package Calculator.Equation.Operators;

public class OperatorFactory {

    public static IOperator getOperator(String name){
        switch (name){
            case "add":
                return new Adder();
            case "sub":
                return new Subtract();
            case "multiply":
                return new Multiply();
            default:
                return null;
        }
    }
}
