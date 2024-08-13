package com.example.eschatondecktraker.data

class CultistCardBase {
    enum class CultistName {
        Initiate, Thrall, Acolyte, Fanatic, Seer, Supplicant, Zealot, Disciple, Magus, Marauder, Herald, Templar, Pontiff, Archon, Null
    }

    enum class Cost(val value: Int) {
        One(1), Two(2), Three(3), Four(4), Five(5), Six(6)
    }

    enum class Zeal(val value: Int) {
        Zero(0), One(1), Two(2)
    }

    enum class Divination(val value: Int) {
        Zero(0), One(1), Two(2), Three(3)
    }

    enum class Influence(val value: Int) {
        Zero(0), One(1), Two(2), Three(3)
    }

    enum class Aggression(val value: Int) {
        Zero(0), One(1), Two(2), Three(3), Four(4)
    }

    enum class Scour(val value: Int) {
        Zero(0), One(1)
    }

    enum class Inspire(val value: Int) {
        Zero(0), One(1), Two(2)
    }

    enum class PointValue(val value: Int) {
        Zero(0), One(1)
    }


    data class Card(
        val cultistName: CultistName,
        val cost: Cost,
        val zeal: Zeal,
        val divination: Divination,
        val influence: Influence,
        val aggression: Aggression,
        val scour: Scour,
        val inspire: Inspire,
        val pointValue: PointValue
    ) {
        companion object {
            fun create(cultistName: CultistName): Card {
                return when (cultistName) {
                    CultistName.Initiate -> Card(
                        cultistName,
                        Cost.One,
                        Zeal.Zero,
                        Divination.Zero,
                        Influence.One,
                        Aggression.Zero,
                        Scour.Zero,
                        Inspire.Zero,
                        PointValue.Zero
                    )
                    CultistName.Thrall -> Card(
                        cultistName,
                        Cost.Two,
                        Zeal.Zero,
                        Divination.Zero,
                        Influence.Zero,
                        Aggression.One,
                        Scour.Zero,
                        Inspire.Zero,
                        PointValue.One
                    )
                    CultistName.Acolyte -> Card(
                        cultistName,
                        Cost.Two,
                        Zeal.Zero,
                        Divination.Two,
                        Influence.Zero,
                        Aggression.Zero,
                        Scour.Zero,
                        Inspire.Zero,
                        PointValue.Zero
                    )
                    CultistName.Fanatic -> Card(
                        cultistName,
                        Cost.Two,
                        Zeal.Zero,
                        Divination.Zero,
                        Influence.Zero,
                        Aggression.Two,
                        Scour.Zero,
                        Inspire.Zero,
                        PointValue.Zero
                    )
                    CultistName.Seer -> Card(
                        cultistName,
                        Cost.Three,
                        Zeal.Zero,
                        Divination.Three,
                        Influence.Zero,
                        Aggression.Zero,
                        Scour.Zero,
                        Inspire.Zero,
                        PointValue.Zero
                    )
                    CultistName.Supplicant -> Card(
                        cultistName,
                        Cost.Three,
                        Zeal.Zero,
                        Divination.Zero,
                        Influence.Two,
                        Aggression.Zero,
                        Scour.Zero,
                        Inspire.Zero,
                        PointValue.Zero
                    )
                    CultistName.Zealot -> Card(
                        cultistName,
                        Cost.Three,
                        Zeal.One,
                        Divination.One,
                        Influence.Zero,
                        Aggression.One,
                        Scour.Zero,
                        Inspire.Zero,
                        PointValue.Zero
                    )
                    CultistName.Disciple -> Card(
                        cultistName,
                        Cost.Three,
                        Zeal.Zero,
                        Divination.Zero,
                        Influence.Zero,
                        Aggression.Zero,
                        Scour.One,
                        Inspire.One,
                        PointValue.Zero
                    )
                    CultistName.Magus -> Card(
                        cultistName,
                        Cost.Four,
                        Zeal.One,
                        Divination.Three,
                        Influence.Zero,
                        Aggression.Zero,
                        Scour.Zero,
                        Inspire.Zero,
                        PointValue.Zero
                    )
                    CultistName.Marauder -> Card(
                        cultistName,
                        Cost.Four,
                        Zeal.One,
                        Divination.Zero,
                        Influence.Zero,
                        Aggression.Three,
                        Scour.Zero,
                        Inspire.Zero,
                        PointValue.Zero
                    )
                    CultistName.Herald -> Card(
                        cultistName,
                        Cost.Four,
                        Zeal.Zero,
                        Divination.Zero,
                        Influence.Three,
                        Aggression.Zero,
                        Scour.Zero,
                        Inspire.Zero,
                        PointValue.Zero
                    )
                    CultistName.Templar -> Card(
                        cultistName,
                        Cost.Five,
                        Zeal.Two,
                        Divination.Zero,
                        Influence.Zero,
                        Aggression.Two,
                        Scour.Zero,
                        Inspire.Zero,
                        PointValue.Zero
                    )
                    CultistName.Pontiff -> Card(
                        cultistName,
                        Cost.Six,
                        Zeal.One,
                        Divination.One,
                        Influence.Three,
                        Aggression.Zero,
                        Scour.Zero,
                        Inspire.Zero,
                        PointValue.Zero
                    )
                    CultistName.Archon -> Card(
                        cultistName,
                        Cost.Six,
                        Zeal.Zero,
                        Divination.Zero,
                        Influence.Zero,
                        Aggression.Four,
                        Scour.Zero,
                        Inspire.Two,
                        PointValue.Zero
                    )
                    CultistName.Null -> Card(
                        cultistName,
                        Cost.One,
                        Zeal.Zero,
                        Divination.Zero,
                        Influence.Zero,
                        Aggression.Zero,
                        Scour.Zero,
                        Inspire.Zero,
                        PointValue.Zero
                    )
                    else -> throw IllegalArgumentException("Undefined attributes for $cultistName")
                }
            }
        }

        override fun toString(): String {
            return "$cultistName (Zeal: $zeal, Divination: $divination, Influence: $influence, Aggression: $aggression, Scour: $scour, Inspire: $inspire, Points: $pointValue)"
        }

    }
}