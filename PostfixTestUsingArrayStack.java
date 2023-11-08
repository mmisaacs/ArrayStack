public class PostfixTestUsingArrayStack {
    public static void main(String[] args){
        //create and print infix expression from task 1
        String infix = "(d * f + 1) * e/(a^b - b * c + 1) - 72";
        System.out.println("Infix Expression: " + infix + "\n");


        System.out.println("Converting infix to postfix using a resizable array stack...\n");

        //convert to postfix and print new expression
        System.out.print("Postfix Expression: ");
        System.out.println(Postfix.convertToPostfix(infix));
    }
}
