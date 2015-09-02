
public class StockItem {
	
	private static int StockItemID = 0;
	private String location;
	
	ProductStockLevel PSL = new ProductStockLevel();
	
	public StockItem(){
		PSL.setStockLevel(0);
		StockItemID = PSL.getStockLevel() + 1;
		
	}
	
	public StockItem(String Name, int StockLevel){
		PSL.setStockLevel(StockLevel);
		StockItemID = PSL.getStockLevel() + 1;
		
	}	
	
	public void Deliver(){
		PSL.ItemRemoved();	
	}
	
}
