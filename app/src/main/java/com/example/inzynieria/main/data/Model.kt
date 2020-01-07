package com.example.inzynieria.main.data

object Model {
    data class Result(val magazines: Magazines)
    data class Magazines(val title: String, val points: Points)
    data class Points(val score: Int)
}