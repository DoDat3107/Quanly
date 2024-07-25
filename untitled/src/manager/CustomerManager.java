package manager;

import model.Customer;

import java.util.ArrayList;

public class CustomerManager implements IManager<Customer> {
    private ArrayList<Customer> list = new ArrayList<>();

    @Override
    public void add(Customer customer) {
        this.list.add(customer);
    }

    @Override
    public void delete(int id) {
        int index = FindById(id);
        this.list.remove(index);
    }

    @Override
    public void edit(int id, Customer customer) {
        int index = FindById(id);
        this.list.set(index, customer);
        System.out.println("Sửa khach hang thành công !");
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
    public ArrayList<Customer> FindByName(String name) {
        ArrayList<Customer> result = new ArrayList<>();
        for (Customer customer : list) {
            if (customer.getName().equalsIgnoreCase(name)) {
                result.add(customer);
            }
        }
        return result;
    }

    @Override
    public ArrayList<Customer> FindByPrice(double price) {
        return null;
    }

    @Override
    public ArrayList<Customer> FindAll() {
        return this.list;
    }
}