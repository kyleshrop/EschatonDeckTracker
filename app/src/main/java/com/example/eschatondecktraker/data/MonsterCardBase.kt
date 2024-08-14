package com.example.eschatondecktraker.data

import com.example.eschatondecktraker.data.CardAttributes.*


class MonsterCardBase {
    enum class MonsterName {
        Lamassu, Geist, Skeleton, Lich, Manticore, Imp, Cyclops, Crone1, Crone2, Necromancer, Familiar, Harpy, Behemoth, Basilisk, Kraken, Succubus, Incubus, Siren, Phantom, Ooze, Devil, Ghoul, Wraith, Wyrm, Gorgon, Gremlin,
    }


    companion object {
        fun create(monsterName: MonsterName): Card {
            return when (monsterName) {
                MonsterName.Lamassu -> Card(
                    null,
                    monsterName,
                    null,
                    Zeal.Zero,
                    Divination.Five,
                    Influence.Zero,
                    Aggression.Zero,
                    null,
                    Inspire.Zero,
                    PointValue.One
                )
                MonsterName.Geist -> Card(
                    null,
                    monsterName,
                    null,
                    Zeal.One,
                    Divination.Two,
                    Influence.Zero,
                    Aggression.Zero,
                    null,
                    Inspire.Zero,
                    PointValue.One
                )
                MonsterName.Skeleton -> Card(
                    null,
                    monsterName,
                    null,
                    Zeal.One,
                    Divination.One,
                    Influence.Zero,
                    Aggression.Two,
                    null,
                    Inspire.Zero,
                    PointValue.One
                )
                MonsterName.Lich -> Card(
                    null,
                    monsterName,
                    null,
                    Zeal.Zero,
                    Divination.Two,
                    Influence.One,
                    Aggression.Two,
                    null,
                    Inspire.Zero,
                    PointValue.One
                )
                MonsterName.Manticore -> Card(
                    null,
                    monsterName,
                    null,
                    Zeal.Zero,
                    Divination.Zero,
                    Influence.Zero,
                    Aggression.Five,
                    null,
                    Inspire.Two,
                    PointValue.One
                )
                MonsterName.Imp -> Card(
                    null,
                    monsterName,
                    null,
                    Zeal.One,
                    Divination.Two,
                    Influence.One,
                    Aggression.Zero,
                    null,
                    Inspire.Zero,
                    PointValue.One
                )
                MonsterName.Cyclops -> Card(
                    null,
                    monsterName,
                    null,
                    Zeal.One,
                    Divination.One,
                    Influence.One,
                    Aggression.One,
                    null,
                    Inspire.Zero,
                    PointValue.One
                )
                MonsterName.Crone1 -> Card(
                    null,
                    monsterName,
                    null,
                    Zeal.Two,
                    Divination.Zero,
                    Influence.Zero,
                    Aggression.Zero,
                    null,
                    Inspire.Zero,
                    PointValue.One
                )
                MonsterName.Crone2 -> Card(
                    null,
                    monsterName,
                    null,
                    Zeal.Two,
                    Divination.Zero,
                    Influence.Zero,
                    Aggression.Zero,
                    null,
                    Inspire.Zero,
                    PointValue.One
                )
                MonsterName.Necromancer -> Card(
                    null,
                    monsterName,
                    null,
                    Zeal.Two,
                    Divination.One,
                    Influence.Zero,
                    Aggression.One,
                    null,
                    Inspire.Zero,
                    PointValue.One
                )
                MonsterName.Familiar -> Card(
                    null,
                    monsterName,
                    null,
                    Zeal.One,
                    Divination.Two,
                    Influence.Zero,
                    Aggression.Zero,
                    null,
                    Inspire.Zero,
                    PointValue.One
                )
                MonsterName.Harpy -> Card(
                    null,
                    monsterName,
                    null,
                    Zeal.One,
                    Divination.Zero,
                    Influence.Zero,
                    Aggression.Three,
                    null,
                    Inspire.Zero,
                    PointValue.One
                )
                MonsterName.Behemoth -> Card(
                    null,
                    monsterName,
                    null,
                    Zeal.Zero,
                    Divination.Zero,
                    Influence.Zero,
                    Aggression.Five,
                    null,
                    Inspire.Zero,
                    PointValue.One
                )
                MonsterName.Basilisk -> Card(
                    null,
                    monsterName,
                    null,
                    Zeal.One,
                    Divination.One,
                    Influence.One,
                    Aggression.Two,
                    null,
                    Inspire.Zero,
                    PointValue.One
                )
                MonsterName.Kraken -> Card(
                    null,
                    monsterName,
                    null,
                    Zeal.One,
                    Divination.Zero,
                    Influence.Zero,
                    Aggression.Four,
                    null,
                    Inspire.Zero,
                    PointValue.One
                )
                MonsterName.Succubus -> Card(
                    null,
                    monsterName,
                    null,
                    Zeal.Zero,
                    Divination.Zero,
                    Influence.Three,
                    Aggression.Zero,
                    null,
                    Inspire.Zero,
                    PointValue.One
                )
                MonsterName.Incubus -> Card(
                    null,
                    monsterName,
                    null,
                    Zeal.One,
                    Divination.Zero,
                    Influence.Three,
                    Aggression.Zero,
                    null,
                    Inspire.Zero,
                    PointValue.One
                )
                MonsterName.Siren -> Card(
                    null,
                    monsterName,
                    null,
                    Zeal.One,
                    Divination.Zero,
                    Influence.Two,
                    Aggression.Zero,
                    null,
                    Inspire.Two,
                    PointValue.One
                )
                MonsterName.Phantom -> Card(
                    null,
                    monsterName,
                    null,
                    Zeal.One,
                    Divination.Three,
                    Influence.Zero,
                    Aggression.Zero,
                    null,
                    Inspire.Zero,
                    PointValue.One
                )
                MonsterName.Ooze -> Card(
                    null,
                    monsterName,
                    null,
                    Zeal.Zero,
                    Divination.Zero,
                    Influence.Zero,
                    Aggression.Three,
                    null,
                    Inspire.One,
                    PointValue.One
                )
                MonsterName.Devil -> Card(
                    null,
                    monsterName,
                    null,
                    Zeal.Zero,
                    Divination.Zero,
                    Influence.Two,
                    Aggression.One,
                    null,
                    Inspire.Zero,
                    PointValue.One
                )
                MonsterName.Ghoul -> Card(
                    null,
                    monsterName,
                    null,
                    Zeal.One,
                    Divination.Zero,
                    Influence.Zero,
                    Aggression.Two,
                    null,
                    Inspire.Zero,
                    PointValue.One
                )
                MonsterName.Wraith -> Card(
                    null,
                    monsterName,
                    null,
                    Zeal.Two,
                    Divination.Zero,
                    Influence.Zero,
                    Aggression.Three,
                    null,
                    Inspire.Two,
                    PointValue.One
                )
                MonsterName.Wyrm -> Card(
                    null,
                    monsterName,
                    null,
                    Zeal.Two,
                    Divination.Zero,
                    Influence.Zero,
                    Aggression.Two,
                    null,
                    Inspire.Zero,
                    PointValue.One
                )
                MonsterName.Gorgon -> Card(
                    null,
                    monsterName,
                    null,
                    Zeal.One,
                    Divination.Zero,
                    Influence.Two,
                    Aggression.Zero,
                    null,
                    Inspire.Zero,
                    PointValue.One
                )
                MonsterName.Gremlin -> Card(
                    null,
                    monsterName,
                    null,
                    Zeal.One,
                    Divination.Two,
                    Influence.One,
                    Aggression.Zero,
                    null,
                    Inspire.Zero,
                    PointValue.One
                )
            }
        }
    }
}

