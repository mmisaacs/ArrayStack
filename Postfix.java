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
        StackInterface<Character> operatorStack = new ResizeableArrayStack<Character>(infix.length());
        int i = 0;
        StringBuilder postfix = new StringBuilder();

        while (i < infix.length()) {
            //char c = infix.charAt(i);
            char nextCharacter = infix.charAt(i);

            switch (nextCharacter){
                case ' ': //ignore white spaces
                    break;
                case '^' : //add ^ to stack
                    operatorStack.push(nextCharacter);
                    break;

                case '+': //add to stack if there isn't already an operator in stack
                case '-':
                case '*':
                case '/':
                    while(!operatorStack.isEmpty() && //checks for a higher priority operator
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

    public static Integer evaluatePostfix(String postfix){
        StackInterface<Integer> valueStack = new LinkedStack<>();
        int i = 0;

        while(i < postfix.length()){
            char nextCharacter = postfix.charAt(i);
            int operandTwo;
            int operandOne;
            int result = 0;

            switch(nextCharacter){

                case ' ':
                    break;
                case '+':
                    operandTwo = valueStack.pop();
                    operandOne = valueStack.pop();
                    result = operandOne + operandTwo;
                    valueStack.push(result);
                    break;
                case '-':
                    operandTwo = valueStack.pop();
                    operandOne = valueStack.pop();
                    result = operandOne - operandTwo;
                    valueStack.push(result);
                    break;
                case '*':
                    operandTwo = valueStack.pop();
                    operandOne = valueStack.pop();
                    result = operandOne * operandTwo;
                    valueStack.push(result);
                    break;
                case '/':
                    operandTwo = valueStack.pop();
                    operandOne = valueStack.pop();
                    result = operandOne / operandTwo;
                    valueStack.push(result);
                    break;
                case '^':
                    operandTwo = valueStack.pop();
                    operandOne = valueStack.pop();
                    valueStack.push((int) Math.pow(operandOne, operandTwo));
                    break;
                default:
                    valueStack.push((int) nextCharacter);
            }
            i++;
        }
        return valueStack.peek();
    }
}
