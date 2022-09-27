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
import ui.theme.strings.stringResources

@Composable
fun PlayerStatsContent(
    onStartClick: () -> Unit,
    onAbortClick: () -> Unit,
    isIdChecked: Boolean,
    onIdCheckedChange: () -> Unit,
    isNameChecked: Boolean,
    onNameCheckedChange: () -> Unit,
    isPowerChecked: Boolean,
    onPowerCheckedChange: () -> Unit,
    isDeadTroopsChecked: Boolean,
    onDeadTroopsCheckedChange: () -> Unit,
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
    isRSSAssistantsChecked: Boolean,
    onRSSAssistantsCheckedChange: () -> Unit,
    isRSSGatheredChecked: Boolean,
    onRSSGatheredCheckedChange: () -> Unit,
    isAllianceHelpsChecked: Boolean,
    onAllianceHelpsCheckedChange: () -> Unit,
) {
    Row {
        PlayerStatsCheckTable(
            isIdChecked = isIdChecked,
            onIdCheckedChange = onIdCheckedChange,
            isNameChecked = isNameChecked,
            onNameCheckedChange = onNameCheckedChange,
            isPowerChecked = isPowerChecked,
            onPowerCheckedChange = onPowerCheckedChange,
            isDeadTroopsChecked = isDeadTroopsChecked,
            onDeadTroopsCheckedChange = onDeadTroopsCheckedChange,
            isT1Checked = isT1Checked,
            onT1CheckedChange = onT1CheckedChange,
            isT2Checked = isT2Checked,
            onT2CheckedChange = onT2CheckedChange,
            isT3Checked = isT3Checked,
            onT3CheckedChange = onT3CheckedChange,
            isT4Checked = isT4Checked,
            onT4CheckedChange = onT4CheckedChange,
            isT5Checked = isT5Checked,
            onT5CheckedChange = onT5CheckedChange,
            isRSSAssistantsChecked = isRSSAssistantsChecked,
            onRSSAssistantsCheckedChange = onRSSAssistantsCheckedChange,
            isRSSGatheredChecked = isRSSGatheredChecked,
            onRSSGatheredCheckedChange = onRSSGatheredCheckedChange,
            isAllianceHelpsChecked = isAllianceHelpsChecked,
            onAllianceHelpsCheckedChange = onAllianceHelpsCheckedChange,
        )
        MutualContent(onStartClick = onStartClick, onAbortClick = onAbortClick)
    }
}

@Composable
fun PlayerStatsCheckTable(
    isIdChecked: Boolean,
    onIdCheckedChange: () -> Unit,
    isNameChecked: Boolean,
    onNameCheckedChange: () -> Unit,
    isPowerChecked: Boolean,
    onPowerCheckedChange: () -> Unit,
    isDeadTroopsChecked: Boolean,
    onDeadTroopsCheckedChange: () -> Unit,
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
    isRSSAssistantsChecked: Boolean,
    onRSSAssistantsCheckedChange: () -> Unit,
    isRSSGatheredChecked: Boolean,
    onRSSGatheredCheckedChange: () -> Unit,
    isAllianceHelpsChecked: Boolean,
    onAllianceHelpsCheckedChange: () -> Unit,
) {
    Column(
        modifier = Modifier
            .width(PLAYER_STATS_CHECK_TABLE_WIDTH),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        Text(
            modifier = Modifier.padding(MaterialTheme.spacing.small),
            text = MaterialTheme.stringResources.playerStatsContentTitle,
            style = MaterialTheme.typography.h5
        )
        PlayerStatsCheckRow(
            text = MaterialTheme.stringResources.playerStatsContentId,
            isChecked = isIdChecked,
            onCheckedChange = onIdCheckedChange
        )
        PlayerStatsCheckRow(
            text = MaterialTheme.stringResources.playerStatsContentName,
            isChecked = isNameChecked,
            onCheckedChange = onNameCheckedChange
        )
        PlayerStatsCheckRow(
            text = MaterialTheme.stringResources.playerStatsContentPower,
            isChecked = isPowerChecked,
            onCheckedChange = onPowerCheckedChange
        )
        PlayerStatsCheckRow(
            text = MaterialTheme.stringResources.playerStatsContentDead,
            isChecked = isDeadTroopsChecked,
            onCheckedChange = onDeadTroopsCheckedChange
        )
        PlayerStatsCheckRow(
            text = MaterialTheme.stringResources.playerStatsContentT1,
            isChecked = isT1Checked,
            onCheckedChange = onT1CheckedChange
        )
        PlayerStatsCheckRow(
            text = MaterialTheme.stringResources.playerStatsContentT2,
            isChecked = isT2Checked,
            onCheckedChange = onT2CheckedChange
        )
        PlayerStatsCheckRow(
            text = MaterialTheme.stringResources.playerStatsContentT3,
            isChecked = isT3Checked,
            onCheckedChange = onT3CheckedChange
        )
        PlayerStatsCheckRow(
            text = MaterialTheme.stringResources.playerStatsContentT4,
            isChecked = isT4Checked,
            onCheckedChange = onT4CheckedChange
        )
        PlayerStatsCheckRow(
            text = MaterialTheme.stringResources.playerStatsContentT5,
            isChecked = isT5Checked,
            onCheckedChange = onT5CheckedChange
        )
        PlayerStatsCheckRow(
            text = MaterialTheme.stringResources.playerStatsContentRSSA,
            isChecked = isRSSAssistantsChecked,
            onCheckedChange = onRSSAssistantsCheckedChange
        )
        PlayerStatsCheckRow(
            text = MaterialTheme.stringResources.playerStatsContentRSSG,
            isChecked = isRSSGatheredChecked,
            onCheckedChange = onRSSGatheredCheckedChange
        )
        PlayerStatsCheckRow(
            text = MaterialTheme.stringResources.playerStatsContentHelps,
            isChecked = isAllianceHelpsChecked,
            onCheckedChange = onAllianceHelpsCheckedChange
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