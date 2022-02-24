package labs.lab8;

import java.util.ArrayList;
import java.util.Collection;

public class Person {
	private String aName = "";

	
	public Person(String aName) {
		this.aName = aName;
	}
	
	public String getName() {return aName;}

	//Declaring two generic types that will be used with return type of an ArrayList.
	// The generic method takes in a generic type T list1, and generic type S list2.
	// S must be a subtype or the T type.
	public static <S extends T, T> void problem3_append(ArrayList<T> a, ArrayList<S> b) {
		{


			
			//System.out.println("Arraylist A: " + a);
			//System.out.println("Arraylist B: "  + b + "\n");
			//System.out.println(a.get(0).getClass());
			
			for (int i = 0; i < b.size(); i++) {
				a.add(b.get(i));
			}
			
			
			//System.out.println("\n" + a);
			
			}
				

			
	}
	




	public static void main(String[] args) {
        ArrayList<Person> a = new ArrayList<>();
        ArrayList<Student> b = new ArrayList<>();
        ArrayList<String> c = new ArrayList<>();
        
        a.add(new Person("Fred"));
        a.add(new Person("Sally"));
        b.add(new Student("Bob", "Bioinformatics"));
        b.add(new Student("Rubia", "Computer Science"));
        problem3_append(a,b);
        
        for (Person ele: a) {
        	System.out.println(ele.getName());
        }
        
        System.out.println(a.containsAll(b));

        
	}

}
