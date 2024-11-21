package br.edu.up.planner.ui.screens.inicio

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import br.edu.up.planner.R // Importando o recurso de imagem
import br.edu.up.planner.ui.screens.util.PlannerTopBar
import br.edu.up.planner.ui.screens.util.TelaUmBottomBar

@Composable
fun TelaProsseguir(
    drawerState: DrawerState,
    navCtrlBottonNav: NavController
) {
    Scaffold(
        topBar = {
            PlannerTopBar(drawerState)
        },
        content = { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                // Variáveis de estado
                var expanded by remember { mutableStateOf(false) }
                var infractionCode by remember { mutableStateOf("Selecione o código da infração") }

                // Imagem
                Image(
                    painter = painterResource(id = R.drawable.sete),
                    contentDescription = "Imagem de multa",
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(350.dp)
                        .padding(bottom = 16.dp)
                )

                // Menu suspenso com âncora
                Box {
                    // Botão para abrir o menu suspenso
                    Button(onClick = { expanded = true }) {
                        Text(text = infractionCode)
                    }

                    // DropdownMenu ancorado ao botão
                    DropdownMenu(
                        expanded = expanded,
                        onDismissRequest = { expanded = false }
                    ) {
                        DropdownMenuItem(
                            text = { Text("167") },
                            onClick = {
                                infractionCode = "167"
                                expanded = false
                            }
                        )
                        DropdownMenuItem(
                            text = { Text("172") },
                            onClick = {
                                infractionCode = "172"
                                expanded = false
                            }
                        )
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))
                Button(onClick = {
                    navCtrlBottonNav.navigate(TelaUm.TELA_PERGUNTAS_ROUTE.replace("{infractionCode}", infractionCode))
                }) {
                    Text("Avançar")
                }

            }
        },
        bottomBar = { TelaUmBottomBar(navCtrlBottonNav) }
    )
}
