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
        System.out.println(leaf.value);
        value += " " + leaf.value;
        return leaf.value;
    }
    public Object visit(ArrayComposite arrayComposite){
        System.out.println("(");
        st.push("(");
        for(int i = 0; i < arrayComposite.array.length; i++){
            arrayComposite.array[i].accept(this);
            if(i < arrayComposite.array.length - 1){
            } else {
                execute(arrayComposite.operation);
                System.out.println(arrayComposite.operation);
                System.out.println(")");
            }
        }
        return solution;
    }

    public void execute(String operation){
        System.out.println("Operation: " + operation);
        Object temp;
        temp = st.pop();
        while(temp != "("){
            System.out.println("Temp: " + temp);
            if(solutionNullFlag){
                solution = (Double)temp;
                solutionNullFlag = false;
            } else {
                solution = executeArithmetic((Double) temp, solution, operation);
            }
            System.out.println("Solution: " + solution);
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
