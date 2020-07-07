package OnlineShoppingCartProject;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

class ProductItemController {
	private ProductItemGUI productItemGUI;
	private ProductDB productDB;
	private CartItem cart;

	public ProductItemController(ProductItemGUI productItemGUI,ProductDB productDB,CartItem cart) {
		this.productItemGUI = productItemGUI;
		this.productDB = productDB;
		this.cart = cart;
		this.productItemGUI.addCheckoutListener(new CheckoutListener());
		this.productItemGUI.addListListener(new ListListener());
		this.productItemGUI.addAddListener(new AddListener());
		this.productItemGUI.addRemoveListener(new RemoveListener());
		this.productItemGUI.addClearListener(new ClearListener());
		this.productItemGUI.addExitListener(new ExitListener());
		this.productItemGUI.addDisplayImage1Listener(new DisplayImage1Listener());
		this.productItemGUI.addDisplayImage2Listener(new DisplayImage2Listener());
		this.productItemGUI.addDisplayImage3Listener(new DisplayImage3Listener());
		this.productItemGUI.addDisplayImage4Listener(new DisplayImage4Listener());
		this.productItemGUI.addDisplayImage5Listener(new DisplayImage5Listener());
		this.productItemGUI.addDisplayImage6Listener(new DisplayImage6Listener());
		this.productItemGUI.addDisplayImage7Listener(new DisplayImage7Listener());
		this.productItemGUI.addDisplayImage8Listener(new DisplayImage8Listener());







		addListElement();
	}

	
	
	public void addListElement(){
		for(Product p:productDB.productList)
			this.productItemGUI.addListElement(p.getProductName());
	}
	
	//eventi za vseki klas
	
	class DisplayImage1Listener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			DisplayImage1 Displayimage1 = new DisplayImage1();

		}
		
	}
	
	
	class DisplayImage2Listener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			DisplayImage2 Displayimage2 = new DisplayImage2();

		}
		
	}

	class DisplayImage3Listener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			DisplayImage3 Displayimage3 = new DisplayImage3();

		}
		
	}
	
	class DisplayImage4Listener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			DisplayImage4 Displayimage4 = new DisplayImage4();

		}
		
	}
	
	
	class DisplayImage5Listener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			DisplayImage5 Displayimage5 = new DisplayImage5();

		}
		
	}
	
	class DisplayImage6Listener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			DisplayImage6 Displayimage6 = new DisplayImage6();

		}
		
	}

	
	class DisplayImage7Listener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			DisplayImage7 Displayimage7 = new DisplayImage7();

		}
		
	}
	
	class DisplayImage8Listener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			DisplayImage8 Displayimage8 = new DisplayImage8();

		}
		
	}
	
	class CheckoutListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if(cart.calculateTotalPrice() == 0){
				productItemGUI.setQStock("Няма продукти");
				productItemGUI.setPrice("");
				
			}else{
				CheckoutGUI checkoutGUI = new CheckoutGUI();
				CheckoutController checkoutController = new CheckoutController(checkoutGUI,productDB,cart);
	    		productItemGUI.close();
	    		checkoutGUI.setVisible(true);
			}
		}
	}

	class ListListener implements ListSelectionListener {
		public void valueChanged(ListSelectionEvent e) {
			int s = 0;
			Product p = productDB.getProduct(productItemGUI.getListValue());
	    	s = p.getProductStock();
	    
	    	if(s==0){
            	productItemGUI.setQStock("Избери продукт");
            }else{
            	productItemGUI.setQStock("Наличност :" + s);
            }
            productItemGUI.setPrice("Цена :" + p.getPrice() + "лв");
            
		}

		
	     
	}

	class AddListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
	    	Product p = productDB.getProduct(productItemGUI.getListValue());
	    	int s = p.getProductStock();
                int id=0;
	    	if(s!=0){
	    		if(s > productItemGUI.getCallNum()){
	    			productDB.updateStock(p,productItemGUI.getCallNum());
	    			int qty = productItemGUI.getCallNum();
			    	id=cart.addProduct(p,qty);
	    		}else{
	    			productDB.updateStock(p,s);
	    			int qty = s;
			    	id=cart.addProduct(p,qty);
	    		}
	    	}
//
            int ss = p.getProductStock();
	    	if(s<=0){
            	productItemGUI.setQStock("Избери продукт");
            }else{
                if (id<0){
                    productItemGUI.addRow(p);
                }else{
                    productItemGUI.setRow(id, p);
                }
                productItemGUI.setQStock("Наличност : " + ss);
                productItemGUI.setPrice("Цена :" + p.getPrice() + "лв");
                productItemGUI.setTotalPrice("Общо : " + cart.calculateTotalPrice() + "лв");
            }
        }
	}

	class RemoveListener implements ActionListener {
		public void actionPerformed(ActionEvent e){
                int r =-1;
                int c =-1;

                r = productItemGUI.getTableRow();
                c = productItemGUI.getTableColumn();
                if(r != -1 && c != -1){
	       		if( c == 1 || c == 0){
                        cart.removeProduct(productItemGUI.getTableRow());
	       		Product p = productDB.getProduct(productItemGUI.getTableName(r));
	       		
	       		int s = p.getProductStock();

	       			if(productItemGUI.getListValue() == p.getProductName()){
	       				productItemGUI.setQStock("Наличност : " + s);
	       			}
	       			
	       			productItemGUI.setTotalPrice("Финална цена: " + cart.calculateTotalPrice());
	       			if(productItemGUI.getTableRow()==0){
	       				productItemGUI.setTotalPrice("");
	       			}
	       		}
	       		productItemGUI.defaultModelRemoveRow();
	       	}else{
	       		if(productItemGUI.getTableIsNull()){
		       		productItemGUI.setQStock("");
	            	productItemGUI.setPrice("");
	            	productItemGUI.setTotalPrice("Няма продукти");
	       		}else{
	            	productItemGUI.setTotalPrice("Избери продуктите");
	       		}
	       	}
       	}
	}

	class ClearListener implements ActionListener {
		public void actionPerformed(ActionEvent e){
                        cart.clearAll();
       			productItemGUI.setTableNull();
       			productItemGUI.setQStock("Избери продукт");
       			productItemGUI.setPrice("");
       			productItemGUI.setTotalPrice("");
       	}
	}
	class ExitListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
       		productItemGUI.close();
       		JOptionPane.showMessageDialog(null, "Благодаря Ви, надяваме се да Ви видим отново", "Съобщение", JOptionPane.INFORMATION_MESSAGE );
       	}
	}
}
