package com.srproyecto.screentime.estadisticas

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.font.FontWeight

class agregarLimite {

    private val ScreenBackground = Color(0xFFBBDBE2)
    private val OnBackground = Color(0xFF000000)
    private val SubText = Color(0xFF666666)
    private val ButtonColor = Color(0xFFB4FFEC)
    private val SelectedAppColor = Color(0xFFC4E4F9)
    private val SaveButtonColor = Color(0xFF4CAF50)

    private val options = listOf(
        "Bloquear permanentemente",
        "Bloquear según horario",
        "Establecer límite de uso diario",
        "Modos predefinidos",
        "Configurar modo descanso"
    )

    @Composable
    fun AgregarLimiteScreen(onBackClick: () -> Unit = {}) {
        Scaffold(
            bottomBar = { AgregarLimiteBottomBar() }
        ) { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .background(ScreenBackground)
                    .verticalScroll(rememberScrollState())
                    .padding(16.dp)
            ) {
                AgregarLimiteTopBar(onBackClick)

                Card(
                    shape = RoundedCornerShape(8.dp),
                    colors = CardDefaults.cardColors(containerColor = SelectedAppColor),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(56.dp)
                        .clickable {}
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(horizontal = 16.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            "Selecciona aplicaciones para limitar",
                            color = OnBackground,
                            fontSize = 16.sp
                        )
                        Icon(Icons.Filled.ArrowForward, contentDescription = null, tint = OnBackground)
                    }
                }

                Text(
                    "Cómo limitar el uso ?",
                    color = OnBackground,
                    style = MaterialTheme.typography.titleLarge,
                    modifier = Modifier.padding(top = 32.dp, bottom = 16.dp)
                )

                options.forEach { option ->
                    LimitOptionCard(option)
                    Spacer(modifier = Modifier.height(12.dp))
                }
            }
        }
    }

    @Composable
    private fun AgregarLimiteTopBar(onBackClick: () -> Unit) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 24.dp),
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
            Text(
                "Agregar límite",
                style = MaterialTheme.typography.headlineSmall,
                color = OnBackground.copy(alpha = 0.8f)
            )
        }
    }

    @Composable
    private fun LimitOptionCard(label: String) {
        Card(
            shape = RoundedCornerShape(8.dp),
            colors = CardDefaults.cardColors(containerColor = ButtonColor),
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp)
                .clickable {}
        ) {
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 16.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    label,
                    color = OnBackground,
                    fontSize = 16.sp
                )
                Icon(Icons.Filled.ArrowForward, contentDescription = null, tint = OnBackground)
            }
        }
    }

    @Composable
    private fun AgregarLimiteBottomBar() {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White.copy(alpha = 0f))
                .padding(horizontal = 16.dp, vertical = 8.dp),
            horizontalArrangement = Arrangement.End,
            verticalAlignment = Alignment.CenterVertically
        ) {
            TextButton(onClick = {}) {
                Text("Cancelar", color = SubText, fontWeight = FontWeight.SemiBold)
            }
            Spacer(modifier = Modifier.width(8.dp))
            Button(
                onClick = {},
                colors = ButtonDefaults.buttonColors(containerColor = SaveButtonColor)
            ) {
                Text("Guardar")
            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun PreviewAgregarLimiteScreen() {
        AgregarLimiteScreen()
    }
}