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

class PantallaInicio {

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

                    Text(
                        text = "Menos scroll, mas control",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Medium
                    )

                    Spacer(modifier = Modifier.height(40.dp))

                    Image(
                        painter = painterResource(R.mipmap.ic_inicio_carga),
                        contentDescription = "Descanso del teléfono",
                        modifier = Modifier.size(120.dp)
                    )
                    Row (
                        modifier = Modifier.padding(0.dp,250.dp,0.dp,0.dp),

                        ) {}

                    Spacer(modifier = Modifier.height(40.dp))

                    ConsejoItem("Tómate un descanso de tu teléfono.")
                    Spacer(modifier = Modifier.height(12.dp))
                    ConsejoItem("Vuelve a tu propósito.")
                    Spacer(modifier = Modifier.height(12.dp))
                    ConsejoItem("Concéntrate en tu trabajo.")
                }

                Button(
                    onClick = onContinuarClick,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(70.dp)
                        .padding(bottom = 20.dp),
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