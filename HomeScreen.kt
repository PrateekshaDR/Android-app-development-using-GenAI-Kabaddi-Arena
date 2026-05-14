package com.kabaddiarena.presentation.screens.home

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.kabaddiarena.ui.theme.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    onNavigateToMatchSetup: () -> Unit
) {
    var selectedFilter by remember { mutableStateOf("All") }
    val filters = listOf("All", "Wins", "Losses", "Practice")

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "KABADDI ARENA",
                        style = MaterialTheme.typography.titleLarge,
                        color = Primary,
                        fontWeight = FontWeight.ExtraBold
                    )
                },
                navigationIcon = {
                    IconButton(onClick = { /* Handle Menu */ }) {
                        Icon(
                            imageVector = Icons.Default.Menu,
                            contentDescription = "Menu",
                            tint = Primary
                        )
                    }
                },
                actions = {
                    Box(
                        modifier = Modifier
                            .padding(end = 16.dp)
                            .size(40.dp)
                            .clip(CircleShape)
                            .border(2.dp, Primary, CircleShape)
                    ) {
                        AsyncImage(
                            model = "https://lh3.googleusercontent.com/aida-public/AB6AXuDumEyw-xjBsGCPcfr7ipgDqVjzqy6nPFnJsH_5tgvxhXtsPgrks2RkHMD3NM4Wt499AZOmgOrwzeVb9XrfTMF_m_-KWCEnQJpiTX2SbBEVYfd6CnnZ9c8skocTdn6GYGWmfW8NydnVzOHArYQLete5oUf_GsirYxhCiQmBD0TO8qFhwnJpiDAA-ePSL7fqmXQUJgh-VSKQjMBx1Gb00DevRbLAtVAXqaHVWRh_Ues7IKObsdwd-XW1FlBUNOBhzqK5yV1Cb4mTGLY2",
                            contentDescription = "User Profile",
                            contentScale = ContentScale.Crop,
                            modifier = Modifier.fillMaxSize()
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = SurfaceContainer
                )
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = onNavigateToMatchSetup,
                containerColor = Primary,
                contentColor = OnPrimary,
                shape = CircleShape,
                modifier = Modifier.padding(bottom = 80.dp) // Avoid Bottom Navigation overlap
            ) {
                Icon(Icons.Default.Add, contentDescription = "Add Match")
            }
        },
        bottomBar = {
            BottomNavigationBar()
        },
        containerColor = Background
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(horizontal = 24.dp)
        ) {
            Spacer(modifier = Modifier.height(16.dp))
            
            // Search Bar
            OutlinedTextField(
                value = "",
                onValueChange = {},
                placeholder = { Text("Search opponents or dates...") },
                leadingIcon = { Icon(Icons.Default.Search, contentDescription = null) },
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(12.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    unfocusedContainerColor = SurfaceContainerHigh,
                    focusedContainerColor = SurfaceContainerHigh,
                    unfocusedBorderColor = Color.Transparent,
                    focusedBorderColor = Primary
                )
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Filters
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .horizontalScroll(rememberScrollState()),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                filters.forEach { filter ->
                    val isSelected = selectedFilter == filter
                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(50))
                            .background(if (isSelected) Primary else SurfaceContainerHigh)
                            .clickable { selectedFilter = filter }
                            .padding(horizontal = 24.dp, vertical = 12.dp)
                    ) {
                        Text(
                            text = filter,
                            style = MaterialTheme.typography.labelLarge,
                            color = if (isSelected) OnPrimary else OnSurfaceVariant
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            // Match List
            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(16.dp),
                modifier = Modifier.fillMaxSize()
            ) {
                item {
                    MatchCard(
                        title = "U-Mumba Strikers",
                        subtitle = "October 24, 2023 • Pro League Qualifiers",
                        status = "WIN",
                        statusColor = PrimaryContainer,
                        onStatusColor = OnPrimaryContainer,
                        borderColor = Primary,
                        stats = listOf("Total Pts" to "42", "Raid %" to "68%", "Tackle %" to "45%"),
                        statColor = Primary
                    )
                }
                item {
                    MatchCard(
                        title = "Jaipur Pink Panthers",
                        subtitle = "October 18, 2023 • Exhibition Match",
                        status = "LOSS",
                        statusColor = ErrorContainer,
                        onStatusColor = OnErrorContainer,
                        borderColor = Error,
                        stats = listOf("Total Pts" to "31", "Raid %" to "52%", "Tackle %" to "30%"),
                        statColor = Error
                    )
                }
                item {
                    MatchCard(
                        title = "Morning Drill Session",
                        subtitle = "October 15, 2023 • Internal Practice",
                        status = "DRILL",
                        statusColor = TertiaryContainer,
                        onStatusColor = OnTertiaryContainer,
                        borderColor = Tertiary,
                        stats = listOf("Raids" to "24", "Success" to "18", "Tackles" to "12"),
                        statColor = Tertiary
                    )
                }
            }
        }
    }
}

@Composable
fun MatchCard(
    title: String,
    subtitle: String,
    status: String,
    statusColor: Color,
    onStatusColor: Color,
    borderColor: Color,
    stats: List<Pair<String, String>>,
    statColor: Color
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(12.dp))
            .background(SurfaceContainer)
            .border(
                width = 1.dp,
                color = OutlineVariant.copy(alpha = 0.2f),
                shape = RoundedCornerShape(12.dp)
            )
    ) {
        Row(modifier = Modifier.fillMaxWidth()) {
            Box(
                modifier = Modifier
                    .width(4.dp)
                    .fillMaxHeight()
                    .background(borderColor)
            )
            Column(modifier = Modifier.padding(16.dp)) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.Top
                ) {
                    Column(modifier = Modifier.weight(1f)) {
                        Text(
                            text = title,
                            style = MaterialTheme.typography.titleMedium,
                            color = OnSurface
                        )
                        Text(
                            text = subtitle,
                            style = MaterialTheme.typography.bodyMedium,
                            color = OnSurfaceVariant
                        )
                    }
                    Box(
                        modifier = Modifier
                            .background(statusColor, RoundedCornerShape(8.dp))
                            .padding(horizontal = 8.dp, vertical = 4.dp)
                    ) {
                        Text(
                            text = status,
                            style = MaterialTheme.typography.labelLarge,
                            color = onStatusColor
                        )
                    }
                }
                
                Spacer(modifier = Modifier.height(16.dp))
                Divider(color = OutlineVariant.copy(alpha = 0.2f))
                Spacer(modifier = Modifier.height(16.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    stats.forEachIndexed { index, stat ->
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            modifier = Modifier.weight(1f)
                        ) {
                            Text(
                                text = stat.first.uppercase(),
                                style = MaterialTheme.typography.bodyMedium,
                                color = OnSurfaceVariant
                            )
                            Text(
                                text = stat.second,
                                style = MaterialTheme.typography.headlineMedium,
                                color = statColor,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun BottomNavigationBar() {
    NavigationBar(
        containerColor = SurfaceContainerHighest,
        contentColor = OnSurfaceVariant,
        tonalElevation = 8.dp,
        modifier = Modifier.clip(RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp))
    ) {
        NavigationBarItem(
            selected = false,
            onClick = { },
            icon = { Icon(Icons.Default.Home, contentDescription = "Home") },
            label = { Text("Home") }
        )
        NavigationBarItem(
            selected = true,
            onClick = { },
            icon = { Icon(Icons.Default.History, contentDescription = "History") },
            label = { Text("History") },
            colors = NavigationBarItemDefaults.colors(
                indicatorColor = PrimaryContainer,
                selectedIconColor = OnPrimaryContainer
            )
        )
        NavigationBarItem(
            selected = false,
            onClick = { },
            icon = { Icon(Icons.Default.Leaderboard, contentDescription = "Analytics") },
            label = { Text("Analytics") }
        )
        NavigationBarItem(
            selected = false,
            onClick = { },
            icon = { Icon(Icons.Default.Psychology, contentDescription = "AI Coach") },
            label = { Text("AI Coach") }
        )
        NavigationBarItem(
            selected = false,
            onClick = { },
            icon = { Icon(Icons.Default.Person, contentDescription = "Profile") },
            label = { Text("Profile") }
        )
    }
}
