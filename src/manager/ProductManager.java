package manager;

import model.Product;
import readAndWrireFile.ReadAndWriteFile;

import java.util.ArrayList;
import java.util.List;

public class ProductManager implements IManager<Product> {
    private List<Product>list;
    private ReadAndWriteFile readAndWriteFile = new ReadAndWriteFile();
    public ProductManager(){
        list = readAndWriteFile.readFile();
    }
    @Override
    public void add(Product product) {
        list.add(product);
        readAndWriteFile.writeFile(list);

    }

    @Override
    public boolean edit(int id, Product product) {
        int index = findById(id);
        if (index == -1){
            return false;
        }
        list.set(index,product);
        readAndWriteFile.writeFile(list);
        return true;
    }

    @Override
    public boolean delete(int id) {
        int index = findById(id);
        if (index == -1){
            return false;
        }
        list.remove(index);
        readAndWriteFile.writeFile(list);
        return true;

    }

    @Override
    public int findById(int id) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId()== id){
                return i;
            }
        }

        return -1;
    }

    @Override
    public int maxPrice() {
       List<Double>listPrice= new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            listPrice.add(list.get(i).getPrice());
        }
        double maxPrice = listPrice.get(0);
        int index = -1;
        for (int i = 0; i < listPrice.size(); i++) {
            if (maxPrice < listPrice.get(i)){
                maxPrice = listPrice.get(i);
                index = i;
            }

        }

        return index;
    }

    @Override
    public List<Product> findAll() {

        return list;
    }
}
