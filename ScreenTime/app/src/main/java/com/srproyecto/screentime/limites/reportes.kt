package com.srproyecto.screentime.limites

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Archive
import androidx.compose.material.icons.filled.History
import androidx.compose.material.icons.filled.Schedule
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class Reportes {

    private val TealBase = Color(0xFF77BBBB)
    private val TealLight = Color(0xFF92E1E1)
    private val TealDark = Color(0xFF3AAFA9)
    private val OnTeal = Color(0xFF000000)
    private val TextLight = Color(0xFF676666)
    private val CardColor = Color(0xFFFFFFFF)

    @Composable
    fun ReportesExportacionScreen(onBackClick: () -> Unit = {}) {
        var showExportForm by remember { mutableStateOf(false) }
        var showResetConfirm by remember { mutableStateOf(false) }

        Scaffold(
            topBar = { ReportesTopBar(onBackClick) }
        ) { paddingValues ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .background(Color.White)
            ) {
                Column(
                    modifier = Modifier.fillMaxSize()
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
                                text = "Almacenamiento",
                                style = MaterialTheme.typography.titleMedium,
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier.padding(16.dp)
                            )
                            Divider(color = Color.LightGray)

                            ReportesListItem(
                                icon = Icons.Filled.Archive,
                                title = "Exportar CSV",
                                subtitle = "Exporta tus datos de uso para el rango de días seleccionados.",
                                onClick = { showExportForm = true }
                            )
                            Divider(color = Color.LightGray)
                            ReportesListItem(
                                icon = Icons.Filled.History,
                                title = "Restablecer estadísticas de uso",
                                subtitle = "Si quieres empezar de cero, puedes restablecer las estadísticas de uso.",
                                onClick = { showResetConfirm = true }
                            )
                        }
                    }
                }

                if (showExportForm) {
                    Surface(
                        modifier = Modifier
                            .align(Alignment.BottomCenter)
                            .fillMaxWidth()
                            .shadow(16.dp, RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp)),
                        color = CardColor
                    ) {
                        CvsExportForm(
                            onCancel = { showExportForm = false },
                            onExport = { showExportForm = false }
                        )
                    }
                }

                if (showResetConfirm) {
                    ResetConfirmDialog(
                        onCancel = { showResetConfirm = false },
                        onConfirm = { showResetConfirm = false }
                    )
                }
            }
        }
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    private fun ReportesTopBar(onBackClick: () -> Unit) {
        CenterAlignedTopAppBar(
            title = {
                Text(
                    text = "Reportes y Exportación",
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
    private fun ReportesListItem(
        icon: ImageVector,
        title: String,
        subtitle: String,
        onClick: () -> Unit
    ) {
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .clickable(onClick = onClick),
            color = Color.Transparent
        ) {
            Row(
                modifier = Modifier.padding(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Surface(
                    modifier = Modifier.size(40.dp),
                    color = TealLight,
                    shape = CircleShape
                ) {
                    Box(contentAlignment = Alignment.Center) {
                        Icon(
                            icon,
                            contentDescription = title,
                            tint = Color.White,
                            modifier = Modifier.size(20.dp)
                        )
                    }
                }
                Spacer(modifier = Modifier.width(16.dp))
                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = title,
                        color = OnTeal,
                        style = MaterialTheme.typography.bodyLarge,
                        fontWeight = FontWeight.Medium
                    )
                    Text(
                        text = subtitle,
                        color = TextLight,
                        style = MaterialTheme.typography.bodySmall
                    )
                }
            }
        }
    }

    @Composable
    private fun CvsExportForm(onCancel: () -> Unit, onExport: () -> Unit) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = "Exportar CSV",
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 16.dp)
            )

            Surface(
                modifier = Modifier
                    .fillMaxWidth()
                    .shadow(2.dp, RoundedCornerShape(8.dp))
                    .border(1.dp, TealLight, RoundedCornerShape(8.dp))
                    .padding(12.dp),
                color = Color.Transparent
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        Icons.Filled.Schedule,
                        contentDescription = "Uso total",
                        modifier = Modifier.size(24.dp),
                        tint = TealDark
                    )
                    Spacer(modifier = Modifier.width(12.dp))
                    Text(
                        "Uso total",
                        style = MaterialTheme.typography.bodyLarge,
                        fontWeight = FontWeight.Medium
                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                "Rango de días",
                style = MaterialTheme.typography.bodyMedium,
                color = TextLight
            )
            OutlinedTextField(
                value = "10 sept - 20 oct",
                onValueChange = { },
                readOnly = true,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                shape = RoundedCornerShape(8.dp)
            )
            Text(
                "Los datos de uso se exportarán para el rango de fechas seleccionados",
                style = MaterialTheme.typography.bodySmall,
                color = TextLight,
                modifier = Modifier.padding(top = 4.dp, bottom = 24.dp)
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.End
            ) {
                OutlinedButton(
                    onClick = onCancel,
                    modifier = Modifier
                        .height(48.dp)
                        .shadow(2.dp, RoundedCornerShape(8.dp))
                ) {
                    Text("Cancelar", fontWeight = FontWeight.SemiBold)
                }
                Spacer(modifier = Modifier.width(8.dp))
                Button(
                    onClick = onExport,
                    modifier = Modifier
                        .height(48.dp)
                        .shadow(4.dp, RoundedCornerShape(8.dp)),
                    colors = ButtonDefaults.buttonColors(containerColor = TealBase)
                ) {
                    Text("Exportar", fontWeight = FontWeight.Bold)
                }
            }
        }
    }

    @Composable
    private fun ResetConfirmDialog(onCancel: () -> Unit, onConfirm: () -> Unit) {
        AlertDialog(
            onDismissRequest = onCancel,
            title = {
                Text(
                    "Restablecer estadísticas",
                    fontWeight = FontWeight.Bold
                )
            },
            text = {
                Text("¿Estás seguro de que quieres restablecer todas las estadísticas de uso? Esta acción no se puede deshacer.")
            },
            confirmButton = {
                Button(
                    onClick = onConfirm,
                    modifier = Modifier.shadow(2.dp, RoundedCornerShape(8.dp)),
                    colors = ButtonDefaults.buttonColors(containerColor = TealBase)
                ) {
                    Text("Restablecer", fontWeight = FontWeight.Bold)
                }
            },
            dismissButton = {
                OutlinedButton(
                    onClick = onCancel,
                    modifier = Modifier.shadow(1.dp, RoundedCornerShape(8.dp))
                ) {
                    Text("Cancelar")
                }
            },
            shape = RoundedCornerShape(12.dp),
            modifier = Modifier.shadow(8.dp, RoundedCornerShape(12.dp))
        )
    }

    @Preview(showBackground = true)
    @Composable
    fun PreviewReportesExportacionScreen() {
        ReportesExportacionScreen()
    }
}