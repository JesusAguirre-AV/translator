import java.util.ArrayList;
import java.util.List;

public class StringTranslator extends TranslatorParent{
    String format = "No special notation for this required, just keep in mind that the numbers will be converted to ascii.\n"+
            "Ex: Any sentence, even one like this 12!%.";
    String string;
    ArrayList<Integer> decimalSave = new ArrayList<>();
    StringBuilder stringBuilder = new StringBuilder();
    public String requestFormat() {
        return format;
    }

    public String decimalConvert() {
        stringBuilder.setLength(0);

        List<String> stringList = new ArrayList<>();
        for(char ch : string.toCharArray()){
            stringList.add(""+ch);
        }
        stringList.forEach(ch -> stringBuilder.append(stringCharToDec(ch)).append(","));
        if(stringBuilder.charAt(stringBuilder.length() - 1)==',') {
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
        return stringBuilder.toString();
    }

    public String binaryConvert() {
        return super.binaryConvert(decimalSave);
    }

    public String hexadecimalConvert() {
        return super.hexadecimalConvert(decimalSave);
    }


    public List<String> stringToOthers(String string) {
        List<String> results = new ArrayList<>();
        this.string=string;
        while (decimalSave.size()>0){
            decimalSave.remove(0);
        }
        results.add("For String to decimal: "+decimalConvert());
        results.add("For String to hexadecimal: "+hexadecimalConvert());
        results.add("For String to Binary: "+binaryConvert());
        return results;
    }
    private String stringCharToDec(String character){
        try {
            Integer strDec = (int) character.charAt(0);
            decimalSave.add(strDec);
            return String.valueOf(strDec);
        }catch (Exception e){
            throw new ArithmeticException();
        }
    }
}
