package com.srproyecto.screentime.estadisticas

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
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

class tiempoUso {

    private val ScreenBackground = Color(0xFFBBDBE2)
    private val OnBackground = Color(0xFF000000)
    private val SubText = Color(0xFF666666)

    private val WhatsAppColor = Color(0xFFA5D6A7)
    private val FacebookColor = Color(0xFF42A5F5)
    private val GoogleColor = Color(0xFFDCC18C)
    private val OtrasColor = Color(0xFF3F51B5)
    private val CalculadoraColor = Color(0xFFE57373)
    private val CamaraColor = Color(0xFF4DB6AC)
    private val GaleriaColor = Color(0xFFBA68C8)
    private val AjustesColor = Color(0xFF90A4AE)

    private val usageSegments = listOf(
        Pair(40, FacebookColor),
        Pair(40, WhatsAppColor),
        Pair(25, GoogleColor),
        Pair(15, OtrasColor)
    )

    private val appIconData = mapOf(
        "Facebook" to Icons.Filled.Facebook,
        "WhatsApp" to Icons.Filled.Whatsapp,
        "Google" to Icons.Filled.Search,
        "Galería" to Icons.Filled.PhotoLibrary,
        "Calculadora" to Icons.Filled.Calculate,
        "Ajustes" to Icons.Filled.Settings,
        "Cámara" to Icons.Filled.Camera
    )
    private val allApps = listOf(
        AppListItem("Facebook", 40, FacebookColor),
        AppListItem("WhatsApp", 40, WhatsAppColor),
        AppListItem("Galería", 7, GaleriaColor),
        AppListItem("Calculadora", 5, CalculadoraColor)
    )

    private data class AppListItem(val name: String, val minutes: Int, val color: Color)

    @Composable
    fun TiempoUsoScreen() {
        Scaffold(
            modifier = Modifier.background(ScreenBackground)
        ) { paddingValues ->
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
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold
                    )
                }

                OutlinedButton(
                    onClick = {},
                    modifier = Modifier.align(Alignment.CenterHorizontally).padding(bottom = 24.dp),
                    shape = RoundedCornerShape(50),
                    colors = ButtonDefaults.outlinedButtonColors(containerColor = Color(0xFFE0E0E0), contentColor = OnBackground),
                    border = BorderStroke(1.dp, SubText)
                ) {
                    Text("Categorías")
                    Icon(Icons.Filled.ArrowDropDown, contentDescription = null, modifier = Modifier.size(20.dp).padding(start = 8.dp), tint = OnBackground)
                }

                DonutChartSimulated()

                Text(
                    text = "Apps",
                    style = MaterialTheme.typography.titleLarge,
                    color = OnBackground,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(16.dp, top = 32.dp, bottom = 8.dp)
                )

                allApps.forEach { app ->
                    AppUsageItem(app)
                    Divider(color = SubText.copy(alpha = 0.2f), thickness = 1.dp)
                }
                Spacer(modifier = Modifier.height(24.dp))
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

    @Composable
    private fun DonutChartSimulated() {
        val size = 300.dp
        val innerSize = 200.dp
        val totalMinutes = usageSegments.sumOf { it.first }.toFloat()

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(size + 80.dp)
                .padding(vertical = 16.dp),
            contentAlignment = Alignment.Center
        ) {
            Box(
                modifier = Modifier
                    .size(size)
                    .clip(CircleShape)
                    .align(Alignment.Center)
            ) {
                var currentRotation = 0f
                usageSegments.forEach { (minutes, color) ->
                    val sweepAngle = (minutes / totalMinutes) * 360f

                    Box(
                        modifier = Modifier
                            .size(size)
                            .graphicsLayer { rotationZ = currentRotation }
                            .clip(CircleShape)
                            .background(Color.Gray)
                            .align(Alignment.TopStart)
                    )

                    Box(
                        modifier = Modifier
                            .size(size)
                            .graphicsLayer { rotationZ = currentRotation + sweepAngle - 2f }
                            .clip(CircleShape)
                            .background(Color(0xFF7CC4CE))
                            .align(Alignment.TopStart)
                    )

                    currentRotation += sweepAngle
                }

                Box(
                    modifier = Modifier
                        .size(innerSize)
                        .clip(CircleShape)
                        .background(Color.White)
                        .align(Alignment.Center)
                )

                Column(modifier = Modifier.align(Alignment.Center), horizontalAlignment = Alignment.CenterHorizontally) {
                    Text("HOY", fontSize = 16.sp, color = SubText)
                    Text("2 horas", fontSize = 32.sp, color = OnBackground, fontWeight = FontWeight.Bold)
                }
            }

            AppLabel("WhatsApp", "40 min", modifier = Modifier.align(Alignment.CenterEnd).offset(x = 55.dp, y = (-20).dp), isTime = true)
            AppLabel("Facebook", "40 min", modifier = Modifier.align(Alignment.BottomCenter).offset(y = 40.dp))
            AppLabel("Otras", "15 min", modifier = Modifier.align(Alignment.CenterStart).offset(x = (-55).dp, y = 20.dp))
        }
    }

    @Composable
    private fun AppLabel(name: String, time: String, modifier: Modifier, isTime: Boolean = false) {
        Column(modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                time,
                color = OnBackground,
                fontSize = 12.sp,
                fontWeight = if (isTime) FontWeight.Bold else FontWeight.Normal,
                modifier = if (isTime) Modifier
                    .background(Color.White, RoundedCornerShape(4.dp))
                    .padding(horizontal = 4.dp, vertical = 2.dp) else Modifier
            )
            Text(name, color = SubText, fontSize = 12.sp)
        }
    }

    @Composable
    private fun AppUsageItem(app: AppListItem) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp)
                .clickable {},
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                appIconData.getValue(app.name),
                contentDescription = app.name,
                modifier = Modifier.size(24.dp),
                tint = app.color
            )
            Spacer(modifier = Modifier.width(16.dp))

            Column(modifier = Modifier.weight(1f)) {
                Text(app.name, color = OnBackground, style = MaterialTheme.typography.bodyLarge)
                Text("${app.minutes} min", color = SubText, style = MaterialTheme.typography.bodySmall)
            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun PreviewTiempoUsoScreen() {
        TiempoUsoScreen()
    }
}