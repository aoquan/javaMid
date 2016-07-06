package day1;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;


public class Reflect1Test {
	public static void main(String[] args) throws Exception{
		String str1 = "abc";
		Class cls1 = str1.getClass();
		Class cls2 = String.class;
		Class cls3 = Class.forName("java.lang.String");
		System.out.println(cls1==cls2);
		System.out.println(cls1==cls3);
		System.out.println(cls1.isPrimitive());
		System.out.println(int.class.isPrimitive());
		System.out.println(int.class==Integer.class);
		System.out.println(int.class == Integer.TYPE);
		System.out.println(int[].class.isArray());
		
//		Constructor con = String.class.getConstructor(StringBuffer.class);
//		String str = con.newInstance(new StringBuffer("abc")).toString();
		
		Constructor<String> con = String.class.getConstructor(StringBuffer.class);
		String str = con.newInstance(new StringBuffer("abc"));
		
		System.out.println(str);
		
		ReflectPoint rp1 = new ReflectPoint(3,5);
		Field fieldX = rp1.getClass().getDeclaredField("x");
		fieldX.setAccessible(true);
		System.out.println(fieldX.get(rp1));
		
		ChangeStringValue(rp1);
		System.out.println(rp1.toString());
		
		Method methodCharAt = String.class.getMethod("charAt", int.class);
		System.out.println(methodCharAt.invoke(str1, 1));
		
		//TestArgument.main(new String [] {"111","222"});
		Method mainMethod = Class.forName("TestArgument").getMethod("main", String[].class);
		mainMethod.invoke(null, (Object)new String[]{"111","222","333"});
		
		int [] a1 = new int[3];
		int [] a2 = new int[4];
		int [][] a3 = new int[2][3];
		String [] a4 = new String[3];
		int [][] a5 =new int [3][4];
		
		System.out.println(a1.getClass() == a2.getClass());
		//System.out.println(a1.getClass() == a3.getClass());
		//System.out.println(a1.getClass() == a4.getClass());
		System.out.println(a3.getClass() == a5.getClass());
		System.out.println(a1.getClass().getName());
		System.out.println(a1.getClass().getSuperclass().getName());
		System.out.println(a4.getClass().getSuperclass().getName());
	}

	private static void ChangeStringValue(Object obj) throws Exception {
		// TODO Auto-generated method stub
		Field [] fields = obj.getClass().getFields();
		for (Field field : fields){
			if(field.getType() == String.class){
				String oldString = (String)field.get(obj);
				String newString = oldString.replace('a', 'x');
				field.set(obj, newString);
			}
		}
	}
}

class TestArgument{
	public static void main(String [] args){
		for(String arg: args){
			System.out.println(arg);
		}
	}
}