package Calculator.Equation.Operator;

public class Adder implements IOperator {
    public Integer Operate(Integer left, Integer right) {
        return left + right;
    }
}
