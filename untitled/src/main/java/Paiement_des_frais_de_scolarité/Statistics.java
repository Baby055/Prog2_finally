package Paiement_des_frais_de_scolarité;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

public class Statistics {
    public static List<Frais> getLateFrais(List<Frais> frais, Instant t){
        return frais.stream()
                .filter(frais1 -> frais1.getStatut(t) == Frais.StatutDeFrais.LATE)
                .collect(Collectors.toList();
    }

    public static double getTotalMissingFrais(List<Frais> frais, Instant t){
        return frais.stream()
                .filter(frais1 -> frais1.getStatut(t) == Frais.StatutDeFrais.LATE)
                .mapToDouble(Frais -> Frais.getMontant_a_payer() - Frais.getTotalPaid(t))
                .sum();
    }

    public static double getTotalPaidByStudent(Etudiants etudiants, List<Frais> frais, Instant t){
        return frais.stream()
                .filter(frais1 -> frais1.getEtudiant().getId() == etudiants.getId())
                .mapToDouble(frai -> frai.getTotalPaid(t))
                .sum();
    }
}
