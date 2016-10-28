/**
 * Created by Takashi on 10/12/16.
 */
public class Leaf extends Composite {
    public double value;

    public Leaf(double value){
        this.value = value;
    }

    @Override
    public Double getOperation(){
        return this.value;
    }

    @Override
    public Object accept(ArithmeticVisitor arithmeticVisitor){
        return arithmeticVisitor.visit(this);
    }
}
