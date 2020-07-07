package OnlineShoppingCartProject;



class Product {
	private String name;
	private int stock;
	private int price;
	private int sell = 0;
	private int thissell;
    private String category;
    
    //Конструктор на продукта и неговите характеристики
    
	public Product(String name,int stock,int price, String category) {
		this.name = name;
		this.stock = stock;
		this.price = price;
		this.category = category;
	}

	public String getProductName(){
		return name;
	}

	public String getCategory() {
		return category;
		
	}
	public int getProductStock(){
			return stock;
	}

	public int getPrice(){
		return price;
	}
	
	
        public void setSell(int q){
            sell=q;
        }

	public int getSell(){
		return sell;
	}

	public int getThisSell(){
		return thissell;
	}

	public String category(String category) {
		return category;
	}

	
	public void updateStock(int quantity){
		stock -= quantity;
		thissell = quantity;
		sell+=quantity;
	}
	public int calculatePrice(){
		return sell*price;
	}
}

