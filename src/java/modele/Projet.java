/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

//import java.sql.Date;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

/**
 *
 * @author Vladimir
 */
public class Projet {

    private int id;
    private int id_promotion;
    private int id_createur;
    private String titre;
    private String sujet;
    private Date date_creation;
    private Date date_limite;

    public Projet(int id, int id_promotion, int id_createur, String titre, String sujet, Date date_creation, Date date_limite) {
        this.id = id;
        this.id_promotion = id_promotion;
        this.id_createur = id_createur;
        this.titre = titre;
        this.sujet = sujet;
        this.date_creation = date_creation;
        this.date_limite = date_limite;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_promotion() {
        return id_promotion;
    }

    public void setId_promotion(int id_promotion) {
        this.id_promotion = id_promotion;
    }

    public int getId_createur() {
        return id_createur;
    }

    public void setId_createur(int id_createur) {
        this.id_createur = id_createur;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getSujet() {
        return sujet;
    }

    public void setSujet(String sujet) {
        this.sujet = sujet;
    }

    public Date getDate_creation() {
        return date_creation;
    }

    public void setDate_creation(Date date_creation) {
        this.date_creation = date_creation;
    }

    public Date getDate_limite() {
        return date_limite;
    }

    public void setDate_limite(Date date_limite) {
        this.date_limite = date_limite;
    }

    public void insert() throws SQLException {

        Connection connection = Database.getConnection();
        // Commencer une transaction
        connection.setAutoCommit(false);

        // Inserer le projet
        String sql = "INSERT INTO projet(id_promotion, id_createur,titre,sujet,date_creation,date_limite) VALUES(?,?,?,?,?,?)";
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setInt(1, id_promotion);
        stmt.setInt(2, id_createur);
        stmt.setString(1, titre);
        stmt.setString(2, sujet);
        stmt.setDate(1, (java.sql.Date) date_creation);
        stmt.setDate(2, (java.sql.Date) date_limite);
        stmt.executeUpdate();
        stmt.close();
        // Recuperer le id
      //  Statement maxStmt = connection.createStatement();
      //  ResultSet rs = maxStmt.executeQuery("SELECT MAX(no_produit) AS id FROM produit");
      //  rs.next();
      //  id = rs.getInt("id");
    //    rs.close();
     //   maxStmt.close();
        // Valider
      //  connection.commit();

    }

    public static Projet getById(int id) {
        throw new UnsupportedOperationException("pas implemente");
    }

}
