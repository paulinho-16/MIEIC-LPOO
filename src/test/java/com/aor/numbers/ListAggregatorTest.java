package com.aor.numbers;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ListAggregatorTest {

    List<Integer> list = new ArrayList<>();
    List<Integer> lista_max = new ArrayList<>();
    List<Integer> lista_distinct = new ArrayList<>();

    @Before
    public void helper() {
        list.add(1);
        list.add(2);
        list.add(4);
        list.add(2);
        list.add(5);
        lista_max.add(-1);
        lista_max.add(-4);
        lista_max.add(-5);
        lista_distinct.add(1);
        lista_distinct.add(2);
        lista_distinct.add(4);
        lista_distinct.add(2);
    }

    @Test
    public void sum() {

        ListAggregator aggregator = new ListAggregator(list);

        int sum = aggregator.sum();

        assertEquals(14, sum);
    }

    @Test
    public void max() {

        ListAggregator aggregator = new ListAggregator(list);
        int max = aggregator.max();

        assertEquals(5, max);

        ListAggregator aggregator2 = new ListAggregator(lista_max);
        int max2 = aggregator2.max();

        assertEquals(-1, max2);
    }

    @Test
    public void min() {

        ListAggregator aggregator = new ListAggregator(list);

        int min = aggregator.min();

        assertEquals(1, min);
    }

    @Test
    public void distinct() {

        class stubDeduplicate implements IListDeduplicator {
            @Override
            public List<Integer> deduplicate() {
                List<Integer> correctList = new ArrayList<>();
                correctList.add(1);
                correctList.add(2);
                correctList.add(4);
                return correctList;
            }
        }

        ListAggregator aggregator = new ListAggregator(list);
        int distinct = aggregator.distinct(new ListDeduplicator(list));

        assertEquals(4, distinct);

        ListAggregator aggregator2 = new ListAggregator(lista_distinct);
        int distinct2 = aggregator2.distinct(new stubDeduplicate());

        assertEquals(3, distinct2);
    }
}