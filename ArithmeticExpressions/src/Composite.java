/**
 * Created by Takashi on 10/11/16.
 */
public abstract class Composite {

    private Composite parent = null;

    final public Composite addWithParent(Composite part){
        try{
            add(part);

            part.parent = this;
        } catch(RuntimeException e){
            throw e;
        }
        return this;
    }

    final public Composite removeWithParent(Composite part){
        try{
            remove(part);

            part.parent = null;
        } catch(RuntimeException e){
            throw e;
        }
        return this;
    }

    protected Composite getParent(){
        return parent;
    }

    public Composite getChild(int number){
        return null;
    }

    public void add(Composite... comps){throw new RuntimeException( "add() not supported" );}

    public void remove(Composite... comps){throw new RuntimeException( "remove() not supported" );}

    public Object getComponentsList(){ return null; }

    @Override
    public String toString(){
        return (parent == null) ?
                getOperation() + " is the root." + "\n" :
                getOperation() + "is the child of " + parent + "\n";
    }

    public abstract Object accept(ArithmeticVisitor arithmeticVisitor);

    public Object getOperation(){ return null; }
}
