package thirteen;

import org.junit.Test;

import static org.junit.Assert.*;

public class PasswordUtilsTest {

    @Test
    public void testValidatePasswordIsNull() {
        String password = null;
        boolean actual = PasswordUtils.validatePassword(password);assertFalse(actual);
    }

    @Test
    public void testValidatePasswordHasMissingOneNumber() {
        String password = "Abcdefg#";
        boolean actual = PasswordUtils.validatePassword(password);
        assertFalse(actual);
    }

    @Test
    public void testValidatePasswordHasMissingOneLowerCaseLetter() {
        String password = "ABCDEFG5#";
        boolean actual = PasswordUtils.validatePassword(password);
        assertFalse(actual);
    }

    @Test
    public void testValidatePasswordAllRulesMet() {
        String password = "Abcfg#";
        boolean actual = PasswordUtils.validatePassword(password);
        assertTrue(actual);
    }

    @Test
    public void testValidatePasswordLengthTooLong() {
        String password = "Abcdefg5#abcdefgabcd";
        boolean actual = PasswordUtils.validatePassword(password);
        assertFalse(actual);
    }

    @Test
    public void testValidatePasswordLengthLessThan6() {
        String password = "Afg5#";
        boolean actual = PasswordUtils.validatePassword(password);
        assertFalse(actual);
    }


}

