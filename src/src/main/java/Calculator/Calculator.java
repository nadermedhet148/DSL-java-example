package Calculator;

import Calculator.Equation.Equation;
import Calculator.Equation.Operator.IOperator;
import Calculator.Equation.Operator.OperatorFactory;
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
            IOperator operator = OperatorFactory.getOperator(eq.getOperator());
            Integer result =  operator.Operate(fieldsMap.get(eq.getLeft()).getValue() , fieldsMap.get(eq.getRight()).getValue());
            System.out.println("result for " + eq.getName() + " equal : " + result );
        });
    }

    public  Integer calcEquation(String equationName){
        Equation eq = equationsMap.get(equationName);
        IOperator operator = OperatorFactory.getOperator(eq.getOperator());
        return operator.Operate(fieldsMap.get(eq.getLeft()).getValue() , fieldsMap.get(eq.getRight()).getValue());
    }

}
