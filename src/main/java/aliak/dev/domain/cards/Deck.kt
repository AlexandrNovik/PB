package aliak.dev.domain.cards

import java.util.*

class Deck {
    private val deck: ArrayList<Card> = arrayListOf()

    init {
        fillDeck()
    }

    fun shuffleDeck() = Collections.shuffle(deck)

    private fun fillDeck() {
        if (deck.isEmpty().not()) {
            deck.clear()
        }
        Cards.values().iterator().forEach {
            deck.add(it.card)
        }
    }

    enum class Cards(val card: Card) {
        D_2(Card(CardRating.TWO, CardSuit.D)),
        D_3(Card(CardRating.TREE, CardSuit.D)),
        D_4(Card(CardRating.FOUR, CardSuit.D)),
        D_5(Card(CardRating.FIVE, CardSuit.D)),
        D_6(Card(CardRating.SIX, CardSuit.D)),
        D_7(Card(CardRating.SEVEN, CardSuit.D)),
        D_8(Card(CardRating.EIGHT, CardSuit.D)),
        D_9(Card(CardRating.NINE, CardSuit.D)),
        D_10(Card(CardRating.TEN, CardSuit.D)),
        D_J(Card(CardRating.J, CardSuit.D)),
        D_Q(Card(CardRating.Q, CardSuit.D)),
        D_K(Card(CardRating.K, CardSuit.D)),
        D_A(Card(CardRating.A, CardSuit.D)),

        C_2(Card(CardRating.TWO, CardSuit.C)),
        C_3(Card(CardRating.TREE, CardSuit.C)),
        C_4(Card(CardRating.FOUR, CardSuit.C)),
        C_5(Card(CardRating.FIVE, CardSuit.C)),
        C_6(Card(CardRating.SIX, CardSuit.C)),
        C_7(Card(CardRating.SEVEN, CardSuit.C)),
        C_8(Card(CardRating.EIGHT, CardSuit.C)),
        C_9(Card(CardRating.NINE, CardSuit.C)),
        C_10(Card(CardRating.TEN, CardSuit.C)),
        C_J(Card(CardRating.J, CardSuit.C)),
        C_Q(Card(CardRating.Q, CardSuit.C)),
        C_K(Card(CardRating.K, CardSuit.C)),
        C_A(Card(CardRating.A, CardSuit.C)),

        H_2(Card(CardRating.TWO, CardSuit.H)),
        H_3(Card(CardRating.TREE, CardSuit.H)),
        H_4(Card(CardRating.FOUR, CardSuit.H)),
        H_5(Card(CardRating.FIVE, CardSuit.H)),
        H_6(Card(CardRating.SIX, CardSuit.H)),
        H_7(Card(CardRating.SEVEN, CardSuit.H)),
        H_8(Card(CardRating.EIGHT, CardSuit.H)),
        H_9(Card(CardRating.NINE, CardSuit.H)),
        H_10(Card(CardRating.TEN, CardSuit.H)),
        H_J(Card(CardRating.J, CardSuit.H)),
        H_Q(Card(CardRating.Q, CardSuit.H)),
        H_K(Card(CardRating.K, CardSuit.H)),
        H_A(Card(CardRating.A, CardSuit.H)),

        S_2(Card(CardRating.TWO, CardSuit.S)),
        S_3(Card(CardRating.TREE, CardSuit.S)),
        S_4(Card(CardRating.FOUR, CardSuit.S)),
        S_5(Card(CardRating.FIVE, CardSuit.S)),
        S_6(Card(CardRating.SIX, CardSuit.S)),
        S_7(Card(CardRating.SEVEN, CardSuit.S)),
        S_8(Card(CardRating.EIGHT, CardSuit.S)),
        S_9(Card(CardRating.NINE, CardSuit.S)),
        S_10(Card(CardRating.TEN, CardSuit.S)),
        S_J(Card(CardRating.J, CardSuit.S)),
        S_Q(Card(CardRating.Q, CardSuit.S)),
        S_K(Card(CardRating.K, CardSuit.S)),
        S_A(Card(CardRating.A, CardSuit.S)),
    }
}