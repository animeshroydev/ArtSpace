package com.appmakerszone.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.appmakerszone.artspace.ui.theme.ArtSpaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceTheme {
                ArtSpaceLayout()
            }
        }
    }
}

@Composable
fun ArtSpaceLayout() {

    var currentImage by remember { mutableStateOf(1) }
    var isEnabledPrev by remember { mutableStateOf(true) }
    var isEnabledNext by remember { mutableStateOf(true) }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 50.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly
        ) {

            when (currentImage) {

                1 -> {
                    ImagePlaceHolder(drawableResourceId = R.drawable.dirt_bike)
                    isEnabledPrev = false
                    isEnabledNext = true
                }

                2 -> {
                    ImagePlaceHolder(drawableResourceId = R.drawable.dirt_bike2)
                    isEnabledPrev = true
                    isEnabledNext = true
                }

                3 -> {
                    ImagePlaceHolder(drawableResourceId = R.drawable.dirt_bike3)
                    isEnabledPrev = true
                    isEnabledNext = true
                }

                4 -> {
                    ImagePlaceHolder(drawableResourceId = R.drawable.dirt_bike4)
                    isEnabledPrev = true
                    isEnabledNext = true
                }

                5 -> {
                    ImagePlaceHolder(drawableResourceId = R.drawable.dirt_bike5)
                    isEnabledPrev = true
                    isEnabledNext = false
                }
            }



            Box(
                modifier = Modifier
                    .padding(top = 30.dp, start = 30.dp, end = 30.dp)
                    .background(
                        brush = Brush.horizontalGradient(
                            colors = listOf(
                                Color(0xFFECEBF5),
                                Color(0xFFECEBF5)
                            )
                        ),
                        shape = RoundedCornerShape(8.dp)
                    )
            ) {

                Column(modifier = Modifier.padding(10.dp)) {
                    Text(
                        text = "I am Riding a Dirt Motorbike",
                        fontSize = 20.sp, lineHeight = 35.sp
                    )
                    Row {
                        Text(
                            text = "Animesh Roy",
                            fontWeight = FontWeight.Bold,
                        )
                        Text(text = "(2024)", fontWeight = FontWeight.SemiBold)
                    }

                }
            }



            PrevNextButton(onClickNext = {
                currentImage += 1
            }, onClickPrev = {
                currentImage -= 1
            },
                isEnabledPrev = isEnabledPrev,
                isEnabledNext = isEnabledNext
            )
        }
    }

}

@Composable
fun PrevNextButton(
    onClickPrev: () -> Unit, onClickNext: () -> Unit,
    isEnabledPrev: Boolean,
    isEnabledNext: Boolean,
    modifier: Modifier = Modifier,
) {

    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly,
        modifier = modifier
            .fillMaxWidth()
            .padding(top = 30.dp)
    ) {
        Button(onClick = onClickPrev, enabled = isEnabledPrev) {
            Text(text = "Previous")
        }
        Button(onClick = onClickNext, enabled = isEnabledNext) {
            Text(text = "Next")
        }
    }

}

@Composable
fun ImagePlaceHolder(drawableResourceId: Int, modifier: Modifier = Modifier) {

    Card(
        modifier = modifier
            .padding(20.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        elevation = CardDefaults.elevatedCardElevation(8.dp)

    ) {

        Box(
            modifier = Modifier
                .wrapContentSize()
                .padding(25.dp).height(300.dp),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = drawableResourceId),
                contentDescription = null,
                modifier = Modifier
                    .wrapContentSize()
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    ArtSpaceTheme {
        ArtSpaceLayout()
    }
}