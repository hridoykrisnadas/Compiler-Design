import java.util.*;
import java.util.regex.*;

public class Lexical {
    // Define patterns for different tokens
    private static final String KEYWORD_PATTERN = "\\b(if|else|byte|int|long|float|double|char|boolean|for|while|return|switch|case|final|do|goto|new|private|public|protected)\\b";
    private static final String IDENTIFIER_PATTERN = "\\b[a-zA-Z_][a-zA-Z0-9_]*\\b";
    private static final String CONSTANT_PATTERN = "-?\\b\\d+\\.?\\d*\\b";
    private static final String ARITHMETIC_OPERATOR_PATTERN = "[+\\-*/%]";
    private static final String ASSIGNMENT_OPERATOR_PATTERN = "=";
    private static final String LOGICAL_OPERATOR_PATTERN = "(==|!=|<=|>=|<|>|&&|\\|\\|)";
    private static final String PUNCTUATION_PATTERN = "[;:,]";
    private static final String PARENTHESIS_PATTERN = "[(){}\\[\\]]";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the input string:");
//        Sample Input: int ab = (bc1 - float 10.6) / {cd * (-12)};
        String input = scanner.nextLine();
        scanner.close();

        Map<String, List<String>> tokens = new HashMap<>();
        tokens.put("Keyword", new ArrayList<>());
        tokens.put("Identifier", new ArrayList<>());
        tokens.put("Constant", new ArrayList<>());
        tokens.put("Arithmetic Operator", new ArrayList<>());
        tokens.put("Logical Operator", new ArrayList<>());
        tokens.put("Assignment Operator", new ArrayList<>());
        tokens.put("Punctuation", new ArrayList<>());
        tokens.put("Parenthesis", new ArrayList<>());

        // Define pattern with all the token patterns combined
        Pattern pattern = Pattern.compile(
                KEYWORD_PATTERN + "|" + IDENTIFIER_PATTERN + "|" + CONSTANT_PATTERN + "|" +
                        ARITHMETIC_OPERATOR_PATTERN + "|" + LOGICAL_OPERATOR_PATTERN + "|" +ASSIGNMENT_OPERATOR_PATTERN + "|" +
                        PUNCTUATION_PATTERN + "|" + PARENTHESIS_PATTERN
        );

        Matcher matcher = pattern.matcher(input);
        while (matcher.find()) {
            String token = matcher.group();
            if (token.matches(KEYWORD_PATTERN)) {
                tokens.get("Keyword").add(token);
            } else if (token.matches(IDENTIFIER_PATTERN)) {
                tokens.get("Identifier").add(token);
            } else if (token.matches(CONSTANT_PATTERN)) {
                tokens.get("Constant").add(token);
            } else if (token.matches(ARITHMETIC_OPERATOR_PATTERN)) {
                tokens.get("Arithmetic Operator").add(token);
            } else if (token.matches(LOGICAL_OPERATOR_PATTERN)) {
                tokens.get("Logical Operator").add(token);
            } else if (token.matches(ASSIGNMENT_OPERATOR_PATTERN)) {
                tokens.get("Assignment Operator").add(token);
            } else if (token.matches(PUNCTUATION_PATTERN)) {
                tokens.get("Punctuation").add(token);
            } else if (token.matches(PARENTHESIS_PATTERN)) {
                tokens.get("Parenthesis").add(token);
            }
        }

        // Print results
        for (Map.Entry<String, List<String>> entry : tokens.entrySet()) {
            List<String> tokenList = entry.getValue();
            if (!tokenList.isEmpty()) {
                System.out.println(entry.getKey() + " (" + tokenList.size() + "): " + String.join(", ", tokenList));
            }
        }
    }
}
