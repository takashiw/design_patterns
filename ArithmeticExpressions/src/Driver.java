/**
 * Created by Takashi on 10/27/16.
 */
public class Driver {

    public static void main(String[] args){
        ArrayComposite ac3 = new ArrayComposite("*", new Leaf(9), new Leaf(11));
        ArrayComposite ac2 = new ArrayComposite("+", new Leaf(3), new Leaf(2), ac3);
        ArrayComposite ac = new ArrayComposite("/", new Leaf(1), ac2);



//        System.out.println(ac.accept(new ArithmeticTextual()));
//        System.out.println(ac.accept(new ArithmeticInfix()));
//        System.out.println(ac.accept(new ArithmeticLispVisitor()));
            System.out.println(ac.accept(new ArithmeticEvaluateVisitor()));

    }

}
