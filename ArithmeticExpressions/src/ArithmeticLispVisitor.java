/**
 * Created by Takashi on 10/27/16.
 */
public class ArithmeticLispVisitor implements ArithmeticVisitor{
    String value = "";

    public Object visit(Leaf leaf){
        value += leaf.value + " ";
        return value;
    }
    public Object visit(ArrayComposite arrayComposite){

        value += "(";
        value += arrayComposite.operation + " ";

        for(int i = 0; i < arrayComposite.array.length; i++){
            arrayComposite.array[i].accept(this);
        }
        value += ")";
        return value;
    }
}
