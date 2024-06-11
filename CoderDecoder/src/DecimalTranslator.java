import java.util.ArrayList;
import java.util.List;

public class DecimalTranslator extends TranslatorParent{
    String format = "Please make sure that each value is formatted with no spaces in between and includes commas between values values.\n"+
            "Ex: (1) (5) (30) (120) -> 1,005,030,120";
    String decimal;
    ArrayList<Integer> decimalSave = new ArrayList<>();
    StringBuilder stringBuilder = new StringBuilder();

    public String requestFormat() {
        return format;
    }

    private String stringConvert() {
        return super.stringConvert(decimalSave);
    }

    private void decimalConvert() {
        stringBuilder.setLength(0);
        List<String> decimalList = List.of(decimal.split(","));
        decimalList.forEach(dec -> stringBuilder.append(decLister(dec)));
    }

    private String binaryConvert() {
        return super.binaryConvert(decimalSave);
    }

    private String hexadecimalConvert() {
        return super.hexadecimalConvert(decimalSave);
    }

    public List<String> decimalToOthers(String decimal) {
        List<String> results = new ArrayList<>();
        this.decimal=decimal;
        while (decimalSave.size()>0){
            decimalSave.remove(0);
        }
        decimalConvert();
        results.add("For decimal to hexadecimal: "+hexadecimalConvert());
        results.add("For decimal to String: "+stringConvert());
        results.add("For decimal to Binary: "+binaryConvert());
        return results;
    }
    private String decLister(String decStr){
        try {
            Integer decVal = Integer.parseInt(decStr);
            decimalSave.add(decVal);
            return String.valueOf(decVal);
        }catch (Exception e){
            throw new ArithmeticException();
        }
    }
}
