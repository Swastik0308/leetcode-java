// Capitalizes words >2 letters (first letter uppercase, rest lowercase), else makes word lowercase.
// TC: O(n)  |  SC: O(n), where n = length of the input string.
//Leetcode Link: https://leetcode.com/problems/capitalize-the-title/
public class CapitalizeTheTitle {
    public static String capitalize(String title) {
        String words[] = title.split(" ");
        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < words.length; i++) {
            if (words[i].length() > 2) {
                // first letter uppercase
                sb.append(Character.toUpperCase(words[i].charAt(0)));
                // rest lowercase
                sb.append(words[i].substring(1).toLowerCase());
            } else {
                // whole word lowercase
                sb.append(words[i].toLowerCase());
            }

            // add space between words except for the last one
            if (i < words.length - 1) {
                sb.append(" ");
            }
        }

        return sb.toString();

    }

    public static void main(String[] args) {
        // String title = "capiTalIze tHe titLe";
        System.out.println(capitalize("First leTTeR OF EACH Word"));
    }
}
