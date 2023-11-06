public class Postfix {
    public static String convertToPostfix(String infix){
        StackInterface<Character> operatorStack = new ResizeableArrayStack<>();
        StringBuilder postfix = new StringBuilder();

        int i = 0;
        while (i < infix.length()) {
            char character = infix.charAt(i);
            char nextCharacter = infix.charAt(i + 1);
            if (Character.isWhitespace(nextCharacter)){
                nextCharacter = infix.charAt(i + 2);
            }
            switch (character){
                case '^' :
                    operatorStack.push(nextCharacter);
                    break;

                case '+':
                case '-':
                case '*':
                case '/':
                    while(!operatorStack.isEmpty() &&
                            (nextCharacter <= operatorStack.peek())){
                        postfix.append(operatorStack.peek());
                    }
            }
            i++;
        }
        return "";
    }
}
