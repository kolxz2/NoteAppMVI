package com.example.noteapp.presenter.screens.main


import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.noteapp.domain.model.NoteModel
import com.example.noteapp.presenter.items.ErrorItem
import com.example.noteapp.presenter.items.NoteItem
import com.example.noteapp.presenter.items.loadingItem

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun MainScreen(navHostController: NavHostController) {
    val viewModel = hiltViewModel<MainViewModel>()

    val state by viewModel.state.collectAsState()

    when{
        state.isLoading -> {
            Log.d("checkData", "Loading.. ")
            loadingItem()
        }
        state.data.isNotEmpty() ->{
            Log.d("checkData", "Data size ${state.data.size}")
            MainScreenContent(state.data)
        }
        state.error != null ->{
            Log.d("checkData", "Error ${state.error}")
            ErrorItem(state.error){
                viewModel.sendEvent(MainScreenEvent.LoadingData)
            }
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun MainScreenContent(data: List<NoteModel>) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            item {
                Text(
                    text = "My super note",
                    fontSize = 32.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .padding(horizontal = 24.dp)
                        .padding(top = 14.dp)
                )
            }
            items(data){note ->
                NoteItem(note, modifier = Modifier.padding(vertical = 16.dp, horizontal = 18.dp))

            }
        }

    }
}