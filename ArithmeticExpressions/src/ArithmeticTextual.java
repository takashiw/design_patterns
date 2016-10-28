/**
 * Created by Takashi on 10/27/16.
 */
public class ArithmeticTextual implements ArithmeticVisitor {

    int indent = 0;
    String value = "";

    @Override
    public Object visit(Leaf leaf){
        value += indentToString() + "[" + leaf.value + "]" + "\n";
        return value;
    }

    public Object visit(ArrayComposite arrayComposite){

        value += indentToString() + "[" + arrayComposite.operation + "]" + "\n";
        indent++;
        for(int i = 0; i < arrayComposite.array.length; i++){
            arrayComposite.array[i].accept(this);
        }
        return value;
    }

    public String indentToString(){
        String indentString = "";
        for(int i = 0; i < indent; i++){
            if(i == 0){
                indentString = "+---";
            } else {
                indentString = "|   " + indentString;
            }
        }

        return indentString;
    }
}
