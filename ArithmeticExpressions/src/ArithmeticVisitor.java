/**
 * Created by Takashi on 10/27/16.
 */
public interface ArithmeticVisitor {
    public Object visit(Leaf leaf);
    public Object visit(ArrayComposite arrayComposite);
}
