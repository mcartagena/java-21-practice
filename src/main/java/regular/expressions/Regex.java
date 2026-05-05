package regular.expressions;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Regex {
    public static void main(String[] args) {
        // create the regular expression
        final String REGEX_PATTERN = "fooa*bar";
        final String INPUT_FILE_NAME = "regex01.txt";

        // Create the Pattern
        Pattern regex = Pattern.compile(REGEX_PATTERN);

        // Open the file
        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(Regex.class.getClassLoader().getResourceAsStream(INPUT_FILE_NAME))
        )) {
            // read each line
            String line;

            while ((line = br.readLine()) != null) {
                // create the match
                Matcher match = regex.matcher(line);
                if (match.find()) {
                    // if there is a match print the line
                    System.out.println(line);
                }
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }


    }
}
