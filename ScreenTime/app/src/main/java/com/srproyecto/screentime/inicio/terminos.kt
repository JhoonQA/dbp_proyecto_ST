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

class terminos {

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
                        painter = painterResource(R.drawable.search_terms_seo),
                        contentDescription = "Descanso del teléfono",
                        modifier = Modifier.size(120.dp)
                    )
                    Row (
                        modifier = Modifier.padding(0.dp,200.dp,0.dp,0.dp).
                        fillMaxWidth(),

                        ) {
                        Text(
                            text = "Términos de servicio",
                            style= MaterialTheme.typography.titleLarge,
                            fontWeight = FontWeight.Bold

                        )
                    }

                    Spacer(modifier = Modifier.height(40.dp))

                    ConsejoItem("Al utilizar esta aplicación, aceptas estos Términos de Servicio. Su propósito es ayudarte a gestionar tu tiempo frente a la pantalla de manera responsable. \n" +
                            "La aplicación puede recopilar estadísticas de uso anónimas para mejorar su funcionamiento. Esta recopilación es opcional y puede desactivarse en la configuración. Los datos se almacenan por un tiempo limitado y no contienen información personal identificable.")
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
                        text = "ACEPTO",
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