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

package bin.looney.poker.dag;

public class DagNode {
    public int      nodeId; //~equivalence class
    public int[]    pointers; //pointers to the next nodeId
    public int      flushClass; //a textual depiction of the cards in this equivalence class
    public int      rankClass; //the ID of the equivalence class if no flush is present
    public char[]   cards; //a textual depiction of the cards in this equivalence class
    public int      worstNormalHand; //the equivalence class ID of the worst hand reachable with this cards
    public int      worstFlushHand; //the equivalence class ID of the worst hand reachable flush hand
    public int      bestNormalHand; //the equivalence class ID of the best hand reachable with this cards (excluding flushes)
    public int      bestFlushHand; //the equivalence class ID of the best flush hand reachable with this cards

    public DagNode() {
        //nothing
    }

    public DagNode(int nodeId, int[] pointers, int flushClass, int rankClass, char[] cards,
                   int worstNormalHand, int worstFlushHand,int bestNormalHand, int bestFlushHand) {
        this.nodeId = nodeId;
        this.pointers = pointers;
        this.flushClass = flushClass;
        this.rankClass = rankClass;
        this.cards = cards;
        this.worstNormalHand = worstNormalHand;
        this.worstFlushHand = worstFlushHand;
        this.bestNormalHand = bestNormalHand;
        this.bestFlushHand = bestFlushHand;
    }

    public int getRank() {
        return flushClass > 0 ? flushClass : rankClass;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder;

        //concat cards
        stringBuilder = new StringBuilder();
        for (int i = 0; i < cards.length; i++) {
            stringBuilder.append(cards[i] + " ");
        }
        String sCards = stringBuilder.toString();

        stringBuilder = new StringBuilder();
        for (int i = 0; i < pointers.length; i++) {
            stringBuilder.append(pointers[i] + " ");
        }
        String sPointers = stringBuilder.toString();

        return "nodeId: " + nodeId
                + "\npointers: " + sPointers
                + "\nflushClass: " + flushClass
                + "\nrankClass: " + rankClass
                + "\ncards: " + sCards
                + "\nworstNormalHand: " + worstNormalHand
                + "\nworstFlushHand: " + worstFlushHand
                + "\nbestNormalHand: " + bestNormalHand
                + "\nbestFlushHand: " + bestFlushHand;
    }
}
