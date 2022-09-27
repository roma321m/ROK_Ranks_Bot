package ui.screens.scan.app_bar

import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import ui.theme.spacing
import ui.theme.topAppBarContentColor

@Composable
fun ScanAppBar(
    onPlayerStatsClicked: () -> Unit,
    onKingdomPowerClicked: () -> Unit,
    onKingdomKillPointsClicked: () -> Unit
) {
    TopAppBar (
        title = {
            Text(
                text = "Scan options:",
                color = MaterialTheme.colors.topAppBarContentColor
            )
        },
        actions = {
            ScanAppBarActions(
                onPlayerStatsClicked = onPlayerStatsClicked,
                onKingdomPowerClicked = onKingdomPowerClicked,
                onKingdomKillPointsClicked = onKingdomKillPointsClicked
            )
        }
    )
}

@Composable
fun ScanAppBarActions(
    onPlayerStatsClicked: () -> Unit,
    onKingdomPowerClicked: () -> Unit,
    onKingdomKillPointsClicked: () -> Unit
) {
    PlayerStatsAction(onPlayerStatsClicked = onPlayerStatsClicked)
    KingdomPowerAction(onKingdomPowerClicked = onKingdomPowerClicked)
    KingdomKillPointsAction(onKingdomKillPointsClicked = onKingdomKillPointsClicked)
}

@Composable
fun PlayerStatsAction(
    onPlayerStatsClicked: () -> Unit,
) {
    Button(
        modifier = Modifier.padding(MaterialTheme.spacing.small),
        onClick = onPlayerStatsClicked
    ) {
        Text("Player Stats")
    }
//    TabItem(
//        modifier = Modifier,
//        backgroundColor = MaterialTheme.colors.topAppBarBackgroundColor,
//        text = "Player Stats",
//        textColor = MaterialTheme.colors.onBackground,
//        onClicked = onPlayerStatsClicked,
//        sliderColor = MaterialTheme.colors.topAppBarContentColor
//    )
}

@Composable
fun KingdomPowerAction(
    onKingdomPowerClicked: () -> Unit,
) {
    Button(
        modifier = Modifier.padding(MaterialTheme.spacing.small),
        onClick = onKingdomPowerClicked
    ) {
        Text("Kingdom Power")
    }
}

@Composable
fun KingdomKillPointsAction(
    onKingdomKillPointsClicked: () -> Unit,
) {
    Button(
        modifier = Modifier.padding(MaterialTheme.spacing.small),
        onClick = onKingdomKillPointsClicked
    ) {
        Text("Kingdom Kill Points")
    }
}