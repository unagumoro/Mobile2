package br.edu.up.planner.ui.screens.inicio

import androidx.compose.material3.DrawerState
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

object TelaUm {
    val TELA_INICIAR_ROUTE = "t1a"
    val TELA_PROSSEGUIR_ROUTE = "t1b"
    val TELA_FINALIZAR_ROUTE = "t1c"
    val TELA_PERGUNTAS_ROUTE = "t1d/{infractionCode}"
}

@Composable
fun InicioNavHost(drawerState: DrawerState) {

    val navCtrlBottonNav = rememberNavController()

    NavHost(
        navController = navCtrlBottonNav,
        startDestination = TelaUm.TELA_INICIAR_ROUTE
    ) {
        composable(TelaUm.TELA_INICIAR_ROUTE) {
            TelaIniciar(drawerState, navCtrlBottonNav)
        }
        composable(TelaUm.TELA_PROSSEGUIR_ROUTE) {
            TelaProsseguir(drawerState, navCtrlBottonNav)
        }

        composable(TelaUm.TELA_PERGUNTAS_ROUTE) { backStackEntry ->
            val infractionCode = backStackEntry.arguments?.getString("infractionCode") ?: ""

            TelaPerguntas(
                infractionCode = infractionCode,
                navCtrlBottomNav = navCtrlBottonNav, // Passa o navCtrlBottomNav corretamente
                onFinish = { respostas ->
                    // Aqui, passamos os parâmetros para a TelaFinalizar
                    navCtrlBottonNav.navigate(
                        "${TelaUm.TELA_FINALIZAR_ROUTE}?infractionCode=$infractionCode&respostas=${
                            respostas.entries.joinToString(
                                ","
                            ) { "${it.key}:${it.value}" }
                        }"
                    )
                }
            )
        }

        composable(TelaUm.TELA_FINALIZAR_ROUTE) { backStackEntry ->
            val infractionCode = backStackEntry.arguments?.getString("infractionCode") ?: ""
            val respostasString = backStackEntry.arguments?.getString("respostas") ?: ""
            val respostas = respostasString.split(",").associate {
                val (key, value) = it.split(":")
                key.toInt() to value.toBoolean()
            }
            TelaFinalizar(
                infractionCode = infractionCode,
                respostas = respostas,
                navCtrlBottomNav = navCtrlBottonNav // Passando o navCtrlBottomNav para a TelaFinalizar
            )
        }

    }
}
