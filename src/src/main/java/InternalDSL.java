import Calculator.Calculator;
import Calculator.Equation.Equation;
import Calculator.Equation.Operator.Adder;
import Calculator.Field.FieldBuilder;


class InternalDSL {

    public static void main(String[] args) throws Exception
    {
        Calculator calculator = new Calculator();
        calculator
                .addField(new FieldBuilder("salary").build())
                .addField(new FieldBuilder("bounce").build())
                .addEquation(new Equation("totalSalary" , "salary" , "bounce" , "add" )).
                run();
    }
}