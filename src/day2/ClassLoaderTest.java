package day2;

public class ClassLoaderTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(ClassLoaderTest.class.getClassLoader().getClass().getName());
		
		//BootStrap类加载器，加载System类
		System.out.println(System.class.getClassLoader());
		
		ClassLoader loader = ClassLoaderTest.class.getClassLoader();
		
		while(loader !=null){
			System.out.println(loader.getClass().getName());
			loader = loader.getParent();
		}
		System.out.println(loader);
		
		System.out.println(new ClassLoaderAttachment().toString());
		
		
	}

}
