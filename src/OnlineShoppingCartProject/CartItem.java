package OnlineShoppingCartProject;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;


class CartItem {
	ArrayList<Item> cItem = new ArrayList<>();

	Random ran = new Random();
        int no = ran.nextInt(1000)+1;
        SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
	Date date = new Date();
	String strDate = "Date: " + sdFormat.format(date);

	public void setCartNull(){
		cItem = null;
			
		
		}
	
	//Настройване на дата и час

	public int addProduct(Product p,int qty){
		System.out.println(p.getProductName());
            Item newitem=null;
            int id=-1;
            int rid=-1;
            for (Item i:cItem){
                id++;
                if (i.getProduc()==p){
                    rid=id;
                    newitem=i;
                    break;
                }
            }
                
            if (newitem==null){
                rid=-1;
                newitem=new Item(p);
                cItem.add(newitem);
            }
            newitem.addqty(qty);
		System.out.println("ID: "+ id);
                p.setSell(newitem.getsellqty());
                System.out.println("cItem number: "+cItem.size());
                System.out.println("this sell: "+newitem.getProduc().getSell());
		System.out.println(calculateTotalPrice());
                return rid;
	}
	
	

	public void removeProduct(int id){
                Item i=cItem.get(id);
                i.remove();
                i=null;
		cItem.remove(id);
	}
	
	//Премахване на продукт
	
        public void clearAll(){
                for (Item i:cItem){
                    i.remove();
                    i=null;
                }
                cItem.removeAll(cItem);
        }
        
        //Смятане на финалната цена
        
	public int calculateTotalPrice(){
		int all=0;
		for(Item p : cItem){
			all += p.getProduc().calculatePrice();
		}
		return all;
	}
	
	

	public String getAllDetail(){
		String str = "";

		for(Item i : cItem){
                        Product p=i.getProduc();
			System.out.println(p);
			String a = p.getProductName();
			String e = p.getCategory();
			String b = String.valueOf(i.getsellqty());
			String c = String.valueOf(p.getPrice());
			System.out.println(a+" "+b+" "+c+" " + e +"");
			str += "Продукт: " + a + "/ Количество: " + b + "/ Цена: " + c + "/   "
					+ "Категория: " + e;
			//return a+" "+b+" "+c + e;
			str += "\n";
		}
		str = "NO." + no + "\n" + strDate + "\n" + str;
		return str;
	}
		
	//Цикъл за извеждане на финалната поръчка
}
