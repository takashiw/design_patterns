/**
 * Created by Takashi on 10/12/16.
 */
public class Leaf<T> extends Composite {
    public T instanceID;

    public Leaf(T value){
        this.instanceID = value;
    }

    @Override
    public T getOperation(){
        return this.instanceID;
    }
}
