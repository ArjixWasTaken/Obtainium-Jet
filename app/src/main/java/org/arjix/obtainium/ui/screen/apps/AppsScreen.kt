package org.arjix.obtainium.ui.screen.apps

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun AppsScreen(
    viewModel: AppsViewModel = hiltViewModel()
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 5.dp, vertical = 10.dp),
    ) {
        Text(text="Apps", style = MaterialTheme.typography.h4)
    }
}

@Composable
fun Toolbar(viewModel: AppsViewModel = hiltViewModel()) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(35.dp)
            .border(2.dp, Color.Gray),
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        Row(horizontalArrangement = Arrangement.SpaceEvenly) {
            Icon(
                modifier = Modifier.size(30.dp).padding(4.dp),
                painter = painterResource(id = org.arjix.obtainium.R.drawable.select_all),
                contentDescription = null,
            )
            Column(
                modifier = Modifier.fillMaxHeight(),
                verticalArrangement = Arrangement.Center
            ) {
                Text("0")
            }
        }

        Column(
            modifier = Modifier.fillMaxHeight(),
            verticalArrangement = Arrangement.Center
        ) {
            Divider(modifier = Modifier.fillMaxHeight(0.8F).width(2.dp), color=Color.Gray)
        }

        Row(horizontalArrangement = Arrangement.SpaceEvenly) {
            Icon(
                modifier = Modifier.size(30.dp).padding(4.dp),
                painter = painterResource(id = org.arjix.obtainium.R.drawable.delete_outline),
                contentDescription = null,
            )
            Icon(
                modifier = Modifier.size(30.dp).padding(4.dp),
                painter = painterResource(id = org.arjix.obtainium.R.drawable.save_alt),
                contentDescription = null,
            )
            Icon(
                modifier = Modifier.size(30.dp).padding(4.dp),
                painter = painterResource(id = org.arjix.obtainium.R.drawable.outline_category),
                contentDescription = null,
            )
            Icon(
                modifier = Modifier.size(30.dp).padding(4.dp),
                painter = painterResource(id = org.arjix.obtainium.R.drawable.more_horiz),
                contentDescription = null,
            )
        }

        Column(
            modifier = Modifier.fillMaxHeight(),
            verticalArrangement = Arrangement.Center
        ) {
            Divider(modifier = Modifier.fillMaxHeight(0.8F).width(2.dp), color=Color.Gray)
        }

        Row(horizontalArrangement = Arrangement.SpaceEvenly) {
            Icon(
                modifier = Modifier.size(30.dp).padding(4.dp),
                painter = painterResource(id = org.arjix.obtainium.R.drawable.update),
                contentDescription = null,
            )
            Row {
                Icon(
                    modifier = Modifier.size(30.dp).padding(4.dp),
                    painter = painterResource(id = org.arjix.obtainium.R.drawable.filter_list),
                    contentDescription = null,
                )
                Column(
                    modifier = Modifier.fillMaxHeight(),
                    verticalArrangement = Arrangement.Center
                ) {
                    Text("Filter")
                }
            }
        }
    }
}
