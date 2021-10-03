package com.aor.numbers;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PositiveFilterTest {

    @Test
    public void accept() {
        PositiveFilter filtro = new PositiveFilter();

        boolean bool1 = filtro.accept(0);
        boolean bool2 = filtro.accept(2);
        boolean bool3 = filtro.accept(-3);
        boolean bool4 = filtro.accept(16);

        assertEquals(false, bool1);
        assertEquals(true, bool2);
        assertEquals(false, bool3);
        assertEquals(true, bool4);
    }
}
