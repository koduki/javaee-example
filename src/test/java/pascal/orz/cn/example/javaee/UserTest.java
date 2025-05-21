package pascal.orz.cn.example.javaee;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import pascal.orz.cn.example.javaee.apps.model.Users;
import java.util.Set;
import jakarta.validation.ConstraintViolation;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.core.Is.*;
import static pascal.orz.cn.example.javaee.commons.utils.TestUtils.*;

/**
 *
 * @author koduki
 */
public class UserTest {

    public UserTest() {
    }

    @Test
    public void setFirstNameAndLastName_with_both_empty_are_Error() {
//        Users user = new Users();
//        user.setFirstName("");
//        Set<ConstraintViolation<User>> violations = validate(user);
//        assertThat(violations.size(), is(1));
//
//        for (ConstraintViolation<User> violation : violations) {
//            assertThat(violation.getMessage(), is("may not be empty2"));
//        }
    }

    @Test
    public void setFirstName_with_null_is_Error() {
        Users user = new Users();
        user.setFirstName(null);
        Set<ConstraintViolation<Users>> violations = validate(user);
        assertThat(violations.size(), is(1));

        for (ConstraintViolation<Users> violation : violations) {
            assertThat(violation.getMessage(), is("may not be empty2"));
        }
    }

}
