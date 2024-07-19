package com.miaplicaion.mycard.data.model

object CardManager {
    val cards = mutableListOf<Card>()

    fun addCard(card: Card) {
        cards.add(card)
    }
}
