import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import data.*;
import stack.*;

public class TestE03 {
	private static Student student1, student2, student3, student4, student5, student6;
    private Stackable<Student> stack;
    
	@BeforeClass
	public static void before() throws Exception {
		student1 = new Student("Arnold", "Anderson", 1, CourseList.law);
		student2 = new Student("Billy", "Brisk", 2, CourseList.music);
		student3 = new Student("Chris", "Colper", 3, CourseList.science);
		student4 = new Student("Daniel", "Deen", 4, CourseList.maths);
		student5 = new Student("Enrico", "Enderle", 5, CourseList.law);
		student6 = new Student("Frank", "Filardo", 6, CourseList.law);
	}

    @Before
    public void setUp() throws Exception {
    	stack = new Stack<Student>();
        stack.push(student1);
        stack.push(student2);
        stack.push(student3);
        stack.push(student4);
        stack.push(student5);
        stack.push(student6);
    }

    @Test
    public void push() throws Exception {
		assertEquals(student6, stack.peek());
    }
    
	@Test
	public void pop() {
		stack.pop();
		assertEquals(student5, stack.peek());
	}
  
	@Test
	public void print() {
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		System.setOut(new PrintStream(output));
		String match = 
    	    "Student [ prename = Frank, surname = Filardo, matriculation number = 6, course = law ]\n" +
	    	"Student [ prename = Enrico, surname = Enderle, matriculation number = 5, course = law ]\n" +
	        "Student [ prename = Daniel, surname = Deen, matriculation number = 4, course = maths ]\n" +
	        "Student [ prename = Chris, surname = Colper, matriculation number = 3, course = science ]\n" +
	        "Student [ prename = Billy, surname = Brisk, matriculation number = 2, course = music ]\n" +
	        "Student [ prename = Arnold, surname = Anderson, matriculation number = 1, course = law ]\n";
        stack.print();
        assertEquals(match, output.toString());
    }
	/*  
	@Test
	public void print() {
		StringWriter buf = new StringWriter();
		PrintWriter out = new PrintWriter(buf);
		stack.print();
		String match = 
    	    "Student [ prename = Frank, surname = Filardo, matriculation number = 6, course = law ]\n" +
	    	"Student [ prename = Enrico, surname = Enderle, matriculation number = 5, course = law ]\n" +
	        "Student [ prename = Daniel, surname = Deen, matriculation number = 4, course = maths ]\n" +
	        "Student [ prename = Chris, surname = Colper, matriculation number = 3, course = science ]\n" +
	        "Student [ prename = Billy, surname = Brisk, matriculation number = 2, course = music ]\n" +
	        "Student [ prename = Arnold, surname = Anderson, matriculation number = 1, course = law ]\n";
        
        assertEquals(match, buf.toString());
    }*/
        /*
Student [ prename = Frank, surname = Filardo, matriculation number = 6, course = law ]
Student [ prename = Enrico, surname = Enderle, matriculation number = 5, course = law ]
Student [ prename = Daniel, surname = Deen, matriculation number = 4, course = maths ]
Student [ prename = Chris, surname = Colper, matriculation number = 3, course = science ]
Student [ prename = Billy, surname = Brisk, matriculation number = 2, course = music ]
Student [ prename = Arnold, surname = Anderson, matriculation number = 1, course = law ]
     */
    @Test
    public void size(){
        assertEquals(6, stack.size());
    }
    
    @Test
    public void clear(){
        stack.clear();
        assertEquals(0, stack.size());
    }
}
