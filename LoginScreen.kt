package com.kabaddiarena.presentation.screens.auth

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.kabaddiarena.ui.components.GlassCard
import com.kabaddiarena.ui.components.PrimaryButton
import com.kabaddiarena.ui.theme.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(
    onNavigateToOTP: (String) -> Unit
) {
    var phoneNumber by remember { mutableStateOf("") }
    var selectedCountryCode by remember { mutableStateOf("+91") }
    var expanded by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Background)
    ) {
        // Background Image with blur & darkness
        AsyncImage(
            model = "https://lh3.googleusercontent.com/aida-public/AB6AXuDut-dH1TRpj0OqF14p9QHpBJpBGeOCXDhglfQt_h4dIelpiGZ7yfY51V2AOpUQTijtrWk27_CfYPvQwzKNrw5T5NSYpzydwNe73I_Oe4F96crHtC9eghmwQE_jIFxEVIE5TLFGqFF4b8SfHtMYbanz585BXvniBlD7ZpL2PMQQLwpUggkxp0kZMmBjll07UhB0VK7xackvAauUc78ztSZb7ascN49Ex9yvLXaSQWW_aUdHznS_26EPKyzV-HmtqDyj6ca3AY95wolu",
            contentDescription = "Arena Background",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
        
        // Gradient overlay
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    Brush.verticalGradient(
                        colors = listOf(
                            Color(0xFF131313).copy(alpha = 0.6f),
                            Color(0xFF131313).copy(alpha = 0.2f),
                            Color(0xFF131313).copy(alpha = 0.9f)
                        )
                    )
                )
        )

        // Main Content
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 24.dp)
                .systemBarsPadding(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            // Header
            Text(
                text = "KABADDI ARENA",
                style = MaterialTheme.typography.displayLarge,
                color = Primary,
                fontWeight = FontWeight.ExtraBold
            )
            Box(
                modifier = Modifier
                    .padding(top = 8.dp, bottom = 32.dp)
                    .width(48.dp)
                    .height(4.dp)
                    .background(Primary, CircleShape)
            )

            // Login Card
            GlassCard(modifier = Modifier.fillMaxWidth()) {
                Column {
                    Text(
                        text = "Welcome Back",
                        style = MaterialTheme.typography.headlineLarge,
                        color = OnSurface
                    )
                    Text(
                        text = "Sign in to continue tracking your performance.",
                        style = MaterialTheme.typography.bodyMedium,
                        color = OnSurfaceVariant,
                        modifier = Modifier.padding(top = 4.dp, bottom = 24.dp)
                    )

                    Text(
                        text = "PHONE NUMBER",
                        style = MaterialTheme.typography.labelLarge,
                        color = Primary,
                        modifier = Modifier.padding(bottom = 8.dp)
                    )

                    // Phone Input Row
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        // Country Code Box
                        Box(
                            modifier = Modifier
                                .width(80.dp)
                                .height(56.dp)
                                .background(
                                    Primary.copy(alpha = 0.05f),
                                    RoundedCornerShape(12.dp)
                                )
                                .border(
                                    1.dp,
                                    OutlineVariant.copy(alpha = 0.3f),
                                    RoundedCornerShape(12.dp)
                                )
                                .clickable { expanded = true },
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = selectedCountryCode,
                                style = MaterialTheme.typography.bodyLarge,
                                color = OnSurface
                            )
                            DropdownMenu(
                                expanded = expanded,
                                onDismissRequest = { expanded = false },
                                modifier = Modifier.background(SurfaceContainerHigh)
                            ) {
                                DropdownMenuItem(
                                    text = { Text("+91", color = OnSurface) },
                                    onClick = { selectedCountryCode = "+91"; expanded = false }
                                )
                                DropdownMenuItem(
                                    text = { Text("+1", color = OnSurface) },
                                    onClick = { selectedCountryCode = "+1"; expanded = false }
                                )
                                DropdownMenuItem(
                                    text = { Text("+44", color = OnSurface) },
                                    onClick = { selectedCountryCode = "+44"; expanded = false }
                                )
                            }
                        }

                        // Input Field Box
                        Box(
                            modifier = Modifier
                                .weight(1f)
                                .height(56.dp)
                                .background(
                                    Primary.copy(alpha = 0.05f),
                                    RoundedCornerShape(12.dp)
                                )
                                .border(
                                    1.dp,
                                    OutlineVariant.copy(alpha = 0.3f),
                                    RoundedCornerShape(12.dp)
                                ),
                            contentAlignment = Alignment.CenterStart
                        ) {
                            Row(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .padding(horizontal = 16.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                BasicTextField(
                                    value = phoneNumber,
                                    onValueChange = { if (it.length <= 10) phoneNumber = it },
                                    modifier = Modifier.weight(1f),
                                    textStyle = MaterialTheme.typography.bodyLarge.copy(color = OnSurface),
                                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
                                    singleLine = true,
                                    cursorBrush = SolidColor(Primary),
                                    decorationBox = { innerTextField ->
                                        if (phoneNumber.isEmpty()) {
                                            Text(
                                                text = "Enter 10 digits",
                                                style = MaterialTheme.typography.bodyLarge,
                                                color = OnSurfaceVariant.copy(alpha = 0.4f)
                                            )
                                        }
                                        innerTextField()
                                    }
                                )
                                Icon(
                                    imageVector = Icons.Default.Phone,
                                    contentDescription = null,
                                    tint = OnSurfaceVariant.copy(alpha = 0.5f),
                                    modifier = Modifier.size(20.dp)
                                )
                            }
                        }
                    }

                    Spacer(modifier = Modifier.height(24.dp))

                    PrimaryButton(
                        onClick = { if (phoneNumber.length == 10) onNavigateToOTP(phoneNumber) }
                    ) {
                        Text(
                            text = "Send OTP",
                            style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Bold)
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Icon(
                            imageVector = Icons.Default.ArrowForward,
                            contentDescription = null,
                            modifier = Modifier.size(20.dp)
                        )
                    }

                    Spacer(modifier = Modifier.height(32.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = "New to Kabaddi Arena? ",
                            style = MaterialTheme.typography.bodyMedium,
                            color = OnSurfaceVariant
                        )
                        Text(
                            text = "Create Account",
                            style = MaterialTheme.typography.labelLarge,
                            color = Primary,
                            modifier = Modifier.clickable { /* Handle click */ }
                        )
                    }
                }
            }
        }
    }
}
