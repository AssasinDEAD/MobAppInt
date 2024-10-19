package com.example.testmobile
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicText
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

        }
    }
}

@Composable
fun MyApp() {
    val items = listOf(
        ListItem(
            title = "First Item",

        ),
        ListItem(
            title = "Second Item",

        ),
        ListItem(
            title = "Third Item",
        )
    )

    LazyColumn(
        modifier = Modifier.fillMaxSize().padding(16.dp)
    ) {
        items(items) { item ->
            ListItemView(item)
            Divider(modifier = Modifier.padding(vertical = 8.dp))
        }
    }
}

@Composable
fun ListItemView(item: ListItem) {
    Row(modifier = Modifier.fillMaxWidth()) {
        item.imageUrl?.let {
            Image(
                painter = rememberImagePainter(it),
                contentDescription = null,
                modifier = Modifier.size(60.dp).padding(end = 8.dp),
                contentScale = ContentScale.Crop
            )
        }
        Column {
            Text(text = item.title, style = MaterialTheme.typography.h6)
            Text(text = item.subtitle, style = MaterialTheme.typography.body2)
            Text(text = item.date, style = MaterialTheme.typography.caption)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewMyApp() {
    YourAppTheme {
        MyApp()
    }
}
