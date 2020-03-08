package com.aor.numbers;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ListDeduplicatorTest {

    List<Integer> list = new ArrayList<>();
    List<Integer> expected = new ArrayList<>();
    List<Integer> lista_bug = new ArrayList();
    List<Integer> lista_bug_esperada = new ArrayList();

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
        lista_bug.add(1);
        lista_bug.add(2);
        lista_bug.add(4);
        lista_bug.add(2);
        lista_bug_esperada.add(1);
        lista_bug_esperada.add(2);
        lista_bug_esperada.add(4);
    }

    @Test
    public void deduplicate() {

        class stubSort implements IListSorter {
            @Override
            public List<Integer> sort() {
                List<Integer> correctList = new ArrayList<>();
                correctList.add(1);
                correctList.add(2);
                correctList.add(2);
                correctList.add(4);
                return correctList;
            }
        }

        ListDeduplicator deduplicator = new ListDeduplicator(list);
        List<Integer> distinct = deduplicator.deduplicate();

        assertEquals(expected, distinct);

        ListDeduplicator deduplicator2 = new ListDeduplicator(lista_bug);
        List<Integer> distinct2 = deduplicator2.deduplicate(new stubSort());

        assertEquals(lista_bug_esperada, distinct2);
    }
}