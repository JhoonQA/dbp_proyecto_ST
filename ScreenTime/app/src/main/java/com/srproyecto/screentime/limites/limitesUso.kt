package com.srproyecto.screentime.limites

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class LimitesUso {

    private val TealBase = Color(0xFF77BBBB)
    private val TealLight = Color(0xFF92E1E1)
    private val TealDark = Color(0xFF3AAFA9)
    private val OnTeal = Color(0xFF000000)
    private val TextLight = Color(0xFF676666)
    private val CardColor = Color(0xFFB6F3E9)

    @Composable
    fun LimitesUsoScreen(onBackClick: () -> Unit = {}) {
        var horas by remember { mutableStateOf(1) }
        var minutos by remember { mutableStateOf(30) }

        Scaffold(
            topBar = { LimitesUsoTopBar(onBackClick) }
        ) { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .background(Color.White)
            ) {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                        .shadow(4.dp, RoundedCornerShape(12.dp)),
                    colors = CardDefaults.cardColors(containerColor = CardColor)
                ) {
                    Column {
                        Text(
                            text = "Agregar límite",
                            style = MaterialTheme.typography.headlineSmall,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(16.dp)
                        )

                        OptionItem(
                            title = "Selecciona aplicaciones para limitar →",
                            onClick = { }
                        )

                        OptionItem(
                            title = "Cómo limitar el uso?",
                            onClick = { }
                        )
                    }
                }

                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp)
                        .shadow(4.dp, RoundedCornerShape(12.dp)),
                    colors = CardDefaults.cardColors(containerColor = CardColor)
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text(
                            text = "Establecer límite de uso diario",
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(bottom = 8.dp)
                        )

                        Text(
                            text = "Selecciona el límite de uso para el tiempo total en un día",
                            style = MaterialTheme.typography.bodyMedium,
                            color = TextLight,
                            modifier = Modifier.padding(bottom = 16.dp)
                        )

                        TimeSelector(
                            horas = horas,
                            minutos = minutos,
                            onHorasChange = { horas = it },
                            onMinutosChange = { minutos = it }
                        )
                    }
                }

                Spacer(modifier = Modifier.weight(1f))

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    horizontalArrangement = Arrangement.End
                ) {
                    OutlinedButton(
                        onClick = onBackClick,
                        modifier = Modifier
                            .height(48.dp)
                            .shadow(2.dp, RoundedCornerShape(8.dp))
                    ) {
                        Text("Cancelar", fontWeight = FontWeight.SemiBold)
                    }
                    Spacer(modifier = Modifier.width(8.dp))
                    Button(
                        onClick = { },
                        modifier = Modifier
                            .height(48.dp)
                            .shadow(4.dp, RoundedCornerShape(8.dp)),
                        colors = ButtonDefaults.buttonColors(containerColor = TealBase)
                    ) {
                        Text("Guardar", fontWeight = FontWeight.Bold)
                    }
                }
            }
        }
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    private fun LimitesUsoTopBar(onBackClick: () -> Unit) {
        CenterAlignedTopAppBar(
            title = {
                Text(
                    text = "Límite de Uso Diario",
                    color = OnTeal,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )
            },
            navigationIcon = {
                IconButton(onClick = onBackClick) {
                    Icon(
                        Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = "Atrás",
                        tint = OnTeal
                    )
                }
            },
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = Color.White
            ),
            modifier = Modifier.shadow(4.dp)
        )
    }

    @Composable
    private fun OptionItem(title: String, onClick: () -> Unit) {
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .clickable(onClick = onClick)
                .padding(vertical = 8.dp),
            color = Color.Transparent
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = title,
                    style = MaterialTheme.typography.bodyLarge,
                    color = OnTeal,
                    modifier = Modifier.weight(1f)
                )
            }
        }
        Divider(modifier = Modifier.padding(horizontal = 8.dp), color = Color.LightGray)
    }

    @Composable
    private fun TimeSelector(
        horas: Int,
        minutos: Int,
        onHorasChange: (Int) -> Unit,
        onMinutosChange: (Int) -> Unit
    ) {
        Column {
            Surface(
                modifier = Modifier
                    .fillMaxWidth()
                    .shadow(2.dp, RoundedCornerShape(12.dp))
                    .border(2.dp, TealLight, RoundedCornerShape(12.dp))
                    .padding(24.dp),
                color = Color.Transparent
            ) {
                Row(
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "$horas hora${if (horas != 1) "s" else ""}",
                        style = MaterialTheme.typography.headlineMedium,
                        fontWeight = FontWeight.Bold,
                        color = TealDark
                    )
                    Text(
                        text = "  ",
                        style = MaterialTheme.typography.headlineMedium
                    )
                    Text(
                        text = "$minutos minutos",
                        style = MaterialTheme.typography.headlineMedium,
                        fontWeight = FontWeight.Bold,
                        color = TealDark
                    )
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            Text(
                text = "Horas",
                style = MaterialTheme.typography.bodyMedium,
                color = TextLight,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                TimeOption(
                    time = "1 hora",
                    isSelected = horas == 1,
                    onClick = { onHorasChange(1) }
                )
                TimeOption(
                    time = "2 horas",
                    isSelected = horas == 2,
                    onClick = { onHorasChange(2) }
                )
                TimeOption(
                    time = "3 horas",
                    isSelected = horas == 3,
                    onClick = { onHorasChange(3) }
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Minutos",
                style = MaterialTheme.typography.bodyMedium,
                color = TextLight,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                TimeOption(
                    time = "29 min",
                    isSelected = minutos == 29,
                    onClick = { onMinutosChange(29) }
                )
                TimeOption(
                    time = "30 min",
                    isSelected = minutos == 30,
                    onClick = { onMinutosChange(30) }
                )
                TimeOption(
                    time = "32 min",
                    isSelected = minutos == 32,
                    onClick = { onMinutosChange(32) }
                )
            }

            Spacer(modifier = Modifier.height(24.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = "Horas",
                        style = MaterialTheme.typography.bodySmall,
                        color = TextLight
                    )
                    Surface(
                        modifier = Modifier
                            .fillMaxWidth()
                            .shadow(2.dp, RoundedCornerShape(8.dp)),
                        color = CardColor,
                        shape = RoundedCornerShape(8.dp)
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            IconButton(
                                onClick = { if (horas > 0) onHorasChange(horas - 1) },
                                modifier = Modifier.size(48.dp)
                            ) {
                                Text("−", fontSize = 20.sp, fontWeight = FontWeight.Bold, color = TealBase)
                            }
                            Text(
                                text = "$horas",
                                style = MaterialTheme.typography.titleLarge,
                                fontWeight = FontWeight.Bold,
                                color = TealDark
                            )
                            IconButton(
                                onClick = { onHorasChange(horas + 1) },
                                modifier = Modifier.size(48.dp)
                            ) {
                                Text("+", fontSize = 20.sp, fontWeight = FontWeight.Bold, color = TealBase)
                            }
                        }
                    }
                }

                Spacer(modifier = Modifier.width(16.dp))

                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = "Minutos",
                        style = MaterialTheme.typography.bodySmall,
                        color = TextLight
                    )
                    Surface(
                        modifier = Modifier
                            .fillMaxWidth()
                            .shadow(2.dp, RoundedCornerShape(8.dp)),
                        color = CardColor,
                        shape = RoundedCornerShape(8.dp)
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            IconButton(
                                onClick = { if (minutos > 0) onMinutosChange(minutos - 1) },
                                modifier = Modifier.size(48.dp)
                            ) {
                                Text("−", fontSize = 20.sp, fontWeight = FontWeight.Bold, color = TealBase)
                            }
                            Text(
                                text = "$minutos",
                                style = MaterialTheme.typography.titleLarge,
                                fontWeight = FontWeight.Bold,
                                color = TealDark
                            )
                            IconButton(
                                onClick = { onMinutosChange(minutos + 1) },
                                modifier = Modifier.size(48.dp)
                            ) {
                                Text("+", fontSize = 20.sp, fontWeight = FontWeight.Bold, color = TealBase)
                            }
                        }
                    }
                }
            }
        }
    }

    @Composable
    private fun TimeOption(time: String, isSelected: Boolean, onClick: () -> Unit) {
        Surface(
            modifier = Modifier
                .shadow(2.dp, RoundedCornerShape(8.dp))
                .clickable(onClick = onClick),
            color = if (isSelected) TealBase else CardColor,
            shape = RoundedCornerShape(8.dp)
        ) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 12.dp)
            ) {
                Text(
                    text = time,
                    color = if (isSelected) Color.White else OnTeal,
                    fontWeight = FontWeight.Medium
                )
            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun PreviewLimitesUsoScreen() {
        LimitesUsoScreen()
    }
}