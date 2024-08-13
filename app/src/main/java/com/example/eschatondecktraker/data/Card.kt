package com.example.eschatondecktraker.data

data class Card(
    val cultistName: CultistCardBase.CultistName?,
    val monsterName: MonsterCardBase.MonsterName?,
    val zeal: CultistCardBase.Zeal,
    val divination: CultistCardBase.Divination,
    val influence: CultistCardBase.Influence,
    val aggression: CultistCardBase.Aggression,
    val scour: CultistCardBase.Scour?,
    val inspire: CultistCardBase.Inspire,
    val pointValue: MonsterCardBase.PointValue
)