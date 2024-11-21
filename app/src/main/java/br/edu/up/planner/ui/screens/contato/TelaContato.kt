package br.edu.up.planner.ui.screens.contato

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.edu.up.planner.ui.screens.util.PlannerTopBar

@Composable
fun TelaContato(drawerState: DrawerState) {
    Scaffold(
        topBar = {
            PlannerTopBar(drawerState)
        },
        content = { innerPadding ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Top
            ) {
                // Título em negrito
                Text(
                    text = "Contato",
                    fontSize = 64.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(16.dp)
                )

                // Informações de contato
                Column(
                    modifier = Modifier.padding(16.dp)
                ) {
                    Text(
                        text = "Escritório",
                        fontSize = 48.sp,
                        modifier = Modifier.padding(bottom = 8.dp)
                    )

                    Text(
                        text = "\nAv. Sete de Setembro, 2775 - Rebouças, Curitiba - PR, 80230-010\n",
                        fontSize = 24.sp,
                        modifier = Modifier.padding(bottom = 16.dp)
                    )

                    // Linha horizontal
                    Divider(color = Color.Gray, thickness = 1.dp)

                    // Telefone
                    Text(
                        text = "\nTelefone: ",
                        fontSize = 22.sp,
                        modifier = Modifier.padding(vertical = 4.dp)
                    )
                    Text(
                        text = "41 99999-9999",
                        fontSize = 26.sp,
                        color = Color.Blue,
                        textDecoration = TextDecoration.Underline,
                        modifier = Modifier.padding(vertical = 4.dp)
                    )

                    // Email
                    Text(
                        text = "\nEmail: ",
                        fontSize = 22.sp,
                        modifier = Modifier.padding(vertical = 4.dp)
                    )
                    Text(
                        text = "info@company.com",
                        fontSize = 26.sp,
                        color = Color.Blue,
                        textDecoration = TextDecoration.Underline,
                        modifier = Modifier.padding(vertical = 4.dp)
                    )
                }
            }
        }
    )
}
