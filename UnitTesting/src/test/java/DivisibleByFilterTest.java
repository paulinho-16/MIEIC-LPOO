import com.aor.numbers.DivisibleByFilter;
import org.junit.Test;

import static org.junit.Assert.*;

public class DivisibleByFilterTest {
    @Test
    public void accept() {
        DivisibleByFilter filtro1 = new DivisibleByFilter(2);
        DivisibleByFilter filtro2 = new DivisibleByFilter(3);

        boolean bool1 = filtro1.accept(2);
        boolean bool2 = filtro1.accept(3);
        boolean bool3 = filtro1.accept(16);

        boolean bool4 = filtro2.accept(6);
        boolean bool5 = filtro2.accept(7);
        boolean bool6 = filtro2.accept(19);

        assertTrue(bool1);
        assertFalse(bool2);
        assertTrue(bool3);
        assertTrue(bool4);
        assertFalse(bool5);
        assertFalse(bool6);
    }
}
