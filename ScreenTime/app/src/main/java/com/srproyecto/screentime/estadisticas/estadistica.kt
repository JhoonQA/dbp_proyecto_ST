package com.srproyecto.screentime.estadisticas

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.CalendarToday
import androidx.compose.material.icons.filled.Facebook
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class estadistica {

    private val ScreenBackground = Color(0xFFBBDBE2)
    private val OnBackground = Color(0xFF000000)
    private val SubText = Color(0xFF666666)
    private val ChipColor = Color(0xFF64FFDA)
    private val CardColor = Color(0xFFE0F7FA)
    private val GreenLineColor = Color(0xFF00C853)

    private val statsData = listOf(
        Triple("Tiempo de uso (Hoy)", "40m 36s", Color(0xFF1E88E5)),
        Triple("Sesiones de hoy", "09", Color(0xFFD32F2F)),
        Triple("Uso medio diario", "15m 52s", Color(0xFF673AB7)),
        Triple("Media diaria global", "--", Color(0xFF009688)),
        Triple("Uso diario mas alto", "40m 36s", Color(0xFFFDD835)),
        Triple("Racha de uso", "04", Color(0xFF43A047))
    )

    @Composable
    fun EstadisticasScreen(onBackClick: () -> Unit = {}) {
        Scaffold { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .background(ScreenBackground)
                    .verticalScroll(rememberScrollState())
                    .padding(16.dp)
            ) {
                EstadisticasTopBar(onBackClick)

                OutlinedButton(
                    onClick = {},
                    modifier = Modifier.fillMaxWidth().padding(vertical = 16.dp),
                    shape = RoundedCornerShape(8.dp),
                    colors = ButtonDefaults.outlinedButtonColors(containerColor = CardColor, contentColor = OnBackground),
                    border = BorderStroke(1.dp, SubText.copy(alpha = 0.3f))
                ) {
                    Icon(Icons.Filled.CalendarToday, contentDescription = null, modifier = Modifier.size(20.dp).padding(end = 8.dp), tint = SubText)
                    Text("Seleccionar fecha")
                    Icon(Icons.Filled.ArrowBack, contentDescription = null, modifier = Modifier.size(20.dp).padding(start = 8.dp).graphicsLayer { rotationZ = 270f }, tint = OnBackground)
                }

                Text(
                    "Estadísticas",
                    color = OnBackground,
                    style = MaterialTheme.typography.titleLarge,
                    modifier = Modifier.padding(bottom = 16.dp)
                )

                StatsGrid()

                Text(
                    "Gráficas",
                    color = OnBackground,
                    style = MaterialTheme.typography.titleLarge,
                    modifier = Modifier.padding(top = 24.dp, bottom = 16.dp)
                )

                UsageChartCard()

                Spacer(modifier = Modifier.height(24.dp))
            }
        }
    }

    @Composable
    private fun EstadisticasTopBar(onBackClick: () -> Unit) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = onBackClick) {
                Icon(
                    Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = "Atrás",
                    tint = OnBackground,
                    modifier = Modifier.size(32.dp)
                )
            }
            Spacer(modifier = Modifier.width(16.dp))
            Icon(Icons.Filled.Facebook, contentDescription = "App Icon", tint = OnBackground, modifier = Modifier.size(28.dp))
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                "Facebook",
                style = MaterialTheme.typography.headlineSmall,
                color = OnBackground.copy(alpha = 0.8f)
            )
        }
    }

    @Composable
    private fun StatsGrid() {
        Column {
            for (i in statsData.indices step 2) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    StatCard(statsData[i].first, statsData[i].second, Modifier.weight(1f))
                    Spacer(modifier = Modifier.width(16.dp))
                    if (i + 1 < statsData.size) {
                        StatCard(statsData[i + 1].first, statsData[i + 1].second, Modifier.weight(1f))
                    } else {
                        Spacer(modifier = Modifier.weight(1f))
                    }
                }
                Spacer(modifier = Modifier.height(16.dp))
            }
        }
    }

    @Composable
    private fun StatCard(title: String, value: String, modifier: Modifier) {
        Card(
            modifier = modifier,
            colors = CardDefaults.cardColors(containerColor = CardColor),
            shape = RoundedCornerShape(8.dp)
        ) {
            Column(modifier = Modifier.padding(12.dp)) {
                Text(
                    title,
                    color = SubText,
                    style = MaterialTheme.typography.bodySmall,
                    fontSize = 12.sp
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    value,
                    color = OnBackground,
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }

    @Composable
    private fun UsageChartCard() {
        Card(
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(containerColor = CardColor),
            shape = RoundedCornerShape(8.dp)
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text(
                    "Desglose diario",
                    color = SubText,
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier.padding(bottom = 16.dp)
                )

                // Simulación del Gráfico de Línea
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(180.dp)
                        .padding(top = 4.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(150.dp)
                            .background(Color.Transparent)
                            .align(Alignment.TopCenter)
                    ) {
                        Box(modifier = Modifier
                            .fillMaxWidth()
                            .height(2.dp)
                            .background(GreenLineColor.copy(alpha = 0.5f))
                            .align(Alignment.BottomCenter)
                        )

                        Row(modifier = Modifier.fillMaxSize(), horizontalArrangement = Arrangement.SpaceBetween) {
                            val times = listOf("09:00", "17:59")
                            val dataPoints = listOf(
                                Pair(0.1f, 0.9f), Pair(0.25f, 0.2f), Pair(0.5f, 0.6f),
                                Pair(0.75f, 0.3f), Pair(1.0f, 0.8f)
                            )

                            //Text("40m 36s", color = OnBackground, fontSize = 12.sp, modifier = Modifier.align(Alignment.TopStart).offset(y = (-16).dp))

                            // Eje vertical y puntos (Simulación)
                            for (i in 0 until 5) {
                                Box(
                                    modifier = Modifier
                                        .fillMaxHeight()
                                        .width(1.dp)
                                        .background(SubText.copy(alpha = 0.2f))
                                )
                                // Aquí se dibujaría el punto y la línea real
                            }
                        }
                    }

                    // Etiquetas de tiempo (Eje X)
                    Row(modifier = Modifier.fillMaxWidth().align(Alignment.BottomCenter).offset(y = 8.dp), horizontalArrangement = Arrangement.SpaceBetween) {
                        Text("09:00", color = SubText, fontSize = 12.sp)
                        Text("17:59", color = SubText, fontSize = 12.sp)
                    }
                }
            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun PreviewEstadisticasScreen() {
        EstadisticasScreen()
    }
}