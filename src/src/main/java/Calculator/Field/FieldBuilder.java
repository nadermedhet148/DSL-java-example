package Calculator.Field;

import java.io.IOException;
import java.util.Scanner;

public class FieldBuilder {
    private String name;
    private Field field;
    public FieldBuilder(String name){
        this.name = name;
    }

    public FieldBuilder(Field feild){
        this.field = feild;
    }

    public Field build() throws IOException {
        System.out.println("please, Enter " + this.name);
        Scanner myInput = new Scanner( System.in );

        Float value = myInput.nextFloat();
        return new Field(this.name , value);
    }

    public Field loadValue() throws IOException {
        System.out.println("please, Enter " + this.field.getName());
        Scanner myInput = new Scanner( System.in );

        this.field.setValue(myInput.nextFloat());

        return this.field;
    }
}
