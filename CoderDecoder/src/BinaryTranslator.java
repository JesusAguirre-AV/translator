import java.util.ArrayList;
import java.util.List;

public class BinaryTranslator extends TranslatorParent{
    String format = "Please include no spaces and make sure to include a comma between each value.\n"+
            "Ex: (11111111) (1) -> 11111111,1";
    String binary;
    ArrayList<Integer> decimalSave = new ArrayList<>();
    StringBuilder stringBuilder = new StringBuilder();

    public String requestFormat() {
        return format;
    }

    public String stringConvert() {
        return super.stringConvert(decimalSave);
    }

    public String decimalConvert() {
        stringBuilder.setLength(0);
        List<String> hexadecimalList = List.of(binary.split(","));
        hexadecimalList.forEach(hex -> stringBuilder.append(binaryToDecimal(hex)).append(","));
        if(stringBuilder.charAt(stringBuilder.length() - 1)==',') {
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
        return stringBuilder.toString();
    }

    public String hexadecimalConvert() {
        return super.hexadecimalConvert(decimalSave);
    }


    public List<String> binaryToOthers(String binary) {
        List<String> results = new ArrayList<>();
        this.binary=binary;
        while (decimalSave.size()>0){
            decimalSave.remove(0);
        }
        results.add("For binary to decimal: "+decimalConvert());
        results.add("For binary to hexadecimal: "+hexadecimalConvert());
        results.add("For binary to String: "+stringConvert());
        return results;
    }
    private String binaryToDecimal(String digits){
        try {
            Integer decimal = 0;
            double pos;
            for (int i = 0; i < digits.length(); i++) {
                if (digits.charAt(i) == '1') {
                    //Math.pow(base, exponent);
                    pos = (digits.length() - 1) - i;
                    decimal += (int) Math.pow(2, pos);
                } else if (digits.charAt(i) != '0') {
                    throw new ArithmeticException();
                }
            }
            decimalSave.add(decimal);
            return String.valueOf(decimal);
        }catch (Exception e){
            throw new ArithmeticException();
        }
    }
}
