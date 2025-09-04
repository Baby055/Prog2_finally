package Paiement_des_frais_de_scolarité;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class Frais {
    private int id;
    private String label;
    private double montant_a_payer;
    private Instant Deadline;
    private Etudiants etudiant;
    private List<Payment> payements = new ArrayList<>();

    public Frais(int id, String label, Instant deadline, double montant_a_payer, Etudiants etudiant) {
        this.id = id;
        this.label = label;
        Deadline = deadline;
        this.montant_a_payer = montant_a_payer;
        this.etudiant = etudiant;
    }
    
    public void addPayment (Payment payment){
        payements.add(payment);
    }

    public double getTotalPaid(Instant t){
        return payements.stream()
                .filter(p -> p.getDate_et_heure_de_payment().isBefore(t))
                .mapToDouble(Payment::getAmount)
                .sum();
    }

    public enum StatutDeFrais {
        IN_PROGRESS,
        PAID,
        LATE,
        OVERPAID
    }

    public StatutDeFrais getStatut(Instant t){
        double TotalPaid = getTotalPaid(t);
        if (TotalPaid == 0) return StatutDeFrais.NULL;
        if (TotalPaid == montant_a_payer) return StatutDeFrais.PAID;
        if (TotalPaid > montant_a_payer) return StatutDeFrais.OVERPAID;
        if (t.isAfter(Deadline)) return StatutDeFrais.LATE;
        return StatutDeFrais.IN_PROGRESS;
    }

    public double getMontant_a_payer() {
        return montant_a_payer;
    }

    public Etudiants getEtudiant() {
        return etudiant;
    }

    public Instant getDeadline() {
        return Deadline;
    }
}
