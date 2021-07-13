package DSlParser;

import Calculator.Equation.Equation;
import Calculator.Field.Field;
import lombok.Getter;

import java.util.ArrayList;

@Getter
public class CalculatorDataModel {
    private ArrayList<Equation> equations = new ArrayList<>();
    private ArrayList<Field> fields = new ArrayList<>();
    private ArrayList<String> calculations = new ArrayList<>();
}
