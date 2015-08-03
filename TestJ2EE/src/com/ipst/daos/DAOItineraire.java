package com.ipst.daos;
import com.ipst.modele.Itineraire;

import java.util.Date;
import java.util.List;

public interface DAOItineraire {
    public List<Itineraire> selectbydate(Date d) throws Exception ;
    public Itineraire selectbydateetcamion(Date d,int camionid) throws Exception ;
    public int insert(Itineraire it) throws Exception;
    public int delete(Itineraire it) throws Exception;
}
