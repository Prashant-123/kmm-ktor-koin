package ui.internships

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import data.InternshipApiModel
import io.kamel.image.KamelImage
import io.kamel.image.asyncPainterResource
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource
import ui.theme.Color as UiColor

@ExperimentalResourceApi
@Composable
fun InternshipCard(internship: InternshipApiModel.Internship) {
    Column(modifier = Modifier.fillMaxWidth().padding(16.dp)) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(modifier = Modifier.weight(0.8f)) {
                Text(
                    text = internship.profileName,
                    fontSize = 18.sp,
                    modifier = Modifier.padding(end = 8.dp),
                    fontWeight = FontWeight.SemiBold
                )
                Spacer(Modifier.height(8.dp))
                Text(
                    text = internship.companyName,
                    fontSize = 14.sp,
                    color = UiColor.textTertiary
                )
            }

            KamelImage(
                resource = asyncPainterResource(data = "https://internshala.com/uploads/logo/${internship.companyLogo}"),
                contentDescription = "Company Logo",
                modifier = Modifier.height(48.dp).width(48.dp)
                    .clip(shape = RoundedCornerShape(8.dp)),
                contentAlignment = Alignment.Center,
                contentScale = ContentScale.Fit
            )
        }


        Spacer(modifier = Modifier.height(16.dp))
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
                imageVector = Icons.Default.Home,
                tint = UiColor.textSecondary,
                contentDescription = "Menu",
                modifier = Modifier.height(18.dp).width(18.dp)
            )
            Spacer(Modifier.width(4.dp))
            Text(
                text = "Work from Home",
                fontSize = 15.sp,
                color = UiColor.textSecondary,
            )
        }


        Spacer(modifier = Modifier.height(16.dp))
        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(
                painter = painterResource("ic_play_circle.xml"),
                contentDescription = "Menu",
                colorFilter = ColorFilter.tint(UiColor.textSecondary)
            )
            Spacer(modifier = Modifier.width(4.dp))
            Text(text = internship.startDate, fontSize = 15.sp, color = UiColor.textSecondary)
            Spacer(Modifier.width(24.dp))
            Image(
                painter = painterResource("ic_calendar.xml"),
                contentDescription = "Calendar",
                colorFilter = ColorFilter.tint(UiColor.textSecondary)
            )
            Spacer(modifier = Modifier.width(4.dp))
            Text(
                text = internship.duration,
                fontSize = 15.sp,
                color = UiColor.textSecondary
            )
        }

        Spacer(modifier = Modifier.height(16.dp))
        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(
                painter = painterResource("ic_stipend.xml"),
                contentDescription = "Stipend",
                colorFilter = ColorFilter.tint(UiColor.textSecondary)
            )
            Spacer(Modifier.width(4.dp))
            Text(
                text = internship.stipend?.salary.orEmpty(),
                fontSize = 15.sp,
                color = UiColor.textSecondary,
            )
        }

        Spacer(Modifier.height(16.dp))
        Row {
            internship.labels?.map { label ->
                Surface(
                    shape = MaterialTheme.shapes.medium,
                    color = UiColor.background,
                    contentColor = Color.DarkGray
                ) {
                    Text(
                        text = label,
                        modifier = Modifier.padding(horizontal = 6.dp, vertical = 4.dp),
                        fontSize = 13.sp
                    )
                }
                Spacer(Modifier.width(8.dp))
            }
        }

        Spacer(Modifier.height(14.dp))
        Surface(
            shape = MaterialTheme.shapes.medium,
            color = Color(233, 241, 254, 205),
            contentColor = UiColor.primary
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(horizontal = 4.dp, vertical = 2.dp)
            ) {
                Image(
                    painterResource("ic_clock.xml"),
                    contentDescription = null,
                    colorFilter = ColorFilter.tint(UiColor.textOnPrimary)
                )
                Text(
                    modifier = Modifier.padding(start = 4.dp),
                    text = internship.postedByLabel,
                    fontSize = 13.sp,
                    color = UiColor.textOnPrimary
                )
            }
        }
    }
}