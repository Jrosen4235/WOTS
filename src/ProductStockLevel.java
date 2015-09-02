
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
	
	public void setStockLevel(int level){
		StockLevels = level;
	}
	
	public void ItemRemoved(){
		StockLevels -= 1;
	}

}
