/**
 * Created by Takashi on 10/11/16.
 */
public abstract class Composite {

    private Composite parent = null;
    Iter<Composite> iterator = null;

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

    public String print(){
        String value = this.toString();
        value += performToString(1);
        return value;
    }

    public String performToString(int indentCount){
        String indent = "";
        for(int i = 0; i < indentCount; i++){
            indent += "\t";
        }
        String value = "";
        makeIter();
        while(iterator.hasNext()){
            Composite comp = iterator.next();
            value = value + indent + comp.toString();
            value = value + comp.performToString(indentCount+1);
        }
        return value;
    }

    public Object getOperation(){ return null; }

    public Iter<Composite> makeIter(){
        iterator = new CompositeIterator(this);
        return iterator;
    }
}
