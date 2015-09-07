import java.util.ArrayList;
import java.util.HashMap;


public class OrderForm {
	
	private int CustomerID;
	private String DeliveryAddress;
	//public ArrayList<OrderLine> Orderlines;
	private HashMap<Integer,OrderLine> Orderlines;
	
	public String toString(){
		
		return "Customer ID: "+CustomerID+"\nDelivery Address: "+DeliveryAddress;
	}
	
	public OrderForm(int ID, String Address){
		//Orderlines =  new ArrayList<OrderLine>();
		Orderlines = new HashMap<Integer,OrderLine>();
		CustomerID = ID;
		DeliveryAddress = Address;
	}
	
	public void addOrderLine(int ID,OrderLine ol){
		//Orderlines.add(ol);
		Orderlines.put(ID,ol);
		
	}
	
	public void printOrderLines(){
		/*for(OrderLine ol: Orderlines){
			System.out.println(ol);
		}*/
		Orderlines.forEach((CustomerID,OrderForm)->System.out.println(OrderForm+"\n"));
	}
	
	public OrderLine/*void*/ selectOrderLine(int ID/*,OrderForm of*/){
		return/*of=*/ Orderlines.get(ID);
		//of.printOrderLines();
	}
	
	

}
