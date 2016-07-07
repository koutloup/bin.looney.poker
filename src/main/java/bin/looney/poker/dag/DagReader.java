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

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class DagReader {

    public static DagNode[] readDag() {
        DagNode[] dagNodes = new DagNode[76154];
        try {
            BufferedReader br = new BufferedReader(new FileReader("carddag"));
            String line = br.readLine();
            while (line != null) {
                DagNode dagNode = new DagNode();
                String[] strings = line.split("\t");

                //nodeId
                dagNode.nodeId =  Integer.parseInt(strings[0]);

                //pointers
                int[] pointers = new int[13];
                for (int i = 0; i < 13; i++) {
                    pointers[i] = Integer.parseInt(strings[i+1]);
                }
                dagNode.pointers = pointers;

                //flush class
                dagNode.flushClass = Integer.parseInt(strings[14]);

                //rank class
                dagNode.rankClass = Integer.parseInt(strings[15]);

                //cards
                String sCards = strings[16].replace(",", "");
                char[] cards = sCards.substring(1, sCards.length() - 1).toCharArray();
                dagNode.cards = cards;

                //worst normal hand
                dagNode.worstNormalHand = Integer.parseInt(strings[17]);

                //worst flush hand
                dagNode.worstFlushHand = Integer.parseInt(strings[18]);

                //best normal hand
                dagNode.bestNormalHand = Integer.parseInt(strings[19]);

                //best flush hand
                dagNode.bestFlushHand = Integer.parseInt(strings[20]);

                dagNodes[dagNode.nodeId] = dagNode;
                line = br.readLine();
            }
            br.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return dagNodes;
    }

}
