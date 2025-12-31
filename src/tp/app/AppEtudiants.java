package tp.app;

import tp.dao.Etudiantdao;
import tp.model.Etudiant;
import java.util.*;
import java.sql.SQLException;

public class AppEtudiants {
    private static Scanner scanner = new Scanner(System.in);
    private static Etudiantdao etudiantDao = new Etudiantdao();
    public static void main(String[] args) {
        boolean quitter = false;
        while (!quitter) {
            afficherMenu();
            System.out.print("Votre choix : ");
            int choix = scanner.nextInt();
            scanner.nextLine();
            try {
                switch (choix) {
                    case 1:
                        listerEtudiants();
                        break;
                    case 2:
                        rechercherEtudiant();
                        break;
                    case 3:
                        filtrerParMoyenne();
                        break;
                    case 4:
                        ajouterEtudiant();
                        break;
                    case 5:
                        modifierMoyenne();
                        break;
                    case 0:
                        quitter = true;
                        System.out.println("Thella !!");
                        break;
                    default:
                        System.out.println("Option non valide. Veuillez reessayer.");
                }
            } catch (SQLException e) {
                System.err.println("Erreur de base de donnees : " + e.getMessage());
            } catch (Exception e) {
                System.err.println("Erreur : " + e.getMessage());
            }

            if (!quitter) {
                System.out.println("\nAppuyez sur Entree pour continuer...");
                scanner.nextLine();
            }
        }
        scanner.close();
    }
    private static void afficherMenu() {
        System.out.println("\n=== Gestion des Etudiants ===");
        System.out.println("1. Lister tous les etudiants");
        System.out.println("2. Rechercher un etudiant par ID");
        System.out.println("3. Filtrer les etudiants par moyenne minimale");
        System.out.println("4. Ajouter un nouvel etudiant");
        System.out.println("5. Modifier la moyenne d'un etudiant");
        System.out.println("0. Quitter");
    }
    private static void listerEtudiants() throws SQLException {
        System.out.println("\n=== Liste des etudiants ===");
        etudiantDao.findAll().forEach(System.out::println);
    }
    private static void rechercherEtudiant() throws SQLException {
        System.out.print("\nEntrez l'ID de l'etudiant : ");
        int id = scanner.nextInt();
        scanner.nextLine();
        Etudiant etudiant = etudiantDao.findById(id);
        if (etudiant != null) {
            System.out.println("\nEtudiant trouve :");
            System.out.println(etudiant);
        } else {
            System.out.println("Aucun etudiant trouve avec l'ID " + id);
        }
    }
    private static void filtrerParMoyenne() throws SQLException {
        System.out.print("\nEntrez la moyenne minimale : ");
        double moyenneMin = scanner.nextDouble();
        scanner.nextLine();
        System.out.println("\nEtudiants avec une moyenne >= " + moyenneMin + " :");
        etudiantDao.filtreFromDB(moyenneMin).forEach(System.out::println);
    }
    private static void ajouterEtudiant() throws SQLException {
        System.out.println("\n=== Ajout d'un nouvel Etudiant ===");
        System.out.print("ID : ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Nom : ");
        String nom = scanner.nextLine();
        System.out.print("Email : ");
        String email = scanner.nextLine();
        System.out.print("Moyenne : ");
        double moyenne = scanner.nextDouble();
        scanner.nextLine();
        Etudiant nouvelEtudiant = new Etudiant(id, nom, email, moyenne);
        etudiantDao.insertEtudiant(nouvelEtudiant);
        System.out.println("Etudiant ajoute avec succes !");
    }
    private static void modifierMoyenne() throws SQLException {
        System.out.println("\n=== Modification de la moyenne d'un etudiant ===");
        System.out.print("ID de l'etudiant : ");
        int id = scanner.nextInt();
        scanner.nextLine();
        Etudiant etudiant = etudiantDao.findById(id);
        if (etudiant == null) {
            System.out.println("Aucun etudiant trouve avec l'ID " + id);
            return;
        }
        System.out.println("Ancienne moyenne : " + etudiant.getMoyenne());
        System.out.print("Nouvelle moyenne : ");
        double nouvelleMoyenne = scanner.nextDouble();
        scanner.nextLine();
        etudiantDao.updateMoyenne(id, nouvelleMoyenne);
        System.out.println("Moyenne mise a jour avec succes !");
    }
}
