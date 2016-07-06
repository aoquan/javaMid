import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Properties;


public class ReflectTest2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		InputStream ips = new FileInputStream("config.properties");
		Properties props = new Properties();
		props.load(ips);
		ips.close();
		String ClassName = props.getProperty("ClassName");
		Collection co = (Collection)Class.forName(ClassName).newInstance();
		
		//Collection co = new HashSet();
		ReflectPoint r1 = new ReflectPoint(3,3);
		ReflectPoint r2 = new ReflectPoint(1,1);
		ReflectPoint r3 = new ReflectPoint(3,3);
		
		co.add(r1);
		co.add(r2);
		co.add(r3);
		co.add(r1);
		
		System.out.println(co.size());
		
	}

}
