package OnlineShoppingCartProject;
import java.util.ArrayList;



class ProductDB {
	ArrayList<Product> productList = new ArrayList<>();

	public ProductDB(){
		productList.add(new Product("Тениска",100,32,"Дрехи"));
		productList.add(new Product("Дънки",100,40, "Дрехи"));
		productList.add(new Product("Комплект обувки чорапи мешка",20,60, "Спортно облекло"));
		productList.add(new Product("Часовник",40,50, "Аксесоари"));
		productList.add(new Product("Гривна",150,20, "Аксесоари"));
		productList.add(new Product("Яке",100,75, "Дрехи"));
		productList.add(new Product("Суитчър",80,40, "Дрехи"));
		productList.add(new Product("Чанта",100,35, "Аксесоари"));
		
	}

	//Цикъл за продуктите
	
	public Product getProduct(String name) {
		Product a = new Product("",0,0,"");
		for(Product p : productList){
			if(name == p.getProductName()){
				return p;
			}
		}
		return a;
	}
	
//Метод за update  на продуктите и количеството

	public void updateStock(Product p,int quantity){
		p.updateStock(quantity);
		for(Product pp : productList){
			if(p.getProductName() == pp.getProductName()){
				pp=p;
			}
		}
	}
}
