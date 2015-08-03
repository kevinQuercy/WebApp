package com.ipst.daos;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.ipst.modele.Ilot;

public class DAOMysqlIlot implements DAOIlot {

	@Override
	public List<Ilot> select() throws Exception {
	    String sql = "SELECT * FROM Ilot;";
        List<Ilot> liste = new ArrayList<Ilot>();
        //ouvrir la connexion
        Connection cnx = BDManager.getConnexion();
        //faire la requ�te
        Statement s = cnx.createStatement();
        ResultSet r = s.executeQuery(sql);

        //traiter les r�ponses
        while (r.next()) {
        	Ilot h = new Ilot();
            //r�cup�rer les champs
            h.set_id(r.getInt("id"));
            h.set_adresse(r.getString("adresse"));
            h.set_codepostal(r.getInt("codepostal"));
            h.set_ville(r.getString("ville"));
            h.set_longitude(r.getDouble("longitude"));
            h.set_latitude(r.getDouble("latitude"));
            h.set_Contact_id(r.getInt("contact_id"));
            DAOConteneur daoconteneur = DAOFactory.creerDAOConteneur();
            h.set_conteneurs(daoconteneur.selectbyilotid(r.getInt("id")));
            //ajouter � la liste
            liste.add(h);
        }
        
        r.close();
        s.close();
        cnx.close();

        return liste;
	}
	
	@Override
	public Ilot selectbyid(int id) throws Exception {
	    String sql = "SELECT * FROM Ilot WHERE id = "+id+";";
        List<Ilot> liste = new LinkedList<Ilot>();
        //ouvrir la connexion
        Connection cnx = BDManager.getConnexion();
        //faire la requ�te
        Statement s = cnx.createStatement();
        
        ResultSet r = s.executeQuery(sql);
        
        r.next();
    	Ilot h = new Ilot();
        //r�cup�rer les champs
        h.set_id(r.getInt("id"));
        h.set_adresse(r.getString("adresse"));
        h.set_codepostal(r.getInt("codepostal"));
        h.set_ville(r.getString("ville"));
        h.set_longitude(r.getDouble("longitude"));
        h.set_latitude(r.getDouble("latitude"));
        h.set_Contact_id(r.getInt("contact_id"));
        DAOConteneur daoconteneur = DAOFactory.creerDAOConteneur();
        h.set_conteneurs(daoconteneur.selectbyilotid(r.getInt("id")));
        
        r.close();
        s.close();
        cnx.close();

        return h;
	}
	@Override
	public List<Ilot> selectByContact(int i) throws Exception {
	    String sql = "SELECT * FROM Ilot WHERE Contact_id = ";
        List<Ilot> liste = new LinkedList<Ilot>();
        //ouvrir la connexion
        Connection cnx = BDManager.getConnexion();
        //faire la requ�te
        Statement s = cnx.createStatement();
        sql += i + ";";
        ResultSet r = s.executeQuery(sql);

        //traiter les r�ponses
        while (r.next()) {
        	Ilot h = new Ilot();
            //r�cup�rer les champs
            h.set_id(r.getInt("id"));
            h.set_adresse(r.getString("adresse"));
            h.set_codepostal(r.getInt("codepostal"));
            h.set_ville(r.getString("ville"));
            h.set_longitude(r.getDouble("longitude"));
            h.set_latitude(r.getDouble("latitude"));
            h.set_Contact_id(r.getInt("Contact_id"));
            //ajouter � la liste
            liste.add(h);
        }
        
        r.close();
        s.close();
        cnx.close();

        return liste;
	}

	/*@Override
	public int insert(Ilot i) throws Exception {
	    String sql = "INSERT INTO Ilot (adresse,codepostal,ville,longitude,latitude,contact_id) "  + " VALUES( ";
        //connexion
        Connection cnx = BDManager.getConnexion();
        //executer la requ�te
        Statement s = cnx.createStatement();
        sql += "'" + i.get_adresse() + "',";
        sql += "'" + i.get_codepostal() + "',";
        sql += "'" + i.get_ville() + "',";
        sql += "'" + i.get_longitude() + "',";
        sql += "'" + i.get_latitude() + "',";
        sql += "'" + i.get_Contact_id() + "')";

        int n = s.executeUpdate(sql);

        s.close();
        cnx.close();
        return n;
	}*/

	/*@Override
	public int update(Ilot i) throws Exception {
	    String sql = "UPDATE Ilot SET ";
        //connexion
        Connection cnx = BDManager.getConnexion();
        //executer la requ�te
        Statement s = cnx.createStatement();
        sql += "adresse='" + i.get_adresse() + "',";
        sql += "codepostal='" + i.get_codepostal() + "',";
        sql += "ville='" + i.get_ville() + "',";
        sql += "longitude='" + i.get_longitude() + "',";
        sql += "latitude='" + i.get_latitude() + "',";
        sql += "contact_id='" + i.get_Contact_id() +  "'";
        sql += " WHERE id = ' " + i.get_id() + "' ;";

        int n = s.executeUpdate(sql);

        s.close();
        cnx.close();
        return n;
	}*/

	/*@Override
	public int delete(Ilot i) throws Exception {
	    String sql = "DELETE FROM Ilot WHERE id = '";
        Connection cnx = BDManager.getConnexion();
        Statement s = cnx.createStatement();
        sql += i.get_id() + "';";
        int n = s.executeUpdate(sql);
        return n;
	}*/
}
