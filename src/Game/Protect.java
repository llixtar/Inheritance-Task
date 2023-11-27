package Game;

import java.util.Set;

public class Protect extends InputData {
    public boolean checkNumber(String inputText){
        try {
            resParseDouble = Double.parseDouble(inputText);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
