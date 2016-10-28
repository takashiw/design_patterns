/**
 * Created by Takashi on 10/12/16.
 */
public class CompositeIterator implements Iter<Composite> {
    private Composite comp;
    private int position;

    public CompositeIterator(Composite comp){
        this.comp = comp;
        this.position = 0;
    }

    @Override
    public boolean hasNext(){
        if(comp instanceof ArrayComposite){
            ArrayComposite ac = (ArrayComposite)comp;
            Composite[] childrenList = ac.getComponentsList();
            if(position < childrenList.length){
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    @Override
    public Composite next(){
        if(comp instanceof ArrayComposite){
            ArrayComposite ac = (ArrayComposite)comp;
            Composite[] childrenList = ac.getComponentsList();
            position++;
            if(position-1 < childrenList.length){
                return childrenList[position-1];
            } else {
                return null;
            }
        }
        return null;
    }

}
