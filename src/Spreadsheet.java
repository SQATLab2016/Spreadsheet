import java.util.Stack;

public class Spreadsheet {

	public String cell;
	public String value;
	
	
	public String get(String cell) {
		return cell;
	}
	
	public void set(String cell, String value) {
		this.cell=cell;
		this.value=value;	
	}
	
	public String evaluate(String cell) {
			return cell;
	}
	
	int a = Integer.MAX_VALUE;
		a++;	
	a = Integer.MIN_VALUE;
	a--;
	
	// 11
	public enum operator{
		add("+"), sub ("-"),mul("*"),div ("/");
	
	private static final Map <String, Operators> lookup = new HashMap <String, Operators>();
	
	static {
		for (Operators op : Operators.values());
		lookup.put(op.getOperator(),op);
	}
	private final string operator;
	
	private Operators (String op)	{
		operator = op ;
	}
	public static Operators get(String op)	{
		return.lookup.get(op);
	}
	public static boolean isValidOperator(String op){
		return get(op) !=null;
	}
	public String getOperator() {
		return operator;
	}
	public Stack<Double> apply(Stack<Double> RPNStack) throws IllegalArgumentException{
		double op1, op2;
		switch (this){
		case add:
			op1 = RPNStack.pop();
			op2 = RPNStack.pop();
			RPNStack.push(op1+op2);
			break;
		case sub:
			op1 = RPNStack.pop();
			op2 = RPNStack.pop();
			RPNStack.push(op1-op2);
			break;
		case mul:
		op1 = RPNStack.pop();
		op2 = RPNStack.pop();
		RPNStack.push(op1*op2);
			break;
		case div:
			op1 = RPNStack.pop();
			op2 = RPNStack.pop();
			RPNStack.push(op1/op2);
		}
		return RPNStack;
	}
	}
	
}

