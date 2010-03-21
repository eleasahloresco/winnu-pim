package winnu.control;

import java.util.List;

import org.apache.torque.TorqueException;

import winnu.dao.Item;
import winnu.dao.ItemBatch;
import winnu.dao.ItemBatchPeer;
import winnu.dao.ItemPeer;
import winnu.dao.StockedItem;
import winnu.dao.StockedItemPeer;
import winnu.dao.WithdrawnItem;
import winnu.dao.WithdrawnItemPeer;

public class ReportController {

	public static List<Item> retrieveFromItem(){

		return (List<Item>)ItemPeer.retrieveAllItems();
		
	}
	
	public static Object[][] retrieveAvailableInventory(){
		List<Item> list = ReportController.retrieveFromItem();
        Item item;
        StockedItem stockedItem;
        ItemBatch itemBatch;

        Object[][] modelObject = new Object[list.size()][];         
        
        for(int i=0; i< list.size(); i++){
        	item = list.get(i);
        	itemBatch = ItemBatchPeer.retrieveItemLatestBatch(item.getItemId(), item.getNextBatch());
        	stockedItem = StockedItemPeer.retrieveAllItemBatchId(itemBatch.getItemBatchId()).get(0);
        	
        	Object[] model = null;
			try {
				model = new Object[]{item.getItemId(),item.getBrandName() ,item.getGenericName(),itemBatch.getSupplier().getSupplierName(), ItemPeer.getTotalQuantity(item.getBrandName()), "pcs", itemBatch.getAcquisitionCost(), stockedItem.getCurrentPrice()};
	        	modelObject[i]= model;     
			} catch (TorqueException e) {
				e.printStackTrace();
			}
        }           
        
        return modelObject;        
	}
	
	public static Object[][] retrieveAvailableInventoryByGenericName(){
		List<Item> list = ReportController.retrieveFromItem();
        Item item;
        StockedItem stockedItem;
        ItemBatch itemBatch;

        Object[][] modelObject = new Object[list.size()][];         
        
        for(int i=0; i< list.size(); i++){
        	item = list.get(i);
        	itemBatch = ItemBatchPeer.retrieveItemLatestBatch(item.getItemId(), item.getNextBatch());
        	stockedItem = StockedItemPeer.retrieveAllItemBatchId(itemBatch.getItemBatchId()).get(0);
        	
        	Object[] model = null;
			try {
				model = new Object[]{item.getItemId(),item.getBrandName() ,itemBatch.getSupplier().getSupplierName(), ItemPeer.getTotalQuantity(item.getBrandName()), "pcs", itemBatch.getAcquisitionCost(), stockedItem.getCurrentPrice()};
	        	modelObject[i]= model;     
			} catch (TorqueException e) {
				e.printStackTrace();
			}
        }           
        
        return modelObject;        
	}
	

	public static Object[][] retrieveAvailableInventoryBySupplier(){
		List<Item> list = ReportController.retrieveFromItem();
        Item item;
        StockedItem stockedItem;
        ItemBatch itemBatch;

        Object[][] modelObject = new Object[list.size()][];         
        
        for(int i=0; i< list.size(); i++){
        	item = list.get(i);
        	itemBatch = ItemBatchPeer.retrieveItemLatestBatch(item.getItemId(), item.getNextBatch());
        	stockedItem = StockedItemPeer.retrieveAllItemBatchId(itemBatch.getItemBatchId()).get(0);
        	
        	Object[] model = null;
			model = new Object[]{item.getItemId(),item.getBrandName(), item.getGenericName(), ItemPeer.getTotalQuantity(item.getBrandName()), "pcs", itemBatch.getAcquisitionCost(), stockedItem.getCurrentPrice()};
			modelObject[i]= model;
        }           
        
        return modelObject;        
	}
	
	public static Object[][] retrieveItemsForReorder(){
		List<Item> list = ReportController.retrieveFromItem();
        Item item;
        StockedItem stockedItem;
        ItemBatch itemBatch;
        int count=0;

        for(int i=0; i< list.size(); i++){
        	item = list.get(i);
        	
        	if(ItemPeer.getTotalQuantity(item.getBrandName()) < item.getMinimumSupplyLimit() ){
        		count++;
        	}
        }           
        
        Object[][] modelObject = new Object[count][];         
        
        count=0;
        for(int i=0; i< list.size(); i++){
        	item = list.get(i);
        	itemBatch = ItemBatchPeer.retrieveItemLatestBatch(item.getItemId(), item.getNextBatch());
        	stockedItem = StockedItemPeer.retrieveAllItemBatchId(itemBatch.getItemBatchId()).get(0);
        	
        	if(ItemPeer.getTotalQuantity(item.getBrandName()) < item.getMinimumSupplyLimit() ){
        		Object[] model = null;
					try {
						model = new Object[]{item.getItemId(),item.getBrandName(), item.getGenericName(), itemBatch.getSupplier().getSupplierName(), ItemPeer.getTotalQuantity(item.getBrandName()), "pcs", itemBatch.getAcquisitionCost(), stockedItem.getCurrentPrice()};
					} catch (TorqueException e) {
						e.printStackTrace();
					}
				
				modelObject[i-1]= model;
				count++;
        	}
        	
        	else{
        		count--;
        		
        	}
        }           
        
        return modelObject;        
	}
	
	public static Object[][] retrieveWithdrawnItem(){
		List<WithdrawnItem> list = WithdrawnItemPeer.retrieveAll();
        WithdrawnItem item;
        ItemBatch itemBatch;
        Item itemName;

        Object[][] modelObject = new Object[list.size()][];         
        
        for(int i=0; i< list.size(); i++){
        	item = list.get(i);
        	itemBatch = ItemBatchPeer.retrieveItemBatch(item.getItemBatchId());
        	itemName = ItemPeer.retrieveItem(itemBatch.getItemId());
        	
        	Object[] model = null;
			try {
				model = new Object[]{item.getDateWithdrawn(),item.getSaleId(), itemBatch.getItemId(), itemName.getBrandName() , itemName.getGenericName(), itemBatch.getSupplier().getSupplierName(), item.getSale().getCustomerName(), item.getQuantity(), "pcs", itemBatch.getAcquisitionCost(), item.getSellingPrice()};
			} catch (TorqueException e) {
				// TODO Auto-generated catch block
				System.out.println("hay");
				e.printStackTrace();
			}
			modelObject[i]= model;
        }           
        
        return modelObject;        
	}
	

	public static Object[][] retrieveSales(){
		List<WithdrawnItem> list = WithdrawnItemPeer.retrieveAll();
        WithdrawnItem item;
        ItemBatch itemBatch;
        Item itemName;

        Object[][] modelObject = new Object[list.size()][];         
        
        for(int i=0; i< list.size(); i++){
        	item = list.get(i);
        	itemBatch = ItemBatchPeer.retrieveItemBatch(item.getItemBatchId());
        	itemName = ItemPeer.retrieveItem(itemBatch.getItemId());
        	
        	Object[] model = null;
			try {
				model = new Object[]{item.getDateWithdrawn(),item.getSaleId(), itemBatch.getItemId(), itemName.getBrandName() , itemName.getGenericName(), itemBatch.getSupplier().getSupplierName(), item.getSale().getCustomerName(), item.getQuantity(), "pcs", itemBatch.getAcquisitionCost(), item.getSellingPrice(), item.getReason()};
			} catch (TorqueException e) {
				// TODO Auto-generated catch block
				System.out.println("hay");
				e.printStackTrace();
			}
			modelObject[i]= model;
        }           
        
        return modelObject;        
	}
	
	public static Object[][] retrieveSalesPerPatient(){
		List<WithdrawnItem> list = WithdrawnItemPeer.retrieveAll();
        WithdrawnItem item;
        ItemBatch itemBatch;
        Item itemName;

        Object[][] modelObject = new Object[list.size()][];         
        
        for(int i=0; i< list.size(); i++){
        	item = list.get(i);
        	itemBatch = ItemBatchPeer.retrieveItemBatch(item.getItemBatchId());
        	itemName = ItemPeer.retrieveItem(itemBatch.getItemId());
        	
        	Object[] model = null;
			try {
				model = new Object[]{item.getDateWithdrawn(),item.getSaleId(), itemBatch.getItemId(), itemName.getBrandName() , itemName.getGenericName(), itemBatch.getSupplier().getSupplierName(), item.getQuantity(), "pcs", itemBatch.getAcquisitionCost(), item.getSellingPrice(), item.getReason()};
			} catch (TorqueException e) {
				// TODO Auto-generated catch block
				System.out.println("hay");
				e.printStackTrace();
			}
			modelObject[i]= model;
        }           
        
        return modelObject;        
	}
	
	public static Object[][] retrieveSRDP(){
		List<WithdrawnItem> list = WithdrawnItemPeer.retrieveAll();
        WithdrawnItem item;
        ItemBatch itemBatch;
        Item itemName;

        Object[][] modelObject = new Object[list.size()][];         
        
        for(int i=0; i< list.size(); i++){
        	item = list.get(i);
        	itemBatch = ItemBatchPeer.retrieveItemBatch(item.getItemBatchId());
        	itemName = ItemPeer.retrieveItem(itemBatch.getItemId());
        	
        	Object[] model = null;
			try {
				model = new Object[]{item.getDateWithdrawn(),item.getSaleId(), itemBatch.getItemId(), itemName.getBrandName() , itemName.getGenericName(), itemBatch.getSupplier().getSupplierName(), item.getDoctor().getDoctorName(), item.getQuantity(), "pcs", itemBatch.getAcquisitionCost(), item.getSellingPrice(), item.getReason()};			
			} catch (TorqueException e) {
				// TODO Auto-generated catch block
				System.out.println("hay");
				e.printStackTrace();
			}
			modelObject[i]= model;
        }           
        
        return modelObject;        
	}
	
	
	public static Object[][] retrieveDrugsPurchased(){
		List<StockedItem> list = StockedItemPeer.retrieveAll();
        StockedItem item;
        ItemBatch itemBatch;
        Item itemName;

        Object[][] modelObject = new Object[list.size()][];         
        
        for(int i=0; i< list.size(); i++){
        	item = list.get(i);
        	itemBatch = ItemBatchPeer.retrieveItemBatch(item.getItemBatchId());
        	itemName = ItemPeer.retrieveItem(itemBatch.getItemId());
        	
        	Object[] model = null;
			try {
				model = new Object[]{item.getItemBatch().getPurchasedDate(), itemBatch.getItemId(), itemName.getBrandName() , itemName.getGenericName(), itemBatch.getSupplier().getSupplierName(), item.getQuantity(), "pcs", itemBatch.getAcquisitionCost(), item.getCurrentPrice()};			
			} catch (TorqueException e) {
				// TODO Auto-generated catch block
				System.out.println("hay");
				e.printStackTrace();
			}
			modelObject[i]= model;
        }           
        
        return modelObject;        
	}
	
	public static Object[][] retrieveDrugsExpiring(){
		List<StockedItem> list = StockedItemPeer.retrieveAll();
        StockedItem stockedItem;

        int count=0;

        java.util.Date today = new java.util.Date();
    	long t = today.getTime();
    	String dt = new java.sql.Date(t).toString().substring(5, 7);
        
        for(int i=0; i< list.size(); i++){
        	stockedItem = list.get(i);
        	
        	try {
				if((Integer.parseInt(dt) - 3) == Integer.parseInt(stockedItem.getItemBatch().getExpirationDate().toString().substring(5, 7))){
					count++;
				}
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (TorqueException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }           
        
        Object[][] modelObject = new Object[count][];         
        
        count=0;
        for(int i=0; i< list.size(); i++){
        	stockedItem = list.get(i);
        	        	
        	try {
				if((Integer.parseInt(dt) - 3) == Integer.parseInt(stockedItem.getItemBatch().getExpirationDate().toString().substring(5, 7))){
					Object[] model = null;
						try {
							model = new Object[]{stockedItem.getItemBatch().getItemBatchId(),stockedItem.getItemBatch().getItem().getBrandName(), stockedItem.getItemBatch().getItem().getGenericName(), stockedItem.getItemBatch().getSupplier().getSupplierName(), ItemPeer.getTotalQuantity(stockedItem.getItemBatch().getItem().getBrandName()), "pcs", stockedItem.getItemBatch().getAcquisitionCost(), stockedItem.getCurrentPrice()};
						} catch (TorqueException e) {
							e.printStackTrace();
						}
					
					modelObject[i]= model;
					count++;
				}
				
				else{
					count--;
					
				}
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (TorqueException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }           
        
        return modelObject;        
	}
	
	private int getDateDifference(String date1, String date2){
		
		return 3;
	}
	

}