import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PermissionManagerTest {

    @Test
    public void testGetRoleName() {
        PermissionManager manager = new PermissionManager();

        assertEquals("Admin", manager.getRoleName(PermissionLevel.ADMIN));
        assertEquals("Developer", manager.getRoleName(PermissionLevel.DEVELOPER));
        assertEquals("User", manager.getRoleName(PermissionLevel.USER));
        assertEquals("Unknown", manager.getRoleName(null)); // Test for "Unknown" case
    }

    @Test
    public void testSetPermissionLevel() {
        PermissionManager manager = new PermissionManager();

        manager.setPermissionLevel(PermissionLevel.ADMIN);
        assertEquals(PermissionLevel.ADMIN, manager.getCurrentPermissionLevel());

        manager.setPermissionLevel(PermissionLevel.DEVELOPER);
        assertEquals(PermissionLevel.DEVELOPER, manager.getCurrentPermissionLevel());

        manager.setPermissionLevel(PermissionLevel.USER);
        assertEquals(PermissionLevel.USER, manager.getCurrentPermissionLevel());
    }

    @Test
    public void testGetCurrentPermissionLevel() {
        PermissionManager manager = new PermissionManager();

        assertEquals(PermissionLevel.USER, manager.getCurrentPermissionLevel());

        manager.setPermissionLevel(PermissionLevel.ADMIN);
        assertEquals(PermissionLevel.ADMIN, manager.getCurrentPermissionLevel());

        manager.setPermissionLevel(PermissionLevel.DEVELOPER);
        assertEquals(PermissionLevel.DEVELOPER, manager.getCurrentPermissionLevel());

        manager.setPermissionLevel(null); // Test setting to null
        assertEquals(null, manager.getCurrentPermissionLevel());
    }
}
