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
                .addEquation(new Equation("totalWithTax" , "totalSalary" , "tax" , "sub" )).
                calcEquation("totalWithTax");
        assertEquals(totalSalary , 9);
    }

    @Test
    void RunEquationWithEquations() {
        Calculator calculator = new Calculator();
        Integer totalSalary = calculator
                .addField( new Field("salary" , 1))
                .addField(new Field("bounce" , 10))
                .addField(new Field("overTime" , 12))
                .addField(new Field("overTimeHourRate" , 1))
                .addField(new Field("tax" , 2))
                .addEquation(new Equation("totalSalary" , "salary" , "bounce" , "add" ))
                .addEquation(new Equation("OverTimeMoney" , "overTime" , "overTimeHourRate" , "multiply" ))
                .addEquation(new Equation("totalWithTax" , "totalSalary" , "tax" , "sub" ))
                .addEquation(new Equation("total" , "totalWithTax" , "OverTimeMoney" , "add" )).
                calcEquation("total");
        assertEquals(totalSalary , 21);
    }

}



