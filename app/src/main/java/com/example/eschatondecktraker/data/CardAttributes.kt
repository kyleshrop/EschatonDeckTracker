package com.example.eschatondecktraker.data

class CardAttributes {

    enum class Zeal(val value: Int) {
        Zero(0), One(1), Two(2), Three(3), Four(4), Five(5)
    }

    enum class Divination(val value: Int) {
        Zero(0), One(1), Two(2), Three(3), Five(5)
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
        Zero(0), One(1)
    }
}