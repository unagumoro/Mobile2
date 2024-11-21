package br.edu.up.planner.ui.screens.inicio

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.edu.up.planner.ui.screens.util.PlannerTopBar
import br.edu.up.planner.ui.screens.util.TelaUmBottomBar
import androidx.compose.ui.text.style.TextAlign

@Composable
fun TelaFinalizar(
    infractionCode: String,
    respostas: Map<Int, Boolean>, // Respostas passadas pela navegação
    navCtrlBottomNav: NavController
) {
    // Variáveis de estado para os campos de texto
    var textField1 by remember { mutableStateOf("") }
    var textField2 by remember { mutableStateOf("") }
    var textField3 by remember { mutableStateOf("") }
    var textField4 by remember { mutableStateOf("") }
    var textField5 by remember { mutableStateOf("") }
    var textField6 by remember { mutableStateOf("") }

    // Scaffold com TopBar e BottomBar
    Scaffold(
        content = { paddingValues ->
            // Layout principal com Padding do Scaffold
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                // Título
                Text(
                    text = "Preencha seus dados:",
                    fontSize = 40.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(30.dp),
                    textAlign = TextAlign.Center
                )

                // Campos de texto
                OutlinedTextField(
                    value = textField1,
                    onValueChange = { textField1 = it },
                    label = { Text("Nome") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 16.dp)
                )

                OutlinedTextField(
                    value = textField2,
                    onValueChange = { textField2 = it },
                    label = { Text("CPF") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 16.dp)
                )

                OutlinedTextField(
                    value = textField3,
                    onValueChange = { textField3 = it },
                    label = { Text("CNH") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 16.dp)
                )

                OutlinedTextField(
                    value = textField4,
                    onValueChange = { textField4 = it },
                    label = { Text("Número da Autuação") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 16.dp)
                )

                OutlinedTextField(
                    value = textField5,
                    onValueChange = { textField5 = it },
                    label = { Text("Data da Infração (dd/mm/aaaa)") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 16.dp)
                )

                OutlinedTextField(
                    value = textField6,
                    onValueChange = { textField6 = it },
                    label = { Text("Local da Infração") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 16.dp)
                )

                // Exibe as respostas
                Spacer(modifier = Modifier.height(16.dp))
                Text("Respostas das perguntas:")
                respostas.forEach { (key, value) ->
                    Text("Pergunta $key: ${if (value) "Sim" else "Não"}")
                }

                // Botão de finalizar
                Spacer(modifier = Modifier.height(32.dp))
                Button(
                    onClick = {
                        // Ação de finalizar (Aqui você pode processar os dados, se necessário)
                        // Por exemplo, você pode chamar uma função que salva os dados ou navega
                        // para outra tela ou realizar uma ação após finalizar
                        navCtrlBottomNav.popBackStack()
                    }
                ) {
                    Text("Finalizar")
                }
            }
        },
        bottomBar = { TelaUmBottomBar(navCtrlBottomNav) }
    )
}
