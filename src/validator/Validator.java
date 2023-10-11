package validator;

import java.util.Scanner;

public class Validator {
    public static int inputChoice() {
        Scanner input = new Scanner(System.in);
        String choiceRegex = "[0-9]";
        String choice;
        do {
            System.out.println(" Xin mời bạn nhập sự lựa chọn");
            choice = input.nextLine();
            if (choice.matches(choiceRegex)) {
                break;
            } else {
                System.out.println("bạn chỉ được phép chọn số từ 0 đến 9");
            }
        } while (true);
        return Integer.parseInt(choice);
    }
    public static int inputId(){
        Scanner scanner = new Scanner(System.in);
        String regex = "^[1-9]\\d{2,}$";
        String id;
        do {
            System.out.println("Xin mời nhập vào ID, yêu cầu ID phải có 3 chữ số trở lên : ");
            id = scanner.nextLine();
            if(id.matches(regex)) {
                break;
            }else {
                System.out.println("!! Error....Xin nhắc lại id phải là số, và có từ 3 ký tự trở lên ");
            }
        } while (true);
        return Integer.parseInt(id);

    }
    public static String inputName(){
        Scanner scanner = new Scanner(System.in);
        String regex = "^[a-zA-Z0-9]{3,15}$";
        String name;
        do {
            System.out.println("Xin mời nhập vào tên sản phẩm , yêu cầu tên sản phẩm phải có từ 3 đến 15 ký tự : ");
            name = scanner.nextLine();
            if (name.matches(regex)){
                break;
            }else {
                System.out.println("!! Error.... Xin nhắc lại,tên sản phẩm phải có từ 3 đến 15 ký tự :");
            }
        }while (true);
        return name;
    }
    public static double inputPrice(){
        Scanner scanner = new Scanner(System.in);
        String regex = "^(0*[1-9][0-9]{0,7}|100000)$";
        String price;
        do {
            System.out.println("Xin mời nhập vào giá của sản phẩm :  ");
            price = scanner.nextLine();
            if (price.matches(regex)){
                break;
            }else {
                System.out.println("!! Error... Xin lưu ý, giá của sản phẩm là số, và nhỏ hơn 100000");
            }
        }while (true);
        return Double.parseDouble(price);
    }
    public static int inputQuantity(){
        Scanner scanner = new Scanner(System.in);
        String regex = "^(0*[1-9][0-9]?|200)$";
        String quantity;
        do {
            System.out.println("Xin mời nhập vào số lượng sản phẩm : ");
            quantity = scanner.nextLine();
            if (quantity.matches(regex)){
                break;
            }else {
                System.out.println("!! Error... Xin lưu ý số lượng sản phẩm là số, và nhỏ hon 200 ");
            }
        }while (true);
        return Integer.parseInt(quantity);
    }
    public static String inputDescription(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Xin mời nhập mô tả sản phẩm  : ");
        return scanner.nextLine();
    }

}
