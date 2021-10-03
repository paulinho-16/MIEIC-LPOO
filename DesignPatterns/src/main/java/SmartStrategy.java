import java.util.ArrayList;
import java.util.List;

public class SmartStrategy implements OrderingStrategy {
    private List<StringRecipe> recipes;
    private List<StringDrink> drinks;

    public SmartStrategy() {
        recipes = new ArrayList<>();
        drinks = new ArrayList<>();
    }

    @Override
    public void wants(StringDrink drink, StringRecipe recipe, StringBar bar) {
        if (bar.isHappyHour()) {
            bar.order(drink, recipe);
        }
        else {
            recipes.add(recipe);
            drinks.add(drink);
        }
    }

    @Override
    public void happyHourStarted(StringBar bar) {
        int contador = 0, contador2 = 0;
        for (StringRecipe receita : recipes) {
            for (StringDrink drink : drinks) {
                if (contador == contador2) {
                    bar.order(drink, receita);
                    break;
                }
                contador2++;
            }
            contador++;
        }
    }

    @Override
    public void happyHourEnded(StringBar bar) {

    }
}
