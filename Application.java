package Module10;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Application {

    private static final String UTF8 = "UTF-8";

    public static void main(String[] args) {

        String fileName = "someFile.txt";
        String message = "Welcome to  Quake lll Arena";

        // Check file for presence
        File file = new File(fileName);
        if (!file.exists()) {
            System.out.println("File not found");
            return;
        }

        // Write message to file
        try (FileOutputStream fos = new FileOutputStream(file);
                OutputStreamWriter osw = new OutputStreamWriter(fos, UTF8);
                BufferedWriter out = new BufferedWriter(osw)) {

            String encodedMessage = Encoder.encodeMechanism(message, 7);
            out.write(encodedMessage);

            System.out.println("Encoded Message has been written to file");
            System.out.println("Encoded message: " + encodedMessage);

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            return;
        } catch (IOException e) {
            System.out.println("Something went wrong when write message to file");
            return;
        }

            // Read message from file
        try (FileInputStream fis = new FileInputStream(file);
                InputStreamReader isr = new InputStreamReader(fis, UTF8);
                BufferedReader in = new BufferedReader(isr)) {

           StringBuilder builder = new StringBuilder();

            int c;
            while ((c = in.read()) != -1) {
                builder.append((char) c);
            }

            String decodeMessage = builder.toString();
            System.out.println("Decoded message has been read from file");

            String decodedMessage = Decoder.decodeMechanism(decodeMessage, 7);
            System.out.println("Decoded  message: " + decodedMessage);

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            return;
        } catch (IOException e) {
            System.out.println("Something went wrong when read message from file");
            return;
        }

    }

}
