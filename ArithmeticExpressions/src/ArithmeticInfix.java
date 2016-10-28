/**
 * Created by Takashi on 10/27/16.
 */
public class ArithmeticInfix implements ArithmeticVisitor {
    String value = "";

    @Override
    public Object visit(Leaf leaf){
        value += leaf.value;
        return value;
    }

    @Override
    public Object visit(ArrayComposite arrayComposite){
        value += "(";
        for(int i = 0; i < arrayComposite.array.length; i++){
            arrayComposite.array[i].accept(this);
            if(i < arrayComposite.array.length - 1){
                value += arrayComposite.operation;
            } else {
                value += ")";
            }
        }
        return value;
    }
}
