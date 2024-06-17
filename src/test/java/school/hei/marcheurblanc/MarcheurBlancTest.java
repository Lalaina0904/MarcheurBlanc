package school.hei.marcheurblanc;

import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MarcheurBlancTest {

    @Test
    void marcheur_blanc_arrive_a_destination() {
        var Bjarni = new Marcheur("Bjarni");

        var hei = new Lieu("HEI");
        var pullman = new Lieu("Pullman");
        var nexta = new Lieu("Nexta");
        var balancoire = new Lieu("Balancoire");
        var boulevardDeLEurope = new Lieu("Boulevard de L'europe");
        var esti = new Lieu("ESTIE");
        var sekolintsika = new Lieu("Sekolintsika");
        var marais = new Lieu("Marais");

        var rue_hei_pullman = new Rue("Rue Andriantsihorana", hei, pullman);
        var rue_pullman_balancoire = new Rue("Rue Ranaivo", pullman, balancoire);
        var rue_pullman_nexta = new Rue(pullman, nexta);
        var rue_hei_balancoire = new Rue(hei, balancoire);
        var rue_balancoire_esti = new Rue(balancoire, esti);
        var rue_esti_boulevardDeLEurope = new Rue(esti, boulevardDeLEurope);
        var rue_balancoire_boulvardDeLEurope = new Rue(balancoire, boulevardDeLEurope);
        var rue_hei_sekolintsika = new Rue(hei, sekolintsika);
        var rue_sekolintsika_marais = new Rue(sekolintsika, marais);

        var cart_Invadry = new Carte(
                Set.of(
                        rue_hei_pullman,
                        rue_pullman_balancoire,
                        rue_pullman_nexta,
                        rue_hei_balancoire,
                        rue_balancoire_esti,
                        rue_esti_boulevardDeLEurope,
                        rue_balancoire_boulvardDeLEurope,
                        rue_hei_sekolintsika,
                        rue_sekolintsika_marais
                )
        );

        assertEquals("ESTIE", Bjarni.marche(cart_Invadry, hei, esti).getClass().getName());
    }

}
