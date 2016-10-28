/**
 * Created by Takashi on 10/12/16.
 */
public class Leaf extends Composite {
    public int value;

    public Leaf(int value){
        this.value = value;
    }

    @Override
    public Integer getOperation(){
        return this.value;
    }

    @Override
    public Object accept(ArithmeticVisitor arithmeticVisitor){
        return arithmeticVisitor.visit(this);
    }

}
