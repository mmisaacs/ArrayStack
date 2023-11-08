public class PostfixTestUsingLinkedStack {
    public static void main(String[] args){
        //print of the infix expression and replacements
        System.out.println("Infix expression: (d * f + 1) * e/(a^b - b * c + 1) - 72" + "\n");
        System.out.println("Replace g = 1 and h = 72");

        //create string infix to run convertToPostfix and print postfix
        String infix = "(d * f + g) * e/(a^b - b * c + g) - h";
        String postfixExp = Postfix.convertToPostfix(infix);
        System.out.println("Postfix expression: " + postfixExp + "\n");

        //print values of variables and evaluate the postfix expression accordingly
        System.out.println("Assume that: a = 2, b = 3, c = 4, d = 5, e = 6, f = 7, g = 1, and h = 72");
        int result = Postfix.evaluatePostfix(postfixExp);
        System.out.println("Result of postfix expression: " + result);
    }

}
