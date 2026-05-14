package com.kabaddiarena.presentation.screens.splash

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay
import coil.compose.AsyncImage
import com.kabaddiarena.ui.theme.*

@Composable
fun SplashScreen(
    onNavigateToLogin: () -> Unit
) {
    LaunchedEffect(key1 = true) {
        delay(2000)
        onNavigateToLogin()
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Background)
    ) {
        // Background Gradient
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    Brush.linearGradient(
                        colors = listOf(
                            Color(0xFFFF6F00).copy(alpha = 0.4f),
                            Color(0xFFD32F2F).copy(alpha = 0.4f),
                            Background.copy(alpha = 0.4f)
                        )
                    )
                )
        )

        // Content
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(320.dp),
                contentAlignment = Alignment.Center
            ) {
                 Box(
                     modifier = Modifier
                         .size(200.dp)
                         .background(Primary.copy(alpha = 0.2f), shape = androidx.compose.foundation.shape.CircleShape)
                 )
                 
                 AsyncImage(
                     model = "https://lh3.googleusercontent.com/aida-public/AB6AXuDdUd6ggnFCdMzf_vLXqkhhX1FLffgZGjv8SUJxIrc119zSFi8t_PLfOPK63h8f9BSx6g9dBgnYsFAPy0jtUhlan97Om6fiCf058tJmNRAhxDr677VDOSk3CBbbCx9j3DG-FXzNHp9oHzZHJsWgqHbTeBWnX7Hfb7JCNqcDHnT7mNrMrvGdG5gNuKZ_PigrI1Pm1Pc7-IAEn314V5KdLhNtspntCVzIDGrbg1bT4pN6dmiAZV99PXamLYeCHPJi7KyDFQb2dnWwDI9q",
                     contentDescription = "Player Silhouette",
                     contentScale = ContentScale.Fit,
                     modifier = Modifier.fillMaxSize()
                 )
            }

            Spacer(modifier = Modifier.height(32.dp))

            Text(
                text = "KABADDI ARENA",
                style = MaterialTheme.typography.displayLarge,
                color = OnSurface,
                fontWeight = FontWeight.ExtraBold
            )
            
            Text(
                text = "TRACK. ANALYZE. DOMINATE.",
                style = MaterialTheme.typography.titleMedium,
                color = Primary,
                modifier = Modifier.padding(top = 8.dp, bottom = 32.dp)
            )

            CircularProgressIndicator(
                color = PrimaryContainer,
                trackColor = SurfaceContainerHighest,
                strokeWidth = 4.dp,
                modifier = Modifier.size(64.dp)
            )
        }

        // Bottom Footer
        Column(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .size(width = 48.dp, height = 4.dp)
                    .background(
                        PrimaryContainer.copy(alpha = 0.4f),
                        shape = androidx.compose.foundation.shape.CircleShape
                    )
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = "INITIALISING TACTICAL DECK",
                style = MaterialTheme.typography.labelLarge,
                color = OnSurfaceVariant.copy(alpha = 0.6f)
            )
        }
    }
}
