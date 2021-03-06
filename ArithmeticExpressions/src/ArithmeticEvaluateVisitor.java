import java.util.Stack;

/**
 * Created by Takashi on 10/27/16.
 */
public class ArithmeticEvaluateVisitor implements ArithmeticVisitor {

    double solution;
    boolean solutionNullFlag = true;
    String value = "";
    Stack st = new Stack();

    public Object visit(Leaf leaf) {
        st.push(leaf.value);
        value += " " + leaf.value;
        return leaf.value;
    }
    public Object visit(ArrayComposite arrayComposite){
        st.push("(");
        for(int i = 0; i < arrayComposite.array.length; i++){
            arrayComposite.array[i].accept(this);
            if(i < arrayComposite.array.length - 1){
            } else {
                execute(arrayComposite.operation);
            }
        }
        return solution;
    }

    public void execute(String operation){
        Object temp;
        temp = st.pop();
        while(temp != "("){
            if(solutionNullFlag){
                solution = (Double)temp;
                solutionNullFlag = false;
            } else {
                solution = executeArithmetic((Double) temp, solution, operation);
            }
            temp = st.pop();
        }
    }

    public double executeArithmetic(double first, double second, String operation){
        switch (operation){
            case "+":
                return first + second;
            case "/":
                return first / second;
            case "*":
                return first * second;
            case "-":
                return first - second;
            default:
                return -1;
        }
    }
}
