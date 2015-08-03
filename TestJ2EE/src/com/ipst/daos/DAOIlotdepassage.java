package com.ipst.daos;
import com.ipst.modele.Ilotdepassage;
import com.ipst.modele.Itineraire;
import java.util.List;

public interface DAOIlotdepassage {
    public List<Ilotdepassage> selectbyitineraire(Itineraire i) throws Exception ;
    public int insert(Ilotdepassage i) throws Exception;
    public int delete(Ilotdepassage i) throws Exception;
}
