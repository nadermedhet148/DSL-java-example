package Calculator.Field;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Field {

    private String name;

    private Integer value;

    public  void  setValue(Integer v){
        this.value = v;
    }

}
