package com.satish.composearticle

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.satish.composearticle.ui.theme.ComposeArticleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeArticleTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
//                    ComposeArticle(
//                        stringResource(id = R.string.article_heading),
//                        stringResource(id = R.string.article_subheading),
//                        stringResource(id = R.string.article_information),
//                        modifier = Modifier.padding(innerPadding)
//                    )
                    TaskManager(taskStatus = stringResource(id = R.string.task_status), compliment = stringResource(
                        id = R.string.task_compliment))
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun ComposeArticlePreview() {
    ComposeArticleTheme {
        ComposeArticle(stringResource(id = R.string.article_heading),
            stringResource(id = R.string.article_subheading),
            stringResource(id = R.string.article_information))
    }
}

@Preview(showBackground = true)
@Composable
fun TaskManagerPreview() {
    ComposeArticleTheme {
        TaskManager(taskStatus = stringResource(id = R.string.task_status), compliment = stringResource(
            id = R.string.task_compliment))
    }
}


@Composable
fun ComposeArticle(heading: String, subHeading: String,information: String, modifier: Modifier = Modifier)  {
    val image = painterResource(id = R.drawable.bg_compose_background)
    val padding = 16.dp
    Column(modifier) {
        Image(
            painter = image,
            contentDescription = null
        )
        Text (
            text = heading,
            fontSize = 24.sp,
            modifier = modifier.padding(padding)
        )
        Text (
            text = subHeading,
            modifier = modifier.padding(start=padding,top=0.dp,end=padding,bottom=0.dp),
            textAlign = TextAlign.Justify
        )
        Text (
            text = information,
            modifier = modifier.padding(padding),
            textAlign = TextAlign.Justify
        )
    }
}

@Composable
fun TaskManager(taskStatus: String, compliment: String, modifier: Modifier = Modifier) {
    val image = painterResource(id = R.drawable.ic_task_completed)
    Column(modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {
        Image (
            painter = image,
            contentDescription = null
        )
        Text(
            text = taskStatus,
            fontWeight = FontWeight.Bold,
            modifier = modifier.padding(0.dp,24.dp,0.dp,8.dp)
        )
        Text (
            text = compliment,
            fontSize = 16.sp
        )
    }
}
