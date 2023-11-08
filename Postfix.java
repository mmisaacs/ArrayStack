import java.util.HashMap;

public class Postfix {
    static int precedence(char c){
        //checks if there is a higher priority operator in stack
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
        String postfix = "";

        while (i < infix.length()) {
            char nextCharacter = infix.charAt(i);
            if (Character.isLetterOrDigit(nextCharacter)){
                postfix += nextCharacter;
                i++;
                continue;
            }

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
                        postfix += operatorStack.pop();
                    }
                    operatorStack.push(nextCharacter);
                    break;

                case '(':
                    operatorStack.push(nextCharacter);
                    break;

                case ')':
                    Character topOperator = operatorStack.pop();
                    while(topOperator != '('){
                        postfix += topOperator;
                        topOperator = operatorStack.pop();
                    }
                    break;

                default:
                    //postfix.append(nextCharacter);
                    break;
            }
            i++;
        }
        while (!operatorStack.isEmpty()){
            Character topOperator = operatorStack.pop();
            postfix += topOperator;
        }
        return postfix;
    }

    public static Integer evaluatePostfix(String postfix){
        StackInterface<Integer> valueStack = new LinkedStack<>();

        //
        HashMap<Character, Integer> values = new HashMap<Character, Integer>();
        values.put('a', 2);
        values.put('b', 3);
        values.put('c', 4);
        values.put('d', 5);
        values.put('e', 6);
        values.put('f', 7);
        values.put('g', 1);
        values.put('h', 72);

        int i = 0;
        int operandTwo;
        int operandOne;
        int result = 0;


        while(i < postfix.length()){
            //gets the next character
            char nextCharacter = postfix.charAt(i);

            //checks if next character is a letter, if so, exchanges it for value in hashmap
            if(Character.isLetter(nextCharacter) && values.containsKey(nextCharacter)){
                valueStack.push(values.get(nextCharacter));
                i++;
                continue;
            }
            switch(nextCharacter){
                case ' ': //moves on if it is a space
                    break;
                case '+':
                    operandTwo = valueStack.pop();
                    operandOne = valueStack.pop();
                    valueStack.push(operandOne + operandTwo);
                    break;
                case '-':
                    operandTwo = valueStack.pop();
                    operandOne = valueStack.pop();
                    valueStack.push(operandOne - operandTwo);
                    break;
                case '*':
                    operandTwo = valueStack.pop();
                    operandOne = valueStack.pop();
                    valueStack.push(operandOne * operandTwo);
                    break;
                case '/':
                    operandTwo = valueStack.pop();
                    operandOne = valueStack.pop();
                    valueStack.push(operandOne / operandTwo);
                    break;
                case '^':
                    operandTwo = valueStack.pop();
                    operandOne = valueStack.pop();
                    valueStack.push((int) Math.pow(operandOne, operandTwo));
                    break;
                default:
                        break;
            }
            i++;
        }
        //returns the total (only number in valueStack)
        return valueStack.peek();
    }
}
