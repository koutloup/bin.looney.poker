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

package bin.looney.poker.model;

import java.util.*;

public class Deck {
    List<Card> cards = new ArrayList<Card>();

    public Deck() {
        this.cards.addAll(Arrays.asList(Card.values()));
    }

    public void removeCards(List<Card> cards) {
        for (Card card : cards)
            this.cards.remove(card);
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public List<Card> dealCards(int count) {
        List<Card> result = new ArrayList<Card>();
        for (int i = 0; i < count; i++)
            result.add(cards.get(i));
        return result;
    }


}
