package manager;

import java.util.List;

public interface IManager <P>{
    void add (P p);
    boolean edit (int id, P p);
    boolean delete (int id );
    int findById(int id);
    int maxPrice ();
    List<P> findAll();
}
