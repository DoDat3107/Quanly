package manager;

import model.Product;

import java.util.ArrayList;

public class ProductManager implements IManager<Product> {
    private ArrayList<Product> list = new ArrayList<>();


    @Override
    public void add(Product product) {
        this.list.add(product);
    }

    @Override
    public void delete(int id) {
        int index = FindById(id);
        this.list.remove(index);
    }

    @Override
    public void edit(int id, Product product) {
        int index = FindById(id);
        this.list.set(index, product);

    }

    @Override
    public int FindById(int id) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId() == id) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public ArrayList<Product> FindByName(String name) {
        ArrayList<Product> result = new ArrayList<>();
        for (Product product : list) {
            if (product.getName().equalsIgnoreCase(name)) {
                result.add(product);
            }
        }
        return result;
    }

    @Override
    public ArrayList<Product> FindByPrice(double price) {
        double tolerance = 10000;
        ArrayList<Product> result = new ArrayList<>();
        for (Product product : list) {
            double productPrice = product.getPrice();
            if (Math.abs(productPrice - price) <= tolerance) {
                result.add(product);
            }
        }
        return result;
    }

    @Override
    public ArrayList<Product> FindAll() {
        return this.list;
    }
}
