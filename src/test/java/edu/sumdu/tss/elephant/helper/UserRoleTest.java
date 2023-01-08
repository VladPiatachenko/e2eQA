package edu.sumdu.tss.elephant.helper;

import org.testng.annotations.Test;
import edu.sumdu.tss.elephant.helper.UserRole;
import static org.testng.Assert.assertEquals;

public class UserRoleTest {
    @Test
    public static void byValuetest() {
        assertEquals(UserRole.byValue(0),UserRole.ANYONE,"passes anyone");
        assertEquals(UserRole.byValue(1),UserRole.UNCHEKED);
        assertEquals(UserRole.byValue(2),UserRole.BASIC_USER);
        assertEquals(UserRole.byValue(3),UserRole.PROMOTED_USER);
        assertEquals(UserRole.byValue(4),UserRole.ADMIN);

    }
}
