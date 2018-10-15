import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import java.lang.Integer;
@Periodic(period = 2)
public class TempTest {
	static int methodCount=0;	
	
    @Test
    @ExtendWith(PeriodicEnabling.class)
    //@ExtendWith is a way JUnit is allowing us to add our code to its methods or code
    public void testTrue() {
    	//count=count+1;
    	this.methodCount++;
        assertTrue(true);
        System.out.println("TestTrue Method Running ");
    }
    @Test
    @ExtendWith(PeriodicEnabling.class)
    public void testZero() {
    	 this.methodCount++;
         int val = 0; assertEquals(0, val);
         System.out.println("TestZero Method Running ");
    }
    @Test
    @ExtendWith(PeriodicEnabling.class)
    public void testZero2() {
    	this.methodCount++;
        assertEquals(0, "".length());
        System.out.println("TestZero2 Method Running ");
    }
    @Test
    @ExtendWith(PeriodicEnabling.class)
    public void testFalse() {
    	this.methodCount++;
        assertTrue(!false);
        System.out.println("TestFalse Method Running "); 
    }
}