package tp.dao;

import java.sql.*;
import java.util.*;
import tp.model.*;
public class Etudiantdao {
    public List<Etudiant> findAll() throws SQLException {
        List<Etudiant> list = new ArrayList<>();
        Connection conn = ConnexionBD.getConnection();
        String sql = "select id,nom,email,moyenne from test";

        PreparedStatement stmt = conn.prepareStatement(sql);
        ResultSet res = stmt.executeQuery();

        while (res.next()) {
            list.add(new Etudiant(res.getInt("id"),res.getString("nom"),res.getString("email"),res.getDouble("moyenne")));
        }
        conn.close();
        return list;
    }


    public Map<Integer,Etudiant> findAllAsmap() throws SQLException {
        Map<Integer,Etudiant> list = new HashMap<>();
        Connection conn = ConnexionBD.getConnection();
        String sql = "select id,nom,email,moyenne from test";

        PreparedStatement stmt = conn.prepareStatement(sql);
        ResultSet res = stmt.executeQuery();

        while (res.next()) {
            list.put(res.getInt("id"),new Etudiant(res.getInt("id"),res.getString("nom"),res.getString("email"),res.getDouble("moyenne")));
        }
        conn.close();
        return list;
    }



    public List<Etudiant> filtreParMoyenne(List<Etudiant> source,double seuil) {
        List<Etudiant> l = new ArrayList<>();
        if(seuil>20 || seuil<4)throw new IllegalArgumentException("Seuil non valide");
        source.forEach((e)->{
            if(e.getMoyenne() >= seuil){
                l.add(e);
            }
        });
        return l;
    }

    public List<Etudiant> filtreFromDB(double seuil) throws SQLException{
        if(seuil>20 || seuil<4)throw new IllegalArgumentException(seuil + " : Seuil non valide");
        List<Etudiant> list = new ArrayList<>();
        Connection conn = ConnexionBD.getConnection();
        String sql = "select* from test where moyenne >= ?";
        PreparedStatement stmt = conn.prepareStatement(sql);

        stmt.setDouble(1, seuil);
        ResultSet res = stmt.executeQuery();

        while(res.next()){
            list.add(new Etudiant(res.getInt("id"),res.getString("nom"),res.getString("email"),res.getDouble("moyenne")));
        }
        conn.close();
        return list;
    }
    
    public static boolean isFine(Etudiant e) throws SQLException{
        Connection conn = ConnexionBD.getConnection();
        PreparedStatement stmt = conn.prepareStatement("select* from test where email=?");
        stmt.setString(1, e.getEmail());

        ResultSet res = stmt.executeQuery();
        if(!res.next()){conn.close();return true;}
        else{conn.close();return false;} 
    }

    public void insertEtudiant(Etudiant e) throws SQLException {
        if(e==null)throw new NullPointerException("Etudiant is null");
        if(isFine(e)){
            Connection conn = ConnexionBD.getConnection();




            PreparedStatement stmt = conn.prepareStatement("insert into test (nom,email,moyenne) values (?,?,?)");
            
            stmt.setString(1,e.getNom());
            stmt.setString(2,e.getEmail());
            stmt.setDouble(3,e.getMoyenne());
            stmt.executeUpdate();
            conn.close();
        }else{
            System.out.println("This email has already used !");
        }
    }




    public void updateMoyenne(int id,double newMoyenne) throws SQLException {
        if(newMoyenne >20 || newMoyenne<0)throw new IllegalArgumentException("Ach kaddiir ! zga");
        Connection conn = ConnexionBD.getConnection();
        String sql = "update test set moyenne = ? where id = ?";

        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setDouble(1,newMoyenne);
        pstmt.setInt(2,id);

        pstmt.executeUpdate();
        conn.close();
    }
    
    public Etudiant findById(int id) throws SQLException {
        Connection conn = ConnexionBD.getConnection();
        String sql = "SELECT * FROM test WHERE id = ?";
        
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                return new Etudiant(
                    rs.getInt("id"),
                    rs.getString("nom"),
                    rs.getString("email"),
                    rs.getDouble("moyenne")
                );
            }
            return null;
        } finally {
            conn.close();
        }
    }


}
