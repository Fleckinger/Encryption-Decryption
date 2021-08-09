package encryptdecrypt;

public class ArgsAnalyzer {
    public String mode(String[] args) {

        for (int i = 0; i < args.length; i++) {
            if (args[i].equals("-mode")) {
                return args[i + 1];
            }
        }
        return "enc";
    }

    public String algorithm(String[] args) {

        return "shift";
    }

}
