package Calculator.Field;

import java.io.IOException;
import java.util.Scanner;

public class FieldBuilder {
    private String name;
    public FieldBuilder(String name){
        this.name = name;
    }

    public Field build() throws IOException {
        System.out.println("please, Enter " + this.name);
        Scanner myInput = new Scanner( System.in );

        Integer value = myInput.nextInt();
        return new Field(this.name , value);
    }
}
