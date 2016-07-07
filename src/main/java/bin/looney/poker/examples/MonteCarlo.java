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
import bin.looney.poker.dag.DagNode;
import bin.looney.poker.model.Card;
import bin.looney.poker.model.Deck;
import bin.looney.poker.model.Hand;

import java.util.List;

/**
 * Created by kekse on 23/02/15.
 */
public class MonteCarlo {

    public static void calc(Hand[] hands) {
        Deck deck = new Deck();
        CardDag cardDag = new CardDag();

        //remove handcards from deck
        for (Hand hand : hands) {
            deck.removeCards(hand.getCards());
        }

        //create starting nodes
        DagNode[][] handDagNodes = new DagNode[hands.length][];
        for (int i = 0; i < hands.length; i++) {
            handDagNodes[i] = cardDag.getNodes(hands[i].getCards());
        }

        int wins[] = new int[hands.length];
        for (int i = 0; i < 200000; i++) {
            deck.shuffle();
            List<Card> cards = deck.dealCards(5);

            int bestRank = 9999;
            int[] ranks = new int[hands.length];
            for (int x = 0; x < hands.length; x++) {
                int rank = cardDag.getEquivalenceClassRank(cards, handDagNodes[x]);
                ranks[x] = rank;
                if (rank < bestRank)
                    bestRank = rank;
            }

            for (int x = 0; x < hands.length; x++) {
                if (ranks[x] == bestRank)
                    wins[x] = wins[x] + 1;
            }
        }

        System.out.println(wins);
        int totalWins = 0;
        for (int i = 0; i <hands.length; i++)
            totalWins += wins[i];


        for (int i = 0; i < hands.length; i++)
            System.out.println(i + ": " + wins[i] + "\t" + (float)(wins[i]) / 200000);
    }

}
