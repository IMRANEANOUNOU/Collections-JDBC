package tp.model;

import java.util.Objects;

public class Etudiant implements Comparable<Etudiant>{
	
	private int id;
	private String nom;
	private String email;
	private double moyenne;

	public Etudiant(){
		this.nom = "Unknown";
		this.email = "Unknown";
		this.moyenne = 0.0;
		this.id = 0;
	}

	public Etudiant(int id ,String nom,String email,double moyenne){
		this.id = id;
		this.nom = nom;
		this.email = email;
		this.moyenne = moyenne;
	}

	public int getId(){
		return id;
	}
	public void setId(int id){
		this.id = id;
	}

	public String getNom(){
		return nom;
	}
	public String getEmail(){
		return email;
	}
	public double getMoyenne(){
		return moyenne;
	}

	public void setNom(String nom){
		this.nom = nom;
	}	

	public void setEmail(String email){
		this.email = email;
	}

	public void setMoyenne(double moyenne){
		this.moyenne = moyenne;
	}


	
	public String toString(){
		return "ID : "+id+"\nNom : " +nom+"\nEmail : " +email+"\nMoyenne : " +moyenne;
	}

	@Override
	public boolean equals(Object o){
		if(this==o)return true;
		if(o==null||o.getClass()!=this.getClass())return false;
		Etudiant e = (Etudiant)o;
		return  Objects.equals(email,e.email);
	}
	
	public int hashCode(){
		return Objects.hash(email);
	} 

	public int compareTo(Etudiant e){
		return nom.compareTo(e.nom);
	}
}
