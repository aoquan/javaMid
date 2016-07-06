import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.PropertyUtils;

import day2.AnnotationTest;


public class IntroSpectorTest {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		
		
		ReflectPoint rp1 = new ReflectPoint(3,5);
		String propertyName = "x";
		
		Object retVal = getProperty(rp1, propertyName);
		System.out.println(retVal);
		
		Object value=7;
		setProperty(rp1, propertyName, value);
		
		System.out.println(BeanUtils.getProperty(rp1, propertyName));
		
		BeanUtils.setProperty(rp1, propertyName, "9");
		System.out.println(rp1.getX());
		
		BeanUtils.setProperty(rp1, "birthday.time", "111");
		System.out.println(BeanUtils.getProperty(rp1, "birthday.time"));
		//Map map = {name:"aquan",age:18};
		//BeanUtils.setProperty(map, "name", "haha");
		PropertyUtils.setProperty(rp1, "x", 10);
		System.out.println(PropertyUtils.getProperty(rp1, propertyName));

	}

	private static void setProperty(Object rp1, String propertyName,
			Object value) throws IntrospectionException,
			IllegalAccessException, InvocationTargetException {
		PropertyDescriptor pd2 = new PropertyDescriptor(propertyName,rp1.getClass());
		Method methodSet = pd2.getWriteMethod();
		methodSet.invoke(rp1, value);
	}

	private static Object getProperty(Object rp1, String propertyName)
			throws IntrospectionException, IllegalAccessException,
			InvocationTargetException {
		/*
		PropertyDescriptor pd = new PropertyDescriptor(propertyName,rp1.getClass());
		Method methodGet = pd.getReadMethod();
		Object retVal = methodGet.invoke(rp1);
		*/
		Object retVal=null;
		BeanInfo beanInfo = Introspector.getBeanInfo(rp1.getClass());
		PropertyDescriptor [] pds = beanInfo.getPropertyDescriptors();
		for(PropertyDescriptor pd : pds){
			if(pd.getName().equals(propertyName)){
				Method methodGetX = pd.getReadMethod();
				retVal = methodGetX.invoke(rp1);
			}
		}
		return retVal;
	}

}
