package com.aor.numbers;

import java.util.ArrayList;
import java.util.List;

public class ListFilterer {
    private List<Integer> lista;

    public ListFilterer(List<Integer> lista) {
        this.lista = lista;
    }

    public List<Integer> filter(IListFilter filter) {
        List<Integer> nova_lista = new ArrayList<>();

        for (Integer number : lista) {
            if (filter.accept(number))
                nova_lista.add(number);
        }

        return nova_lista;
    }
}
