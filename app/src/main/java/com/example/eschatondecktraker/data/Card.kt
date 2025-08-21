package com.example.eschatondecktraker.data

data class Card(
    val cultistName: CultistCardBase.CultistName?,
    val monsterName: MonsterCardBase.MonsterName?,
    val cost: CultistCardBase.Cost?,
    val zeal: CardAttributes.Zeal,
    val divination: CardAttributes.Divination,
    val influence: CardAttributes.Influence,
    val aggression: CardAttributes.Aggression,
    val scour: CultistCardBase.Scour?,
    val inspire: CardAttributes.Inspire,
    val pointValue: CardAttributes.PointValue,
    var isDrawn: Boolean = false,
    var isOwned: Boolean = false
) {
    fun getImageName(): String {
        return when {
            cultistName != null -> when (cultistName) {
                CultistCardBase.CultistName.Marauder -> "maurader"
                else -> cultistName.name.lowercase()
            }
            monsterName != null -> when (monsterName) {
                MonsterCardBase.MonsterName.Crone1 -> "crone"
                MonsterCardBase.MonsterName.Crone2 -> "crone"
                else -> monsterName.name.lowercase()
            }
            else -> "card_back"
        }
    }
}