package com.example.inzynieria.main.data

data class Magazine(val title:String, val points: Int, val categories: List<String>, val issn: String, val year: Int) {
    override fun toString(): String {
        return "$title - $points - $categories - $issn - $year"
    }
}