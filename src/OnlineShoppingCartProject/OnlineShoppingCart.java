package OnlineShoppingCartProject;

import java.text.SimpleDateFormat;

import javax.swing.JFrame;

import java.awt.Window.Type;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.FileNotFoundException;

public class OnlineShoppingCart {

	public static void main(String[] args) {
		JFrame.setDefaultLookAndFeelDecorated(true);

		ProductDB productDB = new ProductDB();
		ProductItemGUI productItemGUI = new ProductItemGUI();
		CartItem cart = new CartItem();
		ProductItemController  productItemController = new ProductItemController(productItemGUI,productDB,cart);
		productItemGUI.setVisible(true);

		
		
		String fileName = "MyFile.txt";
		try {
			PrintWriter outputStream = new PrintWriter(fileName);
			
			
			outputStream.println("Вие закупихте"+ cart.getAllDetail());
			outputStream.write("\r\n");	// write new line

			outputStream.println("Финална цена : " + cart.calculateTotalPrice() + "лв");
			outputStream.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		//Tekstov fail MyFile koito otpechatva metodite cart.getAllDetail i cart.calculateTotalPrice
		
	}
	}

