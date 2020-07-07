package OnlineShoppingCartProject;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

import javax.swing.*;


class CheckoutController {
	private CheckoutGUI checkoutGUI;
	private CartItem cart;
	private ProductDB productDB;

	public CheckoutController(CheckoutGUI checkoutGUI,ProductDB productDB,CartItem cart){
		this.checkoutGUI = checkoutGUI;
		this.productDB = productDB;
		this.cart = cart;
		this.checkoutGUI.addExitListener(new ExitListener());
		this.checkoutGUI.addShopListener(new ShopListener());
		this.checkoutGUI.addShowListener(new ShowListener());
	}
	
	

	class ExitListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
       		checkoutGUI.close();
       		JOptionPane.showMessageDialog(null, "Приятно пазаруване!", "Съобщение", JOptionPane.INFORMATION_MESSAGE );
       	}
	}

	class ShopListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
       		ProductItemGUI productItemGUI = new ProductItemGUI();
       		ProductItemController  productItemController = new ProductItemController(productItemGUI,productDB,new CartItem());
       		checkoutGUI.close();
	    	productItemGUI.setVisible(true);
       	}
	}

	class ShowListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
       		checkoutGUI.showDetail(cart.getAllDetail());
       		checkoutGUI.showCalculateTotalPrice("Финална цена : " + cart.calculateTotalPrice() + "лв");
       	
	


	String fileName = "MyFile.txt";
	try {
		PrintWriter outputStream = new PrintWriter(fileName);
		
		
		outputStream.println("Вие закупихте" + "\r\n" + cart.getAllDetail());
		outputStream.write("\r\n");	// write new line
		outputStream.println("Финална цена : " + cart.calculateTotalPrice() + "лв");
		outputStream.close();

	} catch (FileNotFoundException e1) {
		e1.printStackTrace();
	}
}
	}
}

