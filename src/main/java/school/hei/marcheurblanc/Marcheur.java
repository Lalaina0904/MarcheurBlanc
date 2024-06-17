package school.hei.marcheurblanc;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.*;

@AllArgsConstructor
@Data
public class Marcheur {

    private String nom;
    private List<Lieu> lieuxVisites = new LinkedList<>();

    public Marcheur(String nom) {
        this.nom = nom;
    }

    public List<Lieu> marche(Carte carte, Lieu lieuDepart, Lieu lieuDestiantion) {
        Rue rueAleatoire = getRandomFromList(carte.getRues(), lieuDepart);

        if ((rueAleatoire.getLieu1() == lieuDestiantion) ||
                (rueAleatoire.getLieu2() == lieuDestiantion)) {
            lieuxVisites.add(lieuDestiantion);
            return lieuxVisites;
        };

        if (rueAleatoire.getLieu1() == lieuDepart) {
            lieuxVisites.add(rueAleatoire.getLieu2());
            marche(carte, rueAleatoire.getLieu2(), lieuDestiantion);
        }

        if (rueAleatoire.getLieu2() == lieuDepart) {
            lieuxVisites.add(rueAleatoire.getLieu1());
            marche(carte, rueAleatoire.getLieu1(), lieuDestiantion);
        }
        return lieuxVisites;
    }

    private Rue getRandomFromList(Set<Rue> set, Lieu lieuActuelle) {
        List<Rue> list = new ArrayList<>(set);
        List<Rue> listFilter = list.stream()
                .filter(r -> r.getLieu1() == lieuActuelle || r.getLieu2() == lieuActuelle)
                .toList();
        Random random = new Random();
        return listFilter.get(random.nextInt(listFilter.size()));
    }
}
