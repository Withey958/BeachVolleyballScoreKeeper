package com.example.volleyballscoring

import android.os.Bundle
import android.util.Log
import android.view.Gravity
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.Composable
import androidx.compose.remember
import androidx.ui.core.*
import androidx.ui.foundation.Icon
import androidx.ui.foundation.Image
import androidx.ui.foundation.Text
import androidx.ui.foundation.shape.corner.RoundedCornerShape
import androidx.ui.layout.*
import androidx.ui.material.*
import androidx.ui.res.imageResource
import androidx.ui.res.vectorResource
import androidx.ui.text.style.TextAlign
import androidx.ui.tooling.preview.Preview
import androidx.ui.unit.dp
import com.example.volleyballscoring.ui.VolleyballScoringTheme
import com.example.volleyballscoring.ui.typography
import com.google.android.material.tabs.TabLayout

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
fun NewsStory() {

    val image = imageResource(id = R.drawable.header)
    Column(
        modifier = Modifier.padding(16.dp)
    ) {

        val imageModifier = Modifier
            .preferredHeightIn(maxHeight = 180.dp)
            .fillMaxWidth()
            .clip(shape = RoundedCornerShape(16.dp)) // clip not showing on preview

        Image(image, modifier = imageModifier, contentScale = ContentScale.Crop)

        Spacer(Modifier.preferredHeight(16.dp))

        Text(
            "A party at a neighbours",
            style = typography.h6
        )
        Text(
            "Brighton, UK",
            style = typography.body2
        )
        Text(
            "August, 2020",
            style = typography.body2
        )

        Spacer(modifier = Modifier.preferredHeight(16.dp))


    }


}

@Composable
fun HomeScreen(
    scaffoldState: ScaffoldState = remember { ScaffoldState() }
) {

    Scaffold(scaffoldState = scaffoldState,
        topAppBar = {
            TopAppBar(title = {
                Text(text = "Beach Volleyball Score Keeper", textAlign = TextAlign.Start)
            },
                navigationIcon = {
                    Icon(vectorResource(id = (R.drawable.ic_sports_volleyball_24px)))
                }
            )
        },
        bodyContent = {
            val modifier = Modifier.padding(16.dp)
            HomeScreenBody()
        }
    )

//    Column(modifier = Modifier.padding(16.dp)) {
//        Text(text = "Beach Volleyball Score Card",
//        style = typography.h1,
//        textAlign = TextAlign.Center)
//    }
//
//    Button(modifier = Modifier)
}

@Composable
private fun HomeScreenBody(modifier: Modifier = Modifier) {
    Column(modifier = Modifier.padding(16.dp)) {
        // add some composables
        HomeScreenCurrentScore()

//        HomeScreenTimer()
//        HomeScreenPreviousGames()

    }
}

@Composable
private fun HomeScreenCurrentScore() {
    Row() {
        AddRemoveButton()
        AddRemoveButton()
    }
}

@Composable
private fun AddRemoveButton() {
    Column() {
        IconButton(onClick = { Log.d(TAG, "AddRemoveButton: Up Button Clicked") }) {
            Icon(asset = vectorResource(id = R.drawable.ic_arrow_circle_up_24px))
        }
        IconButton(onClick = { Log.d(TAG, "AddRemoveButton: Down Button Clicked") }) {
            Icon(asset = vectorResource(id = R.drawable.ic_arrow_circle_down_24px))
        }
    }
}



@Preview
@Composable
fun PreviewHomeScreen() {
    HomeScreen()
}

