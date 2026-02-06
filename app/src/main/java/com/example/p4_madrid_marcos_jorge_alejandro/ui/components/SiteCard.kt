package com.example.p4_madrid_marcos_jorge_alejandro.ui.components
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.p4_madrid_marcos_jorge_alejandro.model.Site
import com.example.p4_madrid_marcos_jorge_alejandro.ui.theme.Shapes

@Composable
fun SiteCard(site: Site, onClick: () -> Unit, modifier: Modifier = Modifier) {
    Column(
        modifier
            .fillMaxWidth(0.5f)
            .padding(12.dp)
            .clickable(onClick = onClick),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(Modifier
            .shadow(24.dp, shape = Shapes.large, spotColor = MaterialTheme.colorScheme.primary)
            .clip(Shapes.large)
            .border(1.dp, color = MaterialTheme.colorScheme.primary, shape = Shapes.large)
        ) {
            Image(
                painter = painterResource(site.imgRes),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(0.80f)
            )
        }
        Spacer(Modifier.height(8.dp))
        Text(
            text = stringResource(site.nameRes),
            color = MaterialTheme.colorScheme.tertiary,
            style = MaterialTheme.typography.titleSmall
        )
    }
}
