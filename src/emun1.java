
public class emun1 {
	public static void main(String[] args){
		Lamp la1 =  Lamp.green;
		System.out.println(la1);
		
	}
	public enum Lamp{
		red(1),green,yellow;
		private Lamp(){System.out.println("first");}
		private Lamp(int day){System.out.println("second");}
		public Lamp nextLamp(Lamp l){
			return l==red?green:yellow;
		}
	}
	public enum WeekDay{
		mon{
			public WeekDay nextDay(){
				return tue;
			}
		},tue{
			public WeekDay nextDay(){
				return mon;
			}
		};
		public abstract WeekDay nextDay();
	}
}
