package day2;

//import java.lang.annotation.Annotation;
import javax.jws.soap.InitParam;

@ItcastAnnotation(annotationAttr=@MetaAnnotation("fix"),color="red",value="abc",arrayAttr=1)
public class AnnotationTest {

	/**
	 * @param args
	 */
	@SuppressWarnings("deprecation")
	@ItcastAnnotation("abc")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.runFinalizersOnExit(true);
		if(AnnotationTest.class.isAnnotationPresent(ItcastAnnotation.class)){
			ItcastAnnotation annotation = (ItcastAnnotation) AnnotationTest.class.getAnnotation(ItcastAnnotation.class);
			System.out.println(annotation.color());
			System.out.println(annotation.arrayAttr().length);
			
			System.out.println(annotation.lamp().nextLamp().name());
			System.out.println(annotation.annotationAttr().value());
		}
	}
	
	@Deprecated
	public static void sayHello(){
		System.out.println("helloworld");
	}

}
