import data.*;
import stack.*;

/**
 * @author 55-79-66
 * Program simulates stack-structure with basic operations: push, pop, peek, print, show size and clear
 *
 */
public class Demo {
	static Stackable<Student> stack = new Stack<Student>();
	
	public static void main(String[] args) {
		
		System.out.println("\nWelcome to self-made stack-program!\n");		
		int select;        
        do {
	        System.out.printf("\n\tMenu\n"
	        		+ "0 EXIT\n"
	                + "1 compose a new element and insert it at the top (push)\n"
	                + "2 remove the top-stack-element (pop)\n"
	                + "3 print the top-stack-element (peek)\n"
	                + "4 print all stack-elements\n"
	                + "5 show the stack-size\n"
	                + "6 delete all stack-elements\n"
	                + "_____________________________________\n"
	                + "your choice >> ");
	        
	        select = Tools.intCheck(0, 6);
	        switch (select) {
	        
	            case 0:                    
	                break;
	            
	            case 1:
	            	stack.push(Tools.composeStudent());
	                break;
	                
	            case 2:
	            	stack.pop();
	                break;
	                
	            case 3:
	            	System.out.println();
	            	System.out.println(stack.peek());
	                break;
	                
	            case 4:
	            	System.out.println();
	            	printStack(stack);
	                break;
	                
	            case 5:
	            	System.out.println("\nStack-size: " + stack.size());
	                break;
	                
	            case 6:
	            	stack.clear();
	                break;
	        }
        } while (select != 0);
        
        System.out.println("\nProgram will be closed.\nSo long!");
	}
	
	public static void printStack(Stackable<Student> s) {
		s.print();
		System.out.println("Empty? " + s.isEmpty());
		System.out.println("Size: " + s.size());
	}
}

