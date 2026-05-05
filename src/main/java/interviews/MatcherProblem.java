package interviews;

// Calculate sum of all the numerical values mentioned in the String after $ symbol
// String s = "#1 $001 Tickets $50,000Received $40. Expenses $800 . $x units Cheque$2,00,000";
// Output - 250841

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatcherProblem {
    public static void main(String[] args) {
        String s = "#1 $001 Tickets $50,000Received $40. Expenses $800 . $x units Cheque$2,00,000";
        // Match a '$' followed by digits, commas, or dots
        // [0-9,.]+ matches one or more digits, commas, or periods
        Pattern pattern = Pattern.compile("\\$([0-9,.]+)");
        Matcher matcher = pattern.matcher(s);

        double totalSum = 0;

        while (matcher.find()) {
            // Group 1 is the part after the '$'
            String match = matcher.group(1);

            // Remove commas for parsing
            String cleanedValue = match.replace(",", "");

            try {
                // Parse as double to account for potential decimals
                totalSum += Double.parseDouble(cleanedValue);
            } catch (NumberFormatException e) {
                // This handles cases like "$x" where the match isn't a valid number
                System.out.println("Skipping non-numeric value: " + match);
            }
        }

        // Casting to int to match your specific output requirement
        System.out.println("Output - " + (int) totalSum);

        /*
        my code
        String s = "#1 $001 Tickets $50,000Received $40. Expenses $800 . $x units Cheque$2,00,000";

		System.out.println(s);

        List<Integer> numbers = new ArrayList<>();

        String number = "";

        for(char c: s.toCharArray()()){
            if(c<='9' && c>='0'){
                number = number.concat(c);
            } else {
                if(!number.isEmpty()){
                    numbers.add(Integer.valueOf(num));
                }
            }
        }

        int total = 0;

        for(Integer num: numbers){
            total = total + num;
        }

        System.out.println("Total= " + total);

         */
    }
}
