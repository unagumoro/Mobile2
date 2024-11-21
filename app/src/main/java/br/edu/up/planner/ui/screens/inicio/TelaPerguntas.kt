package br.edu.up.planner.ui.screens.inicio

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import br.edu.up.planner.questions.QuestionsViewModel
import br.edu.up.planner.dados.Multa

@Composable
fun TelaPerguntas(
    infractionCode: String,
    questionsViewModel: QuestionsViewModel = viewModel(), // Usando ViewModel
    onFinish: (Map<Int, Boolean>) -> Unit,
    navCtrlBottomNav: NavController
) {
    // Obter as perguntas do ViewModel
    val questions = questionsViewModel.questions.collectAsState(initial = emptyList()).value // Aqui você coleta as perguntas

    // Map para armazenar as respostas (Sim ou Não)
    var respostas by remember { mutableStateOf(mapOf<Int, Boolean>()) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text(text = "Código da Infração: $infractionCode")

        // Exibir as perguntas
        questions.forEachIndexed { index, question ->
            Column {
                Text(text = "${index + 1}. ${question.pergunta}")
                val options = listOf("Sim", "Não") // Opções fixas para as respostas
                options.forEach { option ->
                    Button(onClick = {
                        // Armazenar a resposta selecionada
                        val answer = option == "Sim" // Mapeia "Sim" para true, "Não" para false
                        respostas = respostas + (index to answer)
                    }) {
                        Text(option)
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Botão de finalizar
        Button(
            onClick = {
                // Passar as respostas para a próxima tela
                onFinish(respostas)
                navCtrlBottomNav.navigate("t1c/${infractionCode}")
            }
        ) {
            Text("Finalizar")
        }
    }
}
