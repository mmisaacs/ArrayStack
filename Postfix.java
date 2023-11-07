import java.nio.charset.CharacterCodingException;

public class Postfix {
    static int precedence(char c){
        switch (c){
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
        }
        return -1;
    }
    public static String convertToPostfix(String infix){
        StackInterface<Character> operatorStack = new ResizeableArrayStack<>();
        int i = 0;
        StringBuilder postfix = new StringBuilder();

        while (i < infix.length()) {
            char c = infix.charAt(i);
            char nextCharacter = infix.charAt(i + 1);

            switch (c){
                case '^' :
                    operatorStack.push(nextCharacter);
                    break;

                case '+', '-', '*', '/':
                    while(!operatorStack.isEmpty() &&
                            (precedence(nextCharacter) <= precedence(operatorStack.peek()))){
                        postfix.append(operatorStack.pop());
                    }
                    operatorStack.push(nextCharacter);
                    break;

                case '(':
                    operatorStack.push(nextCharacter);
                    break;

                case ')':
                    Character topOperator = operatorStack.pop();
                    while(topOperator != '('){
                        postfix.append(topOperator);
                        topOperator = operatorStack.pop();
                    }
                    break;

                default:
                    postfix.append(nextCharacter);
                    break;
            }
            i++;
        }
        while (!operatorStack.isEmpty()){
            Character topOperator = operatorStack.pop();
            postfix.append(topOperator);
        }
        return postfix.toString();
    }
}
