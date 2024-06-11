import java.util.ArrayList;
import java.util.List;

public class HexadecimalTranslator extends TranslatorParent{
    String format = "To ensure that this is translated properly, include no spaces and separate each value using commas" +
            "\n"+
            "Ex: (1) (95) (400) -> 1,5F,190 ...  Additionally, recall the related values (10,A), (11,B), (12,C),...," +
            "(14,E), (15,F)";
    String hexadecimal;
    ArrayList<Integer> decimalSave = new ArrayList<>();
    StringBuilder stringBuilder = new StringBuilder();

    public String requestFormat() {
        return format;
    }

    private String stringConvert() {
        return super.stringConvert(decimalSave);
    }

    private String decimalConvert() {
        stringBuilder.setLength(0);
        List<String> hexadecimalList = List.of(hexadecimal.split(","));
        hexadecimalList.forEach(hex -> stringBuilder.append(hexCharToDec(hex)).append(","));
        if(stringBuilder.charAt(stringBuilder.length() - 1)==',') {
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
        return stringBuilder.toString();
    }

    private String binaryConvert() {
        return super.binaryConvert(decimalSave);
    }


    public List<String> hexadecimalToOthers(String hexadecimal) {
        List<String> results = new ArrayList<>();
        this.hexadecimal=hexadecimal;
        while (decimalSave.size()>0){
            decimalSave.remove(0);
        }
        results.add("For hexadecimal to decimal: "+decimalConvert());
        results.add("For hexadecimal to String(ascii): "+stringConvert());
        results.add("For hexadecimal to Binary: "+binaryConvert());
        return results;
    }
    private String hexCharToDec(String hex){
        try {
            Integer hexDec = Integer.parseInt(hex, 16);
            decimalSave.add(hexDec);
            return String.valueOf(hexDec);
        }catch (Exception e){
            throw new ArithmeticException();
        }
    }
}
