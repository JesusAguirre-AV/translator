import java.util.ArrayList;

public class TranslatorParent {

    StringBuilder stringBuilder = new StringBuilder();

    protected String hexadecimalConvert(ArrayList<Integer> decimalSave) {
        //String i = Integer.toHexString(0);
        stringBuilder.setLength(0);
        decimalSave.forEach(dec ->
                stringBuilder.append(Integer.toHexString(dec)+",")
        );
        if(stringBuilder.charAt(stringBuilder.length() - 1)==',') {
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
        return stringBuilder.toString();
    }
    protected String stringConvert(ArrayList<Integer> decimalSave) {
        //String is the only one that requires a span of values, if a value is not in this parameter then make null and
        //continue translating the rest of the number based values
        // Use int a; -> char c = (char)a;
        char temp;
        stringBuilder.setLength(0);
        for(int i=0; i<decimalSave.size(); i++){
            temp = (char)(int)decimalSave.get(i);
            stringBuilder.append(temp);
        }
        return stringBuilder.toString();
    }
    protected String binaryConvert(ArrayList<Integer> decimalSave) {
        stringBuilder.setLength(0);
        StringBuilder binary = new StringBuilder();
        for(int i=0; i<decimalSave.size(); i++){
            int temp = decimalSave.get(i);
            //This is how any base conversion should work so long as the base is smaller.
            while (temp>0){
                binary.insert(0,temp%2);
                temp/=2;
            }
            stringBuilder.append(binary.toString()).append(',');
            binary.setLength(0);
        }
        if(stringBuilder.charAt(stringBuilder.length() - 1)==',') {
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
        return stringBuilder.toString();
    }
}
