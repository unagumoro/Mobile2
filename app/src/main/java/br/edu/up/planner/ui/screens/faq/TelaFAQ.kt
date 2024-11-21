package br.edu.up.planner.ui.screens.faq

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.edu.up.planner.ui.screens.util.PlannerTopBar
import androidx.compose.ui.text.font.FontWeight

@Composable
fun TelaFAQ(drawerState: DrawerState) {
    // Estado para controlar qual item está expandido
    var expandedItem by remember { mutableStateOf(-1) } // -1 significa nenhum item expandido

    Scaffold(
        topBar = {
            PlannerTopBar(drawerState)
        },
        content = { iPad ->
            iPad
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Top
            ) {
                Text(
                    text = "\nFAQ",
                    fontSize = 64.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(16.dp)
                )

                // Subtítulo 1
                FAQItem(
                    title = "Como funciona?",
                    content = "Na aba \"Prosseguir\" no footer, selecione o código da sua infração e em seguida clique no botão \"Prosseguir\". Responda as perguntas com sinceridade e clique em \"Continuar\". Após isso, uma nova pergunta aparecerá na tela, você deve respondê-la também. Por fim, preencha os seus dados e clicar em \"Salvar\". Pronto, seu recurso está pronto, agora é só copiá-lo!",
                    index = 0,
                    expandedItem = expandedItem,
                    onExpandChange = { expandedItem = if (expandedItem == 0) -1 else 0 }
                )

                Spacer(modifier = Modifier.height(8.dp)) // Espaço entre os itens

                // Subtítulo 2
                FAQItem(
                    title = "Qual a vantagem de usar nossos recursos?",
                    content = "Além de nossos recursos seguirem as normas do português e o molde condinzente com um recurso deste tipo, você não precisa perder horas buscando a melhor forma de esclarescer o seu relato, pois a nossa equipe detém a experiência necessária para lhe fornecê-la.",
                    index = 1,
                    expandedItem = expandedItem,
                    onExpandChange = { expandedItem = if (expandedItem == 1) -1 else 1 }
                )

                Spacer(modifier = Modifier.height(8.dp)) // Espaço entre os itens

                // Subtítulo 3
                FAQItem(
                    title = "O recurso funciona?",
                    content = "Muitas pessoas têm suas infrações anuladas, e nós buscamos aumentar essa estatística cada vez mais. É comum multas serem catalogadas de forma errônea ou equivocada, e é nosso dever como cidadão lutar pelo que é justo.",
                    index = 2,
                    expandedItem = expandedItem,
                    onExpandChange = { expandedItem = if (expandedItem == 2) -1 else 2 }
                )

                Spacer(modifier = Modifier.height(8.dp)) // Espaço entre os itens

                // Subtítulo 4
                FAQItem(
                    title = "Precisa pagar?",
                    content = "Essa é a melhor parte, o nosso serviço é inteiramente gratuíto. Consideramos transformar em um serviço pago num futuro breve, portanto é mais um motivo para você aproveitar esta oportunidade.",
                    index = 3,
                    expandedItem = expandedItem,
                    onExpandChange = { expandedItem = if (expandedItem == 3) -1 else 3 }
                )
            }
        }
    )
}

@Composable
fun FAQItem(
    title: String,
    content: String,
    index: Int,
    expandedItem: Int,
    onExpandChange: () -> Unit
) {
    // Usando Card para fazer o "balão"
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onExpandChange() }
            .padding(8.dp),
        shape = RoundedCornerShape(8.dp), // Define cantos arredondados
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFF46d3d5)
        ),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column(modifier = Modifier.fillMaxWidth().padding(16.dp)) {
            Text(
                text = title,
                fontSize = 32.sp,
                color = Color(0xFF140530)
            )
            if (expandedItem == index) {
                Spacer(modifier = Modifier.height(8.dp)) // Espaço entre o título e o conteúdo
                Text(
                    text = content,
                    fontSize = 24.sp,
                    color = Color(0xFF817d8a),
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
    }
}
