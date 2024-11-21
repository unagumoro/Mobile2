package br.edu.up.planner.questions

data class Question(
    val questionText: String,
    val options: List<String> // Se necessário, pode incluir opções de resposta
)
