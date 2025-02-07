package com.example.ebs.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.googlefonts.Font
import androidx.compose.ui.text.googlefonts.GoogleFont
import androidx.compose.ui.unit.sp
import com.example.ebs.R

val provider = GoogleFont.Provider(
    providerAuthority = "com.google.android.gms.fonts",
    providerPackage = "com.google.android.gms",
    certificates = R.array.com_google_android_gms_fonts_certs
)
val NunitoSans = GoogleFont(name = "Nunito Sans")

val NunitoSansFamily = FontFamily(
    Font(googleFont = NunitoSans, fontProvider = provider),
    Font(googleFont = NunitoSans, fontProvider = provider, weight = FontWeight.Light),
    Font(googleFont = NunitoSans, fontProvider = provider, weight = FontWeight.Medium),
    Font(googleFont = NunitoSans, fontProvider = provider, weight = FontWeight.SemiBold),
    Font(googleFont = NunitoSans, fontProvider = provider, weight = FontWeight.Bold),
)

// Default Material 3 typography values
val baseline = Typography()

val AppTypography = Typography(
    displayLarge = baseline.displayLarge.copy(fontFamily = NunitoSansFamily),
    displayMedium = baseline.displayMedium.copy(fontFamily = NunitoSansFamily),
    displaySmall = baseline.displaySmall.copy(fontFamily = NunitoSansFamily),
    headlineLarge = baseline.headlineLarge.copy(fontFamily = NunitoSansFamily),
    headlineMedium = baseline.headlineMedium.copy(fontFamily = NunitoSansFamily),
    headlineSmall = baseline.headlineSmall.copy(fontFamily = NunitoSansFamily),
    titleLarge = baseline.titleLarge.copy(fontFamily = NunitoSansFamily),
    titleMedium = baseline.titleMedium.copy(fontFamily = NunitoSansFamily, fontSize = 20.sp),
    titleSmall = baseline.titleSmall.copy(fontFamily = NunitoSansFamily),
    bodyLarge = baseline.bodyLarge.copy(fontFamily = NunitoSansFamily),
    bodyMedium = baseline.bodyMedium.copy(fontFamily = NunitoSansFamily),
    bodySmall = baseline.bodySmall.copy(fontFamily = NunitoSansFamily),
    labelLarge = baseline.labelLarge.copy(fontFamily = NunitoSansFamily),
    labelMedium = baseline.labelMedium.copy(fontFamily = NunitoSansFamily),
    labelSmall = baseline.labelSmall.copy(fontFamily = NunitoSansFamily, fontSize = 9.sp),
)
