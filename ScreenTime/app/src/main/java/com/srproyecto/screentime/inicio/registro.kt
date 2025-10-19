package com.srproyecto.screentime.inicio

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class registro {

    @Composable
    fun ClaveSeguridadScreen(onRegistrarClick: () -> Unit = {}) {
        var contrasena by remember { mutableStateOf("") }
        var confirmarContrasena by remember { mutableStateOf("") }

        Surface(
            modifier = Modifier.fillMaxSize(),
            color = Color(0xFFBFF2FA)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(32.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "INGRESAR CLAVE DE",
                    style = MaterialTheme.typography.bodyLarge,
                    fontSize = 16.sp,
                    color = Color.Gray
                )

                Text(
                    text = "SEGURIDAD",
                    style = MaterialTheme.typography.headlineLarge,
                    fontWeight = FontWeight.Bold,
                    fontSize = 28.sp,
                    modifier = Modifier.padding(bottom = 40.dp)
                )

                Row (
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(60.dp)
                        .padding(30.dp,0.dp,30.dp,0.dp)
                ) {
                    Button(
                        onClick = onRegistrarClick,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(40.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFF879A9A)
                        )
                    ) {
                        Image(
                            painter = painterResource(id = android.R.drawable.ic_menu_gallery),
                            contentDescription = "Descanso del teléfono",
                            modifier = Modifier.size(50.dp)
                        )
                        Text(
                            text = "Seleccionar método",
                            fontWeight = FontWeight.Bold,
                            fontSize = 16.sp,
                            color = Color.Black
                        )
                        Image(
                            painter = painterResource(id = android.R.drawable.ic_menu_gallery),
                            contentDescription = "Descanso del teléfono",
                            modifier = Modifier.size(50.dp)
                        )
                    }
                }


                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.Start
                ) {
                    Text(
                        text = "Contraseña:",
                        style = MaterialTheme.typography.bodyMedium,
                        modifier = Modifier.padding(bottom = 8.dp)
                    )

                    OutlinedTextField(
                        value = contrasena,
                        onValueChange = { contrasena = it },
                        modifier = Modifier.fillMaxWidth(),
                        visualTransformation = PasswordVisualTransformation(),
                        placeholder = { Text("password") }
                    )

                    Spacer(modifier = Modifier.height(24.dp))

                    Text(
                        text = "Confirmar contraseña:",
                        style = MaterialTheme.typography.bodyMedium,
                        modifier = Modifier.padding(bottom = 8.dp)
                    )

                    OutlinedTextField(
                        value = confirmarContrasena,
                        onValueChange = { confirmarContrasena = it },
                        modifier = Modifier.fillMaxWidth(),
                        visualTransformation = PasswordVisualTransformation(),
                        placeholder = { Text("password") }
                    )
                }

                Spacer(modifier = Modifier.height(40.dp))

                Button(
                    onClick = onRegistrarClick,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF77BBBB)
                    )
                ) {
                    Text(
                        text = "REGISTRAR",
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp
                    )
                }


                Row (
                    modifier = Modifier.padding(0.dp,300.dp,0.dp,0.dp).
                    fillMaxWidth(),

                    ) {
                }

                Button(
                    onClick = onRegistrarClick,
                    modifier = Modifier
                        .width(121.dp)
                        .height(40.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFFA8E1AA)
                    )
                ) {
                    Text(
                        text = "OMITIR",
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp
                    )
                }

            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun PreviewClaveSeguridadScreen() {
        ClaveSeguridadScreen()
    }
}