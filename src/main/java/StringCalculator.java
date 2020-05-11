public class StringCalculator {

    public String add(String inputNumbers) {
        if (inputNumbers.isEmpty()) {
            return "0";
        }
        if (inputDoesNotContainSeparators(inputNumbers)) {
            return inputNumbers;
        }

        Double result = 0.0;
        try {
            result = addNumbers(inputNumbers);
        } catch (RuntimeException re) {
            return re.getMessage();
        }
        return formatOutputString(result);
    }

    private boolean inputDoesNotContainSeparators(String input) {
        return !input.contains(",") && !input.contains("\n");
    }

    private Double addNumbers(String inputNumbers) {
        Double result = 0.0;
        int errorIndex = 1;
        String[] splittedNumbers = inputNumbers.split("[,\n]");
        for (String splittedNumber : splittedNumbers) {
            if (splittedNumber.isEmpty()) {
                String errorMessage = "Number expected but '" +
                        formatUnexpectedCharacter(inputNumbers.charAt(errorIndex)) +
                        "' found at position " + errorIndex + ".";
                throw new RuntimeException(errorMessage);
            }
            result += Double.parseDouble(splittedNumber);
            errorIndex += splittedNumber.length();
        }
        return result;
    }

    private String formatUnexpectedCharacter(char character) {
        if (character == '\n') {
            return "\\n";
        }
        return String.valueOf(character);
    }

    private String formatOutputString(Double result) {
        if (result == Math.floor(result)) {
            return String.valueOf(result.intValue());
        }
        return result.toString();
    }

}
