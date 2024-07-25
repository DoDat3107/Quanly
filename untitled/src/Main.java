import Menu.CustomerMenu;
import Menu.ProductMenu;
import manager.ProductManager;

public class Main {
    public static void main(String[] args){
        ProductMenu productMenu = new ProductMenu();
        productMenu.showMain();
        CustomerMenu customerMenu = new CustomerMenu();
        customerMenu.showMain();

    }
}