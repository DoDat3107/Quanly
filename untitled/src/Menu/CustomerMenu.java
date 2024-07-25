package Menu;

import manager.CustomerManager;
import model.Customer;


import java.util.ArrayList;
import java.util.Scanner;

public class CustomerMenu {
        CustomerManager CustomerManager = new CustomerManager();
        Scanner InputNumber = new Scanner(System.in);
        Scanner InputString = new Scanner(System.in);

        public void showMain() {
            int choice;
            do {
                System.out.println("=======Menu=======");
                System.out.println("1. Thêm mới khach hang");
                System.out.println("2. Sửa ");
                System.out.println("3. Xóa ");
                System.out.println("4. Tìm kiếm theo id");
                System.out.println("5. Tìm kiếm theo tên");
                System.out.println("6. Hiển thị tất cả");
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
                        showMenuList();
                        break;


                }
            } while (choice != 0);
        }

        public void showMenuList() {
            System.out.println("========Danh sách sản phẩm=======");
            ArrayList<Customer> listCustomer = CustomerManager.FindAll();
            for (int i = 0; i < listCustomer.size(); i++) {
                System.out.println(i + 1 + ". " + listCustomer.get(i));
            }
        }

        public void showMenuAdd() {
            System.out.println("========Menu thêm mới=======");
            System.out.println("Nhập id : ");
            int id = InputNumber.nextInt();
            System.out.println("Nhập sản phẩm : ");
            String name = InputString.nextLine();
            System.out.println("Nhập tuoi : ");
            int age = InputNumber.nextInt();
            System.out.println("Nhập dia chi : ");
            String address = InputString.nextLine();
            Customer newProduct = new Customer(id, name, age, address);
            CustomerManager.add(newProduct);
            System.out.println("Thêm sản phẩm thành công");
        }

        public void showMenuDelete() {
            System.out.println("============Menu Xoá==========");
            System.out.println("nhập id sản phẩm : ");
            int idDelete = InputNumber.nextInt();
            CustomerManager.delete(idDelete);
            System.out.println("Xóa thành công");
        }

        public void showMenuEdit() {
            System.out.println("======Menu sửa :=========");
            System.out.println("Nhập Id sửa :");
            int id = InputNumber.nextInt();
            InputString.nextLine();
            System.out.println("Nhập tên  mới : ");
            String name = InputString.nextLine();
            System.out.println("Nhập tuoi mới : ");
            int age = InputNumber.nextInt();
            System.out.println("Nhập dia chi moi : ");
            String address = InputString.nextLine();
            Customer editProduct = new Customer(id, name, age, address);
            CustomerManager.edit(id, editProduct);
            System.out.println("Sửa sản phẩm thành công !");
        }

        public void showFindById() {
            System.out.println("=======Find Id=======");
            System.out.println("Nhập ID sản phẩm cần tìm kiếm : ");
            int id = InputNumber.nextInt();
            InputString.nextLine();
            int index = CustomerManager.FindById(id);
            if (index == -1) {
                System.out.println("Không tìm thấy sản phẩm có ID = " + id);
            } else {
                Customer foundProduct = CustomerManager.FindAll().get(index);

                System.out.println("Thông tin sản phẩm:");
                System.out.println("ID: " + foundProduct.getId());
                System.out.println("Tên: " + foundProduct.getName());
                System.out.println("tuoi: " + foundProduct.getAge());
                System.out.println("dia chi: " + foundProduct.getAddress());
            }
        }

        public void showFindByName() {
            System.out.println("=======Tìm kiếm theo Tên=======");
            System.out.println("Nhập Tên khach hang cần tìm kiếm : ");
            String name = InputString.nextLine();
            ArrayList<Customer> foundCustomer = CustomerManager.FindByName(name);
            if (foundCustomer.isEmpty()) {
                System.out.println("Không tìm thấy khach hang có tên chứa '" + name + "'");
            } else {
                System.out.println("Các sản phẩm có tên chứa '" + name + "':");
                for (Customer customer : foundCustomer) {
                    System.out.println("ID: " + customer.getId() + ", Tên: " + customer.getName() + ", tuoi: " + customer.getAge()+" Dia chi: "+ customer.getAddress());
                }
            }

        }


            }


