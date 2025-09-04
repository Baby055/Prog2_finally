package Paiement_des_frais_de_scolarité;


import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class Etudiants {
    private int id;
    private String nom;
    private String prenom;
    private Instant date_entre_chez_HEI;
    private List<Group> Historique_de_groupe = new ArrayList<>();

    public Etudiants(String prenom, String nom, int id, Instant date_entre_chez_HEI) {
        this.prenom = prenom;
        this.nom = nom;
        this.id = id;
        this.date_entre_chez_HEI = date_entre_chez_HEI;
    }

    public void addGroup(Group group){
        Historique_de_groupe.add(group);
    }

    public int getId() {
        return id;
    }
}
