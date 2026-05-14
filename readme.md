# Kabaddi Arena - Complete Project Documentation

## Part 1: Screen-by-Screen UI Prompts & Design Guidelines

---

### Screen 1: Splash Screen

**UI Design Prompt:**
Create a modern, energetic splash screen with a dark gradient background transitioning from deep orange (#FF6F00) to dark red (#D32F2F). Display the app logo "Kabaddi Arena" in bold, sporty typography (using Poppins or Montserrat font family) centered on the screen. Below the logo, add a subtle tagline "Track. Analyze. Dominate." in lighter weight font. Include an animated Kabaddi player silhouette in an action pose (raiding position) with a glowing effect. Add a circular progress indicator at the bottom with brand color accent. The entire screen should have a subtle grid pattern overlay to give a digital sports tech feel.

**Components:**
- App Logo (ImageView/Compose Image)
- Tagline Text (TextView/Text)
- Player Silhouette Animation (Lottie Animation)
- Loading Progress Indicator (CircularProgressIndicator)
- Background Gradient Container

**User Experience:**
Duration: 2-3 seconds. Smooth fade-in animation for logo and silhouette. Auto-navigate to Login screen after initialization. Feel: Energetic, modern, professional sports tech application.

---

### Screen 2: Login/Authentication Screen

**UI Design Prompt:**
Design a clean authentication screen with a semi-transparent card layout over a blurred Kabaddi court background image. At the top, display "Welcome Back" in large bold text with "Sign in to continue tracking" subtitle. Include a phone number input field with country code selector (+91 default) using an outlined text field with a phone icon. Below it, place a large, rounded "Send OTP" button in primary orange color (#FF6F00) with white text. At the bottom, add "New to Kabaddi Arena? Create Account" text link. Use Material Design 3 components with proper elevation and corner radius (16dp).

**Components:**
- Background Image with Blur Effect
- Card Container (elevation: 4dp, corner radius: 20dp)
- Welcome Text (Typography.headlineMedium)
- Phone Input Field (OutlinedTextField with prefix icon)
- Country Code Dropdown
- Send OTP Button (FilledButton)
- Create Account Text Link (TextButton)
- Keyboard Type: Phone

**User Experience:**
Smooth keyboard appearance. Real-time phone number validation (10 digits). Disable button until valid number entered. Show loading state on button when OTP is being sent. Error messages appear below input field in red. Feel: Simple, trustworthy, quick authentication flow.

**Navigation Flow:**
Login Screen → OTP Verification Screen → Player Profile Setup (first time) / Home Dashboard (returning user)

---

### Screen 3: OTP Verification Screen

**UI Design Prompt:**
Create an OTP input screen with a centered layout. Display "Verify OTP" heading with "Enter the 6-digit code sent to +91 XXXXX123XX" subtitle. Implement 6 individual boxes for OTP digits with auto-focus progression. Each box should be a square (56dp x 56dp) with rounded corners, centered digits in large font size (24sp). Active box should have orange border, filled boxes should have dark border, empty boxes light gray border. Below OTP boxes, show countdown timer "Resend OTP in 0:45" with resend link enabled after timeout. Add a "Verify" button at bottom. Include a back arrow in top-left corner.

**Components:**
- Top App Bar with Back Button
- Heading Text (Typography.headlineMedium)
- Subtitle with masked phone number
- 6 OTP Input Boxes (Custom Composable or TextFields)
- Countdown Timer Text
- Resend OTP Link (TextButton)
- Verify Button (FilledButton)
- Keyboard Type: Number

**User Experience:**
Auto-focus on first box. Auto-advance to next box on digit entry. Auto-submit when all 6 digits entered. Paste functionality for OTP from SMS. Clear indication of active/filled/empty states. Show error state with shake animation on wrong OTP. Feel: Smooth, intuitive, minimal friction.

**Navigation Flow:**
OTP Screen → Player Profile Setup (first login) / Home Dashboard (returning user)

---

### Screen 4: Player Profile Setup Screen

**UI Design Prompt:**
Design a comprehensive profile creation form with a scrollable layout. At the top-center, place a circular profile photo placeholder (120dp diameter) with a camera icon overlay for photo selection. Below, arrange vertically: Player Name (required), Age (number picker or input), Team Name (optional), Position dropdown (Raider/All-rounder/Defender), and Jersey Number fields. Each field should use OutlinedTextField style with appropriate icons (person, calendar, team, position, number). Use consistent 16dp padding between fields. At the bottom, place a full-width "Complete Profile" button in primary color. Add a "Skip for Now" text button above it. Include a progress indicator showing "Step 1 of 1" at the top.

**Components:**
- ScrollView Container
- Profile Photo Picker (Circular with border, camera icon overlay)
- Player Name TextField (OutlinedTextField with person icon)
- Age Number Input (OutlinedTextField with calendar icon)
- Team Name TextField (OutlinedTextField with team icon)
- Position Dropdown (ExposedDropdownMenu with values: Raider, All-rounder, Defender)
- Jersey Number TextField (OutlinedTextField with number icon)
- Complete Profile Button (FilledButton)
- Skip Button (TextButton)
- Image Picker Integration

**User Experience:**
Photo selection opens bottom sheet with Camera/Gallery options. Real-time validation (name required, age 10-50, jersey number 1-99). Field errors shown below each input. Smooth scroll behavior. Save draft locally if user exits. Feel: Welcoming onboarding, optional but encouraged completion.

**Navigation Flow:**
Profile Setup → Home Dashboard (after completion or skip)

---

### Screen 5: Home Dashboard

**UI Design Prompt:**
Create a vibrant, information-rich dashboard with the following sections:
- **Top Section**: Greeting "Hello, [Player Name]!" with profile picture (40dp circular) in top-right corner. Show current date below greeting.
- **Quick Stats Card**: Display 4 stat tiles in 2x2 grid - Total Matches, Avg Points/Match, Raid Success %, Tackle Success %. Each tile with large number, small label, and icon, using card elevation with subtle gradient backgrounds.
- **AI Insight Card**: Featured card with robot icon, showing latest AI tip in italic text with "View More" link. Use accent color border.
- **Recent Matches Section**: Horizontal scrollable list of match cards showing opponent name, date, score, and "View Details" button. Each card 280dp wide with match outcome indicator (Win/Loss colored strip).
- **Floating Action Button**: Large circular "Start New Match" FAB in bottom-right (orange, with plus icon) elevated above content.

**Components:**
- Top App Bar with greeting and profile icon
- Stats Grid (LazyVerticalGrid with 2 columns)
- AI Insight Card (Card with colored border)
- Recent Matches Horizontal List (LazyRow)
- Match Card Composable (Custom card with outcome indicator)
- Floating Action Button (FAB)
- Pull-to-refresh functionality

**User Experience:**
Smooth scrolling. Stats animate on load with count-up effect. Cards have subtle shadow and ripple effect on tap. Empty state shows "No matches yet" with illustration when no data. Profile icon navigates to profile details. Feel: Motivating, data-rich, actionable dashboard encouraging engagement.

**Navigation Flow:**
Home → Match Setup (via FAB) / Match Details (via recent match card) / Player Profile (via profile icon) / AI Coach Tips (via insight card)

---

### Screen 6: Match Setup Screen

**UI Design Prompt:**
Design a focused pre-match configuration screen with a sports preparation theme. Use a card-based layout with a subtle court background. Display "New Match Setup" heading at top. Include three main input sections:
1. **Opponent Details**: Team name input with team icon
2. **Match Details**: Date picker showing today by default, Time picker, Venue text field (optional)
3. **Match Type**: Segmented button group with options: Practice, League, Tournament, Friendly
Add a large "Start Match Tracking" button at bottom in energetic orange color. Include a back arrow and save as draft option in top bar.

**Components:**
- Top App Bar (Back button, "Save Draft" action)
- Heading Text
- Opponent Team TextField (OutlinedTextField)
- Date Picker Field (click opens DatePickerDialog)
- Time Picker Field (click opens TimePickerDialog)
- Venue TextField (Optional, OutlinedTextField)
- Match Type Segmented Buttons (Single choice)
- Start Match Button (FilledButton, full width)
- Form validation indicators

**User Experience:**
Date defaults to today, time to current time. Match type defaults to "Practice". All fields except venue required. Button disabled until required fields filled. Smooth transitions between field focus. Confirmation dialog on back press if data entered. Feel: Quick setup, focused, getting player ready for match tracking.

**Navigation Flow:**
Match Setup → Live Match Logger (after Start Match button pressed) / Home Dashboard (back navigation)

---

### Screen 7: Live Match Logger Screen

**UI Design Prompt:**
Create a high-energy, real-time tracking interface optimized for quick tapping during live match. Design with the following layout:

**Top Section:**
- Match timer (running clock showing elapsed time)
- Current score display (large, centered) showing total points
- Opponent team name banner

**Middle Section - Action Buttons:**
- Two massive, equally-sized buttons filling the width:
  - **RAID** button (left, orange gradient background, #FF6F00 to #FF8F00)
  - **TACKLE** button (right, blue gradient background, #1976D2 to #2196F3)
- Buttons should be 160dp height with bold white text (20sp) and relevant icons
- Ripple effect on tap with haptic feedback

**Stats Bar** (below action buttons):
- Horizontal scrollable chips showing: Total Points, Raids, Tackles, Success Rate
- Live updating numbers with subtle animation

**Recent Actions List:**
- Bottom sheet style list showing last 5 actions with timestamp
- Each action shows: Time, Action Type, Points, with color coding
- Swipe to undo functionality on items

**Bottom Bar:**
- UNDO button (left, with undo icon)
- END MATCH button (right, with check icon, outlined style)

**Components:**
- Match Timer (Text with automatic update)
- Score Display (Large text, bold)
- Raid Button (Large FilledButton with gradient)
- Tackle Button (Large FilledButton with gradient)
- Stats Chips (Horizontal LazyRow of FilterChips)
- Recent Actions List (LazyColumn with custom item layout)
- Undo Button (FilledTonalButton)
- End Match Button (OutlinedButton)
- Action Type Bottom Sheet Dialog

**User Experience:**
Buttons should respond instantly with visual and haptic feedback. When RAID is tapped, bottom sheet slides up with options: Empty Raid (0 pts), Touch Point (1 pt), Bonus Point (1 pt), Successful Raid (2+ pts), Got Out (0 pts). When TACKLE is tapped, options appear: Successful Tackle (1 pt), Super Tackle (2+ pts), Failed Tackle (0 pts). Stats update in real-time with smooth animations. Undo removes last action with confirmation toast. Feel: Fast-paced, responsive, zero-friction logging during intense match moments.

**Navigation Flow:**
Live Match Logger → Action Type Bottom Sheet (on button tap) / Match Summary (on End Match) / Home Dashboard (on back with confirmation dialog)

---

### Screen 8: Action Type Bottom Sheet

**UI Design Prompt:**
Design a modal bottom sheet that slides up from bottom, occupying 60% of screen height. Display heading "Select [Raid/Tackle] Outcome" at top with close icon. Show large, tappable option cards arranged vertically:

**For Raid:**
- Empty Raid (gray icon, "0 points" subtitle)
- Touch Point (green icon, "+1 point" subtitle)
- Bonus Point (blue icon, "+1 point" subtitle)
- Successful Raid (gold icon, "+2 points" subtitle)
- Got Out (red icon, "0 points" subtitle)

**For Tackle:**
- Successful Tackle (green icon, "+1 point" subtitle)
- Super Tackle (gold icon, "+2 points" subtitle)
- Failed Tackle (red icon, "0 points" subtitle)

Each card should be 72dp height with icon, title, subtitle, and right arrow indicator.

**Components:**
- Modal Bottom Sheet Container
- Sheet Header with Title and Close Button
- Action Option Cards (Custom Composable)
- Icon + Text + Subtitle layout
- Ripple effect on cards

**User Experience:**
Appears with smooth slide-up animation. Tapping any option immediately logs action, updates stats, dismisses sheet, and returns to match logger. Swipe down or tap outside to dismiss without action. Feel: Quick decision making, clear visual hierarchy of options.

**Navigation Flow:**
Action Type Sheet → Live Match Logger (auto-dismiss after selection)

---

### Screen 9: Match Summary/Performance Card Screen

**UI Design Prompt:**
Create a visually stunning, shareable performance summary screen with the following design:

**Performance Card Design** (exportable as image):
- Gradient background (orange to red, matching brand)
- **Header Section**: "Match Performance" title, Date & Opponent team name
- **Hero Stats Section**: Large circular progress indicators for Raid Success % and Tackle Success %, placed side-by-side
- **Stats Grid**: 2x3 grid showing:
  - Total Points (large, emphasized)
  - Total Raids
  - Successful Raids
  - Total Tackles
  - Successful Tackles
  - Super Tackles
- **AI Insight Box**: Small box with AI-generated performance summary (2-3 lines)
- **Footer**: Player name, Team name, "Powered by Kabaddi Arena" branding

**Screen Layout:**
- Performance Card Preview (centered, with border shadow)
- Action Buttons below card:
  - Share as Image (WhatsApp, Instagram, etc.)
  - View Detailed Analytics
  - Save to History
  - Start New Match

**Components:**
- Scrollable Container
- Performance Card Canvas (exportable composable)
- Circular Progress Indicators (with percentage text)
- Stats Grid (LazyVerticalGrid)
- AI Insight Card
- Share Button (with share icon)
- View Analytics Button
- Save Button
- Bitmap conversion functionality for sharing

**User Experience:**
Card automatically generated after match ends. Smooth entrance animation. Stats animate into view with count-up effect. Share button opens Android share sheet with image. Confetti animation plays briefly on screen load for completed match celebration. Feel: Rewarding, shareable, achievement-focused, Instagram-worthy design.

**Navigation Flow:**
Match Summary → Share Dialog (via share button) / Analytics Dashboard (via analytics button) / Home Dashboard (via save/back)

---

### Screen 10: Player Heatmap Screen

**UI Design Prompt:**
Design an analytical visualization screen showing a top-down Kabaddi court layout with position-based performance data:

**Court Visualization:**
- Full Kabaddi court diagram (720px wide, proportional height)
- Divided into zones: Left Corner, Left Cover, Mid, Right Cover, Right Corner for both halves
- Baulk line, mid line, lobby clearly marked with proper dimensions
- Color-coded zone overlays showing raid success density:
  - Dark Green: 80-100% success
  - Light Green: 60-79% success
  - Yellow: 40-59% success
  - Orange: 20-39% success
  - Red: 0-19% success

**Top Section:**
- Filter tabs: All Matches, Last 5 Matches, Last Month
- Success/Failure toggle switch

**Bottom Section:**
- Legend explaining color coding
- Zone-wise statistics list showing exact numbers

**Components:**
- Custom Canvas/SVG for court drawing
- Zone overlay with transparency
- Filter Tabs (TabRow)
- Toggle Switch (Switch with label)
- Statistics List (LazyColumn)
- Color Legend (Row of colored boxes with labels)

**User Experience:**
Interactive zones - tap any zone to see detailed stats for that court position. Smooth color transitions. Swipe to toggle between success and failure heatmaps. Empty state shows "Not enough data" with minimum 5 raids required. Feel: Professional analytics, coaching-tool quality, insight-revealing visualization.

**Navigation Flow:**
Heatmap Screen → Zone Details Bottom Sheet (on zone tap) / Home Dashboard (back navigation)

---

### Screen 11: Point Trend Graph Screen

**UI Design Prompt:**
Create a performance trends analysis screen with multiple chart visualizations:

**Chart Sections:**

1. **Match-wise Points Trend** (Line Chart):
   - X-axis: Match dates
   - Y-axis: Total points scored
   - Line showing performance trajectory
   - 280dp height

2. **Raid vs Tackle Points** (Stacked Bar Chart):
   - Each bar represents one match
   - Stacked segments for raid points and tackle points
   - Different colors for each type
   - 240dp height

3. **Success Rate Over Time** (Area Chart):
   - Dual line area chart showing raid and tackle success percentages
   - Gradient fill below lines
   - 280dp height

**Top Section:**
- Time range selector: Last 5 matches, Last 10, Last Month, All Time
- Average stats summary cards

**Components:**
- Time Range Segmented Buttons
- Summary Stats Cards (Row with 3 cards)
- Line Chart (using Chart library like MPAndroidChart or Vico)
- Bar Chart
- Area Chart
- Chart legends
- ScrollView container for all charts

**User Experience:**
Charts load with smooth animation. Tap data points to see exact values in tooltip. Horizontal scrolling for charts if many data points. Empty state shows "Track more matches to see trends" with illustration. Feel: Data-driven, progress-motivating, clear performance visualization.

**Navigation Flow:**
Trend Graph Screen → Home Dashboard (back navigation)

---

### Screen 12: AI Coach Tips Screen

**UI Design Prompt:**
Design an AI-powered insights and coaching screen with the following structure:

**Header:**
- Robot/AI icon with gradient background
- "Your AI Coach" title
- "Personalized insights based on your performance" subtitle

**Content Sections:**

1. **Latest Insight Card** (Featured):
   - Large card with accent border
   - AI-generated coaching tip based on last match
   - Timestamp "Generated 2 hours ago"
   - Bookmark icon to save

2. **Performance Analysis**:
   - Strengths section (green background):
     - Bullet points of what player does well
     - Supporting statistics
   - Weaknesses section (orange background):
     - Areas needing improvement
     - Specific suggestions

3. **Recommended Focus Areas**:
   - Chip group with focus areas: "Improve Empty Raids", "Tackle Timing", etc.
   - Each chip tappable for detailed tips

4. **Training Drills** (if future enhancement):
   - Suggested exercises based on weaknesses

**Bottom Action:**
- "Generate New Analysis" button (uses latest data)

**Components:**
- Hero Section with icon and title
- Insight Card (elevated, bordered)
- Strengths List (LazyColumn with green accent)
- Weaknesses List (LazyColumn with orange accent)
- Focus Area Chips (FlowRow of FilterChips)
- Generate Button (FilledButton)
- Loading State (shows during API call)
- Error State (with retry button)

**User Experience:**
Insights load automatically on screen open if connected to internet. Smooth loading animation with skeleton screens. Text appears with typewriter effect for engaging feel. Pull-to-refresh to regenerate analysis. Offline state shows last cached insight. Feel: Personalized coaching, AI-assisted improvement, motivating and actionable.

**Navigation Flow:**
AI Coach Screen → Focus Area Details (on chip tap) / Home Dashboard (back navigation)

---

### Screen 13: Match History Screen

**UI Design Prompt:**
Design a comprehensive match history archive with filtering and search capabilities:

**Top Section:**
- Search bar to find matches by opponent
- Filter chips: All, Wins, Losses, Practice, League, Tournament
- Sort dropdown: Recent First, Oldest First, Best Performance

**Match List:**
Each match card displays:
- Date and time (top-left)
- Opponent team name (large, bold)
- Match result badge (Win/Loss/Draw in colored chip)
- Key stats: Total Points, Raid %, Tackle %
- Match type icon (practice/league/tournament indicator)
- Right arrow to view details
- Card uses elevation and has colored left border (green for win, red for loss)

**Components:**
- Top App Bar with title
- Search TextField
- Filter Chips (LazyRow)
- Sort Dropdown (ExposedDropdownMenu)
- Match List (LazyColumn with pagination)
- Match Card Item (Custom Composable)
- Empty State (when no matches)
- Delete Swipe Action (swipe left reveals delete)
- FAB for "Start New Match"

**User Experience:**
List loads with pagination (20 items at a time). Smooth search with debounce. Filters apply instantly with animation. Swipe left on card to reveal delete option with confirmation dialog. Tap card to view full match details. Empty state shows "Your match history will appear here" with illustration. Feel: Organized, searchable, comprehensive history management.

**Navigation Flow:**
Match History → Match Details Screen (on card tap) / Match Setup (via FAB) / Home Dashboard (back navigation)

---

### Screen 14: Match Details Screen

**UI Design Prompt:**
Create a detailed view of a completed match with all statistics and timeline:

**Header:**
- Match date and venue
- Opponent team name (large)
- Final score and match outcome badge

**Stats Overview:**
- Performance Card (similar to post-match summary but non-editable)
- Circular progress indicators for success rates

**Match Timeline:**
- Chronological list of all actions logged during match
- Each entry shows: Time, Action type with icon, Points earned, Running total
- Color-coded by action type (raids orange, tackles blue)

**Action Buttons:**
- Share Performance Card
- View Heatmap (navigates to heatmap filtered for this match)
- Delete Match (with confirmation)

**Components:**
- Scrollable Container
- Header Section with stats
- Performance Summary Card
- Timeline List (LazyColumn with custom items)
- Action Buttons Row
- Share functionality
- Delete confirmation dialog

**User Experience:**
Smooth scrolling through timeline. Tap timeline items to see detailed breakdown. Performance card same design as post-match but read-only. Share creates image identical to post-match card. Feel: Detailed, reviewable, permanent record of performance.

**Navigation Flow:**
Match Details → Heatmap (filtered view) / Share Dialog / Home Dashboard (back navigation)

---

### Screen 15: Player Profile/Settings Screen

**UI Design Prompt:**
Design a profile management and app settings screen with the following sections:

**Profile Section:**
- Large circular profile photo (120dp) with edit button overlay
- Player name (editable)
- Team name and jersey number
- Career stats summary: Total matches, Total points, Avg points/match

**Account Settings:**
- Edit Profile Information
- Change Phone Number
- Notification Preferences (toggle switches)
- Language Selection

**App Settings:**
- Dark Mode Toggle
- Data & Storage: Clear Cache, Export Data
- Backup & Sync options

**About Section:**
- App Version
- Privacy Policy
- Terms of Service
- Rate App
- Share App

**Logout Button** (bottom, outlined, red text)

**Components:**
- Scrollable Container
- Profile Header (Column with centered items)
- Settings List Items (Custom preference items)
- Section Headers (Text with divider)
- Toggle Switches
- Navigation Arrows for sub-screens
- Logout Button (OutlinedButton with alert color)
- Edit Profile Dialog

**User Experience:**
Tap profile photo to change. Each setting item navigates to detail screen or shows dialog. Toggles provide instant feedback. Logout shows confirmation dialog. Profile changes save automatically. Feel: Comprehensive, organized settings hub with easy profile management.

**Navigation Flow:**
Profile Screen → Edit Profile Dialog / Phone Change Screen / Notification Settings / Home Dashboard (back navigation)

---

## Part 2: Complete Workflow & Screen Connection Map

### Application Flow Diagram

```
[Splash Screen] (2-3 seconds)
      ↓
[Login Screen] 
      ↓ (Enter phone, send OTP)
[OTP Verification Screen]
      ↓ (First time user)    ↓ (Returning user)
[Player Profile Setup] → [Home Dashboard] ←┐
      ↓                        ↓             |
      └────────────────────────┘             |
                               ↓             |
                    ┌──────────┼──────────┬─┴──────────┬──────────┐
                    ↓          ↓          ↓            ↓          ↓
            [Match Setup] [Profile] [AI Coach] [Match History] [Analytics]
                    ↓                                   ↓
         [Live Match Logger]                    [Match Details]
                    ↓                                   ↓
         [Action Type Sheet]                    [Performance Card]
                    ↓                                   ↓
         [Match Summary/                         [Heatmap/Trends]
          Performance Card]
                    ↓
         [Share/Save/Analytics]
                    ↓
            [Home Dashboard]
```

### Detailed Screen-to-Screen Navigation Flow

**1. App Launch Flow:**
```
Splash → Check Auth State → 
   If Logged In → Home Dashboard
   If Not Logged In → Login Screen
```

**2. Authentication Flow:**
```
Login Screen → 
   Enter Phone → 
   Send OTP → 
   OTP Verification → 
   Verify Success → 
      If First Time → Profile Setup → Home Dashboard
      If Returning → Home Dashboard
```

**3. Match Tracking Flow:**
```
Home Dashboard → 
   Tap "Start New Match" FAB → 
   Match Setup Screen → 
   Enter Details → 
   Tap "Start Match Tracking" → 
   Live Match Logger → 
   Log Actions (Raid/Tackle) → 
   Action Type Bottom Sheet → 
   Select Outcome → 
   Return to Logger (stats updated) → 
   Continue until match ends → 
   Tap "End Match" → 
   Confirmation Dialog → 
   Match Summary/Performance Card → 
   Options: Share / View Analytics / Save to History → 
   Home Dashboard
```

**4. Analytics & Review Flow:**
```
Home Dashboard → 
   Tap Recent Match Card → 
   Match Details Screen → 
   View Timeline & Stats → 
   Options:
      → Tap "View Heatmap" → Heatmap Screen (filtered for that match)
      → Tap "View Trends" → Point Trend Graph Screen
      → Tap Zone → Zone Detail Sheet
   → Back to Home Dashboard
```

**5. AI Coach Flow:**
```
Home Dashboard → 
   Tap AI Insight Card / Navigate to AI Coach → 
   AI Coach Tips Screen → 
   (Auto-load latest insights using Gemini/Claude API) → 
   View Strengths/Weaknesses/Recommendations → 
   Tap "Generate New Analysis" → 
   Loading State → 
   Updated Insights → 
   Back to Home Dashboard
```

**6. History Management Flow:**
```
Home Dashboard → 
   Navigate to Match History → 
   Match History Screen → 
   Filter/Search/Sort Matches → 
   Tap Match Card → 
   Match Details Screen → 
   View/Share/Delete → 
   Back to History → 
   Back to Home Dashboard
```

**7. Profile Management Flow:**
```
Home Dashboard → 
   Tap Profile Icon → 
   Player Profile/Settings Screen → 
   Edit Profile / Change Settings → 
   Save Changes → 
   Back to Home Dashboard
```

---

## Part 3: Complete SOP Document for Antigravity

# **KABADDI ARENA - Standard Operating Procedure (SOP)**
## **Complete Project Implementation Guide**

---

## **1. PROJECT OVERVIEW**

### 1.1 Project Name
**Kabaddi Arena** - GenAI-Powered Kabaddi Player Performance Tracking & Analytics Android Application

### 1.2 Project Description
Kabaddi Arena is a comprehensive mobile application designed for individual Kabaddi players to track, analyze, and improve their match performance through real-time event logging, AI-powered insights, and visual analytics. The app enables players to log raid and tackle events during live matches, automatically calculates performance statistics, generates shareable performance cards, and provides AI-driven coaching recommendations using Generative AI APIs.

### 1.3 Core Objectives
- Provide zero-friction, real-time match event logging during live Kabaddi matches
- Automatically calculate and display performance metrics (raid success %, tackle success %, points)
- Generate professional, shareable performance cards for social media
- Deliver AI-powered coaching insights and improvement recommendations
- Maintain complete offline functionality with local data storage
- Create visually appealing analytics dashboards (heatmaps, trend graphs)
- Build using modern Android development best practices and architecture

### 1.4 Target Users
- Amateur and semi-professional Kabaddi players
- Kabaddi enthusiasts tracking their recreational play
- Players aged 15-40 seeking performance improvement
- Individual athletes without access to professional coaching analytics

### 1.5 Key Features Summary
1. Phone number + OTP authentication
2. Player profile management with photo
3. Pre-match setup with opponent and match type configuration
4. Live match event logger with large raid/tackle buttons
5. Real-time statistics calculation and display
6. Undo functionality for logged events
7. Auto-generated performance cards (exportable as PNG)
8. Visual analytics: heatmaps and trend graphs
9. AI-powered coaching tips using Gemini/Claude API
10. Complete match history with search and filters
11. Offline-first architecture with Room Database
12. Material Design 3 UI with sports-themed design

---

## **2. TECHNICAL STACK & ARCHITECTURE**

### 2.1 Frontend Technology Stack

**Programming Language:**
- Kotlin (100%)

**UI Framework:**
- Jetpack Compose (declarative UI)
- Material Design 3 (Material You components)

**Architecture Pattern:**
- MVVM (Model-View-ViewModel)
- Clean Architecture principles
- Repository pattern for data layer

**Navigation:**
- Jetpack Navigation Component for Compose
- Type-safe navigation with routes
- Bottom sheet navigation for modals

**State Management:**
- Compose State and StateFlow
- ViewModel with LiveData/StateFlow
- Remember and rememberSaveable for UI state

**Dependency Injection:**
- Hilt (Dagger-based DI for Android)
- Module organization for repositories, use cases, APIs

**Asynchronous Programming:**
- Kotlin Coroutines
- Flow for reactive data streams
- Suspend functions for async operations

### 2.2 Backend & Data Layer Technology Stack

**Local Database:**
- Room Database (SQLite abstraction)
- Type-safe database access
- Migration support for schema changes

**Networking:**
- Retrofit 2 for REST API calls
- OkHttp for HTTP client with interceptors
- Gson/Kotlinx.serialization for JSON parsing

**AI Integration:**
- Google Gemini API (primary) for AI insights
- Anthropic Claude API (alternative/fallback)
- Retrofit-based API clients for GenAI services

**Image Processing:**
- Coil for image loading and caching
- Canvas API for performance card generation
- Bitmap manipulation for PNG export

**Data Storage:**
- SharedPreferences for app settings and auth tokens
- Room for structured match and player data
- File storage for exported images

### 2.3 Libraries & Dependencies

```kotlin
// Core Android & Compose
implementation("androidx.core:core-ktx:1.12.0")
implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.7.0")
implementation("androidx.activity:activity-compose:1.8.2")
implementation(platform("androidx.compose:compose-bom:2024.01.00"))
implementation("androidx.compose.ui:ui")
implementation("androidx.compose.ui:ui-graphics")
implementation("androidx.compose.ui:ui-tooling-preview")
implementation("androidx.compose.material3:material3")

// Navigation
implementation("androidx.navigation:navigation-compose:2.7.6")

// ViewModel & LiveData
implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.7.0")
implementation("androidx.lifecycle:lifecycle-runtime-compose:2.7.0")

// Room Database
implementation("androidx.room:room-runtime:2.6.1")
implementation("androidx.room:room-ktx:2.6.1")
kapt("androidx.room:room-compiler:2.6.1")

// Hilt Dependency Injection
implementation("com.google.dagger:hilt-android:2.50")
kapt("com.google.dagger:hilt-android-compiler:2.50")
implementation("androidx.hilt:hilt-navigation-compose:1.1.0")

// Retrofit & Networking
implementation("com.squareup.retrofit2:retrofit:2.9.0")
implementation("com.squareup.retrofit2:converter-gson:2.9.0")
implementation("com.squareup.okhttp3:okhttp:4.12.0")
implementation("com.squareup.okhttp3:logging-interceptor:4.12.0")

// Coroutines
implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.3")

// Image Loading
implementation("io.coil-kt:coil-compose:2.5.0")

// Charts
implementation("com.patrykandpatrick.vico:compose:1.13.1")
// OR
implementation("com.github.PhilJay:MPAndroidChart:v3.1.0")

// AI APIs (Gemini)
implementation("com.google.ai.client.generativeai:generativeai:0.1.2")

// Authentication (if using Firebase Auth for OTP)
implementation("com.google.firebase:firebase-auth-ktx:22.3.1")

// Permissions
implementation("com.google.accompanist:accompanist-permissions:0.33.2-alpha")

// Date/Time
implementation("org.jetbrains.kotlinx:kotlinx-datetime:0.5.0")
```

### 2.4 Project Architecture Layers

**Presentation Layer (UI):**
```
com.kabaddiarena.presentation/
├── screens/
│   ├── splash/
│   ├── auth/
│   ├── profile/
│   ├── home/
│   ├── match/
│   ├── analytics/
│   └── history/
├── components/ (reusable UI components)
├── navigation/
└── theme/
```

**Domain Layer (Business Logic):**
```
com.kabaddiarena.domain/
├── model/ (domain entities)
├── repository/ (interfaces)
└── usecase/
    ├── match/
    ├── player/
    └── analytics/
```

**Data Layer:**
```
com.kabaddiarena.data/
├── local/
│   ├── dao/
│   ├── database/
│   └── entity/
├── remote/
│   ├── api/
│   ├── dto/
│   └── service/
├── repository/ (implementations)
└── mapper/ (entity ↔ model conversions)
```

**Dependency Injection:**
```
com.kabaddiarena.di/
├── AppModule
├── DatabaseModule
├── NetworkModule
└── RepositoryModule
```

---

## **3. DATABASE STRUCTURE & SCHEMA**

### 3.1 Room Database Architecture

**Database Name:** `kabaddi_arena_db`
**Database Version:** 1

### 3.2 Entity Definitions

#### **Entity 1: Player**
Stores player profile information

```kotlin
@Entity(tableName = "player")
data class PlayerEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    
    @ColumnInfo(name = "phone_number")
    val phoneNumber: String,
    
    @ColumnInfo(name = "player_name")
    val playerName: String,
    
    @ColumnInfo(name = "age")
    val age: Int?,
    
    @ColumnInfo(name = "team_name")
    val teamName: String?,
    
    @ColumnInfo(name = "position")
    val position: String?, // Raider, All-rounder, Defender
    
    @ColumnInfo(name = "jersey_number")
    val jerseyNumber: Int?,
    
    @ColumnInfo(name = "profile_photo_uri")
    val profilePhotoUri: String?,
    
    @ColumnInfo(name = "created_at")
    val createdAt: Long = System.currentTimeMillis(),
    
    @ColumnInfo(name = "updated_at")
    val updatedAt: Long = System.currentTimeMillis()
)
```

#### **Entity 2: Match**
Stores match-level information

```kotlin
@Entity(tableName = "match")
data class MatchEntity(
    @PrimaryKey(autoGenerate = true)
    val matchId: Long = 0,
    
    @ColumnInfo(name = "player_id")
    val playerId: Long,
    
    @ColumnInfo(name = "opponent_team_name")
    val opponentTeamName: String,
    
    @ColumnInfo(name = "match_date")
    val matchDate: Long, // Timestamp
    
    @ColumnInfo(name = "match_time")
    val matchTime: String?, // HH:mm format
    
    @ColumnInfo(name = "venue")
    val venue: String?,
    
    @ColumnInfo(name = "match_type")
    val matchType: String, // Practice, League, Tournament, Friendly
    
    @ColumnInfo(name = "match_duration")
    val matchDuration: Long?, // Duration in milliseconds
    
    @ColumnInfo(name = "total_points")
    val totalPoints: Int = 0,
    
    @ColumnInfo(name = "total_raids")
    val totalRaids: Int = 0,
    
    @ColumnInfo(name = "successful_raids")
    val successfulRaids: Int = 0,
    
    @ColumnInfo(name = "total_tackles")
    val totalTackles: Int = 0,
    
    @ColumnInfo(name = "successful_tackles")
    val successfulTackles: Int = 0,
    
    @ColumnInfo(name = "super_tackles")
    val superTackles: Int = 0,
    
    @ColumnInfo(name = "touch_points")
    val touchPoints: Int = 0,
    
    @ColumnInfo(name = "bonus_points")
    val bonusPoints: Int = 0,
    
    @ColumnInfo(name = "empty_raids")
    val emptyRaids: Int = 0,
    
    @ColumnInfo(name = "got_out_count")
    val gotOutCount: Int = 0,
    
    @ColumnInfo(name = "raid_success_rate")
    val raidSuccessRate: Float = 0f,
    
    @ColumnInfo(name = "tackle_success_rate")
    val tackleSuccessRate: Float = 0f,
    
    @ColumnInfo(name = "match_status")
    val matchStatus: String, // ONGOING, COMPLETED
    
    @ColumnInfo(name = "ai_insight")
    val aiInsight: String?,
    
    @ColumnInfo(name = "created_at")
    val createdAt: Long = System.currentTimeMillis(),
    
    @ColumnInfo(name = "completed_at")
    val completedAt: Long?
)
```

#### **Entity 3: MatchEvent**
Stores individual raid/tackle events logged during match

```kotlin
@Entity(
    tableName = "match_event",
    foreignKeys = [
        ForeignKey(
            entity = MatchEntity::class,
            parentColumns = ["matchId"],
            childColumns = ["match_id"],
            onDelete = ForeignKey.CASCADE
        )
    ],
    indices = [Index("match_id")]
)
data class MatchEventEntity(
    @PrimaryKey(autoGenerate = true)
    val eventId: Long = 0,
    
    @ColumnInfo(name = "match_id")
    val matchId: Long,
    
    @ColumnInfo(name = "event_type")
    val eventType: String, // RAID, TACKLE
    
    @ColumnInfo(name = "event_sub_type")
    val eventSubType: String, 
    // For RAID: EMPTY_RAID, TOUCH_POINT, BONUS_POINT, SUCCESSFUL_RAID, GOT_OUT
    // For TACKLE: SUCCESSFUL_TACKLE, SUPER_TACKLE, FAILED_TACKLE
    
    @ColumnInfo(name = "points_earned")
    val pointsEarned: Int,
    
    @ColumnInfo(name = "timestamp")
    val timestamp: Long, // Time elapsed in match (milliseconds)
    
    @ColumnInfo(name = "court_position")
    val courtPosition: String?, 
    // LEFT_CORNER, LEFT_COVER, MID, RIGHT_COVER, RIGHT_CORNER
    // For future heatmap enhancement
    
    @ColumnInfo(name = "is_successful")
    val isSuccessful: Boolean,
    
    @ColumnInfo(name = "created_at")
    val createdAt: Long = System.currentTimeMillis()
)
```

#### **Entity 4: AIInsightCache**
Caches AI-generated insights for offline access

```kotlin
@Entity(tableName = "ai_insight_cache")
data class AIInsightCacheEntity(
    @PrimaryKey(autoGenerate = true)
    val insightId: Long = 0,
    
    @ColumnInfo(name = "match_id")
    val matchId: Long?,
    
    @ColumnInfo(name = "insight_type")
    val insightType: String, // MATCH_SUMMARY, COACHING_TIP, PERFORMANCE_ANALYSIS
    
    @ColumnInfo(name = "insight_text")
    val insightText: String,
    
    @ColumnInfo(name = "strengths")
    val strengths: String?, // JSON array of strengths
    
    @ColumnInfo(name = "weaknesses")
    val weaknesses: String?, // JSON array of weaknesses
    
    @ColumnInfo(name = "recommendations")
    val recommendations: String?, // JSON array of recommendations
    
    @ColumnInfo(name = "generated_at")
    val generatedAt: Long = System.currentTimeMillis()
)
```

### 3.3 DAO Interfaces

#### **PlayerDao**

```kotlin
@Dao
interface PlayerDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPlayer(player: PlayerEntity): Long
    
    @Update
    suspend fun updatePlayer(player: PlayerEntity)
    
    @Query("SELECT * FROM player WHERE phone_number = :phoneNumber LIMIT 1")
    suspend fun getPlayerByPhone(phoneNumber: String): PlayerEntity?
    
    @Query("SELECT * FROM player WHERE id = :playerId")
    suspend fun getPlayerById(playerId: Long): PlayerEntity?
    
    @Query("SELECT * FROM player LIMIT 1")
    fun getCurrentPlayer(): Flow<PlayerEntity?>
}
```

#### **MatchDao**

```kotlin
@Dao
interface MatchDao {
    @Insert
    suspend fun insertMatch(match: MatchEntity): Long
    
    @Update
    suspend fun updateMatch(match: MatchEntity)
    
    @Query("SELECT * FROM match WHERE matchId = :matchId")
    suspend fun getMatchById(matchId: Long): MatchEntity?
    
    @Query("SELECT * FROM match WHERE player_id = :playerId ORDER BY match_date DESC")
    fun getAllMatchesByPlayer(playerId: Long): Flow<List<MatchEntity>>
    
    @Query("SELECT * FROM match WHERE player_id = :playerId AND match_status = 'ONGOING' LIMIT 1")
    suspend fun getOngoingMatch(playerId: Long): MatchEntity?
    
    @Query("SELECT * FROM match WHERE player_id = :playerId ORDER BY match_date DESC LIMIT :limit")
    fun getRecentMatches(playerId: Long, limit: Int): Flow<List<MatchEntity>>
    
    @Query("DELETE FROM match WHERE matchId = :matchId")
    suspend fun deleteMatch(matchId: Long)
    
    @Query("""
        SELECT * FROM match 
        WHERE player_id = :playerId 
        AND opponent_team_name LIKE '%' || :searchQuery || '%'
        ORDER BY match_date DESC
    """)
    fun searchMatches(playerId: Long, searchQuery: String): Flow<List<MatchEntity>>
}
```

#### **MatchEventDao**

```kotlin
@Dao
interface MatchEventDao {
    @Insert
    suspend fun insertEvent(event: MatchEventEntity): Long
    
    @Query("SELECT * FROM match_event WHERE match_id = :matchId ORDER BY timestamp ASC")
    fun getEventsByMatch(matchId: Long): Flow<List<MatchEventEntity>>
    
    @Query("SELECT * FROM match_event WHERE match_id = :matchId ORDER BY created_at DESC LIMIT 1")
    suspend fun getLastEvent(matchId: Long): MatchEventEntity?
    
    @Query("DELETE FROM match_event WHERE eventId = :eventId")
    suspend fun deleteEvent(eventId: Long)
    
    @Query("DELETE FROM match_event WHERE match_id = :matchId")
    suspend fun deleteAllEventsForMatch(matchId: Long)
    
    @Query("""
        SELECT court_position, 
               COUNT(*) as total_events,
               SUM(CASE WHEN is_successful = 1 THEN 1 ELSE 0 END) as successful_events
        FROM match_event
        WHERE match_id = :matchId AND event_type = 'RAID'
        GROUP BY court_position
    """)
    suspend fun getRaidHeatmapData(matchId: Long): List<HeatmapData>
}

data class HeatmapData(
    val courtPosition: String,
    val totalEvents: Int,
    val successfulEvents: Int
)
```

#### **AIInsightDao**

```kotlin
@Dao
interface AIInsightDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertInsight(insight: AIInsightCacheEntity): Long
    
    @Query("SELECT * FROM ai_insight_cache WHERE match_id = :matchId ORDER BY generated_at DESC LIMIT 1")
    suspend fun getInsightForMatch(matchId: Long): AIInsightCacheEntity?
    
    @Query("SELECT * FROM ai_insight_cache ORDER BY generated_at DESC LIMIT 1")
    suspend fun getLatestInsight(): AIInsightCacheEntity?
    
    @Query("DELETE FROM ai_insight_cache WHERE generated_at < :timestamp")
    suspend fun deleteOldInsights(timestamp: Long)
}
```

### 3.4 Database Class

```kotlin
@Database(
    entities = [
        PlayerEntity::class,
        MatchEntity::class,
        MatchEventEntity::class,
        AIInsightCacheEntity::class
    ],
    version = 1,
    exportSchema = true
)
abstract class KabaddiArenaDatabase : RoomDatabase() {
    abstract fun playerDao(): PlayerDao
    abstract fun matchDao(): MatchDao
    abstract fun matchEventDao(): MatchEventDao
    abstract fun aiInsightDao(): AIInsightDao
}
```

### 3.5 Repository Pattern Implementation

#### **PlayerRepository**

```kotlin
interface PlayerRepository {
    suspend fun createPlayer(player: Player): Result<Long>
    suspend fun updatePlayer(player: Player): Result<Unit>
    suspend fun getPlayerByPhone(phoneNumber: String): Result<Player?>
    fun getCurrentPlayer(): Flow<Player?>
}

class PlayerRepositoryImpl @Inject constructor(
    private val playerDao: PlayerDao
) : PlayerRepository {
    
    override suspend fun createPlayer(player: Player): Result<Long> {
        return try {
            val id = playerDao.insertPlayer(player.toEntity())
            Result.success(id)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
    
    override suspend fun updatePlayer(player: Player): Result<Unit> {
        return try {
            playerDao.updatePlayer(player.toEntity())
            Result.success(Unit)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
    
    override suspend fun getPlayerByPhone(phoneNumber: String): Result<Player?> {
        return try {
            val entity = playerDao.getPlayerByPhone(phoneNumber)
            Result.success(entity?.toDomainModel())
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
    
    override fun getCurrentPlayer(): Flow<Player?> {
        return playerDao.getCurrentPlayer()
            .map { it?.toDomainModel() }
    }
}
```

#### **MatchRepository**

```kotlin
interface MatchRepository {
    suspend fun createMatch(match: Match): Result<Long>
    suspend fun updateMatch(match: Match): Result<Unit>
    suspend fun getMatchById(matchId: Long): Result<Match?>
    fun getAllMatches(playerId: Long): Flow<List<Match>>
    fun getRecentMatches(playerId: Long, limit: Int): Flow<List<Match>>
    suspend fun deleteMatch(matchId: Long): Result<Unit>
    suspend fun getOngoingMatch(playerId: Long): Result<Match?>
}

class MatchRepositoryImpl @Inject constructor(
    private val matchDao: MatchDao,
    private val matchEventDao: MatchEventDao
) : MatchRepository {
    // Implementation with proper error handling and mapping
}
```

---

## **4. API INTEGRATION & NETWORKING**

### 4.1 Authentication API (Firebase or Custom Backend)

**For OTP-based authentication, use Firebase Authentication:**

```kotlin
// Firebase Auth Service
class AuthService @Inject constructor(
    private val firebaseAuth: FirebaseAuth
) {
    suspend fun sendOTP(phoneNumber: String, activity: Activity): Result<String> {
        return suspendCoroutine { continuation ->
            val options = PhoneAuthOptions.newBuilder(firebaseAuth)
                .setPhoneNumber(phoneNumber)
                .setTimeout(60L, TimeUnit.SECONDS)
                .setActivity(activity)
                .setCallbacks(object : PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
                    override fun onVerificationCompleted(credential: PhoneAuthCredential) {
                        continuation.resume(Result.success("Auto-verified"))
                    }
                    
                    override fun onVerificationFailed(e: FirebaseException) {
                        continuation.resume(Result.failure(e))
                    }
                    
                    override fun onCodeSent(
                        verificationId: String,
                        token: PhoneAuthProvider.ForceResendingToken
                    ) {
                        continuation.resume(Result.success(verificationId))
                    }
                })
                .build()
            PhoneAuthProvider.verifyPhoneNumber(options)
        }
    }
    
    suspend fun verifyOTP(verificationId: String, code: String): Result<FirebaseUser?> {
        return try {
            val credential = PhoneAuthProvider.getCredential(verificationId, code)
            val authResult = firebaseAuth.signInWithCredential(credential).await()
            Result.success(authResult.user)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}
```

### 4.2 Gemini AI API Integration

**API Configuration:**

```kotlin
// Gemini API Service
interface GeminiApiService {
    @POST("v1beta/models/gemini-pro:generateContent")
    suspend fun generateContent(
        @Header("x-goog-api-key") apiKey: String,
        @Body request: GeminiRequest
    ): GeminiResponse
}

data class GeminiRequest(
    val contents: List<Content>
)

data class Content(
    val parts: List<Part>
)

data class Part(
    val text: String
)

data class GeminiResponse(
    val candidates: List<Candidate>
)

data class Candidate(
    val content: Content,
    val finishReason: String
)
```

**Repository Implementation:**

```kotlin
class AIInsightRepository @Inject constructor(
    private val geminiApiService: GeminiApiService,
    private val aiInsightDao: AIInsightDao,
    @Named("gemini_api_key") private val apiKey: String
) {
    suspend fun generateMatchInsight(match: Match): Result<AIInsight> {
        return try {
            // Create prompt from match data
            val prompt = buildMatchAnalysisPrompt(match)
            
            val request = GeminiRequest(
                contents = listOf(
                    Content(
                        parts = listOf(Part(text = prompt))
                    )
                )
            )
            
            val response = geminiApiService.generateContent(apiKey, request)
            val insightText = response.candidates.firstOrNull()?.content?.parts?.firstOrNull()?.text
                ?: throw Exception("No insight generated")
            
            // Parse and structure the insight
            val insight = parseInsightResponse(insightText, match.matchId)
            
            // Cache locally
            aiInsightDao.insertInsight(insight.toEntity())
            
            Result.success(insight)
        } catch (e: Exception) {
            // Fallback to cached insight if available
            val cached = aiInsightDao.getInsightForMatch(match.matchId)
            if (cached != null) {
                Result.success(cached.toDomainModel())
            } else {
                Result.failure(e)
            }
        }
    }
    
    private fun buildMatchAnalysisPrompt(match: Match): String {
        return """
            You are an expert Kabaddi coach analyzing a player's match performance. 
            Provide concise, actionable insights in the following structure:
            
            Match Summary:
            - Total Points: ${match.totalPoints}
            - Raids: ${match.successfulRaids}/${match.totalRaids} (${match.raidSuccessRate}%)
            - Tackles: ${match.successfulTackles}/${match.totalTackles} (${match.tackleSuccessRate}%)
            - Empty Raids: ${match.emptyRaids}
            - Super Tackles: ${match.superTackles}
            
            Based on this data, provide:
            1. Overall Performance Summary (2-3 sentences)
            2. Top 3 Strengths
            3. Top 3 Areas for Improvement
            4. 3 Specific Training Recommendations
            
            Format your response as JSON:
            {
              "summary": "...",
              "strengths": ["...", "...", "..."],
              "weaknesses": ["...", "...", "..."],
              "recommendations": ["...", "...", "..."]
            }
        """.trimIndent()
    }
    
    private fun parseInsightResponse(response: String, matchId: Long): AIInsight {
        // Parse JSON response and create AIInsight object
        // Handle parsing errors gracefully
    }
}
```

### 4.3 Network Module (Hilt)

```kotlin
@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    
    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().apply {
                level = if (BuildConfig.DEBUG) 
                    HttpLoggingInterceptor.Level.BODY 
                else 
                    HttpLoggingInterceptor.Level.NONE
            })
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
            .build()
    }
    
    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://generativelanguage.googleapis.com/")
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    
    @Provides
    @Singleton
    fun provideGeminiApiService(retrofit: Retrofit): GeminiApiService {
        return retrofit.create(GeminiApiService::class.java)
    }
    
    @Provides
    @Named("gemini_api_key")
    fun provideGeminiApiKey(): String {
        return BuildConfig.GEMINI_API_KEY // Store in local.properties
    }
}
```

---

## **5. DETAILED FEATURE IMPLEMENTATION**

### 5.1 Authentication Flow Implementation

**AuthViewModel:**

```kotlin
@HiltViewModel
class AuthViewModel @Inject constructor(
    private val authService: AuthService,
    private val playerRepository: PlayerRepository,
    private val preferencesManager: PreferencesManager
) : ViewModel() {
    
    private val _authState = MutableStateFlow<AuthState>(AuthState.Initial)
    val authState: StateFlow<AuthState> = _authState.asStateFlow()
    
    private var verificationId: String? = null
    
    fun sendOTP(phoneNumber: String, activity: Activity) {
        viewModelScope.launch {
            _authState.value = AuthState.Loading
            authService.sendOTP(phoneNumber, activity).fold(
                onSuccess = { vId ->
                    verificationId = vId
                    _authState.value = AuthState.OTPSent
                },
                onFailure = { error ->
                    _authState.value = AuthState.Error(error.message ?: "Failed to send OTP")
                }
            )
        }
    }
    
    fun verifyOTP(code: String) {
        viewModelScope.launch {
            _authState.value = AuthState.Loading
            verificationId?.let { vId ->
                authService.verifyOTP(vId, code).fold(
                    onSuccess = { firebaseUser ->
                        firebaseUser?.let {
                            handleSuccessfulAuth(it.phoneNumber ?: "")
                        }
                    },
                    onFailure = { error ->
                        _authState.value = AuthState.Error(error.message ?: "Invalid OTP")
                    }
                )
            }
        }
    }
    
    private suspend fun handleSuccessfulAuth(phoneNumber: String) {
        playerRepository.getPlayerByPhone(phoneNumber).fold(
            onSuccess = { player ->
                if (player == null) {
                    _authState.value = AuthState.NewUser(phoneNumber)
                } else {
                    preferencesManager.setCurrentPlayerId(player.id)
                    _authState.value = AuthState.ExistingUser
                }
            },
            onFailure = { error ->
                _authState.value = AuthState.Error(error.message ?: "Database error")
            }
        )
    }
}

sealed class AuthState {
    object Initial : AuthState()
    object Loading : AuthState()
    object OTPSent : AuthState()
    data class NewUser(val phoneNumber: String) : AuthState()
    object ExistingUser : AuthState()
    data class Error(val message: String) : AuthState()
}
```

### 5.2 Live Match Logger Implementation

**MatchViewModel:**

```kotlin
@HiltViewModel
class MatchViewModel @Inject constructor(
    private val matchRepository: MatchRepository,
    private val matchEventRepository: MatchEventRepository,
    private val playerRepository: PlayerRepository
) : ViewModel() {
    
    private val _matchState = MutableStateFlow<MatchState>(MatchState.Idle)
    val matchState: StateFlow<MatchState> = _matchState.asStateFlow()
    
    private var currentMatch: Match? = null
    private var matchStartTime: Long = 0
    private val matchTimer = MutableStateFlow(0L)
    
    private var timerJob: Job? = null
    
    fun startMatch(opponentTeam: String, matchType: String, playerId: Long) {
        viewModelScope.launch {
            val match = Match(
                playerId = playerId,
                opponentTeamName = opponentTeam,
                matchDate = System.currentTimeMillis(),
                matchType = matchType,
                matchStatus = "ONGOING"
            )
            
            matchRepository.createMatch(match).fold(
                onSuccess = { matchId ->
                    currentMatch = match.copy(matchId = matchId)
                    matchStartTime = System.currentTimeMillis()
                    startTimer()
                    _matchState.value = MatchState.InProgress(currentMatch!!)
                },
                onFailure = { error ->
                    _matchState.value = MatchState.Error(error.message ?: "Failed to start match")
                }
            )
        }
    }
    
    fun logRaid(raidType: RaidType) {
        viewModelScope.launch {
            currentMatch?.let { match ->
                val event = createRaidEvent(match.matchId, raidType)
                matchEventRepository.logEvent(event).fold(
                    onSuccess = {
                        updateMatchStats(match, event)
                    },
                    onFailure = { error ->
                        _matchState.value = MatchState.Error(error.message ?: "Failed to log raid")
                    }
                )
            }
        }
    }
    
    fun logTackle(tackleType: TackleType) {
        viewModelScope.launch {
            currentMatch?.let { match ->
                val event = createTackleEvent(match.matchId, tackleType)
                matchEventRepository.logEvent(event).fold(
                    onSuccess = {
                        updateMatchStats(match, event)
                    },
                    onFailure = { error ->
                        _matchState.value = MatchState.Error(error.message ?: "Failed to log tackle")
                    }
                )
            }
        }
    }
    
    fun undoLastAction() {
        viewModelScope.launch {
            currentMatch?.let { match ->
                matchEventRepository.getLastEvent(match.matchId).fold(
                    onSuccess = { lastEvent ->
                        lastEvent?.let { event ->
                            matchEventRepository.deleteEvent(event.eventId).fold(
                                onSuccess = {
                                    recalculateMatchStats(match)
                                },
                                onFailure = { error ->
                                    _matchState.value = MatchState.Error(error.message ?: "Failed to undo")
                                }
                            )
                        }
                    },
                    onFailure = { error ->
                        _matchState.value = MatchState.Error(error.message ?: "No action to undo")
                    }
                )
            }
        }
    }
    
    fun endMatch() {
        viewModelScope.launch {
            timerJob?.cancel()
            currentMatch?.let { match ->
                val updatedMatch = match.copy(
                    matchStatus = "COMPLETED",
                    completedAt = System.currentTimeMillis(),
                    matchDuration = System.currentTimeMillis() - matchStartTime
                )
                
                matchRepository.updateMatch(updatedMatch).fold(
                    onSuccess = {
                        _matchState.value = MatchState.Completed(updatedMatch)
                    },
                    onFailure = { error ->
                        _matchState.value = MatchState.Error(error.message ?: "Failed to end match")
                    }
                )
            }
        }
    }
    
    private fun createRaidEvent(matchId: Long, raidType: RaidType): MatchEvent {
        val timestamp = System.currentTimeMillis() - matchStartTime
        return when (raidType) {
            RaidType.EMPTY_RAID -> MatchEvent(
                matchId = matchId,
                eventType = "RAID",
                eventSubType = "EMPTY_RAID",
                pointsEarned = 0,
                timestamp = timestamp,
                isSuccessful = false
            )
            RaidType.TOUCH_POINT -> MatchEvent(
                matchId = matchId,
                eventType = "RAID",
                eventSubType = "TOUCH_POINT",
                pointsEarned = 1,
                timestamp = timestamp,
                isSuccessful = true
            )
            RaidType.BONUS_POINT -> MatchEvent(
                matchId = matchId,
                eventType = "RAID",
                eventSubType = "BONUS_POINT",
                pointsEarned = 1,
                timestamp = timestamp,
                isSuccessful = true
            )
            RaidType.SUCCESSFUL_RAID -> MatchEvent(
                matchId = matchId,
                eventType = "RAID",
                eventSubType = "SUCCESSFUL_RAID",
                pointsEarned = 2,
                timestamp = timestamp,
                isSuccessful = true
            )
            RaidType.GOT_OUT -> MatchEvent(
                matchId = matchId,
                eventType = "RAID",
                eventSubType = "GOT_OUT",
                pointsEarned = 0,
                timestamp = timestamp,
                isSuccessful = false
            )
        }
    }
    
    private fun createTackleEvent(matchId: Long, tackleType: TackleType): MatchEvent {
        val timestamp = System.currentTimeMillis() - matchStartTime
        return when (tackleType) {
            TackleType.SUCCESSFUL_TACKLE -> MatchEvent(
                matchId = matchId,
                eventType = "TACKLE",
                eventSubType = "SUCCESSFUL_TACKLE",
                pointsEarned = 1,
                timestamp = timestamp,
                isSuccessful = true
            )
            TackleType.SUPER_TACKLE -> MatchEvent(
                matchId = matchId,
                eventType = "TACKLE",
                eventSubType = "SUPER_TACKLE",
                pointsEarned = 2,
                timestamp = timestamp,
                isSuccessful = true
            )
            TackleType.FAILED_TACKLE -> MatchEvent(
                matchId = matchId,
                eventType = "TACKLE",
                eventSubType = "FAILED_TACKLE",
                pointsEarned = 0,
                timestamp = timestamp,
                isSuccessful = false
            )
        }
    }
    
    private suspend fun updateMatchStats(match: Match, event: MatchEvent) {
        val events = matchEventRepository.getEventsByMatchSync(match.matchId)
        
        val totalPoints = events.sumOf { it.pointsEarned }
        val totalRaids = events.count { it.eventType == "RAID" }
        val successfulRaids = events.count { it.eventType == "RAID" && it.isSuccessful }
        val totalTackles = events.count { it.eventType == "TACKLE" }
        val successfulTackles = events.count { it.eventType == "TACKLE" && it.isSuccessful }
        val superTackles = events.count { it.eventSubType == "SUPER_TACKLE" }
        val touchPoints = events.count { it.eventSubType == "TOUCH_POINT" }
        val bonusPoints = events.count { it.eventSubType == "BONUS_POINT" }
        val emptyRaids = events.count { it.eventSubType == "EMPTY_RAID" }
        val gotOutCount = events.count { it.eventSubType == "GOT_OUT" }
        
        val raidSuccessRate = if (totalRaids > 0) (successfulRaids.toFloat() / totalRaids) * 100 else 0f
        val tackleSuccessRate = if (totalTackles > 0) (successfulTackles.toFloat() / totalTackles) * 100 else 0f
        
        val updatedMatch = match.copy(
            totalPoints = totalPoints,
            totalRaids = totalRaids,
            successfulRaids = successfulRaids,
            totalTackles = totalTackles,
            successfulTackles = successfulTackles,
            superTackles = superTackles,
            touchPoints = touchPoints,
            bonusPoints = bonusPoints,
            emptyRaids = emptyRaids,
            gotOutCount = gotOutCount,
            raidSuccessRate = raidSuccessRate,
            tackleSuccessRate = tackleSuccessRate
        )
        
        matchRepository.updateMatch(updatedMatch)
        currentMatch = updatedMatch
        _matchState.value = MatchState.InProgress(updatedMatch)
    }
    
    private fun startTimer() {
        timerJob = viewModelScope.launch {
            while (true) {
                delay(1000)
                matchTimer.value = System.currentTimeMillis() - matchStartTime
            }
        }
    }
}

enum class RaidType {
    EMPTY_RAID, TOUCH_POINT, BONUS_POINT, SUCCESSFUL_RAID, GOT_OUT
}

enum class TackleType {
    SUCCESSFUL_TACKLE, SUPER_TACKLE, FAILED_TACKLE
}

sealed class MatchState {
    object Idle : MatchState()
    data class InProgress(val match: Match) : MatchState()
    data class Completed(val match: Match) : MatchState()
    data class Error(val message: String) : MatchState()
}
```

### 5.3 Performance Card Generation & Export

**PerformanceCardGenerator:**

```kotlin
class PerformanceCardGenerator @Inject constructor(
    private val context: Context
) {
    fun generatePerformanceCard(match: Match, player: Player): Bitmap {
        val width = 1080
        val height = 1920
        
        val bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888)
        val canvas = Canvas(bitmap)
        
        // Background gradient
        val gradient = LinearGradient(
            0f, 0f, 0f, height.toFloat(),
            Color.parseColor("#FF6F00"),
            Color.parseColor("#D32F2F"),
            Shader.TileMode.CLAMP
        )
        val bgPaint = Paint().apply {
            shader = gradient
        }
        canvas.drawRect(0f, 0f, width.toFloat(), height.toFloat(), bgPaint)
        
        // Title
        drawText(canvas, "MATCH PERFORMANCE", 540f, 150f, 60f, Color.WHITE, Paint.Align.CENTER, true)
        
        // Date and opponent
        val dateFormat = SimpleDateFormat("dd MMM yyyy", Locale.getDefault())
        val matchDate = dateFormat.format(Date(match.matchDate))
        drawText(canvas, matchDate, 540f, 230f, 36f, Color.WHITE, Paint.Align.CENTER, false)
        drawText(canvas, "vs ${match.opponentTeamName}", 540f, 290f, 42f, Color.WHITE, Paint.Align.CENTER, true)
        
        // Stats container
        val cardTop = 400f
        val cardPaint = Paint().apply {
            color = Color.WHITE
            alpha = 230
        }
        val cardRect = RectF(80f, cardTop, width - 80f, height - 400f)
        canvas.drawRoundRect(cardRect, 40f, 40f, cardPaint)
        
        // Total Points (hero stat)
        drawText(canvas, "${match.totalPoints}", 540f, cardTop + 150f, 120f, Color.parseColor("#FF6F00"), Paint.Align.CENTER, true)
        drawText(canvas, "TOTAL POINTS", 540f, cardTop + 220f, 32f, Color.GRAY, Paint.Align.CENTER, false)
        
        // Success rates
        val raidCenterX = 300f
        val tackleCenterX = 780f
        val circleY = cardTop + 450f
        
        drawCircularProgress(canvas, raidCenterX, circleY, 120f, match.raidSuccessRate, Color.parseColor("#4CAF50"))
        drawText(canvas, "${match.raidSuccessRate.toInt()}%", raidCenterX, circleY + 15f, 48f, Color.parseColor("#4CAF50"), Paint.Align.CENTER, true)
        drawText(canvas, "Raid Success", raidCenterX, circleY + 180f, 28f, Color.GRAY, Paint.Align.CENTER, false)
        
        drawCircularProgress(canvas, tackleCenterX, circleY, 120f, match.tackleSuccessRate, Color.parseColor("#2196F3"))
        drawText(canvas, "${match.tackleSuccessRate.toInt()}%", tackleCenterX, circleY + 15f, 48f, Color.parseColor("#2196F3"), Paint.Align.CENTER, true)
        drawText(canvas, "Tackle Success", tackleCenterX, circleY + 180f, 28f, Color.GRAY, Paint.Align.CENTER, false)
        
        // Detailed stats grid
        val statsStartY = cardTop + 700f
        drawStatRow(canvas, "Successful Raids", "${match.successfulRaids}/${match.totalRaids}", 150f, statsStartY)
        drawStatRow(canvas, "Successful Tackles", "${match.successfulTackles}/${match.totalTackles}", 150f, statsStartY + 80f)
        drawStatRow(canvas, "Super Tackles", "${match.superTackles}", 150f, statsStartY + 160f)
        drawStatRow(canvas, "Touch Points", "${match.touchPoints}", 150f, statsStartY + 240f)
        drawStatRow(canvas, "Empty Raids", "${match.emptyRaids}", 150f, statsStartY + 320f)
        
        // Player footer
        drawText(canvas, player.playerName, 540f, height - 250f, 44f, Color.WHITE, Paint.Align.CENTER, true)
        if (!player.teamName.isNullOrEmpty()) {
            drawText(canvas, player.teamName, 540f, height - 190f, 32f, Color.WHITE, Paint.Align.CENTER, false)
        }
        drawText(canvas, "Powered by Kabaddi Arena", 540f, height - 120f, 24f, Color.WHITE, Paint.Align.CENTER, false)
        
        return bitmap
    }
    
    private fun drawText(
        canvas: Canvas,
        text: String,
        x: Float,
        y: Float,
        textSize: Float,
        color: Int,
        align: Paint.Align,
        bold: Boolean
    ) {
        val paint = Paint().apply {
            this.color = color
            this.textSize = textSize
            this.textAlign = align
            isAntiAlias = true
            if (bold) {
                typeface = Typeface.create(Typeface.DEFAULT, Typeface.BOLD)
            }
        }
        canvas.drawText(text, x, y, paint)
    }
    
    private fun drawCircularProgress(
        canvas: Canvas,
        centerX: Float,
        centerY: Float,
        radius: Float,
        percentage: Float,
        color: Int
    ) {
        // Background circle
        val bgPaint = Paint().apply {
            this.color = Color.LTGRAY
            style = Paint.Style.STROKE
            strokeWidth = 20f
            isAntiAlias = true
        }
        canvas.drawCircle(centerX, centerY, radius, bgPaint)
        
        // Progress arc
        val progressPaint = Paint().apply {
            this.color = color
            style = Paint.Style.STROKE
            strokeWidth = 20f
            strokeCap = Paint.Cap.ROUND
            isAntiAlias = true
        }
        val oval = RectF(
            centerX - radius,
            centerY - radius,
            centerX + radius,
            centerY + radius
        )
        val sweepAngle = (percentage / 100f) * 360f
        canvas.drawArc(oval, -90f, sweepAngle, false, progressPaint)
    }
    
    private fun drawStatRow(canvas: Canvas, label: String, value: String, x: Float, y: Float) {
        drawText(canvas, label, x, y, 32f, Color.DKGRAY, Paint.Align.LEFT, false)
        drawText(canvas, value, width - 150f, y, 36f, Color.parseColor("#FF6F00"), Paint.Align.RIGHT, true)
    }
    
    fun saveBitmapToFile(bitmap: Bitmap, fileName: String): File {
        val directory = File(context.getExternalFilesDir(Environment.DIRECTORY_PICTURES), "KabaddiArena")
        if (!directory.exists()) {
            directory.mkdirs()
        }
        
        val file = File(directory, "$fileName.png")
        FileOutputStream(file).use { out ->
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, out)
        }
        
        return file
    }
    
    fun sharePerformanceCard(bitmap: Bitmap, fileName: String) {
        val file = saveBitmapToFile(bitmap, fileName)
        
        val uri = FileProvider.getUriForFile(
            context,
            "${context.packageName}.fileprovider",
            file
        )
        
        val shareIntent = Intent(Intent.ACTION_SEND).apply {
            type = "image/png"
            putExtra(Intent.EXTRA_STREAM, uri)
            putExtra(Intent.EXTRA_TEXT, "Check out my Kabaddi performance! #KabaddiArena")
            addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
        }
        
        context.startActivity(Intent.createChooser(shareIntent, "Share Performance Card"))
    }
}
```

### 5.4 Heatmap Visualization Implementation

**HeatmapViewModel:**

```kotlin
@HiltViewModel
class HeatmapViewModel @Inject constructor(
    private val matchEventRepository: MatchEventRepository
) : ViewModel() {
    
    private val _heatmapData = MutableStateFlow<HeatmapState>(HeatmapState.Loading)
    val heatmapData: StateFlow<HeatmapState> = _heatmapData.asStateFlow()
    
    fun loadHeatmapData(matchId: Long) {
        viewModelScope.launch {
            matchEventRepository.getRaidHeatmapData(matchId).fold(
                onSuccess = { data ->
                    val zoneStats = calculateZoneStatistics(data)
                    _heatmapData.value = HeatmapState.Success(zoneStats)
                },
                onFailure = { error ->
                    _heatmapData.value = HeatmapState.Error(error.message ?: "Failed to load heatmap")
                }
            )
        }
    }
    
    private fun calculateZoneStatistics(data: List<HeatmapData>): Map<CourtZone, ZoneStats> {
        val zoneMap = mutableMapOf<CourtZone, ZoneStats>()
        
        data.forEach { heatmapData ->
            val zone = CourtZone.valueOf(heatmapData.courtPosition)
            val successRate = if (heatmapData.totalEvents > 0) {
                (heatmapData.successfulEvents.toFloat() / heatmapData.totalEvents) * 100
            } else 0f
            
            zoneMap[zone] = ZoneStats(
                totalAttempts = heatmapData.totalEvents,
                successfulAttempts = heatmapData.successfulEvents,
                successRate = successRate,
                color = getColorForSuccessRate(successRate)
            )
        }
        
        return zoneMap
    }
    
    private fun getColorForSuccessRate(rate: Float): Int {
        return when {
            rate >= 80f -> Color.parseColor("#1B5E20") // Dark Green
            rate >= 60f -> Color.parseColor("#4CAF50") // Light Green
            rate >= 40f -> Color.parseColor("#FFC107") // Yellow
            rate >= 20f -> Color.parseColor("#FF9800") // Orange
            else -> Color.parseColor("#D32F2F") // Red
        }
    }
}

enum class CourtZone {
    LEFT_CORNER, LEFT_COVER, MID, RIGHT_COVER, RIGHT_CORNER
}

data class ZoneStats(
    val totalAttempts: Int,
    val successfulAttempts: Int,
    val successRate: Float,
    val color: Int
)

sealed class HeatmapState {
    object Loading : HeatmapState()
    data class Success(val zoneStats: Map<CourtZone, ZoneStats>) : HeatmapState()
    data class Error(val message: String) : HeatmapState()
}
```

**Heatmap Composable:**

```kotlin
@Composable
fun KabaddiCourtHeatmap(
    zoneStats: Map<CourtZone, ZoneStats>,
    modifier: Modifier = Modifier
) {
    Canvas(modifier = modifier.fillMaxSize()) {
        val courtWidth = size.width
        val courtHeight = size.height
        
        // Draw court outline
        drawRect(
            color = Color.White,
            topLeft = Offset.Zero,
            size = Size(courtWidth, courtHeight),
            style = Stroke(width = 4f)
        )
        
        // Draw mid line
        drawLine(
            color = Color.White,
            start = Offset(0f, courtHeight / 2),
            end = Offset(courtWidth, courtHeight / 2),
            strokeWidth = 2f
        )
        
        // Draw baulk lines
        val baulkOffset = courtHeight * 0.15f
        drawLine(
            color = Color.White,
            start = Offset(0f, baulkOffset),
            end = Offset(courtWidth, baulkOffset),
            strokeWidth = 2f
        )
        drawLine(
            color = Color.White,
            start = Offset(0f, courtHeight - baulkOffset),
            end = Offset(courtWidth, courtHeight - baulkOffset),
            strokeWidth = 2f
        )
        
        // Zone dimensions
        val zoneWidth = courtWidth / 5
        
        // Draw zones with color based on success rate
        CourtZone.values().forEachIndexed { index, zone ->
            val stats = zoneStats[zone]
            if (stats != null && stats.totalAttempts > 0) {
                drawRect(
                    color = Color(stats.color).copy(alpha = 0.6f),
                    topLeft = Offset(zoneWidth * index, 0f),
                    size = Size(zoneWidth, courtHeight)
                )
                
                // Draw stats text
                drawContext.canvas.nativeCanvas.apply {
                    val textPaint = android.graphics.Paint().apply {
                        color = android.graphics.Color.WHITE
                        textSize = 40f
                        textAlign = android.graphics.Paint.Align.CENTER
                        typeface = android.graphics.Typeface.create(android.graphics.Typeface.DEFAULT, android.graphics.Typeface.BOLD)
                    }
                    
                    drawText(
                        "${stats.successRate.toInt()}%",
                        zoneWidth * index + zoneWidth / 2,
                        courtHeight / 2 - 30f,
                        textPaint
                    )
                    
                    textPaint.textSize = 28f
                    drawText(
                        "${stats.successfulAttempts}/${stats.totalAttempts}",
                        zoneWidth * index + zoneWidth / 2,
                        courtHeight / 2 + 30f,
                        textPaint
                    )
                }
            }
        }
    }
}
```

---

## **6. SCREEN NAVIGATION IMPLEMENTATION**

### 6.1 Navigation Graph Setup

**Navigation Routes:**

```kotlin
sealed class Screen(val route: String) {
    object Splash : Screen("splash")
    object Login : Screen("login")
    object OTPVerification : Screen("otp_verification/{phoneNumber}") {
        fun createRoute(phoneNumber: String) = "otp_verification/$phoneNumber"
    }
    object ProfileSetup : Screen("profile_setup/{phoneNumber}") {
        fun createRoute(phoneNumber: String) = "profile_setup/$phoneNumber"
    }
    object Home : Screen("home")
    object MatchSetup : Screen("match_setup")
    object LiveMatchLogger : Screen("live_match_logger/{matchId}") {
        fun createRoute(matchId: Long) = "live_match_logger/$matchId"
    }
    object MatchSummary : Screen("match_summary/{matchId}") {
        fun createRoute(matchId: Long) = "match_summary/$matchId"
    }
    object MatchHistory : Screen("match_history")
    object MatchDetails : Screen("match_details/{matchId}") {
        fun createRoute(matchId: Long) = "match_details/$matchId"
    }
    object Heatmap : Screen("heatmap/{matchId}") {
        fun createRoute(matchId: Long) = "heatmap/$matchId"
    }
    object TrendGraph : Screen("trend_graph")
    object AICoach : Screen("ai_coach")
    object Profile : Screen("profile")
}
```

**Navigation Host:**

```kotlin
@Composable
fun KabaddiArenaNavHost(
    navController: NavHostController,
    startDestination: String
) {
    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        composable(Screen.Splash.route) {
            SplashScreen(
                onNavigateToLogin = { navController.navigate(Screen.Login.route) },
                onNavigateToHome = { navController.navigate(Screen.Home.route) }
            )
        }
        
        composable(Screen.Login.route) {
            LoginScreen(
                onNavigateToOTP = { phoneNumber ->
                    navController.navigate(Screen.OTPVerification.createRoute(phoneNumber))
                }
            )
        }
        
        composable(
            route = Screen.OTPVerification.route,
            arguments = listOf(navArgument("phoneNumber") { type = NavType.StringType })
        ) { backStackEntry ->
            val phoneNumber = backStackEntry.arguments?.getString("phoneNumber") ?: ""
            OTPVerificationScreen(
                phoneNumber = phoneNumber,
                onNavigateToProfileSetup = {
                    navController.navigate(Screen.ProfileSetup.createRoute(phoneNumber)) {
                        popUpTo(Screen.Login.route) { inclusive = true }
                    }
                },
                onNavigateToHome = {
                    navController.navigate(Screen.Home.route) {
                        popUpTo(Screen.Login.route) { inclusive = true }
                    }
                }
            )
        }
        
        composable(
            route = Screen.ProfileSetup.route,
            arguments = listOf(navArgument("phoneNumber") { type = NavType.StringType })
        ) { backStackEntry ->
            val phoneNumber = backStackEntry.arguments?.getString("phoneNumber") ?: ""
            ProfileSetupScreen(
                phoneNumber = phoneNumber,
                onNavigateToHome = {
                    navController.navigate(Screen.Home.route) {
                        popUpTo(Screen.ProfileSetup.route) { inclusive = true }
                    }
                }
            )
        }
        
        composable(Screen.Home.route) {
            HomeScreen(
                onNavigateToMatchSetup = { navController.navigate(Screen.MatchSetup.route) },
                onNavigateToMatchDetails = { matchId ->
                    navController.navigate(Screen.MatchDetails.createRoute(matchId))
                },
                onNavigateToAICoach = { navController.navigate(Screen.AICoach.route) },
                onNavigateToProfile = { navController.navigate(Screen.Profile.route) },
                onNavigateToHistory = { navController.navigate(Screen.MatchHistory.route) }
            )
        }
        
        composable(Screen.MatchSetup.route) {
            MatchSetupScreen(
                onNavigateToLiveLogger = { matchId ->
                    navController.navigate(Screen.LiveMatchLogger.createRoute(matchId)) {
                        popUpTo(Screen.Home.route)
                    }
                },
                onNavigateBack = { navController.popBackStack() }
            )
        }
        
        composable(
            route = Screen.LiveMatchLogger.route,
            arguments = listOf(navArgument("matchId") { type = NavType.LongType })
        ) { backStackEntry ->
            val matchId = backStackEntry.arguments?.getLong("matchId") ?: 0L
            LiveMatchLoggerScreen(
                matchId = matchId,
                onNavigateToMatchSummary = {
                    navController.navigate(Screen.MatchSummary.createRoute(matchId)) {
                        popUpTo(Screen.Home.route)
                    }
                },
                onNavigateBack = { navController.popBackStack() }
            )
        }
        
        composable(
            route = Screen.MatchSummary.route,
            arguments = listOf(navArgument("matchId") { type = NavType.LongType })
        ) { backStackEntry ->
            val matchId = backStackEntry.arguments?.getLong("matchId") ?: 0L
            MatchSummaryScreen(
                matchId = matchId,
                onNavigateToHeatmap = { navController.navigate(Screen.Heatmap.createRoute(matchId)) },
                onNavigateToTrends = { navController.navigate(Screen.TrendGraph.route) },
                onNavigateToHome = {
                    navController.navigate(Screen.Home.route) {
                        popUpTo(Screen.Home.route) { inclusive = true }
                    }
                }
            )
        }
        
        composable(Screen.MatchHistory.route) {
            MatchHistoryScreen(
                onNavigateToMatchDetails = { matchId ->
                    navController.navigate(Screen.MatchDetails.createRoute(matchId))
                },
                onNavigateBack = { navController.popBackStack() }
            )
        }
        
        composable(
            route = Screen.MatchDetails.route,
            arguments = listOf(navArgument("matchId") { type = NavType.LongType })
        ) { backStackEntry ->
            val matchId = backStackEntry.arguments?.getLong("matchId") ?: 0L
            MatchDetailsScreen(
                matchId = matchId,
                onNavigateToHeatmap = { navController.navigate(Screen.Heatmap.createRoute(matchId)) },
                onNavigateBack = { navController.popBackStack() }
            )
        }
        
        composable(
            route = Screen.Heatmap.route,
            arguments = listOf(navArgument("matchId") { type = NavType.LongType })
        ) { backStackEntry ->
            val matchId = backStackEntry.arguments?.getLong("matchId") ?: 0L
            HeatmapScreen(
                matchId = matchId,
                onNavigateBack = { navController.popBackStack() }
            )
        }
        
        composable(Screen.TrendGraph.route) {
            TrendGraphScreen(
                onNavigateBack = { navController.popBackStack() }
            )
        }
        
        composable(Screen.AICoach.route) {
            AICoachScreen(
                onNavigateBack = { navController.popBackStack() }
            )
        }
        
        composable(Screen.Profile.route) {
            ProfileScreen(
                onNavigateBack = { navController.popBackStack() },
                onLogout = {
                    navController.navigate(Screen.Login.route) {
                        popUpTo(0) { inclusive = true }
                    }
                }
            )
        }
    }
}
```

---

## **7. UI/UX DESIGN GUIDELINES**

### 7.1 Material Design 3 Theme Configuration

**Color Scheme:**

```kotlin
// Color.kt
val Orange500 = Color(0xFFFF6F00)
val Orange700 = Color(0xFFFF8F00)
val Red700 = Color(0xFFD32F2F)
val Green500 = Color(0xFF4CAF50)
val Blue500 = Color(0xFF2196F3)

val LightColorScheme = lightColorScheme(
    primary = Orange500,
    onPrimary = Color.White,
    primaryContainer = Orange700,
    secondary = Blue500,
    onSecondary = Color.White,
    tertiary = Green500,
    error = Red700,
    background = Color(0xFFFFFBFE),
    surface = Color.White,
    onBackground = Color(0xFF1C1B1F),
    onSurface = Color(0xFF1C1B1F)
)

val DarkColorScheme = darkColorScheme(
    primary = Orange700,
    onPrimary = Color.White,
    primaryContainer = Orange500,
    secondary = Blue500,
    onSecondary = Color.White,
    tertiary = Green500,
    error = Red700,
    background = Color(0xFF1C1B1F),
    surface = Color(0xFF2B2930),
    onBackground = Color(0xFFE6E1E5),
    onSurface = Color(0xFFE6E1E5)
)
```

**Typography:**

```kotlin
// Type.kt
val Typography = Typography(
    displayLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Bold,
        fontSize = 57.sp,
        lineHeight = 64.sp
    ),
    headlineLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Bold,
        fontSize = 32.sp,
        lineHeight = 40.sp
    ),
    headlineMedium = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Bold,
        fontSize = 28.sp,
        lineHeight = 36.sp
    ),
    titleLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.SemiBold,
        fontSize = 22.sp,
        lineHeight = 28.sp
    ),
    bodyLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp
    ),
    labelLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp,
        lineHeight = 20.sp
    )
)
```

**Theme Composable:**

```kotlin
// Theme.kt
@Composable
fun KabaddiArenaTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }
        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}
```

### 7.2 Reusable UI Components

**Large Action Button:**

```kotlin
@Composable
fun LargeActionButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    icon: ImageVector? = null,
    gradient: Brush = Brush.horizontalGradient(
        colors = listOf(Orange500, Orange700)
    )
) {
    Button(
        onClick = onClick,
        modifier = modifier
            .fillMaxWidth()
            .height(160.dp)
            .background(gradient, shape = RoundedCornerShape(16.dp)),
        enabled = enabled,
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Transparent
        ),
        elevation = ButtonDefaults.buttonElevation(
            defaultElevation = 8.dp,
            pressedElevation = 12.dp
        )
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            icon?.let {
                Icon(
                    imageVector = it,
                    contentDescription = null,
                    modifier = Modifier.size(48.dp),
                    tint = Color.White
                )
                Spacer(modifier = Modifier.height(8.dp))
            }
            Text(
                text = text,
                style = MaterialTheme.typography.headlineMedium,
                color = Color.White,
                fontWeight = FontWeight.Bold
            )
        }
    }
}
```

**Stat Card:**

```kotlin
@Composable
fun StatCard(
    label: String,
    value: String,
    icon: ImageVector,
    modifier: Modifier = Modifier,
    backgroundColor: Color = MaterialTheme.colorScheme.surface
) {
    Card(
        modifier = modifier,
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        colors = CardDefaults.cardColors(containerColor = backgroundColor)
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(
                imageVector = icon,
                contentDescription = null,
                modifier = Modifier.size(32.dp),
                tint = MaterialTheme.colorScheme.primary
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = value,
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onSurface
            )
            Text(
                text = label,
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
}
```

---

## **8. TESTING STRATEGY**

### 8.1 Unit Testing

**Test Coverage Areas:**
- ViewModels (business logic)
- Repositories (data operations)
- Use cases (domain logic)
- Utility functions (calculations, formatters)

**Example ViewModel Test:**

```kotlin
@ExperimentalCoroutinesTest
class MatchViewModelTest {
    
    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()
    
    private val testDispatcher = StandardTestDispatcher()
    
    private lateinit var viewModel: MatchViewModel
    private lateinit var mockMatchRepository: MatchRepository
    private lateinit var mockMatchEventRepository: MatchEventRepository
    
    @Before
    fun setup() {
        Dispatchers.setMain(testDispatcher)
        mockMatchRepository = mockk()
        mockMatchEventRepository = mockk()
        viewModel = MatchViewModel(mockMatchRepository, mockMatchEventRepository)
    }
    
    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }
    
    @Test
    fun `startMatch creates new match and updates state to InProgress`() = runTest {
        // Given
        val matchId = 1L
        val playerId = 1L
        coEvery { mockMatchRepository.createMatch(any()) } returns Result.success(matchId)
        
        // When
        viewModel.startMatch("Opponent Team", "Practice", playerId)
        advanceUntilIdle()
        
        // Then
        val state = viewModel.matchState.value
        assertTrue(state is MatchState.InProgress)
        coVerify { mockMatchRepository.createMatch(any()) }
    }
    
    @Test
    fun `logRaid updates match stats correctly`() = runTest {
        // Test implementation
    }
    
    @Test
    fun `undoLastAction removes last event and recalculates stats`() = runTest {
        // Test implementation
    }
}
```

### 8.2 Integration Testing

**Room Database Tests:**

```kotlin
@RunWith(AndroidJUnit4::class)
class MatchDaoTest {
    
    private lateinit var database: KabaddiArenaDatabase
    private lateinit var matchDao: MatchDao
    
    @Before
    fun createDb() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        database = Room.inMemoryDatabaseBuilder(context, KabaddiArenaDatabase::class.java)
            .allowMainThreadQueries()
            .build()
        matchDao = database.matchDao()
    }
    
    @After
    fun closeDb() {
        database.close()
    }
    
    @Test
    fun insertMatchAndRetrieveById() = runTest {
        // Given
        val match = MatchEntity(
            playerId = 1L,
            opponentTeamName = "Test Team",
            matchDate = System.currentTimeMillis(),
            matchType = "Practice",
            matchStatus = "COMPLETED"
        )
        
        // When
        val matchId = matchDao.insertMatch(match)
        val retrieved = matchDao.getMatchById(matchId)
        
        // Then
        assertNotNull(retrieved)
        assertEquals("Test Team", retrieved?.opponentTeamName)
    }
}
```

### 8.3 UI Testing with Compose

```kotlin
@RunWith(AndroidJUnit4::class)
class LoginScreenTest {
    
    @get:Rule
    val composeTestRule = createComposeRule()
    
    @Test
    fun phoneNumberInput_validatesCorrectly() {
        composeTestRule.setContent {
            LoginScreen(onNavigateToOTP = {})
        }
        
        // Enter invalid phone number
        composeTestRule.onNodeWithTag("phoneInput").performTextInput("12345")
        composeTestRule.onNodeWithTag("sendOTPButton").assertIsNotEnabled()
        
        // Enter valid phone number
        composeTestRule.onNodeWithTag("phoneInput").performTextClearance()
        composeTestRule.onNodeWithTag("phoneInput").performTextInput("9876543210")
        composeTestRule.onNodeWithTag("sendOTPButton").assertIsEnabled()
    }
}
```

---

## **9. DEPLOYMENT & BUILD CONFIGURATION**

### 9.1 Gradle Configuration

**build.gradle (Project level):**

```kotlin
buildscript {
    dependencies {
        classpath("com.google.dagger:hilt-android-gradle-plugin:2.50")
        classpath("com.google.gms:google-services:4.4.0")
    }
}

plugins {
    id("com.android.application") version "8.2.0" apply false
    id("org.jetbrains.kotlin.android") version "1.9.20" apply false
    id("com.google.dagger.hilt.android") version "2.50" apply false
}
```

**build.gradle (App level):**

```kotlin
plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("com.google.dagger.hilt.android")
    id("com.google.devtools.ksp") version "1.9.20-1.0.14"
    id("com.google.gms.google-services")
}

android {
    namespace = "com.kabaddiarena"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.kabaddiarena"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        
        vectorDrawables {
            useSupportLibrary = true
        }
        
        buildConfigField("String", "GEMINI_API_KEY", "\"${project.findProperty("GEMINI_API_KEY")}\"")
    }

    buildTypes {
        release {
            isMinifyEnabled = true
            isShrinkResources = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            signingConfig = signingConfigs.getByName("release")
        }
        debug {
            isMinifyEnabled = false
            isDebuggable = true
        }
    }
    
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    
    kotlinOptions {
        jvmTarget = "17"
    }
    
    buildFeatures {
        compose = true
        buildConfig = true
    }
    
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.4"
    }
    
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}
```

**local.properties:**

```properties
sdk.dir=/path/to/Android/sdk
GEMINI_API_KEY=your_actual_api_key_here
```

### 9.2 ProGuard Rules

**proguard-rules.pro:**

```proguard
# Keep Room entities
-keep class com.kabaddiarena.data.local.entity.** { *; }

# Keep Retrofit models
-keep class com.kabaddiarena.data.remote.dto.** { *; }

# Keep Hilt generated classes
-keep class dagger.hilt.** { *; }
-keep class javax.inject.** { *; }

# Keep Compose
-keep class androidx.compose.** { *; }

# Gson
-keepattributes Signature
-keepattributes *Annotation*
-keep class com.google.gson.** { *; }
```

---

## **10. FUTURE ENHANCEMENTS**

### 10.1 Planned Features (Version 2.0)

1. **Multi-Player Support:**
   - Track multiple players in a team
   - Team-level analytics and comparisons

2. **Video Integration:**
   - Record match videos
   - AI-powered automatic event detection from video
   - Timestamped video clips for each event

3. **Social Features:**
   - Player profiles with public stats
   - Leaderboards and rankings
   - Follow other players
   - Share performance cards in-app feed

4. **Advanced Analytics:**
   - Predictive performance modeling
   - Opponent analysis and scouting
   - Injury risk assessment based on play patterns
   - Fatigue analysis

5. **Coaching Tools:**
   - Create and assign training drills
   - Progress tracking for specific skills
   - Video tutorials integrated with AI recommendations

6. **Cloud Sync:**
   - Firebase integration for data backup
   - Multi-device sync
   - Web dashboard for desktop viewing

7. **Wearable Integration:**
   - Heart rate monitoring
   - Movement tracking with fitness bands
   - Real-time biometric data during matches

8. **Tournament Mode:**
   - Multi-match tournament tracking
   - Bracket management
   - Tournament-level statistics

### 10.2 Monetization Strategy

- **Freemium Model:**
  - Free: Up to 10 matches per month, basic analytics
  - Premium: Unlimited matches, advanced AI insights, cloud sync, video features
  - Pricing: ₹99/month or ₹999/year

- **In-App Purchases:**
  - One-time purchase for performance card customization themes
  - Premium AI coaching packages

---

## **11. DEVELOPMENT TIMELINE**

### Phase 1: Core Foundation (Week 1-2)
- Project setup and architecture
- Database schema implementation
- Authentication flow
- Basic UI screens (Splash, Login, OTP, Profile Setup)

### Phase 2: Match Tracking (Week 3-4)
- Match setup screen
- Live match logger with event logging
- Real-time stats calculation
- Undo functionality
- Match completion flow

### Phase 3: Analytics & Visualization (Week 5-6)
- Performance card generation and export
- Match history and details screens
- Heatmap visualization
- Trend graphs implementation

### Phase 4: AI Integration (Week 7)
- Gemini API integration
- AI insight generation
- Caching and offline fallback
- AI Coach screen implementation

### Phase 5: Polish & Testing (Week 8)
- UI/UX refinements
- Comprehensive testing
- Bug fixes
- Performance optimization
- Beta testing with real users

### Phase 6: Launch Preparation (Week 9-10)
- Play Store assets preparation
- Documentation finalization
- Marketing materials
- Beta deployment
- Production release

---

## **12. QUALITY ASSURANCE CHECKLIST**

### Functional Testing:
- [ ] Authentication works correctly (OTP send/verify)
- [ ] Profile creation and editing saves data
- [ ] Match can be started and events logged
- [ ] Stats calculate correctly in real-time
- [ ] Undo removes last action accurately
- [ ] Match completion saves all data
- [ ] Performance card generates correctly
- [ ] Share functionality works on all platforms
- [ ] AI insights generate successfully
- [ ] Offline mode works without internet
- [ ] Data persists across app restarts

### Performance Testing:
- [ ] App launches in < 2 seconds
- [ ] Match logging has < 100ms response time
- [ ] Smooth 60fps animations
- [ ] No memory leaks detected
- [ ] Battery consumption is reasonable
- [ ] Database queries optimized

### UI/UX Testing:
- [ ] All screens follow Material Design 3 guidelines
- [ ] Responsive layouts for different screen sizes
- [ ] Dark mode works correctly
- [ ] Accessibility features implemented (content descriptions, etc.)
- [ ] Error states handled gracefully
- [ ] Loading states are clear and informative

### Security Testing:
- [ ] API keys secured in BuildConfig
- [ ] No sensitive data logged
- [ ] Phone numbers validated and sanitized
- [ ] Database encrypted (if needed)

---

## **13. DOCUMENTATION FOR ANTIGRAVITY**

### Project Structure to Generate:

```
KabaddiArena/
├── app/
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/com/kabaddiarena/
│   │   │   │   ├── KabaddiArenaApplication.kt
│   │   │   │   ├── MainActivity.kt
│   │   │   │   ├── data/
│   │   │   │   │   ├── local/
│   │   │   │   │   │   ├── dao/
│   │   │   │   │   │   │   ├── PlayerDao.kt
│   │   │   │   │   │   │   ├── MatchDao.kt
│   │   │   │   │   │   │   ├── MatchEventDao.kt
│   │   │   │   │   │   │   └── AIInsightDao.kt
│   │   │   │   │   │   ├── database/
│   │   │   │   │   │   │   └── KabaddiArenaDatabase.kt
│   │   │   │   │   │   └── entity/
│   │   │   │   │   │       ├── PlayerEntity.kt
│   │   │   │   │   │       ├── MatchEntity.kt
│   │   │   │   │   │       ├── MatchEventEntity.kt
│   │   │   │   │   │       └── AIInsightCacheEntity.kt
│   │   │   │   │   ├── remote/
│   │   │   │   │   │   ├── api/
│   │   │   │   │   │   │   ├── GeminiApiService.kt
│   │   │   │   │   │   │   └── AuthService.kt
│   │   │   │   │   │   └── dto/
│   │   │   │   │   │       ├── GeminiRequest.kt
│   │   │   │   │   │       └── GeminiResponse.kt
│   │   │   │   │   ├── repository/
│   │   │   │   │   │   ├── PlayerRepositoryImpl.kt
│   │   │   │   │   │   ├── MatchRepositoryImpl.kt
│   │   │   │   │   │   ├── MatchEventRepositoryImpl.kt
│   │   │   │   │   │   └── AIInsightRepositoryImpl.kt
│   │   │   │   │   └── mapper/
│   │   │   │   │       └── EntityMappers.kt
│   │   │   │   ├── domain/
│   │   │   │   │   ├── model/
│   │   │   │   │   │   ├── Player.kt
│   │   │   │   │   │   ├── Match.kt
│   │   │   │   │   │   ├── MatchEvent.kt
│   │   │   │   │   │   └── AIInsight.kt
│   │   │   │   │   ├── repository/
│   │   │   │   │   │   ├── PlayerRepository.kt
│   │   │   │   │   │   ├── MatchRepository.kt
│   │   │   │   │   │   ├── MatchEventRepository.kt
│   │   │   │   │   │   └── AIInsightRepository.kt
│   │   │   │   │   └── usecase/
│   │   │   │   │       ├── auth/
│   │   │   │   │       ├── match/
│   │   │   │   │       └── analytics/
│   │   │   │   ├── presentation/
│   │   │   │   │   ├── screens/
│   │   │   │   │   │   ├── splash/
│   │   │   │   │   │   │   ├── SplashScreen.kt
│   │   │   │   │   │   │   └── SplashViewModel.kt
│   │   │   │   │   │   ├── auth/
│   │   │   │   │   │   │   ├── LoginScreen.kt
│   │   │   │   │   │   │   ├── OTPVerificationScreen.kt
│   │   │   │   │   │   │   └── AuthViewModel.kt
│   │   │   │   │   │   ├── profile/
│   │   │   │   │   │   │   ├── ProfileSetupScreen.kt
│   │   │   │   │   │   │   ├── ProfileScreen.kt
│   │   │   │   │   │   │   └── ProfileViewModel.kt
│   │   │   │   │   │   ├── home/
│   │   │   │   │   │   │   ├── HomeScreen.kt
│   │   │   │   │   │   │   └── HomeViewModel.kt
│   │   │   │   │   │   ├── match/
│   │   │   │   │   │   │   ├── MatchSetupScreen.kt
│   │   │   │   │   │   │   ├── LiveMatchLoggerScreen.kt
│   │   │   │   │   │   │   ├── MatchSummaryScreen.kt
│   │   │   │   │   │   │   └── MatchViewModel.kt
│   │   │   │   │   │   ├── analytics/
│   │   │   │   │   │   │   ├── HeatmapScreen.kt
│   │   │   │   │   │   │   ├── TrendGraphScreen.kt
│   │   │   │   │   │   │   ├── AICoachScreen.kt
│   │   │   │   │   │   │   └── AnalyticsViewModel.kt
│   │   │   │   │   │   └── history/
│   │   │   │   │   │       ├── MatchHistoryScreen.kt
│   │   │   │   │   │       ├── MatchDetailsScreen.kt
│   │   │   │   │   │       └── HistoryViewModel.kt
│   │   │   │   │   ├── components/
│   │   │   │   │   │   ├── LargeActionButton.kt
│   │   │   │   │   │   ├── StatCard.kt
│   │   │   │   │   │   ├── MatchCard.kt
│   │   │   │   │   │   └── PerformanceCardCanvas.kt
│   │   │   │   │   ├── navigation/
│   │   │   │   │   │   ├── Screen.kt
│   │   │   │   │   │   └── NavGraph.kt
│   │   │   │   │   └── theme/
│   │   │   │   │       ├── Color.kt
│   │   │   │   │       ├── Type.kt
│   │   │   │   │       └── Theme.kt
│   │   │   │   ├── di/
│   │   │   │   │   ├── AppModule.kt
│   │   │   │   │   ├── DatabaseModule.kt
│   │   │   │   │   ├── NetworkModule.kt
│   │   │   │   │   └── RepositoryModule.kt
│   │   │   │   └── util/
│   │   │   │       ├── PerformanceCardGenerator.kt
│   │   │   │       ├── PreferencesManager.kt
│   │   │   │       └── Extensions.kt
│   │   │   └── res/
│   │   │       ├── values/
│   │   │       │   ├── strings.xml
│   │   │       │   └── themes.xml
│   │   │       ├── drawable/
│   │   │       └── mipmap/
│   │   └── test/
│   │       └── java/com/kabaddiarena/
│   │           ├── MatchViewModelTest.kt
│   │           └── MatchDaoTest.kt
│   ├── build.gradle.kts
│   └── proguard-rules.pro
├── build.gradle.kts
├── settings.gradle.kts
├── gradle.properties
└── local.properties
```

---

## **14. FINAL IMPLEMENTATION NOTES**

### Critical Implementation Points:

1. **Offline-First Architecture:**
   - All core features must work without internet
   - AI features gracefully degrade to cached insights
   - Data sync when connection restored

2. **Performance Optimization:**
   - Use LazyColumn/LazyRow for all lists
   - Implement pagination for match history
   - Optimize database queries with proper indexing
   - Use Flow for reactive data streams

3. **Error Handling:**
   - Comprehensive try-catch blocks in repositories
   - User-friendly error messages
   - Automatic retry mechanisms for network calls
   - Fallback to cached data when possible

4. **State Management:**
   - Use StateFlow for ViewModel states
   - Proper loading/success/error state handling
   - Persist UI state across configuration changes

5. **Security:**
   - Store API keys in BuildConfig, not in code
   - Validate all user inputs
   - Sanitize phone numbers before storage
   - Use HTTPS for all network calls

6. **Accessibility:**
   - Add content descriptions to all icons and images
   - Ensure proper contrast ratios
   - Support screen readers
   - Keyboard navigation where applicable

---

## **END OF SOP DOCUMENT**

This comprehensive SOP provides Antigravity with all necessary information to generate the complete Kabaddi Arena Android application, including:

✅ Detailed screen-by-screen UI specifications
✅ Complete database structure with all entities and relationships
✅ Repository pattern implementation
✅ API integration details (Gemini AI, Firebase Auth)
✅ MVVM architecture with ViewModel implementations
✅ Navigation graph with all screen flows
✅ UI/UX design guidelines with Material Design 3
✅ Testing strategies and examples
✅ Build configuration and deployment setup
✅ Complete project structure
✅ Future enhancement roadmap

**Total Estimated Development Time:** 8-10 weeks for complete implementation with all features.