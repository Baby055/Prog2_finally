package Paiement_des_frais_de_scolarité;

import java.time.Instant;

import static org.junit.jupiter.api.Assertions.*;

class FraisTest {
    @Test

    public void TestDeStatutDeFrais(){
       Etudiants e = new Etudiants("Aina", "RANAIVOMANANA", 63, Instant.parse("2022-09-01T00:00:00Z"));
       Frais frais = new Frais(56, "Frais dr scolarité", Instant.parse("2023-09-30T00:00:00Z"), 2580600, e);
       frais.addPayment(new Payment(1, 2850600, Instant.parse("2023-09-01T00:00:00Z")));

       assertEquals(Frais.StatutDeFrais.IN_PROGRESS), frais.getStatut(Instant.parse("2023-09-15T00:00:00Z"));
    }
}