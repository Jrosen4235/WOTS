import java.util.ArrayList;


public class OrderForm {
	
	private int CustomerID;
	private String DeliveryAddress;
	public ArrayList<OrderLine> Orderlines;
	
	public String toString(){
		
		return "Customer ID: "+CustomerID+" DeliveryAddress: "+DeliveryAddress;
	}
	
	public OrderForm(int ID, String Address){
		Orderlines =  new ArrayList<OrderLine>();
		CustomerID = ID;
		DeliveryAddress = Address;
	}
	
	public void addOrderLine(OrderLine ol){
		Orderlines.add(ol);
	}
	
	public void printOrderLines(){
		for(OrderLine ol: Orderlines){
			System.out.println(ol);
		}
	}
	

}
