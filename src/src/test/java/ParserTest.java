import static org.junit.jupiter.api.Assertions.assertEquals;

import DSlParser.CalculatorDataModel;
import DSlParser.DSLParser;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class ParserTest {

    @Test
    void parseText() {
        ArrayList<String> dslRules = new ArrayList<String>(Arrays.asList(new String[]{
                "field:salary",
                "field:bounce",
                "field:overTimeHours",
                "field:overTimeHourRate",
                "field:tax",
                "equation:totalWithBounce=salary add bounce",
                "equation:overTimeTotal=overTimeHours multiply overTimeHourRate",
                "equation:growthSalary=totalWithBounce add overTimeTotal",
                "equation:netSalary=growthSalary sub tax",
                "display:netSalary"
        }));
        DSLParser parser = new DSLParser(dslRules);
        CalculatorDataModel model = parser.loadRules();
        assertEquals(model.getFields().size() , 5);
        assertEquals(model.getFields().get(0).getName(), "salary");
        assertEquals(model.getEquations().get(0).getName(), "totalWithBounce");
        assertEquals(model.getEquations().size(), 4);
    }

    @Test
    void parseTextAndIgnoreSpace() {
        ArrayList<String> dslRules = new ArrayList<String>(Arrays.asList(new String[]{
                "field : salary",
                "field : bounce",
                "field : overTimeHours",
                "field : overTimeHourRate",
                "field : tax",
                "equation : totalWithBounce  =  salary add bounce",
                "equation : overTimeTotal  =   overTimeHours multiply overTimeHourRate",
                "equation : growthSalary=   totalWithBounce add overTimeTotal",
                "equation : netSalary=   growthSalary sub tax",
                "display : netSalary"
        }));
        DSLParser parser = new DSLParser(dslRules);
        CalculatorDataModel model = parser.loadRules();
        assertEquals(model.getFields().size() , 5);
        assertEquals(model.getFields().get(0).getName(), "salary");
        assertEquals(model.getEquations().get(0).getName(), "totalWithBounce");
        assertEquals(model.getEquations().size(), 4);
    }


}
