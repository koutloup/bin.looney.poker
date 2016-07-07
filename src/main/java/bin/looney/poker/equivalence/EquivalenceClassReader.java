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

package bin.looney.poker.equivalence;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class EquivalenceClassReader {

    public static EquivalenceClass[] getEquiClasses() {
        EquivalenceClass[] equiClasses = new EquivalenceClass[7463];

        try {
            BufferedReader br = new BufferedReader(new FileReader("equivalence"));
            String line = br.readLine();
            while (line != null) {
                String[] strings = line.split("\\|");
                EquivalenceClass equiClass = new EquivalenceClass();

                int rank = Integer.parseInt(strings[0]);
                equiClass.setRank(rank);
                equiClass.setSampleHand(strings[5]);
                equiClass.setShortDescription(strings[7]);

                equiClasses[rank - 1] = equiClass;

                line = br.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return equiClasses;
    }

}
