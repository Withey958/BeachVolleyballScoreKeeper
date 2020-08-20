package com.example.volleyballscoring

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.*
import androidx.ui.core.*
import androidx.ui.foundation.Icon
import androidx.ui.foundation.Image
import androidx.ui.foundation.Text
import androidx.ui.foundation.shape.corner.RoundedCornerShape
import androidx.ui.input.KeyboardType
import androidx.ui.layout.*
import androidx.ui.material.*
import androidx.ui.res.imageResource
import androidx.ui.res.vectorResource
import androidx.ui.text.style.TextAlign
import androidx.ui.tooling.preview.Preview
import androidx.ui.unit.TextUnit
import androidx.ui.unit.dp
import com.example.volleyballscoring.ui.VolleyballScoringTheme
import com.example.volleyballscoring.ui.typography

private const val TAG = "MainActivity"

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            VolleyballScoringTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {

                    HomeScreen()
                }
            }
        }
    }
}

@Composable
fun HomeScreen(
    scaffoldState: ScaffoldState = remember { ScaffoldState() }
) {

    val vectorModifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight()


    Scaffold(scaffoldState = scaffoldState,
        topAppBar = {
            TopAppBar(title = {
                Text(text = "Beach Volleyball Score Keeper", textAlign = TextAlign.Start)
            },
                navigationIcon = {
                    Icon(vectorResource(id = (R.drawable.ic_sports_volleyball_24px)), modifier = vectorModifier)

                }
            )
        },
        bodyContent = {
            HomeScreenBody()
        }
    )
}

@Composable
private fun HomeScreenBody() {
    Column(modifier = Modifier.padding(16.dp)
        ) {
        // add some composables
        HomeScreenCurrentScore()

//        HomeScreenTimer()
//        HomeScreenPreviousGames()

    }
}


@Composable
private fun HomeScreenCurrentScore() {
    Row(modifier = Modifier.fillMaxWidth(),
    horizontalArrangement = Arrangement.SpaceEvenly,
    verticalGravity = Alignment.CenterVertically) {
        val scoreTeamOne = state {0}
        val scoreTeamTwo = state {0}

        AddRemoveButton(count = scoreTeamOne)
        Column(verticalArrangement = Arrangement.SpaceEvenly,
            horizontalGravity = Alignment.CenterHorizontally) {

            Text(
                text = "Team One: Team Two"
            )
            Text(
                text = "${scoreTeamOne.value}:${scoreTeamTwo.value}",
                style = typography.h1,
                fontSize = TextUnit.Companion.Sp(40)
            )
        }

        AddRemoveButton(count = scoreTeamTwo)
    }
}

@Composable
private fun AddRemoveButton(count: MutableState<Int>) {
    Column() {
        IconButton(onClick = {
            count.value++
            Log.d(TAG, "AddRemoveButton: Up Button Clicked count = ${count.value}")
        }) {
            Icon(asset = vectorResource(id = R.drawable.ic_arrow_circle_up_24px))
        }
        IconButton(onClick = {
            Log.d(TAG, "AddRemoveButton: Down Button Clicked count = ${count.value}")
            count.value--
        }) {
            Icon(asset = vectorResource(id = R.drawable.ic_arrow_circle_down_24px))
        }
    }
}


@Preview
@Composable
fun PreviewHomeScreen() {
    HomeScreen()
}

