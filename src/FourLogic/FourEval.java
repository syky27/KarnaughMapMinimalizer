package FourLogic;


/**
 * This is class for storing logic operands its extending the operations
 * @author syky
 */
public class FourEval extends FourEvalOperations{
    public int product[];
    public int nvar;
    public FourEval next;
    public int used;

    /**
     * Construct the desire memory
     */
    public FourEval(){
    int dproduct[] = {-1,-1,-1,-1};
    this.product = dproduct;
    nvar = 4;
    next = null;
    used = 0;
    }
}
