package application;



import model.entities.Department;
import model.entities.Seller;

public class program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Department obj = new Department(1, "books");
		
		Seller seller = new Seller(1, "cristian", "cris@gmail.com", new Date() , 3.000, obj);
		System.out.println(obj);
	}

}
