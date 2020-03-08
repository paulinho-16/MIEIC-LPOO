package com.aor.numbers;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ListSorterTest {
    List<Integer> list = new ArrayList();
    List<Integer> expected = new ArrayList();
    List<Integer> lista_bug = new ArrayList();
    List<Integer> lista_bug_esperada = new ArrayList();

    @Before
    public void helper() {
        list.add(3);
        list.add(2);
        list.add(6);
        list.add(1);
        list.add(4);
        list.add(5);
        list.add(7);
        expected.add(1);
        expected.add(2);
        expected.add(3);
        expected.add(4);
        expected.add(5);
        expected.add(6);
        expected.add(7);
        lista_bug.add(1);
        lista_bug.add(2);
        lista_bug.add(4);
        lista_bug.add(2);
        lista_bug_esperada.add(1);
        lista_bug_esperada.add(2);
        lista_bug_esperada.add(2);
        lista_bug_esperada.add(4);
    }

    @Test
    public void sort() {

        ListSorter sorter = new ListSorter(list);
        List<Integer> sorted = sorter.sort();

        assertEquals(expected, sorted);

        ListSorter sorter2 = new ListSorter(lista_bug);
        List<Integer> sorted2 = sorter2.sort();

        assertEquals(lista_bug_esperada, sorted2);
    }
}