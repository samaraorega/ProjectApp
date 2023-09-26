@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.clubactivitytracker.ui.theme.pages.training

import android.icu.text.CaseMap.Title
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateColor
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.tween
import androidx.compose.animation.core.updateTransition
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.clubactivitytracker.ui.theme.ClubActivityTrackerTheme

data class Content(
    val id:Int,
    val title: String,
    val desc: String
)

const val EXPANSION_ANIMATION_DURATION = 300
const val LOREM_TEXT =
    "3.00pm to 7.00pm"
const val REST =
    "Relax,you earned it"
val contentList = listOf(
    Content(0,"Monday", LOREM_TEXT),
    Content(1,"Tuesday ", LOREM_TEXT),
    Content(2,"Wednesday ", LOREM_TEXT),
    Content(3,"Thursday ", LOREM_TEXT),
    Content(4,"Friday ", LOREM_TEXT),
    Content(4,"Saturday ", REST),
    Content(4,"Sunday ", REST),
)
@Composable
fun TrainingScreen(navController: NavHostController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Next Week's Schedule",
            color = Color.White,
            fontSize = 30.sp,
            fontFamily = FontFamily.Monospace,
            textDecoration = TextDecoration.Underline,
            fontWeight = FontWeight.Bold
        )
    }

    var expandedItem by remember {
        mutableStateOf(-1)
    }
    
    LazyColumn{
        items(contentList){content ->
            ExpandableCard(content = content, expanded = expandedItem== content.id,
                onClickExpanded = {id ->
                    expandedItem = if (expandedItem == id){
                        -1
                    }else{
                        id
                    }
                }
            )

        }
    }


}

@Composable
fun ExpandableCard(
    content: Content,
    expanded:Boolean,
    onClickExpanded:(id:Int) -> Unit
) {

    val transition = updateTransition(targetState = expanded, label = "trans")
    val iconRotationDeg by
            transition.animateFloat(label = "icon change") {state ->
                if (state){
                    0f
                }else{
                    180f
                }
            }

    val color by transition.animateColor(label = "color change") { state ->
        if (state){
            Color.Black.copy(.4f)
        }else{
            MaterialTheme.colorScheme.surface
        }
    }

    Card(){
        Column(modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)) {
            Row (modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp), horizontalArrangement = Arrangement.SpaceBetween){
                Text(text = content.title)
                Icon(imageVector = Icons.Default.KeyboardArrowUp,
                    contentDescription = null,
                    modifier = Modifier
                        .rotate(iconRotationDeg)
                        .clickable {
                            onClickExpanded(content.id)
                        }
                )
                Spacer(modifier = Modifier.size(16.dp))
                ExpandableContent(isExpanded = expanded, desc = content.desc)

            }

        }

    }

}

@Composable
fun ExpandableContent(
    isExpanded:Boolean,
    desc: String
) {
    val enterTransition = remember {
        expandVertically(
            expandFrom = Alignment.Top,
            animationSpec = tween(EXPANSION_ANIMATION_DURATION)
        ) + fadeIn(initialAlpha = .3f, animationSpec = tween(EXPANSION_ANIMATION_DURATION))
    }
    val exitTransition = remember {
        shrinkVertically (
            shrinkTowards = Alignment.Top,
            animationSpec = tween(EXPANSION_ANIMATION_DURATION)
        ) + fadeOut(animationSpec = tween(EXPANSION_ANIMATION_DURATION))
    }
    AnimatedVisibility(
        visible = isExpanded,
        enter = enterTransition,
        exit = exitTransition) {
        Text(text = desc, textAlign = TextAlign.Justify)
        
    }
    
}






@Preview
@Composable
fun TrainingScreenPreview() {
    ClubActivityTrackerTheme {
        TrainingScreen(rememberNavController())
    }
}

