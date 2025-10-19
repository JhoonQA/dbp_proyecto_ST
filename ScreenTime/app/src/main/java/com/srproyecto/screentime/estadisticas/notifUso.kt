package com.srproyecto.screentime.estadisticas

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset

class notifUso {

    private val ScreenBackground = Color(0xFFBBDBE2)
    private val OnBackground = Color(0xFF000000)
    private val SubText = Color(0xFF666666)
    private val ActiveTabColor = Color(0xFFE0E0E0)
    private val ChipColor = Color(0xFF64FFDA)
    private val NewDotColor = Color(0xFF4CAF50)
    private val ReadDotColor = Color(0xFFBDBDBD)

    private data class NotificationItem(val text: String, val date: String, val time: String, val isNew: Boolean)

    private val allNotifications = listOf(
        NotificationItem("Tu uso de categorías", "14/09/25", "19:27", true),
        NotificationItem("Habilitar permiso de acceso a notificaciones", "12/09/25", "09:55", true),
        NotificationItem("El tiempo de uso de hoy es: 03h 15m 25s", "10/09/25", "07:13", true),
        NotificationItem("Habilita el permiso de inicio automático en segundo plano", "19/08/25", "12:45", true),
        NotificationItem("Elige tu propio icono de la Aplicación", "04/08/25", "17:30", true),
        NotificationItem("El tiempo de uso de hoy es: 02h 07m 30s", "04/08/25", "10:30", true),

        NotificationItem("Activar servicio de accesibilidad", "14/09/25", "19:27", false),
        NotificationItem("Informe de estado de uso", "12/09/25", "09:55", false),
        NotificationItem("El tiempo de uso de hoy es: 03h 15m 25s", "10/09/25", "07:13", false),
        NotificationItem("Elige tu propio icono de la Aplicación", "04/08/25", "17:30", false)
    )

    private val newNotifications = allNotifications.filter { it.isNew }
    private val readNotifications = allNotifications.filter { !it.isNew }

    @Composable
    fun NotificacionesUsoScreen(onBackClick: () -> Unit = {}) {
        var selectedTabIndex by remember { mutableStateOf(0) }
        val tabs = listOf("Nuevos", "Leídos")

        Scaffold { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .background(ScreenBackground)
                    .verticalScroll(rememberScrollState())
            ) {
                NotificacionesTopBar(onBackClick)

                Text(
                    "Notificaciones",
                    color = OnBackground,
                    style = MaterialTheme.typography.titleLarge,
                    modifier = Modifier.padding(start = 16.dp, top = 24.dp, bottom = 8.dp)
                )

                TabRow(
                    selectedTabIndex = selectedTabIndex,
                    containerColor = Color.Transparent,
                    indicator = { tabPositions ->
                        Box(
                            Modifier
                                .tabIndicatorOffset(tabPositions[selectedTabIndex])
                                .height(2.dp)
                                .background(Color.Transparent)
                        )
                    },
                    divider = { Divider(color = OnBackground.copy(alpha = 0.3f), thickness = 1.dp) }
                ) {
                    tabs.forEachIndexed { index, title ->
                        Tab(
                            selected = selectedTabIndex == index,
                            onClick = { selectedTabIndex = index },
                            selectedContentColor = OnBackground,
                            unselectedContentColor = SubText,
                            modifier = Modifier
                                .height(40.dp)
                                .clip(RoundedCornerShape(topStart = 8.dp, topEnd = 8.dp))
                                .background(if (selectedTabIndex == index) ActiveTabColor else Color.Transparent)
                        ) {
                            Text(title, fontSize = 16.sp)
                        }
                    }
                }

                val currentList = if (selectedTabIndex == 0) newNotifications else readNotifications

                currentList.forEach { item ->
                    NotificationListItem(item = item)
                    Divider(color = OnBackground.copy(alpha = 0.1f), thickness = 1.dp)
                }
            }
        }
    }

    @Composable
    private fun NotificacionesTopBar(onBackClick: () -> Unit) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp),
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
            Surface(
                shape = RoundedCornerShape(50),
                color = ChipColor,
            ) {
                Text(
                    "Notificaciones de uso",
                    color = OnBackground,
                    modifier = Modifier.padding(horizontal = 16.dp, vertical = 6.dp),
                    fontSize = 16.sp
                )
            }
        }
    }

    @Composable
    private fun NotificationListItem(item: NotificationItem) {
        val dotColor = if (item.isNew) NewDotColor else ReadDotColor
        val dotSize = if (item.isNew) 8.dp else 12.dp

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 10.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(dotSize)
                    .clip(CircleShape)
                    .background(dotColor)
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    item.text,
                    color = OnBackground,
                    style = MaterialTheme.typography.bodyLarge,
                    fontSize = 15.sp
                )
                Row {
                    Text(
                        item.date,
                        color = SubText,
                        style = MaterialTheme.typography.bodySmall,
                        fontSize = 12.sp
                    )
                    Text(
                        " ${item.time}",
                        color = SubText,
                        style = MaterialTheme.typography.bodySmall,
                        fontSize = 12.sp
                    )
                }
            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun PreviewNotificacionesUsoScreen() {
        NotificacionesUsoScreen()
    }
}