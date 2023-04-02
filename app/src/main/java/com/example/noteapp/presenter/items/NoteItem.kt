package com.example.noteapp.presenter.items

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.noteapp.domain.model.NoteModel
import com.example.noteapp.presenter.theme.NoteAppTheme
import java.time.LocalDate
import java.util.Random

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun NoteItem(
    noteModel: NoteModel,
    modifier: Modifier
) {
    val color = Color(
        Random().nextInt(256),
        Random().nextInt(256),
        Random().nextInt(256),
        alpha = 30
    )
    Box(modifier = modifier) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(10.dp))
                .background(color)
                .padding(vertical = 16.dp, horizontal = 24.dp)
        ) {
            Column {
                Text(
                    text = noteModel.title,
                    fontSize = 23.sp,
                    fontWeight = FontWeight.Bold,
                )
                Text(
                    text = noteModel.subtitle,
                    fontSize = 16.sp,
                    modifier = Modifier
                        .padding(top = 24.dp)
                )

                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    Text(
                        text = noteModel.author,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Light,
                        modifier = Modifier
                            .padding(top = 24.dp)
                    )
                    Text(
                        text = "${noteModel.date.dayOfMonth} ${noteModel.date.month}".lowercase(),
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Light,
                        modifier = Modifier
                            .padding(top = 24.dp)
                    )
                }
            }
        }
    }
}


@RequiresApi(Build.VERSION_CODES.O)
@Preview(showBackground = true)
@Composable
fun NoteItemPreview() {
    val item = NoteModel(
        id = 1,
        title = "Note 1",
        subtitle = "Subtitle for note 1",
        date = LocalDate.now(),
        author = "Author"
    )
    NoteAppTheme {
        NoteItem(item, modifier = Modifier.padding(vertical = 8.dp, horizontal = 16.dp))
    }
}