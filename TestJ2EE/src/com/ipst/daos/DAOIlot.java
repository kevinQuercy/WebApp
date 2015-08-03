package com.ipst.daos;

import java.util.List;

import com.ipst.modele.Ilot;


public interface DAOIlot {
    public List<Ilot> select() throws Exception;
    public List<Ilot> selectByContact(int i) throws Exception ;
    public Ilot selectbyid(int i) throws Exception ;
    //public int insert(Ilot i) throws Exception;
    //public int delete(Ilot i) throws Exception;
    //public int update(Ilot i) throws Exception;
}
