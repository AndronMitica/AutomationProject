package ObjectData;

import java.util.ArrayList;
import java.util.List;

public class GeneralObject {

    public List<String> getPreparedValue(String value) {
        List<String> result = new ArrayList<>();
        String[] valueSplit = value.split(",");
        for(Integer index = 0; index < valueSplit.length;index++) {
            result.add(valueSplit[index]);
        }
        return result;
    }
}
