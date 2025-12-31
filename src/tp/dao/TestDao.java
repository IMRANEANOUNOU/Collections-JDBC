package tp.dao;
import java.util.*;
import  tp.model.*;
import java.sql.*;
public class TestDao {
    public static void main(String[] args) {
        Etudiantdao e = new Etudiantdao();

        List<Etudiant> l = new ArrayList<>();
        Map<Integer,Etudiant> M = new HashMap<>();
        try {
            l = e.findAll();
        } catch (SQLException e1) {
            e1.printStackTrace();
        }

        StringBuilder sb = new StringBuilder();
        l.forEach((q)->{
            sb.append("-----------------------------------------------------------------------------------------\n");
            sb.append( "ID : " + q.getId() + "\nNom : " + q.getNom() + "\nEmail : " + q.getEmail() + "\nMoyenne :"+ q.getMoyenne() + "\n");
        });

        try { 
            M = e.findAllAsmap();
        }catch(SQLException e1){
            e1.printStackTrace();
        }

        
        System.out.println("--------------LIST TEST------------");
        System.out.println(sb.toString());

        System.out.println("--------------MAP TEST------------");
        System.out.println(M);


        System.out.println("---------------------FILTRAGE PAR MOYENNE--------------------------------------\n");

        List<Etudiant> listFilterer = e.filtreParMoyenne(l,17);
        System.out.println(listFilterer);


        System.out.println("---------------------FILTRAGE PAR MOYENNE Direct from DB-------------------------------\n");

        List<Etudiant> FiltredByMoy = null;
        try {
            FiltredByMoy = e.filtreFromDB(18);
        }catch(SQLException er){
            er.printStackTrace();
        }

        System.out.println(FiltredByMoy);


        Etudiant NewEtudiant = new Etudiant(11,"lambda","lambda@gmail.com",16);
        try {
            e.insertEtudiant(NewEtudiant);
        }catch(SQLException exc){
            exc.printStackTrace();
        }


        System.out.println(l);
        System.out.println("----------------NOTES UPDATE--{fahd}-----------------\n");
        try {
            e.updateMoyenne(4,17);
        }catch(SQLException exc){
            exc.printStackTrace();
        }
        System.out.println(l);

    }
}
