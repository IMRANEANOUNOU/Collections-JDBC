package tp.model;
import java.util.*;
public class TriParMoyenne implements Comparator<Etudiant>{

  
  public int compare(Etudiant e1,Etudiant e2){
  	  return -Double.compare(e1.getMoyenne(),e2.getMoyenne());
  }
}