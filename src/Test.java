
public class Test {
	public static void main(String[] args){
		/*test 1
		//Create Stock Levels For test
		ProductStockLevel psl = new ProductStockLevel(1000);
		
		// create order
		OrderLine o = new OrderLine(123, "brookrise", true, 123);
		StockItem Product = o.getProduct();
		
		//PickOrder
		Product.PickItem(o);
		
		//Show order Picked Status
		System.out.println("Picked - " + o.getPicked());
		
		
		//PackOrder
		Product.PackItem(o);
		
		//Show order packed Status
		System.out.println("Packed - " + o.getPacked());
		
		//Deliver the order
		Product.Deliver(o,psl);
		
		//Show order delivered Status;
		System.out.println("Delivered - " + o.getDelivered());
		
		//Show the new Stock Levels
		System.out.println("Current Stock Levels " + psl.getStockLevel());
		*/
		
		//test2
		
		//create OrderForm
		OrderList oList = new OrderList();
		OrderForm of  = new OrderForm(123,"29 Brook Rise");
		OrderForm of1 = new OrderForm(124, "19 Tudor Close");
		
		
		OrderLine oLine = new OrderLine(true, 10);
		OrderLine oLine1 = new OrderLine(true, 15);
		
		
		of.addOrderLine(oLine);
		of1.addOrderLine(oLine1);
		oList.addOrderForm(123, of);
		oList.addOrderForm(124,of1);
		oList.printOrders();
		int ID = oList.promptSelectOrder();
		of = oList.selectOrder(ID);
		of.printOrderLines();

		
		
		
		
		
		 
		
	
		
		
		
		
	}
}
