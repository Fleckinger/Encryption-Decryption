package encryptdecrypt;

public class Encryptor {
    public String encrypt(String textToEncrypt, int shiftKey, String encryptAlgorithm) {
        switch (encryptAlgorithm) {
            case "unicode":
                return unicodeShiftCipher(textToEncrypt, shiftKey);
            case "shift":
                return alphabeticalShiftCipher(textToEncrypt, shiftKey);
        }
        return "";
    }

    public String alphabeticalShiftCipher(String textToEncrypt, int shiftKey) {
        StringBuilder result = new StringBuilder();

        for (char character : textToEncrypt.toCharArray()) {
            //uppercase range
            if (character >= 'A' && character <= 'Z') {
                int originalAlphabetPosition = character - 'A';
                int newAlphabetPosition = (originalAlphabetPosition + shiftKey) % 26;
                char newCharacter = (char) ('A' + newAlphabetPosition);
                result.append(newCharacter);
                //lowercase range
            } else if (character >= 'a' && character <= 'z') {
                int originalAlphabetPosition = character - 'a';
                int newAlphabetPosition = (originalAlphabetPosition + shiftKey) % 26;
                char newCharacter = (char) ('a' + newAlphabetPosition);
                result.append(newCharacter);
            } else {
                result.append(character);
            }
        }

        return result.toString();
    }

    public String unicodeShiftCipher(String stringToProcess, int shiftKey) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < stringToProcess.length(); i++) {
            result.append((char) (stringToProcess.charAt(i) + shiftKey));
        }

        return result.toString();
    }


}
