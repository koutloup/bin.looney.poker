/*
 * Copyright 2016 Petros Koutloubasis <koutloup@gmail.com>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.

 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.

 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
*/

package bin.looney.poker.examples;

import bin.looney.poker.dag.CardDag;
import bin.looney.poker.equivalence.EquivalenceClass;
import bin.looney.poker.equivalence.EquivalenceClassReader;
import bin.looney.poker.model.Card;
import bin.looney.poker.model.Deck;
import bin.looney.poker.model.Hand;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kekse on 07/07/16.
 */
public class Main {

    private final static EquivalenceClass[] equivalenceClasses = EquivalenceClassReader.getEquiClasses();
    private final static CardDag cardDag = new CardDag();
    private final static Deck deck = new Deck();

    public static void main(String args[]) {
        randomHands();
        monteCarlo();
    }

    public static void randomHands() {
        System.out.println("some random hand with..");
        for (int i = 0; i < 10; i++) {
            deck.shuffle();
            List<Card> randomHand = deck.dealCards(7);
            int rank = cardDag.getEquivalenceClassRank(randomHand);
            EquivalenceClass equivalenceClass = equivalenceClasses[rank];
            System.out.println(randomHand);
            System.out.println(equivalenceClass);
        }
    }


    public static void monteCarlo() {
        System.out.println("monte carlo example..");
        List<Hand> hands = new ArrayList<Hand>();
        hands.add(new Hand(Card.ACE_OF_CLUBS, Card.ACE_OF_DIAMONDS));
        hands.add(new Hand(Card.TEN_OF_CLUBS, Card.NINE_OF_CLUBS));

        MonteCarlo.calc(hands.toArray(new Hand[0]));
    }

}
