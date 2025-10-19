package com.srproyecto.screentime.estadisticas

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class tiempoVacio {

    private val ScreenBackground = Color(0xFFBBDBE2)
    private val OnBackground = Color(0xFF000000)
    private val SubText = Color(0xFF666666)

    @Composable
    fun TiempoUsoSinDatosScreen() {
        Scaffold { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .background(ScreenBackground)
                    .verticalScroll(rememberScrollState())
            ) {
                TiempoUsoTopBar()

                Surface(
                    shape = RoundedCornerShape(50),
                    color = Color(0xFF64FFDA),
                    modifier = Modifier.align(Alignment.CenterHorizontally).padding(vertical = 16.dp)
                ) {
                    Text(
                        "Tiempo de uso",
                        color = OnBackground,
                        modifier = Modifier.padding(horizontal = 16.dp, vertical = 6.dp),
                        fontSize = 16.sp
                    )
                }

                OutlinedButton(
                    onClick = {},
                    modifier = Modifier.align(Alignment.CenterHorizontally).padding(bottom = 80.dp),
                    shape = RoundedCornerShape(50),
                    colors = ButtonDefaults.outlinedButtonColors(containerColor = Color(0xFFE0E0E0), contentColor = OnBackground),
                    border = BorderStroke(1.dp, SubText)
                ) {
                    Text("Sitio de Apuestas")
                    Icon(Icons.Filled.Search, contentDescription = null, modifier = Modifier.size(20.dp).padding(start = 8.dp), tint = OnBackground)
                }

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Icon(
                            Icons.Filled.Search,
                            contentDescription = "Sin Uso",
                            modifier = Modifier.size(64.dp),
                            tint = SubText
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            "No hay uso para este periodo de tiempo.",
                            color = SubText,
                            fontSize = 16.sp
                        )
                    }
                }

                Spacer(modifier = Modifier.height(100.dp))

                Text(
                    text = "Apps",
                    style = MaterialTheme.typography.titleLarge,
                    color = OnBackground,
                    modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
                )

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Icon(
                            Icons.Filled.Search,
                            contentDescription = "Sin Filtros",
                            modifier = Modifier.size(64.dp),
                            tint = SubText
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            "No se encontró uso para los filtros activos",
                            color = SubText,
                            fontSize = 16.sp
                        )
                    }
                }
            }
        }
    }

    @Composable
    private fun TiempoUsoTopBar() {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(Icons.Filled.Menu, contentDescription = "Menú", tint = OnBackground, modifier = Modifier.size(32.dp))
            Spacer(modifier = Modifier.width(16.dp))
            Text(
                text = "BIENVENIDO, usuario",
                style = MaterialTheme.typography.headlineSmall,
                color = OnBackground.copy(alpha = 0.8f)
            )
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun PreviewTiempoUsoSinDatosScreen() {
        TiempoUsoSinDatosScreen()
    }
}