/**
 * Created by Takashi on 10/27/16.
 */
public interface ArithmeticVisitor {
    public void visit(Leaf leaf);
    public void visit(ArrayComposite arrayComposite);
}
