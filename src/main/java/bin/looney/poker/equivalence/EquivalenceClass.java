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

public class EquivalenceClass {
    private int rank;
    private String sampleHand;
    private String shortDescription;

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public String getSampleHand() {
        return sampleHand;
    }

    public void setSampleHand(String sampleHand) {
        this.sampleHand = sampleHand;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    @Override
    public String toString() {
        return "EquivalenceClass{" +
                "rank=" + rank +
                ", sampleHand='" + sampleHand + '\'' +
                ", shortDescription='" + shortDescription + '\'' +
                '}';
    }
}
