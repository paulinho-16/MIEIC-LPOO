public class StringReplacer implements StringTransformer {
    private Character oldChar;
    private Character newChar;

    public StringReplacer(Character oldChar, Character newChar) {
        this.oldChar = oldChar;
        this.newChar = newChar;
    }

    @Override
    public void execute(StringDrink drink) {
        String text = drink.getText();
        text = text.replace(oldChar, newChar);
        drink.setText(text);
    }

    @Override
    public void undo(StringDrink drink) {
        String text = drink.getText();
        text = text.replace(newChar, oldChar);
        drink.setText(text);
    }
}
