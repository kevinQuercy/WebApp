package com.ipst.daos;
import com.ipst.daos.DAOHistorique;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import com.ipst.modele.Historique;

public class DAOMysqlHistorique implements DAOHistorique {
    
    @Override
    public List<Historique> select() throws Exception {
    	String sqlSelect = "SELECT * FROM Historique;";
        List<Historique> liste = new LinkedList<Historique>();
        //ouvrir la connexion
        Connection cnx = BDManager.getConnexion();
        //faire la requ�te
        Statement s = cnx.createStatement();
        ResultSet r = s.executeQuery(sqlSelect);

        //traiter les r�ponses
        while (r.next()) {
        	Historique h = new Historique();
            //r�cup�rer les champs
            h.set_id(r.getInt("id"));
            h.set_Conteneur_id(r.getInt("Conteneur_id"));
            h.set_date(r.getTimestamp("date"));
            h.set_poids(r.getInt("poids"));
            h.set_volume(r.getInt("volume"));
            //ajouter � la liste
            liste.add(h);
        }
        
        r.close();
        s.close();
        cnx.close();

        return liste;
    }
    
    @Override
    public List<Historique> selectByConteneur(int c) throws Exception {
    	String sqlSelectByConteneur = "SELECT * FROM Historique WHERE Conteneur_id = ";
        List<Historique> liste = new LinkedList<Historique>();
        //ouvrir la connexion
        Connection cnx = BDManager.getConnexion();
        //faire la requ�te
        Statement s = cnx.createStatement();
        sqlSelectByConteneur += c + ";";
        ResultSet r = s.executeQuery(sqlSelectByConteneur);

        //traiter les r�ponses
        while (r.next()) {
        	Historique h = new Historique();
            //r�cup�rer les champs
            h.set_id(r.getInt("id"));
            h.set_Conteneur_id(r.getInt("Conteneur_id"));
            h.set_date(r.getTimestamp("date"));
            h.set_poids(r.getInt("poids"));
            h.set_volume(r.getInt("volume"));
            //ajouter � la liste
            liste.add(h);
        }
        
        r.close();
        s.close();
        cnx.close();

        return liste;
    }
    
    @Override
    public Date selectderniervidage(int c) throws Exception {
    	String sql = "SELECT MAX(date) FROM Historique WHERE Conteneur_id ='"+c+"' AND volume='0' AND poids='0';";
        List<Historique> liste = new LinkedList<Historique>();
        //ouvrir la connexion
        Connection cnx = BDManager.getConnexion();
        //faire la requ�te
        Statement s = cnx.createStatement();
        ResultSet r = s.executeQuery(sql);
        r.next();
        Date d = r.getTimestamp(1);
        r.close();
        s.close();
        cnx.close();

        return d;
    }

    @Override
    public int insert(Historique h) throws Exception {
        String sql = "INSERT INTO Historique (conteneur_id,date,poids,volume) " + " VALUES( ";
        //connexion
        Connection cnx = BDManager.getConnexion();
        //executer la requ�te
        Statement s = cnx.createStatement();
        sql += "'" + h.get_Conteneur_id() + "',";
        java.text.SimpleDateFormat sdf =  new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        sql += "'" + sdf.format(h.get_date()) + "',";
        sql += "'" + h.get_poids() + "',";
        sql += "'" + h.get_volume() + "')";
		//System.out.println ("\nsql :" + sql + "\n");
        int n = s.executeUpdate(sql);

        s.close();
        cnx.close();
        return n;
    }

    /*@Override
    public int update(Historique h) throws Exception {
        String sqlUpdate = "UPDATE Historique " + " (conteneur_id,date,poids,volume) " + " VALUES (" ;
        //connexion
        Connection cnx = BDManager.getConnexion();
        //executer la requ�te
        Statement s = cnx.createStatement();
        sqlUpdate += "'" + h.get_Conteneur_id() + "',";
        java.text.SimpleDateFormat sdf =  new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        sqlUpdate += "'" + sdf.format(h.get_date()) + "',";
        sqlUpdate += "'" + h.get_poids() + "',";
        sqlUpdate += "'" + h.get_volume() + "')";
        sqlUpdate += " WHERE reference = ' " + h.get_id() + "' ;";

        int n = s.executeUpdate(sqlUpdate);

        s.close();
        cnx.close();
        return n;
    }*/
    
    @Override
    public int delete(Historique h) throws Exception {
        String sqlDelete = "DELETE FROM Historique WHERE id = '";
        Connection cnx = BDManager.getConnexion();
        Statement s = cnx.createStatement();
        sqlDelete += h.get_id() + "';";
        int n = s.executeUpdate(sqlDelete);
        return n;

    }
}