package Menu;

import manager.ProductManager;
import model.Product;

import java.util.ArrayList;
import java.util.Scanner;

public class ProductMenu {
    ProductManager productManager = new ProductManager();
    Scanner InputNumber = new Scanner(System.in);
    Scanner InputString = new Scanner(System.in);

    public void showMain() {
        int choice;
        do {
            System.out.println("=======Menu=======");
            System.out.println("1. Thêm mới sản phẩm");
            System.out.println("2. Sửa sản phẩm");
            System.out.println("3. Xóa sản phẩm");
            System.out.println("4. Tìm kiếm theo id");
            System.out.println("5. Tìm kiếm theo tên");
            System.out.println("6. Tìm kiếm theo giá gần đúng ");
            System.out.println("7. Hiển thị tất cả");
            System.out.println("0. Exit");
            System.out.println("Nhập lựa chọn của bạn : ");
            choice = InputNumber.nextInt();

            switch (choice) {
                case 1:

                    showMenuAdd();
                    break;
                case 2:
                    showMenuEdit();
                    break;
                case 3:
                    showMenuDelete();
                    break;
                case 4:
                    showFindById();
                    break;
                case 5:
                    showFindByName();
                    break;
                case 6:
                    showFindByPrice();
                    break;
                case 7:
                    showMenuList();
                    break;


            }
        } while (choice != 0);
    }

    public void showMenuList() {
        System.out.println("========Danh sách sản phẩm=======");
        ArrayList<Product> listProduct = productManager.FindAll();
        for (int i = 0; i < listProduct.size(); i++) {
            System.out.println(i + 1 + ". " + listProduct.get(i));
        }
    }

    public void showMenuAdd() {
        System.out.println("========Menu thêm mới=======");
        System.out.println("Nhập id : ");
        int id = InputNumber.nextInt();
        System.out.println("Nhập sản phẩm : ");
        String name = InputString.nextLine();
        System.out.println("Nhập giá : ");
        double price = InputNumber.nextDouble();
        Product newProduct = new Product(id, name, price);
        productManager.add(newProduct);
        System.out.println("Thêm sản phẩm thành công");
    }

    public void showMenuDelete() {
        System.out.println("============Menu Xoá==========");
        System.out.println("nhập id sản phẩm muon xoa : ");
        int idDelete = InputNumber.nextInt();
        productManager.delete(idDelete);
        System.out.println("Xóa sản phẩm thành công");
    }

    public void showMenuEdit() {
        System.out.println("======Menu sửa sản phẩm======");
        System.out.println("Nhập ID sản phẩm cần sửa:");
        int id = InputNumber.nextInt();
        InputNumber.nextLine(); // Consume newline character after reading id

        // Tìm sản phẩm theo ID
        int index = productManager.FindById(id);
        if (index == -1) {
            System.out.println("Không tìm thấy sản phẩm có ID = " + id);
        } else {
            Product existingProduct = productManager.FindAll().get(index);
            System.out.println("Thông tin sản phẩm cũ:");
            System.out.println("ID: " + existingProduct.getId());
            System.out.println("Tên: " + existingProduct.getName());
            System.out.println("Giá: " + existingProduct.getPrice());

            // Nhập thông tin sản phẩm mới
            System.out.println("Nhập tên mới:");
            String newName = InputString.nextLine();
            System.out.println("Nhập giá mới:");
            double newPrice = InputNumber.nextDouble();
            InputNumber.nextLine(); // Consume newline character after reading newPrice

            // Tạo đối tượng sản phẩm mới
            Product updatedProduct = new Product(id, newName, newPrice);

            // Thực hiện chỉnh sửa thông tin sản phẩm
            productManager.edit(id, updatedProduct);
            System.out.println("Sửa thông tin sản phẩm thành công!");
        }
    }

    public void showFindById() {
        System.out.println("=======Find Id=======");
        System.out.println("Nhập ID sản phẩm cần tìm kiếm : ");
        int id = InputNumber.nextInt();
        int index = productManager.FindById(id);
        if (index == -1) {
            System.out.println("Không tìm thấy sản phẩm có ID = " + id);
        } else {
            Product foundProduct = productManager.FindAll().get(index);

            System.out.println("Thông tin sản phẩm:");
            System.out.println("ID: " + foundProduct.getId());
            System.out.println("Tên: " + foundProduct.getName());
            System.out.println("Giá: " + foundProduct.getPrice());
        }
    }

    public void showFindByName() {
        System.out.println("=======Tìm kiếm theo Tên=======");
        System.out.println("Nhập Tên sản phẩm cần tìm kiếm : ");
        String name = InputString.nextLine();
        ArrayList<Product> foundProducts = productManager.FindByName(name);
        if (foundProducts.isEmpty()) {
            System.out.println("Không tìm thấy sản phẩm có tên chứa '" + name + "'");
        } else {
            System.out.println("Các sản phẩm có tên chứa '" + name + "':");
            for (Product product : foundProducts) {
                System.out.println("ID: " + product.getId() + ", Tên: " + product.getName() + ", Giá: " + product.getPrice());
            }
        }

    }

    public void showFindByPrice() {
        System.out.println("=======Tìm kiếm theo Giá gần đúng=======");
        System.out.println("Nhập Giá sản phẩm cần tìm kiếm : ");
        double price = InputNumber.nextDouble();
        ArrayList<Product> foundProducts = productManager.FindByPrice(price);
        if (foundProducts.isEmpty()) {
            System.out.println("Không tìm thấy sản phẩm có giá gần đúng " + price);
        } else {
            System.out.println("Các sản phẩm có giá gần đúng " + price + ":");
            for (Product product : foundProducts) {
                System.out.println("ID: " + product.getId() + ", Tên: " + product.getName() + ", Giá: " + product.getPrice());
            }
        }
    }

}


