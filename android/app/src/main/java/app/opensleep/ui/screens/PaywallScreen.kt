package app.opensleep.ui.screens

import android.app.Activity
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import app.opensleep.R
import app.opensleep.ui.components.GlassCard
import app.opensleep.ui.theme.*
import app.opensleep.viewmodel.BillingViewModel

@Composable
fun PaywallScreen(
    billingVm: BillingViewModel,
    onDismiss: (() -> Unit)? = null
) {
    val context = LocalContext.current
    val activity = context as? Activity
    val formattedPrice by billingVm.formattedPrice.collectAsState()
    val isRestoring by billingVm.isRestoring.collectAsState()
    val isPremium by billingVm.isPremium.collectAsState()

    LaunchedEffect(billingVm) {
        billingVm.userMessage.collect { message ->
            Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
        }
    }

    LaunchedEffect(isPremium) {
        if (isPremium && onDismiss != null) {
            onDismiss()
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(NavyDeep)
    ) {
        // Ambient background glow circles
        Box(
            modifier = Modifier
                .size(260.dp)
                .offset(x = (-60).dp, y = (-60).dp)
                .background(IndigoAccent.copy(alpha = 0.15f), CircleShape)
                .blur(70.dp)
        )
        Box(
            modifier = Modifier
                .size(240.dp)
                .align(Alignment.BottomEnd)
                .offset(x = 60.dp, y = 40.dp)
                .background(CyanAccent.copy(alpha = 0.12f), CircleShape)
                .blur(70.dp)
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(horizontal = 20.dp, vertical = 12.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Dismiss button header if in dialog
            if (onDismiss != null) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.End
                ) {
                    IconButton(onClick = onDismiss) {
                        Icon(
                            imageVector = Icons.Default.Close,
                            contentDescription = stringResource(R.string.cancel),
                            tint = TextSecondary
                        )
                    }
                }
            } else {
                Spacer(Modifier.height(8.dp))
            }

            // Header Icon
            Box(
                modifier = Modifier
                    .size(68.dp)
                    .background(
                        Brush.radialGradient(
                            colors = listOf(IndigoAccent.copy(alpha = 0.35f), NavyMid)
                        ),
                        CircleShape
                    ),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.Default.AutoAwesome,
                    contentDescription = null,
                    tint = CyanAccent,
                    modifier = Modifier.size(32.dp)
                )
            }

            Spacer(Modifier.height(12.dp))

            Text(
                text = stringResource(R.string.paywall_title),
                style = MaterialTheme.typography.titleLarge.copy(
                    fontWeight = FontWeight.Bold,
                    fontSize = 24.sp
                ),
                color = TextPrimary,
                textAlign = TextAlign.Center
            )

            Spacer(Modifier.height(6.dp))

            Text(
                text = stringResource(R.string.paywall_subtitle),
                style = MaterialTheme.typography.bodySmall,
                color = TextSecondary,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(horizontal = 14.dp)
            )

            Spacer(Modifier.height(16.dp))

            // Single Consolidated Feature Card
            GlassCard(modifier = Modifier.fillMaxWidth()) {
                Column(
                    modifier = Modifier.padding(14.dp),
                    verticalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    PaywallFeatureRowCompact(
                        icon = Icons.Default.Timeline,
                        iconColor = CyanAccent,
                        title = stringResource(R.string.paywall_feature1_title),
                        description = stringResource(R.string.paywall_feature1_desc)
                    )

                    HorizontalDivider(color = IndigoLight.copy(alpha = 0.15f))

                    PaywallFeatureRowCompact(
                        icon = Icons.Default.Memory,
                        iconColor = IndigoLight,
                        title = stringResource(R.string.paywall_feature2_title),
                        description = stringResource(R.string.paywall_feature2_desc)
                    )

                    HorizontalDivider(color = IndigoLight.copy(alpha = 0.15f))

                    PaywallFeatureRowCompact(
                        icon = Icons.Default.ChatBubble,
                        iconColor = Color(0xFF4ADE80),
                        title = stringResource(R.string.paywall_feature3_title),
                        description = stringResource(R.string.paywall_feature3_desc)
                    )

                    HorizontalDivider(color = IndigoLight.copy(alpha = 0.15f))

                    PaywallFeatureRowCompact(
                        icon = Icons.Default.LockOpen,
                        iconColor = Color(0xFFFBBF24),
                        title = stringResource(R.string.paywall_feature4_title),
                        description = stringResource(R.string.paywall_feature4_desc)
                    )
                }
            }

            Spacer(Modifier.height(14.dp))

            // Lifetime Pricing Card
            GlassCard(modifier = Modifier.fillMaxWidth()) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 14.dp, vertical = 12.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column {
                        Row(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
                            Surface(
                                color = IndigoAccent.copy(alpha = 0.25f),
                                shape = CircleShape
                            ) {
                                Text(
                                    text = stringResource(R.string.paywall_lifetime_badge),
                                    color = CyanAccent,
                                    style = MaterialTheme.typography.labelSmall.copy(
                                        fontWeight = FontWeight.Bold,
                                        fontSize = 10.sp
                                    ),
                                    modifier = Modifier.padding(horizontal = 7.dp, vertical = 2.dp)
                                )
                            }

                            Surface(
                                color = NavySurface,
                                shape = CircleShape
                            ) {
                                Text(
                                    text = stringResource(R.string.paywall_one_time_badge),
                                    color = TextSecondary,
                                    style = MaterialTheme.typography.labelSmall.copy(fontSize = 10.sp),
                                    modifier = Modifier.padding(horizontal = 7.dp, vertical = 2.dp)
                                )
                            }
                        }

                        Spacer(Modifier.height(4.dp))

                        Text(
                            text = stringResource(R.string.paywall_no_subscription_note),
                            style = MaterialTheme.typography.bodySmall.copy(fontSize = 11.sp),
                            color = TextTertiary
                        )
                    }

                    // Live fetched price from Google Play
                    if (formattedPrice != null) {
                        Text(
                            text = formattedPrice!!,
                            style = MaterialTheme.typography.titleLarge.copy(
                                fontWeight = FontWeight.Black,
                                fontSize = 22.sp
                            ),
                            color = CyanAccent
                        )
                    } else {
                        CircularProgressIndicator(
                            modifier = Modifier.size(18.dp),
                            color = CyanAccent,
                            strokeWidth = 2.dp
                        )
                    }
                }
            }

            Spacer(Modifier.height(14.dp))

            // Primary Purchase Button
            Button(
                onClick = {
                    if (activity != null) {
                        billingVm.launchPurchaseFlow(activity)
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(52.dp),
                shape = RoundedCornerShape(14.dp),
                colors = ButtonDefaults.buttonColors(containerColor = IndigoAccent)
            ) {
                Icon(
                    imageVector = Icons.Default.AutoAwesome,
                    contentDescription = null,
                    modifier = Modifier.size(16.dp)
                )
                Spacer(Modifier.width(8.dp))

                val buttonText = if (formattedPrice != null) {
                    stringResource(R.string.paywall_unlock_with_price, formattedPrice!!)
                } else {
                    stringResource(R.string.paywall_unlock_button)
                }

                Text(
                    text = buttonText,
                    style = MaterialTheme.typography.titleMedium.copy(
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp
                    ),
                    color = Color.White
                )
            }

            Spacer(Modifier.height(6.dp))

            // Restore Purchases & Terms row
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                TextButton(
                    onClick = { billingVm.restorePurchases() },
                    enabled = !isRestoring,
                    contentPadding = PaddingValues(horizontal = 6.dp, vertical = 0.dp)
                ) {
                    if (isRestoring) {
                        CircularProgressIndicator(
                            modifier = Modifier.size(12.dp),
                            color = TextSecondary,
                            strokeWidth = 1.5.dp
                        )
                        Spacer(Modifier.width(4.dp))
                    }
                    Text(
                        text = stringResource(R.string.paywall_restore_button),
                        style = MaterialTheme.typography.bodySmall.copy(fontSize = 12.sp),
                        color = TextSecondary
                    )
                }

                Text(
                    text = "•",
                    style = MaterialTheme.typography.bodySmall.copy(fontSize = 12.sp),
                    color = TextTertiary,
                    modifier = Modifier.padding(horizontal = 4.dp)
                )

                Text(
                    text = stringResource(R.string.paywall_terms_privacy),
                    style = MaterialTheme.typography.bodySmall.copy(fontSize = 10.sp),
                    color = TextTertiary,
                    maxLines = 1
                )
            }

            Spacer(Modifier.height(16.dp))
        }
    }
}

@Composable
private fun PaywallFeatureRowCompact(
    icon: ImageVector,
    iconColor: Color,
    title: String,
    description: String
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Surface(
            color = iconColor.copy(alpha = 0.15f),
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier.size(32.dp)
        ) {
            Box(contentAlignment = Alignment.Center) {
                Icon(
                    imageVector = icon,
                    contentDescription = null,
                    tint = iconColor,
                    modifier = Modifier.size(16.dp)
                )
            }
        }

        Spacer(Modifier.width(10.dp))

        Column {
            Text(
                text = title,
                style = MaterialTheme.typography.titleSmall.copy(
                    fontWeight = FontWeight.Bold,
                    fontSize = 13.sp
                ),
                color = TextPrimary
            )
            Text(
                text = description,
                style = MaterialTheme.typography.bodySmall.copy(fontSize = 11.sp),
                color = TextSecondary,
                lineHeight = 15.sp,
                maxLines = 2
            )
        }
    }
}

