public class PostfixTestUsingArrayStack {
    public static void main(String[] args){
        String infix = "(d * f + 1) * e/(a^b - b * c + 1) - 72";
        System.out.println("Infix Expression: " + infix);
        System.out.print("Postfix Expression: ");
        System.out.println(Postfix.convertToPostfix(infix));
    }
}
