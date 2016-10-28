/**
 * Created by Takashi on 10/27/16.
 */
public class ArithmeticTextual implements ArithmeticVisitor {

    String value = "";
    int indent = 0;

    @Override
    public void visit(Leaf leaf){
        System.out.println(indentToString() + "[" + leaf.value + "]");
    }

    public void visit(ArrayComposite arrayComposite){

        System.out.println(indentToString() + "[" + arrayComposite.operation + "]");
        indent++;
        for(int i = 0; i < arrayComposite.array.length; i++){
            arrayComposite.array[i].accept(this);
        }
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
