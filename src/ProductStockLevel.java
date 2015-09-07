
public class ProductStockLevel {
	private static int StockLevels;
	
	

	public ProductStockLevel(){
		
	}
	
	public ProductStockLevel(int CurrentStockLevel){
		StockLevels = CurrentStockLevel;
		
	}
	
	public int getStockLevel(){
		return StockLevels;
	}
	
	public void addStockLevel(int amount){
		StockLevels += amount;
	}
	
	
	public void ItemRemoved(){
		StockLevels -= 1;
	}

}
