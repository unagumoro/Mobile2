package br.edu.up.planner.questions

import androidx.lifecycle.ViewModel
import androidx.compose.runtime.mutableStateOf
import br.edu.up.planner.questions.Question

class QuestionsViewModel : ViewModel() {

    private val questionsMap = mapOf(
        "167" to listOf(
            Question("Havia algum problema mecânico ou defeito no cinto de segurança no momento da infração?", listOf("Sim", "Não")),
            Question("Havia uma situação de emergência que justificasse a não utilização do cinto de segurança?", listOf("Sim", "Não")),
            Question("O veículo estava parado no momento da infração?", listOf("Sim", "Não"))
        ),
        "172" to listOf(
            Question("Foi um acidente proporcionado por uma situação de emergência?", listOf("Sim", "Não")),
            Question("O objeto foi atirado por alguém que não seja o motorista do veículo?", listOf("Sim", "Não")),
            Question("A pessoa que atirou o objeto o fez intimidado por alguma ameaça vindo de um terceiro (seja este passageiro ou não)?", listOf("Sim", "Não"))
        )
    )

    val selectedQuestions = mutableStateOf<List<Question>>(emptyList())

    fun loadQuestions(infractionCode: String) {
        selectedQuestions.value = questionsMap[infractionCode] ?: emptyList()
    }
}
