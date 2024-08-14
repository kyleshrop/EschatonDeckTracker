package com.example.eschatondecktraker.data

import com.example.eschatondecktraker.data.CardAttributes.*

class CultistCardBase {

    enum class CultistName { Initiate, Thrall, Acolyte, Fanatic, Seer, Supplicant, Zealot, Disciple, Magus, Marauder, Herald, Templar, Pontiff, Archon, Null }

    enum class Cost(val value: Int) { One(1), Two(2), Three(3), Four(4), Five(5), Six(6) }

    enum class Scour(val value: Int) { Zero(0), One(1) }


    companion object {
        fun create(cultistName: CultistName): Card {
            return when (cultistName) {
                CultistName.Initiate -> Card(cultistName, null, Cost.One, Zeal.Zero, Divination.Zero, Influence.One, Aggression.Zero, Scour.Zero, Inspire.Zero, PointValue.Zero)
                CultistName.Thrall -> Card(cultistName, null, Cost.Two, Zeal.Zero, Divination.Zero, Influence.Zero, Aggression.One, Scour.Zero, Inspire.Zero, PointValue.One)
                CultistName.Acolyte -> Card(cultistName, null, Cost.Two, Zeal.Zero, Divination.Two, Influence.Zero, Aggression.Zero, Scour.Zero, Inspire.Zero, PointValue.Zero)
                CultistName.Fanatic -> Card(cultistName, null, Cost.Two, Zeal.Zero, Divination.Zero, Influence.Zero, Aggression.Two, Scour.Zero, Inspire.Zero, PointValue.Zero)
                CultistName.Seer -> Card(cultistName, null, Cost.Three, Zeal.Zero, Divination.Three, Influence.Zero, Aggression.Zero, Scour.Zero, Inspire.Zero, PointValue.Zero)
                CultistName.Supplicant -> Card(cultistName, null, Cost.Three, Zeal.Zero, Divination.Zero, Influence.Two, Aggression.Zero, Scour.Zero, Inspire.Zero, PointValue.Zero)
                CultistName.Zealot -> Card(cultistName, null, Cost.Three, Zeal.One, Divination.One, Influence.Zero, Aggression.One, Scour.Zero, Inspire.Zero, PointValue.Zero)
                CultistName.Disciple -> Card(cultistName, null, Cost.Three, Zeal.Zero, Divination.Zero, Influence.Zero, Aggression.Zero, Scour.One, Inspire.One, PointValue.Zero)
                CultistName.Magus -> Card(cultistName, null, Cost.Four, Zeal.One, Divination.Three, Influence.Zero, Aggression.Zero, Scour.Zero, Inspire.Zero, PointValue.Zero)
                CultistName.Marauder -> Card(cultistName, null, Cost.Four, Zeal.One, Divination.Zero, Influence.Zero, Aggression.Three, Scour.Zero, Inspire.Zero, PointValue.Zero)
                CultistName.Herald -> Card(cultistName, null, Cost.Four, Zeal.Zero, Divination.Zero, Influence.Three, Aggression.Zero, Scour.Zero, Inspire.Zero, PointValue.Zero)
                CultistName.Templar -> Card(cultistName, null, Cost.Five, Zeal.Two, Divination.Zero, Influence.Zero, Aggression.Two, Scour.Zero, Inspire.Zero, PointValue.Zero)
                CultistName.Pontiff -> Card(cultistName, null, Cost.Six, Zeal.One, Divination.One, Influence.Three, Aggression.Zero, Scour.Zero, Inspire.Zero, PointValue.Zero)
                CultistName.Archon -> Card(cultistName, null, Cost.Six, Zeal.Zero, Divination.Zero, Influence.Zero, Aggression.Four, Scour.Zero, Inspire.Two, PointValue.Zero)
                CultistName.Null -> Card(cultistName, null, Cost.One, Zeal.Zero, Divination.Zero, Influence.Zero, Aggression.Zero, Scour.Zero, Inspire.Zero, PointValue.Zero)
                else -> throw IllegalArgumentException("Undefined attributes for $cultistName")
            }
        }
    }
}
