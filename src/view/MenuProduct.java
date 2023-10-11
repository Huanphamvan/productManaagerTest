package view;

import manager.ProductManager;
import model.Product;
import validator.Validator;

import java.util.ArrayList;
import java.util.List;

public class MenuProduct {
    ProductManager productManager = new ProductManager();
    public void showMainMenu(){
        int choice;
        do {
            System.out.println("=====Chương Trình Quản Lý Sản Phẩm =====\n1.Xem danh sách sản phẩm.\n2.Thêm mới sản phẩm theo .\n3.Cập nhật sản phẩm theo id.\n" +
                    "4.Xóa bỏ  sản phẩm.\n5.Sắp xếp sản phẩm.\n6.Tìm kiếm sản phẩm có giá đắt nhất.\n0.Thoát.");
            System.out.println("Chọn chức năng");
            choice = Validator.inputChoice();
            switch (choice){
                case  1:
                    showAll();
                    break;
                case  2:
                    showMenuAdd();
                    break;
                case 3:
                    showMenuEdit();
                    break;
                case 4:
                    showMenuDelete();
                    break;
                case 5:
                    showMenuArrange();
                    break;
                case 6:
                    showMeNuMaxPrice();
                    break;

            }
        } while (choice != 0);

    }
    public void showAll(){
        System.out.println("=======Đây là mục xem danh sách sản phẩm =====");
        System.out.println("Danh sách sản phẩm  : ");
        List<Product> list= productManager.findAll();
        for (Product product:list) {
            System.out.println(product);
        }
    }
    public void showMenuAdd(){
        System.out.println("=======Đây là mục thêm mới sản phẩm =====");
        System.out.println("Nhập id sản phẩm muốn thêm mới");
        int id = Validator.inputId();
        System.out.println("Nhập tên sản phẩm muốn thêm mới");
        String name = Validator.inputName();
        System.out.println("Nhập giá của sản phẩm muốn thêm mới : ");
        double price = Validator.inputPrice();
        System.out.println("Nhập số lượng sản phẩm muốn thêm mới");
        int quantity = Validator.inputQuantity();
        System.out.println("Nhập mô tả về sản phẩm: ");
        String description = Validator.inputDescription();
        Product product = new Product(id,name,price,quantity,description);
        productManager.add(product);
        System.out.println("=======Đã thêm mới thành công =====");

    }
    public void showMenuEdit(){
        System.out.println("=======Đây là mục cập nhật dữ liệu sản phẩm =====");
        System.out.println("Nhập id sản phẩm muốn sửa");
        int id = Validator.inputId();
        if (productManager.findById(id)== -1){
            System.out.println("Không có sản phẩm này.");
        }
        else {
            System.out.println("Nhập tên sản phẩm muốn sửa đổi");
            String name = Validator.inputName();
            System.out.println("Nhập giá của sản phẩm muốn sửa đổi : ");
            double price = Validator.inputPrice();
            System.out.println("Nhập số lượng sản phẩm muốn sửa đổi");
            int quantity = Validator.inputQuantity();
            System.out.println("Nhập mô tả về  sản phẩm muốn sửa đổi: ");
            String description = Validator.inputDescription();
            Product product = new Product(id,name,price,quantity,description);
            productManager.edit(id,product);
            System.out.println("=======Đã cập nhật dữ liệu sản phẩm thành công =====");

        }



    }
    public void showMenuDelete(){
        System.out.println("=======Đây là mục xóa sản phẩm =====");
        System.out.println("Nhập id muốn xóa");
        int id = Validator.inputId();
        if (productManager.findById(id)== -1){
            System.out.println("Không có sản phẩm này.");
        }
        else
        {productManager.delete(id);}
        System.out.println("=======Đã xóa thành công =====");
    }
    public void showMenuArrange(){
        int choice;
        do {System.out.println("=======Đây là mục sắp xếp sản phẩm =====");
            System.out.println("1. Sắp xếp theo thứ tu giá sản phẩm tăng dần");
            System.out.println("2. Sắp xếp theo thứ tu giá sản phẩm giảm dần");
            System.out.println("0. Thoat");
            System.out.println("Chọn cách sắp xếp");
            choice = Validator.inputChoice();
            switch (choice){
                case  1:
                    sortIncreaseProduct();

                    break;
                case  2:
                    sortDecreaseProduct();

                    break;

            }
        } while (choice != 0);

}
    public void showMeNuMaxPrice(){
        System.out.println("=======Đây là mục hiển thị sản phẩm có giá đắt nhất =====");
        int index = productManager.maxPrice();
        System.out.println("Thông tin sản phẩm có giá đắt nhất là : ");
        System.out.println(productManager.findAll().get(index));

    }
    public void sortIncreaseProduct(){
        List<Product>list = productManager.findAll();
        for (int i = 1; i < list.size(); i++) {
            for (int j = 0; j < list.size() - i; j++) {
                if (list.get(j).getPrice() > list.get(j + 1).getPrice()) {
                    Product temp = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, temp);
                }
            }
        }
        for (Product product : list
        ) {
            System.out.println(product);
        }
    }

    public void sortDecreaseProduct(){
        List<Product>list = productManager.findAll();
        for (int i = 1; i < list.size(); i++) {
            for (int j = 0; j < list.size() - i; j++) {
                if (list.get(j).getPrice() < list.get(j + 1).getPrice()) {
                    Product temp = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, temp);
                }
            }
        }
        for (Product product : list
        ) {
            System.out.println(product);
        }

    }
}


