package OnlineShoppingCartProject;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

class CheckoutGUI extends JFrame{
	private JButton show,shop,exit;
	private JLabel wJLabel;
	private JTextArea jTA;
	private JScrollPane scrollPane;
	private JRadioButton rdbtnNewRadioButton;
	private JRadioButton jRadioButtonA;
	private JRadioButton jRadioButtonB;
	private JRadioButton jRadioButtonC;

    public CheckoutGUI() {
    	setResizable(false);
    	this.setTitle("Прегледай");	
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(100,100,321,400);
		this.getContentPane().setBackground(Color.DARK_GRAY); 
		this.setPreferredSize(new Dimension(450, 400));
        getContentPane().setLayout(null);
		this.setLocationRelativeTo(null);
       	this.setVisible(true);
       	this.setIconImage(this.getToolkit().getImage("icon.jpg"));

       	jTA = new JTextArea();
       	jTA.setLineWrap(true);
       	scrollPane = new JScrollPane(jTA,
       		ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
       		ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
       	jTA.setEditable(false);
       	jTA.setBorder(BorderFactory.createTitledBorder("Детайли на покупката"));
		wJLabel = new JLabel("");
		wJLabel.setForeground(Color.PINK);
		show = new JButton("Покажи");	
       	shop = new JButton("Пазарувай отново");
       	exit = new JButton("ОК");

       	scrollPane.setBounds(5,10,280,300);
		wJLabel.setBounds(30,310,140,20);
       	show.setBounds(200,310,80,20);
       	shop.setBounds(10,340,190,20);
       	exit.setBounds(200,340,80,20);

       	getContentPane().add(scrollPane);
       	getContentPane().add(wJLabel);
       	getContentPane().add(show);
       	getContentPane().add(shop);
       	getContentPane().add(exit);
       	
       	jRadioButtonA = new JRadioButton("Плати с карта");
       	jRadioButtonA.setActionCommand("Вие избрахте плащане с карта! Благодарим!");
       	jRadioButtonA.setBounds(301, 112, 140, 23);
       	getContentPane().add(jRadioButtonA);
       	
       	jRadioButtonB = new JRadioButton("Плати с PayPal");
       	jRadioButtonB.setActionCommand("Вие избрахте плащане посредством PayPal! Благодарим!");
       	jRadioButtonB.setBounds(301, 163, 140, 23);
       	getContentPane().add(jRadioButtonB);
       
       	
        ActionListener radioButtonActionListener = new ActionListener() {
        	 
            @Override
            public void actionPerformed(ActionEvent ae) {
                JOptionPane.showMessageDialog(
                        CheckoutGUI.this, ae.getActionCommand());
            }
             
        };
       	
       	
       	jRadioButtonA.addActionListener(radioButtonActionListener);
        jRadioButtonB.addActionListener(radioButtonActionListener);
         
        ButtonGroup buttonGroup  = new ButtonGroup();
        buttonGroup.add(jRadioButtonA);
        buttonGroup.add(jRadioButtonB);
         
     
         
        getContentPane().add(scrollPane);
        
       

    
       	this.pack();
    }

    public void addExitListener(ActionListener listener){
		exit.addActionListener(listener);
	}

	public void addShopListener(ActionListener listener){
		shop.addActionListener(listener);
	}

	public void addShowListener(ActionListener listener){
		show.addActionListener(listener);
	}

	public void showDetail(String s){
		jTA.setText(s);
	}

	public void showCalculateTotalPrice(String s){
		wJLabel.setText(s);
	}

    public void close() {
	       this.dispose();
	}
}

