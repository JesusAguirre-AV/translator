import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    private final Scanner scanner = new Scanner(System.in);
    private final List<String> options = List.of("1) Convert a String to decimal, binary, and hexadecimal (from ascii)",
            "2) Convert decimal to String(ascii), binary, and hexadecimal",
            "3) Convert binary to String(ascii), decimal, and hexadecimal",
            "4) Convert hexadecimal to String(ascii), decimal, and binary",
            "Enter to exit");
    BinaryTranslator bt = new BinaryTranslator();
    static HexadecimalTranslator ht = new HexadecimalTranslator();
    StringTranslator st = new StringTranslator();
    DecimalTranslator dt = new DecimalTranslator();

    public static void main(String[] args) {
        new Main().menu();
    }

    private void menu(){
        boolean done = false;
        while (!done){
            try{
                int selection = getUserSelection();

                switch (selection){
                    case -1:
                        done = exitMenu();
                        break;
                    case 1:
                        fromString();
                        break;
                    case 2:
                        fromDecimal();
                        break;
                    case 3:
                        fromBinary();
                        break;
                    case 4:
                        fromHexadecimal();
                    default:
                        System.out.println("\n"+selection+" is not a valid selection, please try again.");
                }
            }catch (Exception e){
                System.out.println("\nError "+e+" try again.");
            }
        }
    }

    private boolean exitMenu() {
        System.out.println("Exiting menu.");
        return true;
    }

    private int getUserSelection() {
        printOptions();
        Integer integer = getIntChoice("Please Enter an option");
        return Objects.isNull(integer) ? -1 : integer;
    }

    private Integer getIntChoice(String prompt) {
        String input = getStringInput(prompt);

        if(Objects.isNull(input)) {
            return null;
        }

        try {
            return Integer.parseInt(input);
        }catch(NumberFormatException e) {
            throw new RuntimeException(input+" is not a valid number.");
        }
    }

    private String getStringInput(String prompt) {
        System.out.println(prompt+": ");
        String input = scanner.nextLine();

        return input.isBlank() ? null : input.trim();
    }

    private void printOptions() {
        options.forEach(line -> System.out.println("    "+line));
    }

    private void fromString(){
        String string = getStringInput(st.requestFormat());
        List<String> results = st.stringToOthers(string);
        results.forEach(result -> System.out.println("    "+result));
    }

    private void fromDecimal(){
        String decimal = getStringInput(dt.requestFormat());
        List<String> results = dt.decimalToOthers(decimal);
        results.forEach(result -> System.out.println("    "+result));
    }

    private void fromBinary(){
        String binary = getStringInput(bt.requestFormat());
        List<String> results = bt.binaryToOthers(binary);
        results.forEach(result -> System.out.println("    "+result));
    }

    private void fromHexadecimal(){
        String hexadecimal = getStringInput(ht.requestFormat());
        List<String> results = ht.hexadecimalToOthers(hexadecimal);
        results.forEach(result -> System.out.println("    "+result));
    }
}