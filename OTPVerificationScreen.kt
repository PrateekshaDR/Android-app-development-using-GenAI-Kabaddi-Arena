package com.kabaddiarena.presentation.screens.auth

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.kabaddiarena.ui.components.PrimaryButton
import com.kabaddiarena.ui.theme.*

@Composable
fun OTPVerificationScreen(
    phoneNumber: String = "+91 XXXXX123XX",
    onBack: () -> Unit,
    onVerify: () -> Unit
) {
    var otpValues by remember { mutableStateOf(List(6) { "" }) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Background)
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    brush = Brush.radialGradient(
                        colors = listOf(
                            Primary.copy(alpha = 0.05f),
                            Color.Transparent
                        ),
                        radius = 2.dp.value
                    )
                )
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .systemBarsPadding(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp, vertical = 16.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                IconButton(onClick = onBack) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "Back",
                        tint = Primary
                    )
                }
                Text(
                    text = "KABADDI ARENA",
                    style = MaterialTheme.typography.titleMedium,
                    color = Primary,
                    fontWeight = FontWeight.ExtraBold
                )
                Spacer(modifier = Modifier.width(48.dp)) 
            }

            Column(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Box(
                    modifier = Modifier
                        .padding(bottom = 16.dp)
                        .size(80.dp)
                        .background(
                            PrimaryContainer.copy(alpha = 0.2f),
                            shape = androidx.compose.foundation.shape.CircleShape
                        )
                        .border(
                            1.dp,
                            Primary.copy(alpha = 0.2f),
                            androidx.compose.foundation.shape.CircleShape
                        ),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = Icons.Default.CheckCircle,
                        contentDescription = null,
                        tint = Primary,
                        modifier = Modifier.size(40.dp)
                    )
                }

                Text(
                    text = "Verify OTP",
                    style = MaterialTheme.typography.headlineLarge,
                    color = OnSurface
                )
                Text(
                    text = "Enter the 6-digit code sent to $phoneNumber",
                    style = MaterialTheme.typography.bodyMedium,
                    color = OnSurfaceVariant,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(top = 4.dp, bottom = 32.dp)
                )

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    for (i in 0..5) {
                        BasicTextField(
                            value = otpValues[i],
                            onValueChange = { value ->
                                if (value.length <= 1) {
                                    val newValues = otpValues.toMutableList()
                                    newValues[i] = value
                                    otpValues = newValues
                                }
                            },
                            modifier = Modifier
                                .size(56.dp)
                                .background(
                                    SurfaceContainer,
                                    RoundedCornerShape(12.dp)
                                )
                                .border(
                                    2.dp,
                                    if (otpValues[i].isNotEmpty()) PrimaryContainer else OutlineVariant.copy(alpha = 0.3f),
                                    RoundedCornerShape(12.dp)
                                ),
                            textStyle = MaterialTheme.typography.headlineLarge.copy(
                                color = Primary,
                                textAlign = TextAlign.Center
                            ),
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                            singleLine = true,
                            cursorBrush = SolidColor(Primary),
                            decorationBox = { innerTextField ->
                                Box(contentAlignment = Alignment.Center) {
                                    if (otpValues[i].isEmpty()) {
                                        Text(
                                            text = "-",
                                            color = Primary.copy(alpha = 0.5f),
                                            style = MaterialTheme.typography.headlineLarge
                                        )
                                    }
                                    innerTextField()
                                }
                            }
                        )
                    }
                }

                Spacer(modifier = Modifier.height(32.dp))

                Text(
                    text = "Resend OTP in 0:45",
                    style = MaterialTheme.typography.labelLarge,
                    color = OnSurfaceVariant
                )
                TextButton(
                    onClick = { },
                    enabled = false
                ) {
                    Text(
                        text = "Resend Code",
                        style = MaterialTheme.typography.labelLarge,
                        color = Primary.copy(alpha = 0.5f)
                    )
                }

                Spacer(modifier = Modifier.height(24.dp))

                PrimaryButton(onClick = onVerify) {
                    Text(
                        text = "Verify",
                        style = MaterialTheme.typography.titleMedium
                    )
                }

                Text(
                    text = "Secure biometric access enabled",
                    style = MaterialTheme.typography.labelLarge,
                    color = OnSurfaceVariant.copy(alpha = 0.6f),
                    modifier = Modifier.padding(top = 16.dp)
                )

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 32.dp)
                        .height(180.dp)
                        .clip(RoundedCornerShape(16.dp))
                        .border(1.dp, OutlineVariant.copy(alpha = 0.2f), RoundedCornerShape(16.dp))
                ) {
                    AsyncImage(
                        model = "https://lh3.googleusercontent.com/aida-public/AB6AXuBzqIt-PP6clMvXaorMxq9QlctDvhoCGWfydP9Vsk0vQTB_x6FG2ENIq6UYS0_Xb7T4budUvVj-CplF6IRe0rIlpILJmxZ2Sfx9rHNRNsOuhYq2zapUesxiKFtpdEP1gbUTx_lzSmAw2RWr8AlIcOT8RoiRA5xMBKVTPR6iTy4c3HZu0IacrHp-A2Hjactji0LKkWIHB-EASvs7EJ1oy7DizhlKTBydnvRsmUOj_vXQqmrGgKVwh22ypEtVclvMG-mgHKVOLYPcRaAs",
                        contentDescription = "Match Action",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.fillMaxSize()
                    )
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(
                                Brush.verticalGradient(
                                    colors = listOf(Color.Transparent, Background)
                                )
                            )
                    )
                    Box(
                        modifier = Modifier
                            .align(Alignment.BottomStart)
                            .padding(16.dp)
                            .background(
                                SurfaceContainer.copy(alpha = 0.8f),
                                RoundedCornerShape(8.dp)
                            )
                            .padding(12.dp)
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Box(
                                modifier = Modifier
                                    .size(8.dp)
                                    .background(Primary, androidx.compose.foundation.shape.CircleShape)
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(
                                text = "LIVE AUTHENTICATION PROTOCOL",
                                style = MaterialTheme.typography.labelLarge,
                                color = Primary
                            )
                        }
                    }
                }
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 24.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Default.Lock,
                    contentDescription = null,
                    tint = OnSurfaceVariant.copy(alpha = 0.4f),
                    modifier = Modifier.size(16.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "End-to-End Encryption Active",
                    style = MaterialTheme.typography.labelLarge.copy(fontSize = 10.sp),
                    color = OnSurfaceVariant.copy(alpha = 0.4f)
                )
            }
        }
    }
}
