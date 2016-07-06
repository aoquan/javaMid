package day1;

public class ForTest {
	public static void main(String[] args){
		System.out.println(sum(1,2,3,4,5));
	}
	public static int sum(int a, int ... args){
		for(int arg:args){
			a += arg;
		}
		return a;
	}
}
