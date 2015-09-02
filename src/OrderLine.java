public class OrderLine {
	
	
	
	//Flags. True means yes and false means no
	private boolean picked = false;
	private String pickedAnswer = "No";
	private boolean packed = false;
	private String packedAnswer = "No";
	private boolean NeedsPorousWare = false;
	private String NeedsPorousWareAnswer = "No";
	private boolean PourousWareApplied = false;
	private String PourousWareAppliedAnswer = "No";
	private int StockItemID;
	private boolean Delivered = false;
	private String DeliveredAnswer = "No";
	private StockItem SI;
	
	
	public OrderLine( boolean YesNo,int ID){
	
			NeedsPorousWare = YesNo;
			setNeedsPorousWareAnswer();
		StockItemID = ID;
		SI = new StockItem(StockItemID);
	}
	
	
	public StockItem getStockItem(){
		return SI;
	}
	
	//getters
	public boolean getPicked(){
		return picked;
	};
	
	public boolean getPacked(){
		return packed;
	}
	
	public boolean getNeedsPorousWare(){
		return NeedsPorousWare;
	}
	
	public boolean getPorousWareApplied(){
		return PourousWareApplied;
	}
	
	public boolean getDelivered(){
		return Delivered;
	}
	
	public StockItem getProduct(){
		return SI;
	}
	
	
	
	
	
	//setters
	public void setPickedTrue(){
		picked = true; 
	}
	
	public void setPickedFalse(){
		picked = false;
	}
	
	
	public void setPackedTrue(){
		packed = true;
	}
	
	public void setPackedFalse(){
		packed = false;
	}
	
	public void setPorousWareAppliedTrue(){
		PourousWareApplied = true;
	}
	
	public void setNeedsPorousWareTrue(){
		NeedsPorousWare = true;
	}
	
	public void setDeliveredTrue(){
		Delivered = true;
	}
	
	//answers for Select an order prompt
	public void setPackedAnswer(){
		if(packed){
			packedAnswer = "Yes";
		}
		
		else{
			packedAnswer = "No";
		}
	}
		
	public void setNeedsPorousWareAnswer(){
		if(NeedsPorousWare){
			NeedsPorousWareAnswer = "Yes";
		}
		else{
			NeedsPorousWareAnswer = "No";
		}
	}
	
	
	public String toString(){
		return "\n\nStock Item ID: " + StockItemID +"\n"+ "Packed? " +packedAnswer + "\n" + "Picked? " 
	           + pickedAnswer + "\n" + "Delivered? "+ DeliveredAnswer
	           +"\n" + "Porousware Needed? " + NeedsPorousWareAnswer +"\n" + "Porousware applied? "+ 
			   PourousWareAppliedAnswer + "\n\n"; 
	}
	

}
