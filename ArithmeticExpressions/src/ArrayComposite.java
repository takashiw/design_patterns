/**
 * Created by Takashi on 10/12/16.
 */
public class ArrayComposite extends Composite{
    String operation;
    Composite[] array;

    public ArrayComposite(String operation, Composite... comps){
        this.operation = operation;
        this.array = new Composite[comps.length];
        add(comps);
    }

    @Override
    public void add(Composite... comps){
//        int counter = 0;
        for(Composite comp: comps){
            for(int i = 0; i < array.length; i++){
                if(array[i] == null){
                    array[i] = comp;
                    break;
                }
            }
        }
    }

    @Override
    public void remove(Composite... comps){
        for(Composite comp: comps){
            for(int i = 0; i < array.length; i++){
                if(this.array[i] == comp){
                    this.array[i] = null;
                    break;
                }
            }
        }
    }

    @Override
    public Composite[] getComponentsList(){
        return this.array;
    }

    public String getOperation(){
        return this.operation;
    }

    @Override
    public Object accept(ArithmeticVisitor arithmeticVisitor){

        return arithmeticVisitor.visit(this);

    }

}
