package OnlineShoppingCartProject;


import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import com.jgoodies.forms.factories.DefaultComponentFactory;

public class DisplayImage5 extends JFrame {
	


public DisplayImage5() {
	
			setResizable(false);
			this.setBounds(100,100,321,400);
			this.setPreferredSize(new Dimension(300, 400));
			getContentPane().setLayout(null);
			JLabel label = new JLabel("");
			label.setIcon(new ImageIcon(DisplayImage5.class.getResource("/img/grivna.jpg")));
			label.setBounds(10, 11, 295, 349);
			getContentPane().add(label);
			this.setLocationRelativeTo(null);
			this.setVisible(true);
			this.setIconImage(this.getToolkit().getImage("grivna.jpg"));


}

}
