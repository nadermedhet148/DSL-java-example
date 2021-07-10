package Calculator;

import Calculator.Equation.Equation;
import Calculator.Equation.Operators.IOperator;
import Calculator.Equation.Operators.OperatorFactory;
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

            Integer result =  this.calcEquation(equationName);
            System.out.println("result for " + equationName + " equal : " + result );
        });
    }

    public  Integer calcEquation(String equationName)  {
        Equation eq = equationsMap.get(equationName);
        IOperator operator = OperatorFactory.getOperator(eq.getOperator());
        return operator.Operate(getValueForEquation(eq.getLeft()), getValueForEquation(eq.getRight()));
    }

    private Integer getValueForEquation(String name)  {
        if(fieldsMap.get(name) != null)
            return fieldsMap.get(name).getValue();
        if(equationsMap.get(name) != null)
            return calcEquation(name);

        return 0;
    }

}
