public class StringInverter implements StringTransformer {

    @Override
    public void execute(StringDrink drink) {
        StringBuffer stringBuffer = new StringBuffer(drink.getText());
        drink.setText(stringBuffer.reverse().toString());
    }

    @Override
    public void undo(StringDrink drink) {
        execute(drink);
    }
}
