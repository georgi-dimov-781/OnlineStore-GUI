package OnlineShoppingCartProject;



class Item{
    private Product product;
    private int qty=0;
    public Item(Product product){
        this.product=product;
    }
    public void remove(){
        product.updateStock(qty*(-1));
    }
    public void addqty(int q){
        qty+=q;
    }
    public Product getProduc(){
        return product;
    }
    public int getsellqty(){
        return qty;
    }
}

