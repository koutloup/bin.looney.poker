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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Hand {
    private List<Card> cards = new ArrayList<>();

    public Hand(Card... cards) {
        setCards(cards);
    }

    public Hand(long cardsBitMask) {
        List<Card> cardsList = new ArrayList<Card>();
        for (int i = 0; i < Constants.CARDS_BIT_MASKS.length; i++) {
            long cardBitMask = Constants.CARDS_BIT_MASKS[i];
            if ((cardBitMask & cardsBitMask) != 0) {
                cardsList.add(Card.values()[i]);
            }
        }
        this.cards = cardsList;
    }

    public void setCards(Card[] cards) {
        for (int i = 0; i < cards.length; i++) {
            this.cards.add(cards[i]);
        }
    }

    public void addCards(List<Card> cards) {
        this.cards.addAll(cards);
    }

    public List<Card> getCards() {
        return cards;
    }

    @Override
    public String toString() {
        String string = "";
        for (Card card : cards) {
            string += Constants.CARD_STRINGS[card.ordinal()] + " ";
        }
        return string;
    }

    public long cardsBitMask() {
        long cardsBitMask = 0L;
        for (Card card : cards) {
            cardsBitMask |= card.bitMask();
        }
        return cardsBitMask;
    }
}
