package readAndWrireFile;

import model.Product;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadAndWriteFile {
    private File file = new File("product.csv");
    public void writeFile (List<Product> list){
        try {
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            String line = "";
            for (Product product: list) {
                line += product.getData() + "\n";
            }
            bufferedWriter.write(line);
            bufferedWriter.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    public List<Product> readFile(){
        List<Product>list = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine())!= null) {
                String [] data = line.split(",");
                Product product = new Product(Integer.parseInt(data[0]),data[1], Double.parseDouble(data[2]),
                        Integer.parseInt(data[3]), (data[4]));
                list.add(product);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return list;

    }



}
