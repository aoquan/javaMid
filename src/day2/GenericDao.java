package day2;

import java.util.Set;

// dao: data access object ---> c(create) r(retrieval) u(update) d(delete)
public class GenericDao<T> {
	public void add(T x){
		
	}
	
	public T findById(int id){
		return null;
	}
	
	public void delete(T obj){
		
	}
	
	public void delete(int id){
		
	}
	
	public void update(T obj){
		
	}
	
	public Set<T> findByConditions(String where){
		return null;
	}
	
	/*
	 * 静态方法和成员没有泛型，例如以下
	public static void update2(T obj){
		
	}
	*/
}
