package com.srproyecto.screentime.limites

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.AlignmentLine
import androidx.compose.ui.layout.VerticalAlignmentLine
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlin.math.round

class notificaciones {

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun LanzamientosScreen(onBackClick: () -> Unit = {}) {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text("Notificaciones") },
                    navigationIcon = {
                        IconButton(onClick = onBackClick) {
                            Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Atrás")
                        }
                    }
                )
            }
        ) { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .verticalScroll(rememberScrollState())
            ) {
                Text(
                    text = "Graficas",
                    modifier = Modifier
                        .padding(start = 16.dp) // Margen externo solo a la izquierda
                        .border(
                            width = 2.dp,
                            color = Color(0xFF000000),
                            shape = RoundedCornerShape(11.dp)
                        )
                        .background(
                            color = Color(0xFF77BBBB),
                            shape = RoundedCornerShape(11.dp)
                        )
                        .padding(8.dp), // Padding interno
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold
                )


                Text(
                    text = "27 notificaciones",
                    modifier = Modifier
                        .padding(16.dp) // Margen externo
                        .fillMaxWidth()
                        .border(
                            width = 2.dp,
                            color = Color.Gray,
                            shape = RoundedCornerShape(8.dp)
                        )
                        .background(
                            color = Color(0xFFEEF4F7),
                            shape = RoundedCornerShape(8.dp)
                        )
                        .padding(12.dp), // Padding interno
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black,
                    textAlign = TextAlign.Center
                )


                GraficaBarras()

                Divider(modifier = Modifier.padding(vertical = 16.dp))

                Text(
                    text = "89 notificaciones de esta semana",
                    modifier = Modifier
                        .padding(horizontal = 16.dp)
                        .fillMaxWidth(),
                    style = MaterialTheme.typography.titleSmall,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center
                )

                Spacer(modifier = Modifier.height(16.dp))

                ListaApps()
            }
        }
    }

    @Composable
    private fun GraficaBarras() {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.Bottom
            ) {
                val dias = listOf("Lun", "Mar", "Mier", "Juey", "Vier", "Sab", "Dom")
                val alturas = listOf(120, 110, 80, 60, 40, 30, 90)
                val minutos = listOf(40, 60, 30, 50, 70, 45, 35)
                val colores = listOf(Color(0xFF1877F2), Color(0xFF25D366), Color(0xFF4285F4), Color(0xFFFF9800), Color(0xFF3F51B5), Color(0xFF9E9E9E),Color(0xFFF44336))


                dias.forEachIndexed { index, dia ->
                    Column(
                        //horizontalAlignment = Alignment.Center,
                        verticalArrangement = Arrangement.Bottom
                    ) {
                        Text(
                            text = minutos[index].toString(),
                            style = MaterialTheme.typography.bodySmall,
                            fontSize = 12.sp
                        )
                        Spacer(modifier = Modifier.height(4.dp))
                        Box(
                            modifier = Modifier
                                .width(20.dp)
                                .height(alturas[index].dp)
                                .background(colores[index])
                        )
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(
                            text = dia,
                            style = MaterialTheme.typography.bodySmall,
                            fontSize = 12.sp
                        )
                    }
                }
            }
        }
    }

    @Composable
    private fun ListaApps() {
        val apps = listOf(
            AppData(Icons.Filled.Facebook, "Facebook", 27),
            AppData(Icons.Filled.Chat, "WhatsApp", 19),
            AppData(Icons.Filled.Search, "Google", 13),
            AppData(Icons.Filled.Photo, "Galería", 10),
            AppData(Icons.Filled.Calculate, "Calculadora", 9),
            AppData(Icons.Filled.Settings, "Ajustes", 9),
            AppData(Icons.Filled.CameraAlt, "Cámara", 7)
        )

        Column {
            apps.forEach { app ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp, vertical = 18.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            imageVector = app.icon,
                            contentDescription = app.nombre,
                            modifier = Modifier.size(24.dp)
                        )
                        Spacer(modifier = Modifier.width(12.dp))
                        Text(
                            text = app.nombre,
                            style = MaterialTheme.typography.bodyMedium
                        )
                    }
                    Text(
                        text = "${app.veces} notificaciones",
                        style = MaterialTheme.typography.bodyMedium,
                        color = Color.Gray
                    )
                }
                Divider(modifier = Modifier.padding(horizontal = 6.dp))
            }
        }
    }

    data class AppData(
        val icon: ImageVector,
        val nombre: String,
        val veces: Int
    )

    @Preview(showBackground = true)
    @Composable
    fun PreviewLanzamientosScreen() {
        LanzamientosScreen()
    }
}