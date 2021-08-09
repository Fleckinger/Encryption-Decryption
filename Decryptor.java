package encryptdecrypt;

public class Decryptor {
    public String decrypt(String textToDecrypt, int shiftKey, String decryptAlgorithm) {
        switch (decryptAlgorithm) {
            case "unicode":
                return unicodeShiftDecipher(textToDecrypt, shiftKey);
            case "shift":
                return alphabeticalShiftDecipher(textToDecrypt, shiftKey);
        }
        return "";
    }

    public String unicodeShiftDecipher(String textToDecrypt, int shiftKey) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < textToDecrypt.length(); i++) {
            result.append((char)(textToDecrypt.charAt(i) - shiftKey));
        }

        return result.toString();
    }
    //TODO реализовать алфавитный

    public String alphabeticalShiftDecipher(String textToDecrypt, int shiftKey) {
        Encryptor encryptor = new Encryptor();

        return encryptor.alphabeticalShiftCipher(textToDecrypt, 26- (shiftKey % 26));
    }
}
