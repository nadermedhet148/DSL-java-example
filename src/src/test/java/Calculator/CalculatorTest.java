package Calculator;
import static org.junit.jupiter.api.Assertions.assertEquals;


import Calculator.Equation.Equation;
import Calculator.Equation.Operator.Adder;
import Calculator.Field.Field;
import org.junit.jupiter.api.Test;

public class CalculatorTest {

    @Test
    void RunEquationName() {
        Calculator calculator = new Calculator();
        Integer totalSalary = calculator
                .addField( new Field("salary" , 1))
                .addField(new Field("bounce" , 10))
                .addEquation(new Equation("totalSalary" , "salary" , "bounce" , new Adder() )).
                calcEquation("totalSalary");
        assertEquals(totalSalary , 11);
    }

}



