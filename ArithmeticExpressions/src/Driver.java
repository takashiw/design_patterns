/**
 * Created by Takashi on 10/27/16.
 */
public class Driver {

    public static void main(String[] args){
        ArrayComposite ac3 = new ArrayComposite("*", new Leaf<Integer>(9), new Leaf<Integer>(11));
        ArrayComposite ac2 = new ArrayComposite("+", new Leaf<Integer>(3),  ac3, new Leaf<Integer>(2));
        ArrayComposite ac = new ArrayComposite("/", ac2, new Leaf<Integer>(1));

        System.out.println(ac.print());
    }

}
