import DSlParser.CalculatorDataModel;
import DSlParser.DSLController;
import DSlParser.DSLParser;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ExternalDSL {
    public static void main(String[] args) throws Exception {
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
        DSLController controller = new DSLController(model);
        controller.run();


    }
}
