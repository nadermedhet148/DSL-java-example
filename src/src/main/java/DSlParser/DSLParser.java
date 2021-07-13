package DSlParser;

import Calculator.Equation.Equation;
import Calculator.Field.Field;
import Calculator.Field.FieldBuilder;
import lombok.Getter;

import java.io.IOException;
import java.util.ArrayList;

@Getter
public class DSLParser {
    private  ArrayList<String> dslRules;

    private CalculatorDataModel model;


    public DSLParser(ArrayList<String> dslRules){
        this.dslRules = dslRules;
        this.model = new CalculatorDataModel();

    }

    public CalculatorDataModel loadRules(){
        dslRules.forEach(rule->{
            String[] line = rule.split(":");
            if(line[0].contains("field"))
                parseField(line[1]);
            if(line[0].contains("equation"))
                parseEquation(line[1]);
            if(line[0].contains("display"))
                this.model.getCalculations().add(line[1]);
        });
        return model;
    }
    public void parseField(String field){
        this.model.getFields().add(new Field(field.replace(" " , "") , null));
    }

    public void parseEquation(String equation){
        String[] nameAndRule =  equation.split("=");
        String[] rules = nameAndRule[1].split(" ");
        this.model.getEquations().add(new Equation(nameAndRule[0] , rules[0] , rules[2] , rules[1]));
    }

}
