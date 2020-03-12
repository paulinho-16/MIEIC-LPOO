package com.aor.numbers;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ListFiltererTest {
    List<Integer> lista_antiga1 = new ArrayList<>();
    List<Integer> lista_correta1 = new ArrayList<>();
    List<Integer> lista_antiga2 = new ArrayList<>();
    List<Integer> lista_correta2 = new ArrayList<>();
    List<Integer> lista_antiga3 = new ArrayList<>();
    List<Integer> lista_correta3 = new ArrayList<>();

    @Before
    public void helper() {
        lista_antiga1.add(1);
        lista_antiga1.add(2);
        lista_antiga1.add(3);
        lista_antiga1.add(4);
        lista_antiga1.add(5);
        lista_correta1.add(2);
        lista_correta1.add(4);

        lista_antiga2.add(6);
        lista_antiga2.add(0);
        lista_antiga2.add(2);
        lista_antiga2.add(-2);
        lista_antiga2.add(-4);
        lista_correta2.add(6);
        lista_correta2.add(2);

        lista_antiga3.add(5);
        lista_antiga3.add(6);
        lista_antiga3.add(30);
        lista_antiga3.add(15);
        lista_antiga3.add(1);
        lista_antiga3.add(18);
        lista_correta3.add(5);
        lista_correta3.add(30);
        lista_correta3.add(15);
    }

    static class FilterStub implements IListFilter {
        @Override
        public boolean accept(Integer number) {
            return number % 2 == 0;
        }
    }

    @Test
    public void filterer() {

        ListFilterer lista1 = new ListFilterer(lista_antiga1);
        FilterStub filtro1 = new FilterStub();
        List<Integer> lista_filtrada1 = lista1.filter(filtro1);
        assertEquals(lista_correta1, lista_filtrada1);

        ListFilterer lista2 = new ListFilterer(lista_antiga2);
        PositiveFilter filtro2 = new PositiveFilter();
        List<Integer> lista_filtrada2 = lista2.filter(filtro2);
        assertEquals(lista_correta2, lista_filtrada2);

        ListFilterer lista3 = new ListFilterer(lista_antiga3);
        DivisibleByFilter filtro3 = new DivisibleByFilter(5);
        List<Integer> lista_filtrada3 = lista3.filter(filtro3);
        assertEquals(lista_correta3, lista_filtrada3);
    }
}
