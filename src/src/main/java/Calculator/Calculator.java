package Calculator;

import Calculator.Equation.Equation;
import Calculator.Field.Field;

import java.util.HashMap;
import java.util.Map;

public class Calculator {
    private Map<String , Field> fieldsMap ;
    private Map<String , Equation> equationsMap;

    public Calculator(){
        this.fieldsMap = new HashMap<String, Field>();
        this.equationsMap = new HashMap<String, Equation>();
    }

    public Calculator addField(Field f){
        this.fieldsMap.put(f.getName() , f);
        return this;
    }

    public Calculator addEquation(Equation eq){
        this.equationsMap.put(eq.getName() , eq);
        return this;
    }

    public void run(){
        equationsMap.keySet().forEach(equationName ->{
            Equation eq = equationsMap.get(equationName);
            Integer result =  eq.getOperator().Operate(fieldsMap.get(eq.getLeft()).getValue() , fieldsMap.get(eq.getRight()).getValue());
            System.out.println("result for " + eq.getName() + " equal : " + result );
        });
    }

    public  Integer calcEquation(String equationName){
        Equation eq = equationsMap.get(equationName);
        return eq.getOperator().Operate(fieldsMap.get(eq.getLeft()).getValue() , fieldsMap.get(eq.getRight()).getValue());
    }

}
