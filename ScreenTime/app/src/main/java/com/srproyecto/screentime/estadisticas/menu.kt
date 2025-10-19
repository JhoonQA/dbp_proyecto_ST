package com.srproyecto.screentime.estadisticas

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Archive
import androidx.compose.material.icons.filled.Block
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.SignalCellularAlt
import androidx.compose.material.icons.filled.WatchLater
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class menu {

    private val ScreenBackgroundGradient = Color(0xFFBBDBE2)
    private val DrawerBackground = Color(0xFFFFFFFF)
    private val SelectedItemColor = Color(0xFFF7D9E0)
    private val OnSelectedColor = Color(0xFF000000)
    private val DefaultItemColor = Color(0xFF666666)

    private data class MenuItem(val label: String, val icon: ImageVector, val isSelected: Boolean = false, val isDivider: Boolean = false)

    private val menuItems = listOf(
        MenuItem("Inicio", Icons.Filled.Home, isSelected = true),
        MenuItem("Límites de Uso", Icons.Filled.WatchLater),
        MenuItem("Bloqueo en la app", Icons.Filled.Block),
        MenuItem("Notificaciones de Uso", Icons.Filled.Notifications),
        MenuItem("Estadísticas", Icons.Filled.SignalCellularAlt),
        MenuItem("", Icons.Filled.Home, isDivider = true), // Separador
        MenuItem("Categorías", Icons.Filled.KeyboardArrowUp),
        MenuItem("Configuración", Icons.Filled.Settings),
        MenuItem("Reportes y exportación", Icons.Filled.Archive)
    )

    @Composable
    fun AppDrawerContent(onItemClick: (String) -> Unit = {}) {
        ModalDrawerSheet(
            drawerTonalElevation = 0.dp,
            drawerContainerColor = DrawerBackground,
            modifier = Modifier.fillMaxWidth(0.8f)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp)
                    .padding(end = 16.dp),
                horizontalArrangement = Arrangement.End,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    Icons.Default.Menu,
                    contentDescription = "Cerrar Menú",
                    modifier = Modifier.size(32.dp),
                    tint = OnSelectedColor
                )
            }

            Column(modifier = Modifier.padding(top = 16.dp)) {
                menuItems.forEach { item ->
                    if (item.isDivider) {
                        Divider(modifier = Modifier.padding(vertical = 16.dp, horizontal = 16.dp), color = DefaultItemColor.copy(alpha = 0.3f))
                    } else {
                        DrawerItem(item = item, onClick = onItemClick)
                    }
                }
            }
        }
    }

    @Composable
    private fun DrawerItem(item: MenuItem, onClick: (String) -> Unit) {
        val backgroundColor = if (item.isSelected) SelectedItemColor else Color.Transparent
        val contentColor = if (item.isSelected) OnSelectedColor else DefaultItemColor

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp)
                .padding(end = 16.dp)
                .background(backgroundColor, RoundedCornerShape(topEnd = 24.dp, bottomEnd = 24.dp))
                .clickable { onClick(item.label) }
                .padding(start = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                item.icon,
                contentDescription = item.label,
                modifier = Modifier.size(24.dp),
                tint = contentColor
            )
            Spacer(modifier = Modifier.width(16.dp))
            Text(
                item.label,
                color = contentColor,
                fontSize = 16.sp
            )
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun PreviewMenuScreen() {
        Row(modifier = Modifier.fillMaxSize().background(ScreenBackgroundGradient)) {
            AppDrawerContent()
            Spacer(modifier = Modifier.weight(1f))
        }
    }
}