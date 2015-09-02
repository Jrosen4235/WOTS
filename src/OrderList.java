import java.util.HashMap;
import java.util.Scanner;



public class OrderList {

	private HashMap<Integer,OrderForm> Orders ;
	private int CustomerIDChoice;
	
	
	public OrderList(){
		
		Orders =  new HashMap<Integer,OrderForm>();
		
	}
	
	public void addOrderForm(int CustomerID, OrderForm of){
		Orders.put( CustomerID, of); 
	}
	
	public void printOrders(){
		Orders.forEach((CustomerID,OrderForm)->System.out.println(OrderForm));
		
	}
	
	public int promptSelectOrder(){
		System.out.println("\nSelect an Order (Using Customer ID): ");
		Scanner sc = new Scanner(System.in);
		return CustomerIDChoice = sc.nextInt();
	}
	
	public OrderForm/*void*/ selectOrder(int ID/*,OrderForm of*/){
		return/*of=*/ Orders.get(ID);
		//of.printOrderLines();
	}
}

