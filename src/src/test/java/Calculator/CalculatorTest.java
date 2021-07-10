package Calculator;
import static org.junit.jupiter.api.Assertions.assertEquals;


import Calculator.Equation.Equation;
import Calculator.Field.Field;
import org.junit.jupiter.api.Test;

public class CalculatorTest {

    @Test
    void RunEquationWithFields() {
        Calculator calculator = new Calculator();
        Float totalSalary = calculator
                .addField( new Field("salary" , 1f))
                .addField(new Field("bounce" , 10f))
                .addEquation(new Equation("totalSalary" , "salary" , "bounce" , "add" )).
                calcEquation("totalSalary");
        assertEquals(totalSalary , 11f);
    }

    @Test
    void RunEquationWithEquationANDFields() {
        Calculator calculator = new Calculator();
        Float totalSalary = calculator
                .addField( new Field("salary" , 1f))
                .addField(new Field("bounce" , 10f))
                .addField(new Field("tax" , 2f))
                .addEquation(new Equation("totalSalary" , "salary" , "bounce" , "add" ))
                .addEquation(new Equation("totalWithTax" , "totalSalary" , "tax" , "sub" )).
                calcEquation("totalWithTax");
        assertEquals(totalSalary , 9f);
    }

    @Test
    void RunEquationWithEquations() {
        Calculator calculator = new Calculator();
        Float totalSalary = calculator
                .addField( new Field("salary" , 1f))
                .addField(new Field("bounce" , 10f))
                .addField(new Field("overTime" , 12f))
                .addField(new Field("overTimeHourRate" , 0.7f))
                .addField(new Field("tax" , 2f))
                .addEquation(new Equation("totalSalary" , "salary" , "bounce" , "add" ))
                .addEquation(new Equation("OverTimeMoney" , "overTime" , "overTimeHourRate" , "multiply" ))
                .addEquation(new Equation("totalWithTax" , "totalSalary" , "tax" , "sub" ))
                .addEquation(new Equation("total" , "totalWithTax" , "OverTimeMoney" , "add" )).
                calcEquation("total");
        assertEquals(totalSalary , 17.4f);
    }

}



