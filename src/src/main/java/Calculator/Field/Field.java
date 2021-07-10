package Calculator.Field;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Field {

    private String name;

    private Float value;

    public  void  setValue(Float v){
        this.value = v;
    }

}
