package encryptdecrypt;

public class Decryptor {


    public String shiftDecipher(String stringToProcess, int shiftKey) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < stringToProcess.length(); i++) {
            result.append((char)(stringToProcess.charAt(i) - shiftKey));
        }

        return result.toString();
    }
}
