package com.example.gwent;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
    private List <Card> cards;

    public Deck(String type) {
        cards = new ArrayList<>();
        if (type.equals("Nilfgaard")) {
            cards.add(new Card("Albrich", 2, "RANGED"));
            cards.add(new Card("Assire var Anahid", 6, "RANGED"));
            cards.add(new Card("Black Infantry Archer", 10, "RANGED"));
            cards.add(new Card("Cahir Mawr Dyffryn aep Ceallach", 6, "MELEE"));
            cards.add(new Card("Cynthia", 4, "RANGED"));
            cards.add(new Card("Etolian Auxiliary Archers", 1, "RANGED")); //MEDIC
            cards.add(new Card("Heavy Zerrikanian Fire Scorpion", 10, "SIEGE"));
            cards.add(new Card("Impera Brigade Guard", 3, "MELEE")); //BOUND
            cards.add(new Card("Letho of Gulet", 10, "MELEE","HERO"));
            cards.add(new Card("Menno Coehoorn", 10, "MELEE","HERO"));
            cards.add(new Card("Morteisen", 3, "MELEE"));
            cards.add(new Card("Morvran Voorhis(HERO)", 10, "SIEGE","HERO"));
            cards.add(new Card("Nausicaa Cavalry Rider", 2, "MELEE"));
            cards.add(new Card("Puttkammer", 3, "RANGED"));
            cards.add(new Card("Rainfarn", 4, "MELEE"));
            cards.add(new Card("Renuald aep Matsen", 5, "RANGED"));
            cards.add(new Card("Rotten Mangonel", 3, "SIEGE"));
            cards.add(new Card("Shilard Fitz-Oesterlen(SPY)", 7, "MELEE","SPY")); //SPY
            cards.add(new Card("Siege Engineer", 6, "SIEGE"));
            cards.add(new Card("Siege Technician", 0, "SIEGE")); //MEDIC
            cards.add(new Card("Stefan Skellen(SPY)", 9, "MELEE","SPY")); //SPY
            cards.add(new Card("Sweers", 2, "RANGED"));
            cards.add(new Card("Tibor Eggebracht(HERO)", 10, "RANGED","HERO")); //HERO
            cards.add(new Card("ICE", 0, "MELEE","WEATHER")); // WEATHER
            cards.add(new Card("RAIN", 0, "SIEGE", "WEATHER")); //WEATHER
            cards.add(new Card("FOGGY", 0, "RANGED", "WEATHER")); //WEATHER
            cards.add(new Card("SUN", 0, "RANGED", "WEATHER"));
            cards.add(new Card("SUN", 0, "RANGED", "WEATHER"));//WEATHER
        } else if (type.equals("Northern Realms")) {
            cards.add(new Card("Ballista", 6, "SIEGE"));
            cards.add(new Card("Blue Stripes Commando", 4, "MELEE"));
            cards.add(new Card("Catapult", 8, "SIEGE")); //BOUND
            cards.add(new Card("Crinfrid Reavers", 5, "RANGED")); //BOUND
            cards.add(new Card("Dethmold", 10, "MELEE")); //HERO
            cards.add(new Card("Dun Banner Medic", 5, "SIEGE")); //MEDIC
            cards.add(new Card("Esterad Thyssen(HERO)", 10, "MELEE","HERO")); //HERO
            cards.add(new Card("John Natalis(HERO)", 10, "MELEE","HERO")); //HERO
            cards.add(new Card("Kaedweni Siege Expert", 1, "SIEGE")); //BOOST
            cards.add(new Card("Philippa Eilhart", 10, "RANGED","HERO")); //HERO
            cards.add(new Card("Poor Fucking Infantry", 1, "MELEE")); //BOUND
            cards.add(new Card("Prince Stennis(SPY)", 5, "MELEE","SPY")); //SPY
            cards.add(new Card("Redanian Foot Soldier", 1, "MELEE"));
            cards.add(new Card("Sabrina Glevissig", 4, "RANGED"));
            cards.add(new Card("Sheldon Skaggs", 4, "RANGED"));
            cards.add(new Card("Siege Tower", 6, "SIEGE"));
            cards.add(new Card("Sigismund Dijkstra(SPY)", 4, "MELEE","SPY")); //SPY
            cards.add(new Card("Síle de Tansarville", 5, "RANGED"));
            cards.add(new Card("Thaler", 1, "SIEGE","SPY")); //SPY
            cards.add(new Card("Vernon Roche(HERO)", 10, "MELEE","HERO")); //HERO
            cards.add(new Card("ICE", 0, "MELEE", "WEATHER")); // WEATHER
            cards.add(new Card("RAIN", 0, "SIEGE", "WEATHER")); //WEATHER
            cards.add(new Card("FOGGY", 0, "RANGED", "WEATHER")); //WEATHER
            cards.add(new Card("SUN", 0, "RANGED", "WEATHER")); //WEATHER


        } else if (type.equals("Scoia'tael")) {
            cards.add(new Card("Barclay Els", 6, "MELEE"));
            cards.add(new Card("Ciaran aep Easnillien", 3, "MELEE"));
            cards.add(new Card("Dennis Cranmer", 6, "MELEE"));
            cards.add(new Card("Dol Blathanna Archer", 4, "RANGED"));
            cards.add(new Card("Dol Blathanna Scout", 6, "MELEE"));
            cards.add(new Card("Eithné(HERO)", 10, "MELEE","HERO")); //HERO
            cards.add(new Card("Filavandrel aen Fidhail", 6, "RANGED"));
            cards.add(new Card("Havekar Healer", 0, "RANGED")); //MEDIC
            cards.add(new Card("Havekar Smuggler", 5, "MELEE"));
            cards.add(new Card("Iorveth", 10, "MELEE","HERO")); //HERO
            cards.add(new Card("Isengrim Faoiltiarna(HERO)", 10, "MELEE","HERO")); //HERO
            cards.add(new Card("Milva", 10, "RANGED")); //BOOST
            cards.add(new Card("Riordain", 1, "RANGED"));
            cards.add(new Card("Saesenthessis(HERO)", 10, "RANGED","HERO")); //HERO
            cards.add(new Card("Schirrú", 8, "SIEGE")); //BOUND
            cards.add(new Card("Toruviel", 4, "RANGED"));
            cards.add(new Card("Vrihedd Brigade Recruit", 4, "RANGED"));
            cards.add(new Card("Vrihedd Brigade Veteran", 5, "MELEE"));
            cards.add(new Card("Yaevinn", 6, "RANGED"));
            cards.add(new Card("Elven Skirmisher", 2, "RANGED"));
            cards.add(new Card("Riordain", 1, "RANGED"));
            cards.add(new Card("Mahakaman Tower", 6, "SIEGE"));
            cards.add(new Card("ICE", 0, "MELEE", "WEATHER")); // WEATHER
            cards.add(new Card("RAIN", 0, "SIEGE", "WEATHER")); //WEATHER
            cards.add(new Card("FOGGY", 0, "RANGED", "WEATHER")); //WEATHER
            cards.add(new Card("SUN", 0, "RANGED", "WEATHER")); //WEATHER



        } else if (type.equals("Monsters")) {
            cards.add(new Card("Arachas", 4, "MELEE"));
            cards.add(new Card("Arachas Behemoth", 6, "SIEGE"));
            cards.add(new Card("Botchling", 4, "MELEE"));
            cards.add(new Card("Celaeno Harpy", 2, "MELEE"));
            cards.add(new Card("Cockatrice", 2, "RANGED"));
            cards.add(new Card("Crone: Brewess", 6, "MELEE")); //BOUND
            cards.add(new Card("Crone: Weavess", 6, "MELEE")); //BOUND
            cards.add(new Card("Crone: Whispess", 6, "MELEE")); //BOUND
            cards.add(new Card("Earth Elemental", 6, "SIEGE"));
            cards.add(new Card("Draug(HERO)", 10, "MELEE","HERO")); //HERO
            cards.add(new Card("Fiend", 6, "MELEE"));
            cards.add(new Card("Fire Elemental", 6, "SIEGE"));
            cards.add(new Card("Forktail", 5, "MELEE"));
            cards.add(new Card("Gargoyle", 2, "RANGED"));
            cards.add(new Card("Grave Hag", 5, "RANGED"));
            cards.add(new Card("Griffin", 5, "MELEE"));
            cards.add(new Card("Ice Giant", 5, "SIEGE"));
            cards.add(new Card("Imlerith(HERO)", 10, "MELEE","HERO")); //HERO
            cards.add(new Card("Kayran(HERO)", 10, "RANGED","HERO")); //HERO
            cards.add(new Card("Leshen(HERO)", 10, "RANGED","HERO")); //HERO
            cards.add(new Card("Plague Maiden", 5, "MELEE"));
            cards.add(new Card("Toad", 7, "RANGED")); //DESTROY ENEMY'S SIEGE ROW'S
            cards.add(new Card("Vampire: Bruxa", 4, "MELEE"));
            cards.add(new Card("ICE", 0, "MELEE", "WEATHER")); // WEATHER
            cards.add(new Card("RAIN", 0, "SIEGE", "WEATHER")); //WEATHER
            cards.add(new Card("FOGGY", 0, "RANGED", "WEATHER")); //WEATHER
            cards.add(new Card("SUN", 0, "RANGED", "WEATHER")); //WEATHER



        }
    }

    public List<Card> drawHand() {
        if (cards.size() < 10) {
            throw new IllegalStateException("Not enough cards in the deck");
        }
        Collections.shuffle(cards);
        return new ArrayList<>(cards.subList(0, 10));
    }

    public List<Card> drawAdditionalCards(int numberOfCards) {
        if (cards.size() < numberOfCards) {
            throw new IllegalStateException("Not enough cards in the deck");
        }
        List<Card> drawnCards = new ArrayList<>(cards.subList(0, numberOfCards));
        cards.removeAll(drawnCards);
        return drawnCards;
    }

    public List<Card> getRemainingCards() {
        return cards;
    }

    public Card drawCard() {
        if (cards.isEmpty()) {
            throw new IllegalStateException("No cards left in the deck");
        }
        return cards.remove(0);
    }
}
