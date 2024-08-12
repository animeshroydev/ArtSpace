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
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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

            Card(
                modifier = Modifier
                    .padding(20.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color.White
                ),
                elevation = CardDefaults.elevatedCardElevation(8.dp)

            ) {

                Box(
                    modifier = Modifier
                        .wrapContentSize()
                        .padding(25.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.dirt_bike),
                        contentDescription = null,
                        modifier = Modifier
                            .wrapContentSize()
                    )
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
                    Text(text = "I am Riding a Dirt Motorbike",
                        fontSize = 20.sp, lineHeight = 35.sp)
                    Row {
                        Text(
                            text = "Animesh Roy",
                            fontWeight = FontWeight.Bold,
                        )
                        Text(text = "(2024)", fontWeight = FontWeight.SemiBold)
                    }

                }
            }

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 30.dp)
            ) {
                Button(onClick = { /*TODO*/ }) {
                    Text(text = "Previous")
                }
                Button(onClick = { /*TODO*/ }) {
                    Text(text = "Next")
                }
            }
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