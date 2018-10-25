//Дан класс OverloadTest с перегруженными методами print и статическим методом test.
//Удастся ли скомпилировать OverloadTest? Что выведет на консоль метод test?

public class OverloadTest {
	public void print(Object o1, Object o2) {
		System.out.println("Object, Object");
	}
	
	public void print(Number o1, Object o2) {
    	System.out.println("Number, Object");
    }
	
	public void print(Object o1, OverloadTest o2) {
    	System.out.println("Object, OverloadTest");
    }
	
	public void print(Double o1, Double o2) {
    	System.out.println("Double, Double");
    }
    
    public static void test() {
    	Object obj = new Double(1.0);
    	Object objNull = null;
    	
    	Object[][] objTwiceArray = new Object[10][10];    	
    	Number[][] numTwiceArray = new Number[10][10];
    	
    	OverloadTest overload = new OverloadTest();
    	
    	overload.print((Double)null, (Object)null);
    	overload.print(obj, objNull);
    	overload.print(null, obj);
    	overload.print(numTwiceArray, objTwiceArray);    	
    	overload.print(objTwiceArray, null);    	
    	overload.print(null, (Double)obj);    	
    }
}