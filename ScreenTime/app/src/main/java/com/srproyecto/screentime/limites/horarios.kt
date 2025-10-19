package com.srproyecto.screentime.limites

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
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

class Horarios {

    private val TealBase = Color(0xFF77BBBB)
    private val OnTeal = Color(0xFF000000)
    private val TextLight = Color(0xFF676666)
    private val GreenButton = Color(0xFF00BFA5)
    private val SelectedDay = Color(0xFF3AAFA9)
    private val UnselectedDay = Color(0xFFF5F5F5)
    private val CardColor = Color(0xFF8CE3DA)

    @Composable
    fun HorariosScreen(onBackClick: () -> Unit = {}) {
        var todoElDia by remember { mutableStateOf(true) }
        var horaInicio by remember { mutableStateOf("07:30") }
        var horaFin by remember { mutableStateOf("23:30") }
        val diasSeleccionados = remember { mutableStateListOf("L", "M", "X", "J", "V", "S", "D") }

        Scaffold(
            topBar = { HorariosTopBar(onBackClick) }
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
                            text = "Bloquear según horario",
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(bottom = 8.dp)
                        )

                        OptionItem(
                            title = "Selecciona el número de días",
                            onClick = { }
                        )

                        Text(
                            text = "Días de la semana",
                            style = MaterialTheme.typography.titleSmall,
                            fontWeight = FontWeight.SemiBold,
                            modifier = Modifier.padding(top = 16.dp, bottom = 12.dp)
                        )

                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 8.dp),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            listOf("L", "M", "X", "J", "V", "S", "D").forEach { dia ->
                                DayChip(
                                    dia = dia,
                                    isSelected = diasSeleccionados.contains(dia),
                                    onSelect = {
                                        if (diasSeleccionados.contains(dia)) {
                                            diasSeleccionados.remove(dia)
                                        } else {
                                            diasSeleccionados.add(dia)
                                        }
                                    }
                                )
                            }
                        }

                        Spacer(modifier = Modifier.height(16.dp))

                        Surface(
                            modifier = Modifier
                                .fillMaxWidth()
                                .clickable { todoElDia = !todoElDia }
                                .border(1.dp, Color.LightGray, RoundedCornerShape(8.dp))
                                .padding(12.dp),
                            color = Color.Transparent
                        ) {
                            Row(
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Checkbox(
                                    checked = todoElDia,
                                    onCheckedChange = { todoElDia = it },
                                    colors = CheckboxDefaults.colors(checkedColor = GreenButton)
                                )
                                Spacer(modifier = Modifier.width(8.dp))
                                Text(
                                    text = "Todo el día",
                                    style = MaterialTheme.typography.bodyLarge
                                )
                            }
                        }

                        if (!todoElDia) {
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(top = 16.dp),
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                Column(modifier = Modifier.weight(1f)) {
                                    Text(
                                        text = "Hora inicio",
                                        style = MaterialTheme.typography.bodyMedium,
                                        color = TextLight,
                                        modifier = Modifier.padding(bottom = 4.dp)
                                    )
                                    OutlinedTextField(
                                        value = horaInicio,
                                        onValueChange = { horaInicio = it },
                                        modifier = Modifier.fillMaxWidth(),
                                        shape = RoundedCornerShape(8.dp)
                                    )
                                }

                                Spacer(modifier = Modifier.width(16.dp))

                                Column(modifier = Modifier.weight(1f)) {
                                    Text(
                                        text = "Hora fin",
                                        style = MaterialTheme.typography.bodyMedium,
                                        color = TextLight,
                                        modifier = Modifier.padding(bottom = 4.dp)
                                    )
                                    OutlinedTextField(
                                        value = horaFin,
                                        onValueChange = { horaFin = it },
                                        modifier = Modifier.fillMaxWidth(),
                                        shape = RoundedCornerShape(8.dp)
                                    )
                                }
                            }
                        }
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
                        colors = ButtonDefaults.buttonColors(containerColor = GreenButton)
                    ) {
                        Text("Guardar", fontWeight = FontWeight.Bold)
                    }
                }
            }
        }
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    private fun HorariosTopBar(onBackClick: () -> Unit) {
        CenterAlignedTopAppBar(
            title = {
                Text(
                    text = "Configurar Horario",
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
    private fun DayChip(dia: String, isSelected: Boolean, onSelect: () -> Unit) {
        Surface(
            modifier = Modifier
                .size(44.dp)
                .shadow(2.dp, CircleShape)
                .clickable { onSelect() },
            color = if (isSelected) SelectedDay else UnselectedDay,
            shape = CircleShape
        ) {
            Box(contentAlignment = Alignment.Center) {
                Text(
                    text = dia,
                    color = if (isSelected) Color.White else TextLight,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun PreviewHorariosScreen() {
        HorariosScreen()
    }
}