package Paiement_des_frais_de_scolarité;

import java.time.Instant;

public class Payment {
    private int id;
    private double amount;
    private Instant date_et_heure_de_payment;

    public Payment(int id, double amount, Instant date_et_heure_de_payment) {
        this.id = id;
        this.amount = amount;
        this.date_et_heure_de_payment = date_et_heure_de_payment;
    }

    public double getAmount() {
        return amount;
    }

    public Instant getDate_et_heure_de_payment() {
        return date_et_heure_de_payment;
    }
}
