package Calculator.Equation.Operators;

public class Multiplier implements IOperator {
    public Integer Operate(Integer left, Integer right) {
        return left * right;
    }
}
