package com.srproyecto.screentime.inicio

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.srproyecto.screentime.R

class descanso {

    private val TealBase = Brush.linearGradient(
        colors = listOf(Color(0xFF92E1E1), Color(0xFF3AAFA9)),
        start = Offset(100f, 100f),
        end = Offset(0f, 1000f)
    )

    @Composable
    fun PantallaInicioScreen(onContinuarClick: () -> Unit = {}) {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = Color(0xFFBFF2FA)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(32.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "ScreenTime",
                        style = MaterialTheme.typography.bodyMedium,
                        color = Color.Gray
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    Text(
                        text = "SCREENTIME",
                        style = MaterialTheme.typography.headlineLarge,
                        fontWeight = FontWeight.Bold,
                        fontSize = 32.sp
                    )

                    Spacer(modifier = Modifier.height(32.dp))

                    Spacer(modifier = Modifier.height(40.dp))

                    Image(
                        painter = painterResource(R.drawable.ic_rest),
                        contentDescription = "Descanso del teléfono",
                        modifier = Modifier.size(120.dp)
                    )
                    Row (
                        modifier = Modifier.padding(0.dp,250.dp,0.dp,0.dp).
                        fillMaxWidth(),

                        ) {
                        Text(
                            text = "Inicia tu descanso",
                            style= MaterialTheme.typography.titleLarge,
                            fontWeight = FontWeight.Bold

                        )
                    }

                    Spacer(modifier = Modifier.height(40.dp))

                    ConsejoItem("Fàcil - 2 horas.")
                    Spacer(modifier = Modifier.height(12.dp))
                    ConsejoItem("Medio - 4 horas.")
                    Spacer(modifier = Modifier.height(12.dp))
                    ConsejoItem("Dificìl - 12 horas.")
                    Spacer(modifier = Modifier.height(12.dp))
                    ConsejoItem("Personalizado (5 minutos - 30 dias)")
                }

                Button(
                    onClick = onContinuarClick,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF77BBBB)
                    )
                ) {
                    Text(
                        text = "CONTINUAR",
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }
    }

    @Composable
    private fun ConsejoItem(texto: String) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Filled.Check,
                contentDescription = null,
                tint = Color(0xFF77BBBB),
                modifier = Modifier.size(20.dp)
            )
            Spacer(modifier = Modifier.width(12.dp))
            Text(
                text = texto,
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }


    @Preview(showBackground = true)
    @Composable
    fun PreviewPantallaInicioScreen() {
        PantallaInicioScreen()
    }
}