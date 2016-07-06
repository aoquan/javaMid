package day2;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Vector;
import day1.*;

public class GenericTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		ArrayList collection1 = new ArrayList();
		collection1.add(1);
		collection1.add(1L);
		collection1.add("abc");
		//int i =(Integer)collection1.get(1);
		
		ArrayList<String> collection2 = new ArrayList<String>();
//		collection2.add(1);
//		collection2.add(1L);
		collection2.add("abc");
		String element = collection2.get(0);
		
		ArrayList<Integer> collection3 = new ArrayList<Integer>();
		
		//去类型化
		System.out.println(collection2.getClass() ==  collection3.getClass());
		
		//泛型是来给编译器看的，运行时会被去掉，通过反射可以透过泛型
		collection3.getClass().getMethod("add", Object.class).invoke(collection3, "abc");
		System.out.println(collection3.get(0));
		
		HashMap<String,Integer> maps = new HashMap<String,Integer>();
		maps.put("zxx", 28);
		maps.put("aaa", 18);
		maps.put("bbb", 33);
		
		Set<Map.Entry<String,Integer>> entrySet =  maps.entrySet();
		
		for(Map.Entry<String, Integer> entry:entrySet){
			System.out.println(entry.getKey()+ ":"+entry.getValue());
		}
		
		add(3,5);
		//int被自动装箱称Integer
		add(3.5,3);
		add(3,"abc");
		
		swap(new String[]{"abc","xyz","aquan"},1,2);
		
		//泛型的方法的实际参数不能是基本类型，只能使用引用类型
		//swap(new int[]{1,2,3,4,5},3,4);
		
		Object obj = "123";
		String x3 = autoConvert(obj);
		
		copy1(new Vector<String>(),new String[10]);//类型推断
		//copy1(new Vector<Date>(),new String[10]);//类型推断传播
		copy2(new Date[10],new String[10]);
		
		
		GenericDao<ReflectPoint> dao  = new GenericDao<ReflectPoint>();
		dao.add(new ReflectPoint(3,3));
		
		//Vector<Date> v1 = new Vector<Date>();
		
		//通过反射获取泛型的参数类型
		Method applyMethod = GenericTest.class.getMethod("applyVector", Vector.class);
		Type[] types = applyMethod.getGenericParameterTypes();
		ParameterizedType  pType = (ParameterizedType)types[0];
		System.out.println(pType.getRawType());
		System.out.println(pType.getActualTypeArguments()[0]);
		
	}
	
	public static void applyVector(Vector<Date> v1){
		
	}
	/*
	* 以下非重载，因为去类型化，该date以及Integer都是给编译器看的，运行过程中没有Vector<Date> 和 Vector<Integer>没有区别（字节码相同）
	public static void applyVector(Vector<Integer> v1){
		
	}
	*/
	
	private static <T> void fillArray(T[] a, T obj){
		for (int i=0;i<a.length;i++){
			a[i]=obj;
		}
	}
	private static <T> T autoConvert(Object obj){
		return (T)obj;
	}
	
	public static void printCollection1(Collection<?> collection){
		//使用？通配符时，不能调用与类型相关方法
		collection.size();
	}
	
	public static <T> void printCollection2(Collection<T> collection,T obj){
		//使用？通配符时，不能调用与类型相关方法
		System.out.println(collection.size());
		//collection.size();
		collection.add(obj);
	}
	
	public static <T> void copy1(Collection<T> dest,T[] src){
		
	}
	
	public static <T> void copy2(T[] dest,T[] src){
		//类型推断
		//类型传播
	}
	
	
	
	
	private static <T> T add(T x,T y){
		return y;
	}
	
	private static <T> void swap(T[] a,int i, int j){
		T tmp = a[i];
		a[i] = a[j];
		a[j] = tmp;
	}

}
