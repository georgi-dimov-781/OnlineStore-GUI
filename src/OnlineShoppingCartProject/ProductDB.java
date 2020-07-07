package OnlineShoppingCartProject;
import java.util.ArrayList;



class ProductDB {
	ArrayList<Product> productList = new ArrayList<>();

	public ProductDB(){
		productList.add(new Product("�������",100,32,"�����"));
		productList.add(new Product("�����",100,40, "�����"));
		productList.add(new Product("�������� ������ ������ �����",20,60, "������� �������"));
		productList.add(new Product("��������",40,50, "���������"));
		productList.add(new Product("������",150,20, "���������"));
		productList.add(new Product("���",100,75, "�����"));
		productList.add(new Product("�������",80,40, "�����"));
		productList.add(new Product("�����",100,35, "���������"));
		
	}

	//����� �� ����������
	
	public Product getProduct(String name) {
		Product a = new Product("",0,0,"");
		for(Product p : productList){
			if(name == p.getProductName()){
				return p;
			}
		}
		return a;
	}
	
//����� �� update  �� ���������� � ������������

	public void updateStock(Product p,int quantity){
		p.updateStock(quantity);
		for(Product pp : productList){
			if(p.getProductName() == pp.getProductName()){
				pp=p;
			}
		}
	}
}
