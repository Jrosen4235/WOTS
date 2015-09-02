
public class StockItem {
	
	private static int StockItemID = 0;
	private String location;
	
	

	
	public StockItem(int ID){
		StockItemID = ID;
		
	}
	
	
	public void Deliver(OrderLine o, ProductStockLevel psl){			
		psl.ItemRemoved();
		o.setDeliveredTrue();
	}
	
	public void PackItem(OrderLine o){
		o.setPackedTrue();
	}
	
	public void PickItem(OrderLine o){
		o.setPickedTrue();
	}
	
	public void ApplyPorousWare(OrderLine o){
		o.setPorousWareAppliedTrue();
	}
	
	
}
