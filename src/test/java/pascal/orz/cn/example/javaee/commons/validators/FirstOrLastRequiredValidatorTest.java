package pascal.orz.cn.example.javaee.commons.validators;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import pascal.orz.cn.example.javaee.apps.model.Users;
import jakarta.validation.ConstraintValidatorContext;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
 * Unit tests for FirstOrLastRequiredValidator to verify Jakarta EE 10 migration.
 * Tests custom validation logic with Jakarta Bean Validation.
 */
@DisplayName("FirstOrLastRequiredValidator Tests")
class FirstOrLastRequiredValidatorTest {

    private FirstOrLastRequiredValidator validator;
    private ConstraintValidatorContext context;

    @BeforeEach
    void setUp() {
        validator = new FirstOrLastRequiredValidator();
        context = mock(ConstraintValidatorContext.class);
    }

    @Test
    @DisplayName("Null user should be invalid")
    void testNullUser() {
        assertFalse(validator.isValid(null, context), 
                "Null user should be invalid");
    }

    @Test
    @DisplayName("User with valid firstName should be valid")
    void testValidFirstName() {
        Users user = new Users();
        user.setFirstName("John");

        assertTrue(validator.isValid(user, context), 
                "User with firstName should be valid");
    }

    @Test
    @DisplayName("User with firstName and lastName should be valid")
    void testValidBothNames() {
        Users user = new Users();
        user.setFirstName("John");
        user.setLastName("Doe");

        assertTrue(validator.isValid(user, context), 
                "User with both names should be valid");
    }

    @Test
    @DisplayName("User with null firstName should be invalid")
    void testNullFirstName() {
        Users user = new Users();
        user.setFirstName(null);
        user.setLastName("Doe");

        assertFalse(validator.isValid(user, context), 
                "User with null firstName should be invalid");
    }

    @Test
    @DisplayName("User with empty firstName should be invalid")
    void testEmptyFirstName() {
        Users user = new Users();
        user.setFirstName("");

        assertFalse(validator.isValid(user, context), 
                "User with empty firstName should be invalid");
    }

    @Test
    @DisplayName("User with whitespace-only firstName should be invalid")
    void testWhitespaceOnlyFirstName() {
        Users user = new Users();
        user.setFirstName("   ");

        assertFalse(validator.isValid(user, context), 
                "User with whitespace-only firstName should be invalid");
    }

    @Test
    @DisplayName("User with valid firstName with leading/trailing spaces should be valid")
    void testFirstNameWithSpaces() {
        Users user = new Users();
        user.setFirstName(" John ");

        assertTrue(validator.isValid(user, context), 
                "User with firstName containing actual characters should be valid");
    }

    @Test
    @DisplayName("User without any names should be invalid")
    void testNoNames() {
        Users user = new Users();

        assertFalse(validator.isValid(user, context), 
                "User without any names should be invalid");
    }
}
