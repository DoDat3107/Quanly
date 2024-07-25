package manager;

import java.util.ArrayList;

public interface IManager<E> {
    void add(E e);
    void delete(int id);
    void edit(int id, E e);
    int FindById(int id);

    ArrayList<E> FindByName(String name);
    ArrayList<E> FindByPrice(double price);
    ArrayList<E> FindAll();
}
