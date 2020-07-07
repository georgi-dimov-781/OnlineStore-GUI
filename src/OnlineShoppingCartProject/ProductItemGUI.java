package OnlineShoppingCartProject;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

class ProductItemGUI extends JFrame {
	private JLabel pmenu,cartItem,qStock,num,price,totalPrice, category;
	private DefaultListModel<String> myListModel;
	private JList<String> list;
	private JScrollPane scrollPane,scrollPane2;
	private JComboBox<String> callNum;
	private JButton add,checkout,remove,clear,exit,picButton1,picButton2,picButton3,picButton4,picButton5,picButton6,picButton7,picButton8;
	private JTable table;
	private DefaultTableModel defaultModel;
	private JPanel panel,panel2;
	private JLabel lblNewLabel;

	public ProductItemGUI() {
		this.setTitle("Онлайн магазин");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(100,100,600,380);
		this.getContentPane().setBackground(Color.DARK_GRAY);
		this.setPreferredSize(new Dimension(800, 500));
        this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setIconImage(Toolkit.getDefaultToolkit().getImage(ProductItemGUI.class.getResource("/img/shopify_og.png")));
		Font font1 = new Font(Font.DIALOG, Font.BOLD, 12);
		myListModel = new DefaultListModel<>();

		cartItem = new JLabel("Продукти в количка");	
		cartItem.setForeground(Color.PINK);
		Font font2 = new Font(Font.DIALOG, Font.BOLD, 13);
        cartItem.setFont(font2);
		totalPrice = new JLabel();
		totalPrice.setForeground(Color.PINK);
		String[][] productInfo = new String[0][2];
		String[] names = {"Продукт","Количество","Категория"};
		defaultModel = new DefaultTableModel(productInfo, names){
			public boolean isCellEditable(int row,int col){
				return false;
			}
		};
		table = new JTable(defaultModel);

		TableColumn col = table.getColumnModel().getColumn(0);
		int width = 150;
    	col.setPreferredWidth(width);
    	table.setAutoResizeMode(JTable.AUTO_RESIZE_SUBSEQUENT_COLUMNS);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.getTableHeader().setReorderingAllowed(false);
		DefaultTableCellRenderer render2 = new DefaultTableCellRenderer();
       	render2.setHorizontalAlignment(SwingConstants.CENTER);
       	table.getColumn("Продукт").setCellRenderer(render2);
       	table.getColumn("Количество").setCellRenderer(render2);
       	table.getColumn("Категория").setCellRenderer(render2);
		scrollPane2 = new JScrollPane(table);

		remove = new JButton("Премахни");
		clear = new JButton("Изчисти");
		checkout = new JButton("Разгледай");
		exit = new JButton("Изход");
		panel2 = new JPanel();
		panel2.setBorder(BorderFactory.createTitledBorder(""));
		panel2.setOpaque(false);
		panel2.setLayout(null);
		
		cartItem.setBounds(523,106,226,20);
        remove.setBounds(468,345,125,20);
        clear.setBounds(624,345,125,20);
        totalPrice.setBounds(556,315,100,20);
		checkout.setBounds(624,408,125,20);
		exit.setBounds(473,408,120,20);
		panel2.setBounds(300,0,300,380);
		panel2.add(checkout);
		panel2.add(exit);
		panel2.add(cartItem);
		panel2.add(totalPrice);
        
        scrollPane2 = new JScrollPane(table);
        scrollPane2.setBounds(464,132,291,172);
        panel2.add(scrollPane2);
        panel2.add(remove);
		panel2.add(clear);
		getContentPane().add(panel2);
		
				pmenu = new JLabel("Меню с продукти");
				pmenu.setForeground(Color.PINK);
				pmenu.setFont(font1);
				list = new JList<>(myListModel);
				list.setFont(new Font("Tahoma", Font.BOLD, 14));
				list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
				DefaultListCellRenderer renderer1 = (DefaultListCellRenderer) list.getCellRenderer();
				scrollPane = new JScrollPane(list);
				qStock = new JLabel("");
				qStock.setForeground(Color.PINK);
				price = new JLabel("");
				price.setForeground(Color.PINK);
				num = new JLabel("Избери количество");
				num.setForeground(Color.PINK);
				num.setFont(new Font("Tahoma", Font.BOLD, 12));
				callNum = new JComboBox<>();
				callNum.addItem("1");
				callNum.addItem("2");
				callNum.addItem("3");
				callNum.addItem("4");
				callNum.addItem("5");
				add = new JButton("Добави продукт");
				
				

		panel = new JPanel();
		panel2.add(panel);
		panel.setBorder(BorderFactory.createTitledBorder(""));
		panel.setOpaque(false);
		panel.setLayout(null);
		
				pmenu.setBounds(82,11,100,20);
				scrollPane.setBounds(25,30,250,180);
				qStock.setBounds(82,210,100,20);
				price.setBounds(200,210,100,20);
				num.setBounds(50,280,120,20);
				callNum.setBounds(180,280,50,20);
				add.setBounds(70,320,177,20);
				panel.setBounds(10,106,406,380);
				
						panel.add(pmenu);
						panel.add(scrollPane);
						panel.add(qStock);
						panel.add(price);
						panel.add(num);
						panel.add(callNum);
						panel.add(add);
						
						picButton1 = new JButton("Виж снимка");
						picButton1.setFont(new Font("Tahoma", Font.PLAIN, 12));
						picButton1.setForeground(Color.BLACK);
						picButton1.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
							}
						});
						picButton1.setBounds(281, 33, 112, 14);
						panel.add(picButton1);
						
						picButton2 = new JButton("Виж снимка");
						picButton2.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
							}
						});
						picButton2.setForeground(Color.BLACK);
						picButton2.setFont(new Font("Tahoma", Font.PLAIN, 12));
						picButton2.setBounds(281, 48, 112, 14);
						panel.add(picButton2);
						
						picButton3 = new JButton("Виж снимка");
						picButton3.setForeground(Color.BLACK);
						picButton3.setFont(new Font("Tahoma", Font.PLAIN, 12));
						picButton3.setBounds(281, 63, 112, 14);
						panel.add(picButton3);
						
						picButton4 = new JButton("Виж снимка");
						picButton4.setForeground(Color.BLACK);
						picButton4.setFont(new Font("Tahoma", Font.PLAIN, 12));
						picButton4.setBounds(281, 79, 112, 14);
						panel.add(picButton4);
						
						picButton5 = new JButton("Виж снимка");
						picButton5.setForeground(Color.BLACK);
						picButton5.setFont(new Font("Tahoma", Font.PLAIN, 12));
						picButton5.setBounds(281, 100, 112, 14);
						panel.add(picButton5);
						
						picButton6 = new JButton("Виж снимка");
						picButton6.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
							}
						});
						picButton6.setForeground(Color.BLACK);
						picButton6.setFont(new Font("Tahoma", Font.PLAIN, 12));
						picButton6.setBounds(281, 121, 112, 14);
						panel.add(picButton6);
						
						picButton7 = new JButton("Виж снимка");
						picButton7.setForeground(Color.BLACK);
						picButton7.setFont(new Font("Tahoma", Font.PLAIN, 12));
						picButton7.setBounds(281, 142, 112, 14);
						panel.add(picButton7);
						
						picButton8 = new JButton("Виж снимка");
						picButton8.setForeground(Color.BLACK);
						picButton8.setFont(new Font("Tahoma", Font.PLAIN, 12));
						picButton8.setBounds(281, 161, 112, 14);
						panel.add(picButton8);
						
						lblNewLabel = new JLabel("Добре дошли!");
						lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
						lblNewLabel.setBackground(Color.WHITE);
						lblNewLabel.setForeground(Color.PINK);
						lblNewLabel.setFont(new Font("Bookman Old Style", lblNewLabel.getFont().getStyle() | Font.BOLD, 24));
						lblNewLabel.setBounds(190, 25, 412, 59);
						panel2.add(lblNewLabel);
						
						JLabel lblNewLabel_1 = new JLabel("New label");
						lblNewLabel_1.setForeground(UIManager.getColor("CheckBox.focus"));
						lblNewLabel_1.setBackground(SystemColor.inactiveCaptionBorder);
						lblNewLabel_1.setIcon(new ImageIcon(ProductItemGUI.class.getResource("/img/cart.jpg")));
						lblNewLabel_1.setBounds(668, 67, 116, 59);
						panel2.add(lblNewLabel_1);

		this.pack();
	}
//eventi za vseki buton
	public void addCheckoutListener(ActionListener listener){
		checkout.addActionListener(listener);
	}
	
	public void addDisplayImage1Listener(ActionListener listener) {
		picButton1.addActionListener(listener);
	}
	
	public void addDisplayImage2Listener(ActionListener listener) {
		picButton2.addActionListener(listener);
	}
	
	public void addDisplayImage3Listener(ActionListener listener) {
		picButton3.addActionListener(listener);
	}
	
	public void addDisplayImage4Listener(ActionListener listener) {
		picButton4.addActionListener(listener);
	}
	
	public void addDisplayImage5Listener(ActionListener listener) {
		picButton5.addActionListener(listener);
	}
	
	public void addDisplayImage6Listener(ActionListener listener) {
		picButton6.addActionListener(listener);
	}
	
	public void addDisplayImage7Listener(ActionListener listener) {
		picButton7.addActionListener(listener);
	}

	public void addDisplayImage8Listener(ActionListener listener) {
		picButton8.addActionListener(listener);
	}

	public void addListListener(ListSelectionListener listener){
		list.addListSelectionListener(listener);
	}

	public void addAddListener(ActionListener listener){
		add.addActionListener(listener);
	}

	public void addRemoveListener(ActionListener listener){
		remove.addActionListener(listener);
	}

	public void addClearListener(ActionListener listener){
		clear.addActionListener(listener);
	}

	public void addExitListener(ActionListener listener){
		exit.addActionListener(listener);
	}

	public void addListElement(String s){
		myListModel.addElement(s);
	}

	public void setQStock(String s){
		qStock.setText(s);
	}

	public void setPrice(String s){
		price.setText(s);
	}
	
	public void setCategory(String s) {
		category.setText(s);
	}

	public int getCallNum(){
		return Integer.parseInt((String)callNum.getSelectedItem());
	}

	public String getListValue(){
		return String.valueOf(list.getSelectedValue());
	}

	public void addRow(Product p){
		defaultModel.addRow(new String[]{p.getProductName(),String.valueOf(p.getSell()),p.getCategory()});
	}

    public void setRow(int id,Product p){//!!
        defaultModel.setValueAt(String.valueOf(p.getSell()),id,1);
    }

	public int getTableRow(){
		return (Integer)table.getSelectedRow();
	}

	public int getTableColumn(){
		return (Integer)table.getSelectedColumn();
	}

	public String getTableName(int r){
		return String.valueOf(table.getValueAt(r,0));
	}

	public int getTableNum(int r){
		return Integer.parseInt(String.valueOf(table.getValueAt(r,1)));
	}

	public void defaultModelRemoveRow(){
		defaultModel.removeRow((Integer)table.getSelectedRow());
	}

	public void setTableNull(){
		DefaultTableModel model = (DefaultTableModel) table.getModel();
    	model.setRowCount(0);
	}

	public boolean getTableIsNull(){
		return table.getRowCount()==0;
	}

	public void setTotalPrice(String s){
		totalPrice.setText(s);
	}

	public void close() {
	    this.dispose();
	}
}
