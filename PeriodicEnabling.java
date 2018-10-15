import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Method;
import java.lang.reflect.Field;
import java.util.Optional;

import org.junit.jupiter.api.extension.ConditionEvaluationResult;
import org.junit.jupiter.api.extension.ExecutionCondition;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.platform.commons.support.AnnotationSupport;

public class PeriodicEnabling implements ExecutionCondition {
	@Override
	public ConditionEvaluationResult evaluateExecutionCondition(ExtensionContext context) {		
				
				//Get Period annotation value to schedule the test cases accordingly 
			    Annotation an=context.getTestClass().get().getAnnotation(Periodic.class);
				Periodic p =(Periodic)an;				
				int period=p.period();
				//System.out.println("Period "+period);
				TempTest t=new TempTest();
				//Using Reflection API to get test number (methodNum) from of class
				Class<?> c = t.getClass();
			    try {
					Field chap = c.getDeclaredField("methodCount");
				} catch (NoSuchFieldException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SecurityException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			    
			    
			   // System.out.println("t.methodNum "+t.methodCount);
			    
				//Choosing 2 methods from available methods 
			    if((t.methodCount)%period == 0) {
			    	//System.out.println("(t.methodNum)%period  "+(t.methodCount)%period);
			    	
			    	return ConditionEvaluationResult.enabled("Enable test");
			    }
			    
			    else {
			    	  t.methodCount++;
		              return  ConditionEvaluationResult.disabled("Disabled test");
			    }

		}
	}
