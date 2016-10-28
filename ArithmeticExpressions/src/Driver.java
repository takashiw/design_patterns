/**
 * Created by Takashi on 10/27/16.
 */
public class Driver {

    public static void main(String[] args){
        ArrayComposite ac3 = new ArrayComposite("*", new Leaf(9), new Leaf(11));
        ArrayComposite ac2 = new ArrayComposite("+", new Leaf(3), new Leaf(2), ac3);
        ArrayComposite ac = new ArrayComposite("/", new Leaf(1), ac2);


        ArrayComposite complex1 = new ArrayComposite("+", new Leaf(3), new Leaf(-5));
        ArrayComposite complex2 = new ArrayComposite("-", complex1, new Leaf(-45));
        ArrayComposite complex3 = new ArrayComposite("/", new Leaf(1), new Leaf(2));
        ArrayComposite complex4 = new ArrayComposite("*", complex2, complex3);
        ArrayComposite complex5 = new ArrayComposite("+", new Leaf(11), complex4, new Leaf(-23));

        ArrayComposite trivial1 = new ArrayComposite("-", new Leaf(1), new Leaf(1));

        System.out.println(ac.accept(new ArithmeticInfix()));
        System.out.println(ac.accept(new ArithmeticLispVisitor()));
        System.out.println(ac.accept(new ArithmeticEvaluateVisitor()));
        System.out.println(ac.accept(new ArithmeticTextual()));


        System.out.println(complex5.accept(new ArithmeticInfix()));
        System.out.println(complex5.accept(new ArithmeticLispVisitor()));
        System.out.println(complex5.accept(new ArithmeticEvaluateVisitor()));
        System.out.println(complex5.accept(new ArithmeticTextual()));


        System.out.println(trivial1.accept(new ArithmeticInfix()));
        System.out.println(trivial1.accept(new ArithmeticLispVisitor()));
        System.out.println(trivial1.accept(new ArithmeticEvaluateVisitor()));
        System.out.println(trivial1.accept(new ArithmeticTextual()));


    }

}
