package OnlineShoppingCartProject;


import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import com.jgoodies.forms.factories.DefaultComponentFactory;

public class DisplayImage8 extends JFrame {
	


public DisplayImage8() {
				
			setResizable(false);
			this.setBounds(100,100,321,400);
			this.setPreferredSize(new Dimension(300, 400));
			getContentPane().setLayout(null);
			JLabel label = new JLabel("");
			label.setIcon(new ImageIcon(DisplayImage8.class.getResource("/img/chanta.jpg")));
			label.setBounds(10, 11, 295, 349);
			getContentPane().add(label);
			this.setLocationRelativeTo(null);
			this.setVisible(true);
			this.setIconImage(this.getToolkit().getImage("chanta.jpg"));


}

}