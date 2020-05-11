import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringCalculatorShould {

    StringCalculator stringCalculator = new StringCalculator();

    @Test
    public void return_0_when_input_is_empty() {
        assertThat(stringCalculator.add("")).isEqualTo("0");
    }

    @Test
    public void return_input_when_input_is_only_one_number() {
        assertThat(stringCalculator.add("1")).isEqualTo("1");
        assertThat(stringCalculator.add("3.1416")).isEqualTo("3.1416");
    }

    @Test
    public void return_added_input_numbers_separated_by_commas() {
        assertThat(stringCalculator.add("1,2")).isEqualTo("3");
        assertThat(stringCalculator.add("1,2,3,4")).isEqualTo("10");
        assertThat(stringCalculator.add("1.2,2.1")).isEqualTo("3.3");
        assertThat(stringCalculator.add("11,22")).isEqualTo("33");
    }

    @Test
    public void return_added_input_numbers_separated_by_commas_or_new_line() {
        assertThat(stringCalculator.add("1\n2")).isEqualTo("3");
        assertThat(stringCalculator.add("1,2\n3\n4")).isEqualTo("10");
        assertThat(stringCalculator.add("1.2\n2.1")).isEqualTo("3.3");
        assertThat(stringCalculator.add("1\n1,22")).isEqualTo("24");
        assertThat(stringCalculator.add("175.2,\n35")).isEqualTo("Number expected but '\\n' found at position 6.");
    }



}
