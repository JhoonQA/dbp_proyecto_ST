package com.srproyecto.screentime.estadisticas

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Facebook
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Whatsapp
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class agregar {

    private val ScreenBackground = Color(0xFFBBDBE2)
    private val OnBackground = Color(0xFF000000)
    private val SubText = Color(0xFF666666)
    private val ChipColor = Color(0xFF64FFDA)
    private val FBAColor = Color(0xFFE91E63) // Rosa Oscuro/Morado para el FAB

    private data class LimitItem(val name: String, val timeRemaining: String, val icon: ImageVector, var isEnabled: Boolean)

    private val limits = listOf(
        LimitItem("Facebook", "Quedan 1h 20m", Icons.Filled.Facebook, true),
        LimitItem("WhastApp", "Quedan 3h 20m", Icons.Filled.Whatsapp, true)
    )

    @Composable
    fun LimitesDeUsoScreen() {
        Scaffold(

            floatingActionButton = {
                ExtendedFloatingActionButton(
                    onClick = {},
                    modifier = Modifier.padding(16.dp).height(56.dp).padding(start = 150.dp),
                    containerColor = FBAColor,
                    contentColor = Color.White,
                    shape = RoundedCornerShape(50)
                ) {
                    Icon(Icons.Filled.Add, contentDescription = null)
                    Spacer(modifier = Modifier.width(8.dp))
                    Text("Añadir límite de uso")
                }
            },
            floatingActionButtonPosition = FabPosition.Center
        ) { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .background(ScreenBackground)
                    .verticalScroll(rememberScrollState())
            ) {
                LimitesTopBar()

                limits.forEach { item ->
                    LimitListItem(item)
                    Divider(color = OnBackground.copy(alpha = 0.1f), thickness = 1.dp)
                }
            }
        }
    }

    @Composable
    private fun LimitesTopBar() {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(Icons.Filled.Menu, contentDescription = "Menú", tint = OnBackground, modifier = Modifier.size(32.dp))
            Spacer(modifier = Modifier.width(16.dp))

            Surface(
                shape = RoundedCornerShape(50),
                color = ChipColor,
            ) {
                Text(
                    "Límites de Uso",
                    color = OnBackground,
                    modifier = Modifier.padding(horizontal = 16.dp, vertical = 6.dp),
                    fontSize = 16.sp
                )
            }
        }
    }

    @Composable
    private fun LimitListItem(item: LimitItem) {
        var isEnabled by remember { mutableStateOf(item.isEnabled) }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 10.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                item.icon,
                contentDescription = item.name,
                modifier = Modifier.size(28.dp),
                tint = OnBackground
            )
            Spacer(modifier = Modifier.width(16.dp))

            Column(modifier = Modifier.weight(1f)) {
                Text(
                    item.name,
                    color = OnBackground,
                    style = MaterialTheme.typography.bodyLarge
                )
                Text(
                    item.timeRemaining,
                    color = SubText,
                    style = MaterialTheme.typography.bodySmall,
                    fontSize = 12.sp
                )
            }

            Switch(
                checked = isEnabled,
                onCheckedChange = { isEnabled = it },
                colors = SwitchDefaults.colors(
                    checkedThumbColor = Color(0xFFF7D9E0), // Rosa Claro
                    checkedTrackColor = Color(0xFFC5B0C2), // Morado Claro (imitando el track de la imagen)
                    uncheckedThumbColor = Color(0xFFE0E0E0),
                    uncheckedTrackColor = Color(0xFFBDBDBD)
                )
            )
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun PreviewLimitesDeUsoScreen() {
        LimitesDeUsoScreen()
    }
}