package tp.app;
import tp.model.*;
import java.util.*;
public class TestCollections {
	public static void main(String[] args) {
		Etudiant e1 = new Etudiant(1,"imrane","imrane@gmail.com",20);
		Etudiant e2 = new Etudiant(2,"kawki","kawki@gmail.com",15);
		Etudiant e3 = new Etudiant(3,"lambda","imrane@gmail.com",17);
		List<Etudiant> listEtudiant = new ArrayList<>();
		listEtudiant.add(e1);
		listEtudiant.add(e2);
		listEtudiant.add(e3);

		for(Etudiant e : listEtudiant){
			System.out.println(e);
		}

		System.out.println("---------------------Triage par nom-------------------");

		Collections.sort(listEtudiant);

		for(Etudiant e : listEtudiant){
			System.out.println(e);
		}
		System.out.println("--------------------Triage par moyenne-----------------");

		Collections.sort(listEtudiant,new TriParMoyenne());

		for(Etudiant e : listEtudiant){
			System.out.println(e);
		}


		System.err.println("---------------Set-------------------");
		Set<Etudiant> listEtudiantUnique = new HashSet<>(listEtudiant);

		for(Etudiant e : listEtudiantUnique){
			System.out.println(e);
		}

		System.err.println("---------------Map-------------------");

		Map<Integer,Etudiant> listMap = new HashMap<>();

		for(Etudiant e : listEtudiant){
			listMap.put(e.getId(), e);
		}

		listMap.forEach((id,e)->{
			System.out.println("ID => " + id);
			System.out.println("Nom => " + e.getNom());
			System.out.println("Email => " + e.getEmail());
			System.out.println("Moyenne => " + e.getMoyenne());
		});


	}
}