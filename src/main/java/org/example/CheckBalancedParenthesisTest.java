package org.example;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
public class CheckBalancedParenthesisTest {

    @Test
    void testCheckBalancedParenthesis() {
        Assertions.assertTrue(CheckBalancedParenthesis.checkBalancedParenthesis("()"));
        Assertions.assertFalse(CheckBalancedParenthesis.checkBalancedParenthesis("(()"));
        Assertions.assertTrue(CheckBalancedParenthesis.checkBalancedParenthesis("({})"));
        Assertions.assertFalse(CheckBalancedParenthesis.checkBalancedParenthesis("({)}"));
        Assertions.assertFalse(CheckBalancedParenthesis.checkBalancedParenthesis(")("));
        Assertions.assertTrue(CheckBalancedParenthesis.checkBalancedParenthesis("[{[]}()]"));
        Assertions.assertTrue(CheckBalancedParenthesis.checkBalancedParenthesis("{}()"));
    }

}
