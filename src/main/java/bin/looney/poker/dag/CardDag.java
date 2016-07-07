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

import bin.looney.poker.model.Card;

import java.util.Arrays;
import java.util.List;

public class CardDag {

    private static final DagNode[] mDagNodes = DagReader.readDag();

    public DagNode[] getNodes(List<Card> cards) {
        return getNodes(cards, null);
    }

    public DagNode[] getNodes(List<Card> cards, DagNode[] dagNodes) {
        DagNode[] nodes = new DagNode[5]; //one for  non-flush hands, and 4 for flush hands
        if (dagNodes != null) {
            nodes = Arrays.copyOf(dagNodes, dagNodes.length);
        }

        for (Card card : cards) {
            int suit = card.suit();
            int nodeIndex = card.ordinal() % 13;

            DagNode flushNode = nodes[suit];
            if (flushNode == null) {
                nodes[suit] = mDagNodes[nodeIndex];
            } else {
                nodes[suit] = mDagNodes[flushNode.pointers[nodeIndex]];
            }

            //rank dag
            DagNode rankNode = nodes[4];
            if (rankNode == null) {
                nodes[4] = mDagNodes[nodeIndex];
            } else {
                nodes[4] = mDagNodes[rankNode.pointers[nodeIndex]];
            }
        }

        return nodes;
    }

    public int getEquivalenceClassRank(List<Card> cards) {
        return getEquivalenceClassRank(cards, null);
    }

    public int getEquivalenceClassRank(List<Card> cards, DagNode[] dagNodes) {
        DagNode[] nodes = getNodes(cards, dagNodes);

        //check for flush
        for (int i = 0; i < 4; i++) {
            DagNode flushNode = nodes[i];
            if (flushNode != null && flushNode.flushClass > 0) {
                return flushNode.flushClass;
            }
        }

        //no flush
        return nodes[4].rankClass;
    }

}
