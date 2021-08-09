package encryptdecrypt;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        start(args);

    }

    public static void start(String[] args) {
        ArgsAnalyzer argsAnalyzer = new ArgsAnalyzer();
        String mode = argsAnalyzer.mode(args);
        String algorithm = argsAnalyzer.algorithm(args);
        String stringToProcess = "";
        int key = 0;
        String result = "";
        String writePath = "";
        boolean hasInArgument = false;
        boolean hasDataArgument = false;

        for (String argument: args){
            if (argument.equals("-in")) {
                hasInArgument = true;
            }
            if (argument.equals("-data")) {
                hasDataArgument = true;
            }
        }

        for (int i = 0; i < args.length; i++) {
            if (args[i].equals("-mode")) {
                mode = args[i + 1];
            }
            if (args[i].equals("-key")) {
                key = Integer.parseInt(args[i + 1]);
            }

            if (args[i].equals("-in")) {
                if (hasDataArgument && hasInArgument) {
                    //do nothing
                } else {
                    File file = new File(args[i + 1]);
                    StringBuilder sb = new StringBuilder();
                    try (Scanner scanner = new Scanner(file)) {
                        while (scanner.hasNext()) {
                            sb.append(scanner.nextLine());
                        }
                    } catch (FileNotFoundException e) {
                        System.out.println("Error! File not found!");
                    }
                    stringToProcess = sb.toString();
                }

            }

            if (args[i].equals("-data")) {
                stringToProcess = args[i + 1];
            }

            if (args[i].equals("-out")) {
                writePath = args[i + 1];
            }

            if (args[i].equals("-alg")) {
                algorithm = args[i + 1];
            }

        }

        switch (mode) {
            case "enc":
                Encryptor encryptor = new Encryptor();
                result = encryptor.shiftCipher(stringToProcess, key);
                break;

            case "dec":
                Decryptor decryptor = new Decryptor();
                result = decryptor.shiftDecipher(stringToProcess, key);
                break;
        }

        if (!writePath.isEmpty()) {
            File file = new File(writePath);
            try (FileWriter fileWriter = new FileWriter(file)) {
                fileWriter.write(result);
            } catch (Exception ignored) {

            }
        } else {
            System.out.println(result);
        }


    }
}
