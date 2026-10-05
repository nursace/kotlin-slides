package kg.iuca.myfirstandroidproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {

            // sp - scale-independent pixels
            // dp - density-independent pixels dpi - dots per inch

            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .background(color = Color.Yellow),

                verticalArrangement = Arrangement.Bottom,

            ) {
                Text(
                    modifier = Modifier
                        .background(color = Color.Blue)
                        .padding(15.dp)
                        .width(100.dp),
                    text = "Hello, World!",
                    color = Color.Red,
                    fontWeight = FontWeight.Bold,
                    fontSize = 24.sp
                )
            }

        }

    }

}