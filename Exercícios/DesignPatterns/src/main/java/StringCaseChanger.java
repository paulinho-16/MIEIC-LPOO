public class StringCaseChanger implements StringTransformer {

    @Override
    public void execute(StringDrink drink) {
        String text = drink.getText();
        StringBuffer stringBuffer = new StringBuffer(text);
        for (int i = 0 ; i < text.length() ; i++) {
            Character caracter = text.charAt(i);
            if (Character.isLowerCase(caracter))
                stringBuffer.replace(i, i+1, Character.toUpperCase(caracter) + "");
            else
                stringBuffer.replace(i, i+1, Character.toLowerCase(caracter) + "");
        }
        drink.setText(stringBuffer.toString());
    }

    @Override
    public void undo(StringDrink drink) {
        execute(drink);
    }
}
