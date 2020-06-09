import org.junit.Test;

import static org.junit.Assert.*;

public class SameNumberTest {

    @Test
    public void testSame() {

        assertTrue(Flik.isSameNumber(5, 5));
        assertTrue(Flik.isSameNumber(128, 128));
        assertFalse(Flik.isSameNumber(3, 6));
    }
}
