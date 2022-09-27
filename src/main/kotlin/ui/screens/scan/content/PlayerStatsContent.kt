package ui.screens.scan.content

import androidx.compose.foundation.layout.*
import androidx.compose.material.Checkbox
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import ui.theme.PLAYER_STATS_CHECK_TABLE_WIDTH
import ui.theme.spacing

@Composable
fun PlayerStatsContent(
    onStartClick: () -> Unit,
    onAbortClick: () -> Unit,
    isT1Checked: Boolean,
    onT1CheckedChange: () -> Unit,
    isT2Checked: Boolean,
    onT2CheckedChange: () -> Unit,
    isT3Checked: Boolean,
    onT3CheckedChange: () -> Unit,
    isT4Checked: Boolean,
    onT4CheckedChange: () -> Unit,
    isT5Checked: Boolean,
    onT5CheckedChange: () -> Unit,
    // todo - add all check box stats
) {
    Row {
        PlayerStatsCheckTable(
            isT1Checked,
            onT1CheckedChange,
            isT2Checked,
            onT2CheckedChange,
            isT3Checked,
            onT3CheckedChange,
            isT4Checked,
            onT4CheckedChange,
            isT5Checked,
            onT5CheckedChange
        )
        MutualContent(onStartClick = onStartClick, onAbortClick = onAbortClick)
    }
}

@Composable
fun PlayerStatsCheckTable(
    isT1Checked: Boolean,
    onT1CheckedChange: () -> Unit,
    isT2Checked: Boolean,
    onT2CheckedChange: () -> Unit,
    isT3Checked: Boolean,
    onT3CheckedChange: () -> Unit,
    isT4Checked: Boolean,
    onT4CheckedChange: () -> Unit,
    isT5Checked: Boolean,
    onT5CheckedChange: () -> Unit,
) {
    Column(
        modifier = Modifier
            .width(PLAYER_STATS_CHECK_TABLE_WIDTH),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        Text(
            modifier = Modifier.padding(MaterialTheme.spacing.small),
            text = "Select stats to collect",
            style = MaterialTheme.typography.h5
        )
        PlayerStatsCheckRow(
            text = "Gov ID",
            isChecked = isT1Checked, // fixme
            onCheckedChange = onT1CheckedChange //fixme
        )
        PlayerStatsCheckRow(
            text = "Name",
            isChecked = isT1Checked, // fixme
            onCheckedChange = onT1CheckedChange //fixme
        )
        PlayerStatsCheckRow(
            text = "Power",
            isChecked = isT1Checked, // fixme
            onCheckedChange = onT1CheckedChange //fixme
        )
        PlayerStatsCheckRow(
            text = "Dead Troops",
            isChecked = isT1Checked, // fixme
            onCheckedChange = onT1CheckedChange //fixme
        )
        PlayerStatsCheckRow(
            text = "T1 Kills",
            isChecked = isT1Checked,
            onCheckedChange = onT1CheckedChange
        )
        PlayerStatsCheckRow(
            text = "T2 Kills",
            isChecked = isT2Checked,
            onCheckedChange = onT2CheckedChange
        )
        PlayerStatsCheckRow(
            text = "T3 Kills",
            isChecked = isT3Checked,
            onCheckedChange = onT3CheckedChange
        )
        PlayerStatsCheckRow(
            text = "T4 Kills",
            isChecked = isT4Checked,
            onCheckedChange = onT4CheckedChange
        )
        PlayerStatsCheckRow(
            text = "T5 Kills",
            isChecked = isT5Checked,
            onCheckedChange = onT5CheckedChange
        )
        PlayerStatsCheckRow(
            text = "RSS Assistants",
            isChecked = isT1Checked, // fixme
            onCheckedChange = onT1CheckedChange //fixme
        )
        PlayerStatsCheckRow(
            text = "RSS Gathered",
            isChecked = isT1Checked, // fixme
            onCheckedChange = onT1CheckedChange //fixme
        )
        PlayerStatsCheckRow(
            text = "Alliance helps",
            isChecked = isT1Checked, // fixme
            onCheckedChange = onT1CheckedChange //fixme
        )
    }
}

@Composable
fun PlayerStatsCheckRow(
    text: String,
    isChecked: Boolean,
    onCheckedChange: () -> Unit,
) {
    Row(
        modifier = Modifier
            .padding(
                start = MaterialTheme.spacing.large,
                end = MaterialTheme.spacing.large
            )
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Checkbox(
            checked = isChecked,
            onCheckedChange = {
                onCheckedChange()
            }
        )
        Text(
            text = text,
            style = MaterialTheme.typography.body1,
            maxLines = 1
        )
    }
}