

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.font.FontWeight

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { App() }
    }
}

@Composable
fun App() {
    MaterialTheme(colorScheme = darkColorScheme()) {
        Surface(Modifier.fillMaxSize()) { HomeScreen() }
    }
}

@Composable
fun HomeScreen() {
    var trFunny by remember { mutableStateOf(true) }
    var enFunny by remember { mutableStateOf(false) }
    Column(
        Modifier.fillMaxSize().padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp, Alignment.CenterVertically)
    ) {
        Text("HoloViral", fontSize = 28.sp, fontWeight = FontWeight.Bold)
        Text("Video Seç → Oluştur → Paylaş")
        Row(verticalAlignment = Alignment.CenterVertically) {
            Checkbox(trFunny, onCheckedChange = { trFunny = it })
            Text("Türkçe Komik Dublaj")
        }
        Row(verticalAlignment = Alignment.CenterVertically) {
            Checkbox(enFunny, onCheckedChange = { enFunny = it })
            Text("İngilizce Komik Dublaj")
        }
        Button(onClick = { /* Sonraki adımda eklenecek */ }) {
            Text("Video Seç ve Oluştur")
        }
        Text("Bu ilk derleme testidir.", fontSize = 12.sp)
    }
}
