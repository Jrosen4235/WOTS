import java.util.Scanner;


public class Menu {
	
	private static OrderList oList = new OrderList();
	
	static int swValue;
	static int swValue2;
	static int swValue3;
	static Scanner sc = new Scanner(System.in);
	static int stockID;
	static int customerID;
	static String address = null;
	static String houseNumber = null;
	static String streetName;
	static String town;
	static String porousWareAnswer;
	static OrderForm of; 
	static OrderLine oLine;
	static ProductStockLevel psl;
	static int StockLevel;

	
	public static void addOrder(){
		System.out.println("============================");
		System.out.println("|         ADD ORDER        |");
		System.out.println("============================");
		
		
		System.out.println("Enter Customer ID: ");
		customerID = sc.nextInt();
		System.out.println("Enter House Number: ");
		houseNumber = sc.next();
		System.out.println("Enter Street Name: ");
		streetName = sc.next();
		System.out.println("Enter town: ");
		town = sc.next();
		address = houseNumber+" "+streetName+" "+town;
		of  = new OrderForm(customerID,address);
		oList.addOrderForm(customerID,of);
		
	}
	
	public static void addItem(){
		
		System.out.println("============================");
		System.out.println("|         ADD ITEM         |");
		System.out.println("============================");
		System.out.println("Enter Stock ID: ");
		stockID = sc.nextInt();
		System.out.println("Does the item Need PorousWare?");
		System.out.println("yes/no: ");
		porousWareAnswer = sc.next();
		if(porousWareAnswer.equals("yes")){
			oLine = new OrderLine(true, stockID);
			
		}
		else{
			
			oLine = new OrderLine(false, stockID);
		}
		 of.addOrderLine(stockID,oLine);
		
		System.out.println("\n\nORDER ADDED!\n\n");
	}	

	public static void menuGenerator(){
		
		
		System.out.println("============================");
		System.out.println("|      MENU SELECTION      |");
		System.out.println("============================");
		System.out.println("| Options:                 |");
		System.out.println("|       1. Add Order       |");
		System.out.println("|       2. Order Status    |");
	    System.out.println("|       3. Pick Order      |");
	    System.out.println("|       4. Pack Order      |");
	    System.out.println("|       5. Porous Ware     |");
	    System.out.println("|       6. Add Item        |");
	    System.out.println("|       7. Update Stock    |");
	    System.out.println("|       8. Exit            |");
	    System.out.println("============================");
		System.out.println("Select Option: ");
		int swValue1;
		swValue1 = sc.nextInt();
		switch (swValue1) {
	    case 1:
			addOrder();
			addItem();		
			menuGenerator();
		 break;
	    case 2:
	    	System.out.println("============================");
			System.out.println("|      CURRENT ORDERS      |");
			System.out.println("============================");
	    	
	    	showOrders();
	    	System.out.println("Select order using Customer ID");
	    	/*oList.printOrders();
	    	System.out.println("");*/
	    	customerID = sc.nextInt();
	    	of = oList.selectOrder(customerID);
	    	of.printOrderLines();
	    	menuGenerator();
	      break;
	    case 3:
	    	System.out.println("============================");
	    	System.out.println("|    UPDATE PICKED STATUS  |");
	    	System.out.println("============================");
	    	showOrders();
	    	System.out.println("Select order using Customer ID: ");
	    	customerID = sc.nextInt();
	    	of = oList.selectOrder(customerID);
	    	of.printOrderLines();
	    	System.out.println("Pick order line using Stock ID");
	    	stockID = sc.nextInt();
	    	oLine = of.selectOrderLine(stockID);
	    	oLine.setPickedTrue();
	    	oLine.setPickedAnswer();
	    	System.out.println(oLine);
	    	menuGenerator();
	      break;
	    case 4:
	    	System.out.println("============================");
	    	System.out.println("|    UPDATE PACKED STATUS  |");
	    	System.out.println("============================");
	    	showOrders();System.out.println("Select order using Customer ID: ");
	    	customerID = sc.nextInt();
	    	of = oList.selectOrder(customerID);
	    	of.printOrderLines();
	    	oLine = of.selectOrderLine(stockID);
	    	oLine.setPackedTrue();
	    	oLine.setPackedAnswer();
	    	System.out.println(oLine);
	    	menuGenerator();
	    case 5:
	    	System.out.println("=============================");
	    	System.out.println("|         POROUS WARE       |");
	    	System.out.println("=============================");
	    	System.out.println("| Options:                  |");
			System.out.println("|      	1. Apply PorousWare |");
			System.out.println("|      	2. Check Levels     |");
			System.out.println("|       3. Fill Levels      |");
		    System.out.println("=============================");
		    System.out.println("Select Option: ");
		    swValue2 = sc.nextInt();
		    
		    switch(swValue2){
		    	case 1:
		    		System.out.println("=============================");
			    	System.out.println("|       Apply PorousWare    |");
			    	System.out.println("=============================");
			    	showOrders();
			    	System.out.println("Select order using Customer ID: ");
			    	customerID = sc.nextInt();
			    	of = oList.selectOrder(customerID);
			    	of.printOrderLines();
			    	System.out.println("Pick order line using Stock ID");
			    	stockID = sc.nextInt();
			    	oLine = of.selectOrderLine(stockID);
			    	System.out.println(oLine);
			    	if(oLine.getNeedsPorousWare()){
			    		oLine.setPorousWareAppliedTrue();
				    	oLine.setPorousWareAppliedAnswer();
			    	}
			    	else{
			    		System.out.println("This Item doesnt need PorousWare");
			    	}
			    	//System.out.println(oLine);
			    	menuGenerator();
		    		break;
		    	case 2:
		    		System.out.println("Not done Yet");
		    		break;
		    	case 3:
		    		System.out.println("Filled");
		    		break;
		    	default:
		    		System.out.println("Invalid selection");
		    } 
		    
		    
		    menuGenerator();
		    
	    case 6:
	    	System.out.println("============================");
	    	System.out.println("|    	 Add Item          |");
	    	System.out.println("============================");
	    	showOrders();
	    	System.out.println("Select order using Customer ID: ");
	    	customerID = sc.nextInt();
	    	of = oList.selectOrder(customerID);
	    	System.out.println("Enter Stock ID: ");
			stockID = sc.nextInt();
			System.out.println("Does the item Need PorousWare?");
			System.out.println("yes/no: ");
			porousWareAnswer = sc.next();
			if(porousWareAnswer.equals("yes")){
				oLine = new OrderLine(true, stockID);
				
			}
			else{
				
				oLine = new OrderLine(false, stockID);
			}
			 of.addOrderLine(stockID,oLine);
			
			System.out.println("\n\nORDER ADDED!\n\n");
	    	
			 menuGenerator();
	    case 7:
	    	
	    case 8:
	    	System.out.println("============================");
	    	System.out.println("|    	  Add Stock        |");
	    	System.out.println("============================");
	    	System.out.println("Current Stock Levels Are: " + psl.getStockLevel());
	    	StockLevel = psl.getStockLevel();
	    	System.out.println("Add Stock: ");
	    	int amount = sc.nextInt();
	    	psl.addStockLevel(amount);
	    	System.out.println("New Stock Levels Are: ");
	    	System.out.println(psl.getStockLevel());
	    	
	    default:
	      System.out.println("Invalid selection");
	      break;  
	    }
		
	}
	
	public static void showOrders(){
		oList.printOrders();
    	
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		psl = new ProductStockLevel(1000);
		
		
		System.out.println("============================");
		System.out.println("|      MENU SELECTION      |");
		System.out.println("============================");
		System.out.println("| Options:                 |");
		System.out.println("|       1. Add Order       |");
		System.out.println("|       2. Order Status    |");
	    System.out.println("|       3. Pick Order      |");
	    System.out.println("|       4. Pack Order      |");
	    System.out.println("|       5. Porous Ware     |");
	    System.out.println("|       6. Add Item        |");
	    System.out.println("|       7. Update Stock    |");
	    System.out.println("|       8. Exit            |");
	    System.out.println("============================");
	    
	    System.out.println("Select Option: ");
	    swValue = sc.nextInt();
	    
	    switch (swValue) {
	    case 1:
			addOrder();
			addItem();
			menuGenerator();
			
			
		 break;
	    case 2:
	    	
	    	System.out.println("============================");
			System.out.println("|      CURRENT ORDERS      |");
			System.out.println("============================");
	    	
	    	showOrders();
	    	System.out.println("Select order using Customer ID");
	    	customerID = sc.nextInt();
	    	of = oList.selectOrder(customerID);
	    	of.printOrderLines();
	    	menuGenerator();
	      break;
	    case 3:
	    	System.out.println("============================");
	    	System.out.println("|    UPDATE PICKED STATUS  |");
	    	System.out.println("============================");
	    	showOrders();
	    	System.out.println("Select order using Customer ID: ");
	    	customerID = sc.nextInt();
	    	of = oList.selectOrder(customerID);
	    	System.out.println("Pick order line using Stock ID");
	    	stockID = sc.nextInt();
	    	oLine = of.selectOrderLine(stockID);
	    	oLine.setPickedTrue();
	    	System.out.println(oLine);
	    	menuGenerator();
	    	
	    	//System.out.println("Enter Customer ID");
	    	
	      break;
	    case 4:
	    	System.out.println("============================");
	    	System.out.println("|    UPDATE PACKED STATUS  |");
	    	System.out.println("============================");
	    	showOrders();System.out.println("Select order using Customer ID: ");
	    	customerID = sc.nextInt();
	    	of = oList.selectOrder(customerID);
	    	System.out.println("Select order lines using Stock ID: ");
	    	stockID = sc.nextInt();
	    	oLine = of.selectOrderLine(stockID);
	    	oLine.setPackedTrue();
	    	oLine.setPackedAnswer();
	    	System.out.println(oLine);
	    	menuGenerator();
	    case 5:
	    	System.out.println("=============================");
	    	System.out.println("|         POROUS WARE       |");
	    	System.out.println("=============================");
	    	System.out.println("| Options:                  |");
			System.out.println("|      	1. Apply PorousWare |");
			System.out.println("|      	2. Check Levels     |");
			System.out.println("|       3. Fill Levels      |");
		    System.out.println("=============================");
		    System.out.println("Select Option: ");
		    swValue2 = sc.nextInt();
		    
		    System.out.println("=============================");
	    	System.out.println("|         POROUS WARE       |");
	    	System.out.println("=============================");
	    	System.out.println("| Options:                  |");
			System.out.println("|      	1. Apply PorousWare |");
			System.out.println("|      	2. Check Levels     |");
			System.out.println("|       3. Fill Levels      |");
		    System.out.println("=============================");
		    System.out.println("Select Option: ");
		    swValue2 = sc.nextInt();
		    
		    switch(swValue2){
		    	case 1:
		    		System.out.println("=============================");
			    	System.out.println("|       Apply PorousWare    |");
			    	System.out.println("=============================");
			    	showOrders();
			    	System.out.println("Select order using Customer ID: ");
			    	customerID = sc.nextInt();
			    	of = oList.selectOrder(customerID);
			    	of.printOrderLines();
			    	System.out.println("Pick order line using Stock ID");
			    	stockID = sc.nextInt();
			    	oLine = of.selectOrderLine(stockID);
			    	if(oLine.getNeedsPorousWare()){
			    		oLine.setPorousWareAppliedTrue();
				    	oLine.setPorousWareAppliedAnswer();
			    	}
			    	else{
			    		System.out.println("This Item doesnt need PorousWare");
			    	}
			    	//System.out.println(oLine);
			    	menuGenerator();
		    		break;
		    	case 2:
		    		System.out.println("Not done Yet");
		    		break;
		    	case 3:
		    		System.out.println("Filled");
		    		break;
		    	default:
		    		System.out.println("Invalid selection");
		    } 
		    
		    
		    
		    menuGenerator();
		    
	    case 6:
	    	System.out.println("============================");
	    	System.out.println("|    	 Add Item          |");
	    	System.out.println("============================");
	    	showOrders();
	    	System.out.println("Select order using Customer ID: ");
	    	customerID = sc.nextInt();
	    	of = oList.selectOrder(customerID);
	    	System.out.println("Enter Stock ID: ");
			stockID = sc.nextInt();
			System.out.println("Does the item Need PorousWare?");
			System.out.println("yes/no: ");
			porousWareAnswer = sc.next();
			if(porousWareAnswer.equals("yes")){
				oLine = new OrderLine(true, stockID);
				
			}
			else{
				
				oLine = new OrderLine(false, stockID);
			}
			 of.addOrderLine(stockID,oLine);
			
			System.out.println("\n\nORDER ADDED!\n\n");
			 menuGenerator();
	    case 7:
	    	System.out.println("============================");
	    	System.out.println("|    	  Update Stock     |");
	    	System.out.println("============================");
	    	System.out.println("| Options:                 |");
			System.out.println("|   1. Current Stock Levels|");
			System.out.println("|   2. Add Stock           |");
			System.out.println("|   3. Remove Stock        |");
		    System.out.println("=============================");
		    System.out.println("Select Option: ");
		    swValue3 = sc.nextInt();
		    /*switch(swValue3){
		    case 1
		    
		    }*/
	    	System.out.println("Current Stock Levels Are: " +"\n"+ psl.getStockLevel());
	    	StockLevel = psl.getStockLevel();
	    	System.out.println("Add Stock: ");
	    	int amount = sc.nextInt();
	    	psl.addStockLevel(amount);
	    	System.out.println("New Stock Levels Are: ");
	    	System.out.println(psl.getStockLevel());
	    	menuGenerator();
	    case 8:
	    	System.out.println("============================");
	    	System.out.println("|    	    BYE!           |");
	    	System.out.println("============================");
	    	System.exit(0);
	    default:
	      System.out.println("Invalid selection");
	      break;  
	    }
	    
	   
	}
	
	

}
