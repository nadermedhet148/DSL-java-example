package Calculator;
import static org.junit.jupiter.api.Assertions.assertEquals;


import Calculator.Equation.Equation;
import Calculator.Field.Field;
import org.junit.jupiter.api.Test;

public class CalculatorTest {

    @Test
    void RunEquationWithFields() {
        Calculator calculator = new Calculator();
        Integer totalSalary = calculator
                .addField( new Field("salary" , 1))
                .addField(new Field("bounce" , 10))
                .addEquation(new Equation("totalSalary" , "salary" , "bounce" , "add" )).
                calcEquation("totalSalary");
        assertEquals(totalSalary , 11);
    }

    @Test
    void RunEquationWithEquationANDFields() {
        Calculator calculator = new Calculator();
        Integer totalSalary = calculator
                .addField( new Field("salary" , 1))
                .addField(new Field("bounce" , 10))
                .addField(new Field("tax" , 2))
                .addEquation(new Equation("totalSalary" , "salary" , "bounce" , "add" ))
                .addEquation(new Equation("totalWithTax" , "totalSalary" , "tax" , "add" )).
                calcEquation("totalWithTax");
        assertEquals(totalSalary , 13);
    }

}



