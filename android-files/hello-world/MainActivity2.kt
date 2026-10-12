package kg.iuca.myfirstandroidproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {

            val text = "Hello, World!".filter { it.isLetter() }

            val firstRow = text.take(5) // Hello
            val secondRow = text.takeLast(5) // World

            val words = listOf(firstRow, secondRow)

            // sp - scale-independent pixels
            // dp - density-independent pixels dpi - dots per inch

            Column(
                modifier = Modifier
                    .padding(top = 48.dp)
                    .fillMaxWidth()
                    .background(Color.Magenta)
                    .padding(8.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp),
                horizontalAlignment = Alignment.CenterHorizontally,

                ) {
                words.forEach { word ->
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(8.dp),
                    ) {
                        word
                            .forEach {
                                Box(
                                    modifier = Modifier
                                        .background(color = Color.Green)
                                        .weight(1f)
                                        .aspectRatio(1f),
                                    contentAlignment = Alignment.Center,
                                ) {
                                    Text(
                                        text = it.toString(),
                                        textAlign = TextAlign.Center,
                                        color = Color.Blue,
                                        fontWeight = FontWeight.Bold,
                                        fontSize = 20.sp
                                    )
                                }
                            }
                    }
                }
            }
        }
    }
}