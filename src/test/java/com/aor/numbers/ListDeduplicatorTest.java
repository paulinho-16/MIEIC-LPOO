package com.aor.numbers;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ListDeduplicatorTest {

    List<Integer> list = new ArrayList<>();
    List<Integer> expected = new ArrayList<>();

    @Before
    public void helper() {
        list.add(1);
        list.add(2);
        list.add(4);
        list.add(2);
        list.add(5);
        expected.add(1);
        expected.add(2);
        expected.add(4);
        expected.add(5);
    }

    @Test
    public void deduplicate() {

        ListDeduplicator deduplicator = new ListDeduplicator(list);
        List<Integer> distinct = deduplicator.deduplicate();

        assertEquals(expected, distinct);
    }
}