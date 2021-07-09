package Calculator.Equation;

import Calculator.Equation.Operator.IOperator;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Equation {
    private String name;
    private String left;
    private String right;
    private String operator;
}
