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

public enum Card {
    TWO_OF_SPADES,
    THREE_OF_SPADES,
    FOUR_OF_SPADES,
    FIVE_OF_SPADES,
    SIX_OF_SPADES,
    SEVEN_OF_SPADES,
    EIGHT_OF_SPADES,
    NINE_OF_SPADES,
    TEN_OF_SPADES,
    JACK_OF_SPADES,
    QUEEN_OF_SPADES,
    KING_OF_SPADES,
    ACE_OF_SPADES,
    TWO_OF_HEARTS,
    THREE_OF_HEARTS,
    FOUR_OF_HEARTS,
    FIVE_OF_HEARTS,
    SIX_OF_HEARTS,
    SEVEN_OF_HEARTS,
    EIGHT_OF_HEARTS,
    NINE_OF_HEARTS,
    TEN_OF_HEARTS,
    JACK_OF_HEARTS,
    QUEEN_OF_HEARTS,
    KING_OF_HEARTS,
    ACE_OF_HEARTS,
    TWO_OF_DIAMONDS,
    THREE_OF_DIAMONDS,
    FOUR_OF_DIAMONDS,
    FIVE_OF_DIAMONDS,
    SIX_OF_DIAMONDS,
    SEVEN_OF_DIAMONDS,
    EIGHT_OF_DIAMONDS,
    NINE_OF_DIAMONDS,
    TEN_OF_DIAMONDS,
    JACK_OF_DIAMONDS,
    QUEEN_OF_DIAMONDS,
    KING_OF_DIAMONDS,
    ACE_OF_DIAMONDS,
    TWO_OF_CLUBS,
    THREE_OF_CLUBS,
    FOUR_OF_CLUBS,
    FIVE_OF_CLUBS,
    SIX_OF_CLUBS,
    SEVEN_OF_CLUBS,
    EIGHT_OF_CLUBS,
    NINE_OF_CLUBS,
    TEN_OF_CLUBS,
    JACK_OF_CLUBS,
    QUEEN_OF_CLUBS,
    KING_OF_CLUBS,
    ACE_OF_CLUBS;

    private final static String[] suits = {"s", "h", "d", "c"};
    private final static String[] cards = {"2", "3", "4", "5", "6", "7", "8", "9", "T", "J", "Q", "K", "A"};

    public long bitMask() {
        return Constants.CARDS_BIT_MASKS[this.ordinal()];
    }

    public int suit() {
        return ordinal() / 13;
    }

    @Override
    public String toString() {
        return cards[ordinal() % 13] + suits[suit()];
    }
}
