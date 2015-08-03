package com.ipst.daos;

import java.util.Date;
import com.ipst.modele.Planification;

public interface DAOPlanification {
    public Planification selectbydate(Date d) throws Exception ;
    public int insert(Planification pl) throws Exception;
    public int deletebydate(Date d) throws Exception;
}
