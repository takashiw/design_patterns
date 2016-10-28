import java.util.Stack;

/**
 * Created by Takashi on 10/27/16.
 */
public class ArithmeticEvaluateVisitor implements ArithmeticVisitor {

    String value;
    Stack st = new Stack();

    public Object visit(Leaf leaf) {
        System.out.println(leaf.value);
        return leaf.value;
    }
    public Object visit(ArrayComposite arrayComposite){
        double solution = 0;
        value += "(";
        for(int i = 0; i < arrayComposite.array.length; i++){
            arrayComposite.array[i].accept(this);
            if(i < arrayComposite.array.length - 1){
                System.out.println(arrayComposite.operation);
            } else {
                value += ")";
            }
        }
////        return value;
//        for(int i = 0; i < arrayComposite.array.length; i++){
//            arrayComposite.array[i].accept(this);
//            int temp = Integer.parseInt((String)arrayComposite.array[i].accept(this));
//            if(i == 0){
//                solution = temp;
//            } else {
//                 solution = executeArithmetic(solution, temp, arrayComposite.operation);
//            }
//            System.out.println("Temp: " + temp);
//            System.out.println("Solution: " + solution);
//        }
        return "";
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
