package com.example.eschatondecktraker.data

class MonsterCardBase {
    enum class MonsterName {
        Lamassu, Geist, Skeleton, Lich, Manticore, Imp, Cyclops, Crone1, Crone2, Necromancer, Familiar, Harpy, Behemoth, Basilisk, Kraken, Succubus, Incubus, Siren, Phantom, Ooze, Devil, Ghoul, Wraith, Wyrm, Gorgon, Gremlin,
    }

    enum class Zeal(val value: Int) {
        Zero(0), One(1), Two(2)
    }

    enum class Divination(val value: Int) {
        Zero(0), One(1), Two(2), Three(3), Four(4), Five(5)
    }

    enum class Influence(val value: Int) {
        Zero(0), One(1), Two(2), Three(3)
    }

    enum class Aggression(val value: Int) {
        Zero(0), One(1), Two(2), Three(3), Four(4), Five(5)
    }


    enum class Inspire(val value: Int) {
        Zero(0), One(1), Two(2)
    }

    enum class PointValue(val value: Int) {
        One(1)
    }

    data class Card(
        val monsterName: MonsterName,
        val zeal: Zeal,
        val divination: Divination,
        val influence: Influence,
        val aggression: Aggression,
        val inspire: Inspire,
        val pointValue: PointValue = PointValue.One
    ) {
        companion object {
            fun create(monsterName: MonsterName): Card {
                return when (monsterName) {
                    MonsterName.Lamassu -> Card(
                        monsterName,
                        Zeal.Zero,
                        Divination.Five,
                        Influence.Zero,
                        Aggression.Zero,
                        Inspire.Zero
                    )
                    MonsterName.Geist -> Card(
                        monsterName,
                        Zeal.One,
                        Divination.Two,
                        Influence.Zero,
                        Aggression.Zero,
                        Inspire.Zero
                    )
                    MonsterName.Skeleton -> Card(
                        monsterName,
                        Zeal.One,
                        Divination.One,
                        Influence.Zero,
                        Aggression.Two,
                        Inspire.Zero
                    )
                    MonsterName.Lich -> Card(
                        monsterName,
                        Zeal.Zero,
                        Divination.Two,
                        Influence.One,
                        Aggression.Two,
                        Inspire.Zero
                    )
                    MonsterName.Manticore -> Card(
                        monsterName,
                        Zeal.Zero,
                        Divination.Zero,
                        Influence.Zero,
                        Aggression.Five,
                        Inspire.Two
                    )
                    MonsterName.Imp -> Card(
                        monsterName,
                        Zeal.One,
                        Divination.Two,
                        Influence.One,
                        Aggression.Zero,
                        Inspire.Zero
                    )
                    MonsterName.Cyclops -> Card(
                        monsterName,
                        Zeal.One,
                        Divination.One,
                        Influence.One,
                        Aggression.One,
                        Inspire.Zero
                    )
                    MonsterName.Crone1 -> Card(
                        monsterName,
                        Zeal.Two,
                        Divination.Zero,
                        Influence.Zero,
                        Aggression.Zero,
                        Inspire.Zero
                    )
                    MonsterName.Crone2 -> Card(
                        monsterName,
                        Zeal.Two,
                        Divination.Zero,
                        Influence.Zero,
                        Aggression.Zero,
                        Inspire.Zero
                    )
                    MonsterName.Necromancer -> Card(
                        monsterName,
                        Zeal.Two,
                        Divination.One,
                        Influence.Zero,
                        Aggression.One,
                        Inspire.Zero
                    )
                    MonsterName.Familiar -> Card(
                        monsterName,
                        Zeal.One,
                        Divination.Two,
                        Influence.Zero,
                        Aggression.Zero,
                        Inspire.Zero
                    )
                    MonsterName.Harpy -> Card(
                        monsterName,
                        Zeal.One,
                        Divination.Zero,
                        Influence.Zero,
                        Aggression.Three,
                        Inspire.Zero
                    )
                    MonsterName.Behemoth -> Card(
                        monsterName,
                        Zeal.Zero,
                        Divination.Zero,
                        Influence.Zero,
                        Aggression.Five,
                        Inspire.Zero
                    )
                    MonsterName.Basilisk -> Card(
                        monsterName,
                        Zeal.One,
                        Divination.One,
                        Influence.One,
                        Aggression.Two,
                        Inspire.Zero
                    )
                    MonsterName.Kraken -> Card(
                        monsterName,
                        Zeal.One,
                        Divination.Zero,
                        Influence.Zero,
                        Aggression.Four,
                        Inspire.Zero
                    )
                    MonsterName.Succubus -> Card(
                        monsterName,
                        Zeal.Zero,
                        Divination.Zero,
                        Influence.Three,
                        Aggression.Zero,
                        Inspire.Zero
                    )
                    MonsterName.Incubus -> Card(
                        monsterName,
                        Zeal.One,
                        Divination.Zero,
                        Influence.Three,
                        Aggression.Zero,
                        Inspire.Zero
                    )
                    MonsterName.Siren -> Card(
                        monsterName,
                        Zeal.One,
                        Divination.Zero,
                        Influence.Two,
                        Aggression.Zero,
                        Inspire.Two
                    )
                    MonsterName.Phantom -> Card(
                        monsterName,
                        Zeal.One,
                        Divination.Three,
                        Influence.Zero,
                        Aggression.Zero,
                        Inspire.Zero
                    )
                    MonsterName.Ooze -> Card(
                        monsterName,
                        Zeal.Zero,
                        Divination.Zero,
                        Influence.Zero,
                        Aggression.Three,
                        Inspire.One
                    )
                    MonsterName.Devil -> Card(
                        monsterName,
                        Zeal.Zero,
                        Divination.Zero,
                        Influence.Two,
                        Aggression.One,
                        Inspire.Zero
                    )
                    MonsterName.Ghoul -> Card(
                        monsterName,
                        Zeal.One,
                        Divination.Zero,
                        Influence.Zero,
                        Aggression.Two,
                        Inspire.Zero
                    )
                    MonsterName.Wraith -> Card(
                        monsterName,
                        Zeal.Two,
                        Divination.Zero,
                        Influence.Zero,
                        Aggression.Three,
                        Inspire.Two
                    )
                    MonsterName.Wyrm -> Card(
                        monsterName,
                        Zeal.Two,
                        Divination.Zero,
                        Influence.Zero,
                        Aggression.Two,
                        Inspire.Zero
                    )
                    MonsterName.Gorgon -> Card(
                        monsterName,
                        Zeal.One,
                        Divination.Zero,
                        Influence.Two,
                        Aggression.Zero,
                        Inspire.Zero
                    )
                    MonsterName.Gremlin -> Card(
                        monsterName,
                        Zeal.One,
                        Divination.Two,
                        Influence.One,
                        Aggression.Zero,
                        Inspire.Zero
                    )

                    else -> throw IllegalArgumentException("Undefined attributes for $monsterName")
                }
            }
        }
    }
}