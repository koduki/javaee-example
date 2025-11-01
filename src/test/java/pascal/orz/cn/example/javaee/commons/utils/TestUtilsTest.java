package pascal.orz.cn.example.javaee.commons.utils;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import pascal.orz.cn.example.javaee.apps.model.Users;
import jakarta.validation.ConstraintViolation;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for TestUtils to verify Jakarta EE 10 validation utilities.
 */
@DisplayName("TestUtils Tests")
class TestUtilsTest {

    @Test
    @DisplayName("Validate method should work with valid entity")
    void testValidateWithValidEntity() {
        Users user = new Users();
        user.setFirstName("John");
        user.setAge(30);

        Set<ConstraintViolation<Users>> violations = TestUtils.validate(user);

        assertNotNull(violations, "Violations set should not be null");
        assertTrue(violations.isEmpty(), "Valid entity should have no violations");
    }

    @Test
    @DisplayName("Validate method should detect violations")
    void testValidateWithInvalidEntity() {
        Users user = new Users();
        user.setFirstName(""); // Violates @Size(min = 1)
        user.setAge(30);

        Set<ConstraintViolation<Users>> violations = TestUtils.validate(user);

        assertNotNull(violations, "Violations set should not be null");
        assertFalse(violations.isEmpty(), "Invalid entity should have violations");
    }

    @Test
    @DisplayName("Validate method should work with Jakarta Validation API")
    void testJakartaValidationIntegration() {
        Users user = new Users();
        // No firstName or lastName set

        Set<ConstraintViolation<Users>> violations = TestUtils.validate(user);

        assertNotNull(violations, "Violations set should not be null");
        assertFalse(violations.isEmpty(), 
                "User without required fields should have violations");
        
        // Verify we're using Jakarta validation (not javax)
        violations.forEach(violation -> {
            assertNotNull(violation.getMessage());
            assertNotNull(violation.getPropertyPath());
        });
    }
}
