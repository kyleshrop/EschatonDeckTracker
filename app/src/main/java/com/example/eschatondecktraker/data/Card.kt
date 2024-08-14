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
    val pointValue1: CardAttributes.PointValue?,
)