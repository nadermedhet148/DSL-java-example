import Calculator.Equation.Equation;
import Calculator.Field.Field;
import Calculator.Field.FieldBuilder;
import lombok.Getter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

@Getter
public class DSLParser {
    private  ArrayList<String> dslRules;

    private ArrayList<Equation> equations;
    private ArrayList<Field> fields ;
    private ArrayList<String> calculations ;


    public DSLParser(ArrayList<String> dslRules){
        this.dslRules = dslRules;
        equations = new ArrayList<>();
        fields = new ArrayList<>();
        calculations = new ArrayList<>();
    }

    public void loadRules(){
        dslRules.forEach(rule->{
            String[] line = rule.split(":");
            if(line[0].contains("field"))
                parseField(line[1]);
            if(line[0].contains("equation"))
                parseEquation(line[1]);
            if(line[0].contains("display"))
                this.calculations.add(line[1]);


        });
    }
    public void parseField(String field){
        try {
            this.fields.add(new FieldBuilder(field.replace(" " , "")).build());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void parseEquation(String equation){
        String[] nameAndRule =  equation.split("=");
        String[] rules = nameAndRule[1].split(" ");
        this.equations.add(new Equation(nameAndRule[0] , rules[0] , rules[2] , rules[1]));
    }

}
