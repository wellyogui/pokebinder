package br.com.well.pokebinder.ui.presentation.common

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import br.com.well.pokebinder.ui.theme.red
import br.com.well.pokebinder.ui.theme.white

@Composable
fun ErrorScreen(modifier: Modifier = Modifier,
                message: String,
                retryAction: () -> Unit) {
    Column(modifier = modifier,
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = message,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                fontStyle = FontStyle.Italic,
                fontSize = 16.sp,
                color = white)
        Button(onClick = retryAction, colors = ButtonDefaults.buttonColors(containerColor = red)) {
            Text(text = "Try Again")
        }
    }
}

@Preview
@Composable
private fun ErrorScreenPreview() {
    ErrorScreen(message = "Erro ao carregar filmes", retryAction = {})
}