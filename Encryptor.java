package encryptdecrypt;

public class Encryptor {
    public String atbashCipher(String stringToProcess) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < stringToProcess.length(); i++) {
            //uppercase range
            if ((stringToProcess.charAt(i) >= 'A' && stringToProcess.charAt(i) <= 'Z')) {
                int letterPosition = stringToProcess.charAt(i) - 64;
                result.append((char)(91 - letterPosition));
                //lowercase range
            } else if ((stringToProcess.charAt(i) >= 'a' && stringToProcess.charAt(i) <= 'z')) {
                int letterPosition = stringToProcess.charAt(i) - 96;
                result.append((char)(123 - letterPosition));
            } else {
                result.append(stringToProcess.charAt(i));
            }
        }


        return result.toString();
    }

    public String shiftCipher(String stringToProcess, int shiftKey) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < stringToProcess.length(); i++) {

            result.append((char)(stringToProcess.charAt(i) + shiftKey));
           /* //uppercase range
            if ((stringToProcess.charAt(i) >= 'A' && stringToProcess.charAt(i) <= 'Z')) {
                if ((stringToProcess.charAt(i) + shiftKey) < 'Z') {
                    result.append((char) (stringToProcess.charAt(i) + shiftKey));
                } else {
                    result.append((char) (stringToProcess.charAt(i) + shiftKey - 26));
                }
                //lowercase range
            } else if ((stringToProcess.charAt(i) >= 'a' && stringToProcess.charAt(i) <= 'z')) {
                if (stringToProcess.charAt(i) + shiftKey < 'z') {
                    result.append((char) (stringToProcess.charAt(i) + shiftKey));
                }
                else {
                    result.append((char) (stringToProcess.charAt(i) + shiftKey - 26) );
                }
            } else {
                result.append(stringToProcess.charAt(i));
            }*/
        }

        return result.toString();
    }


}
