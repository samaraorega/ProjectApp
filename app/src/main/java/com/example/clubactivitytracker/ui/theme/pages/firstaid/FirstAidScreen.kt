package com.example.clubactivitytracker.ui.theme.pages.firstaid

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
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
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
import com.example.clubactivitytracker.ui.theme.pages.training.Content
import com.example.clubactivitytracker.ui.theme.pages.training.ExpandableCard
import com.example.clubactivitytracker.ui.theme.pages.training.ExpandableContent
import com.example.clubactivitytracker.ui.theme.pages.training.LOREM_TEXT

data class Content(
    val id:Int,
    val title: String,
    val desc: String
)

const val EXPANSION_ANIMATION_DURATION = 300
const val NOSE_BLEED =
    "First sit down,lean forward and firmly pinch the soft part of your nose for about 10 minutes. Ensure to breathe through your mouth."
const val SNAKE_BITE =
    "Wash the bite with soap and water.Keep the area still and lower than the heart.Cover the area to ease swelling and discomfort.Monitor breathing rate and seek out immediate medical assistance."
val contentList = listOf(
    Content(0,"Nose-bleed", NOSE_BLEED),
    Content(1,"Snake-bite ", SNAKE_BITE),)

@Composable
fun FirstAidScreen(navController: NavHostController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "First Aid Skills",
            color = Color.White,
            fontSize = 30.sp,
            fontFamily = FontFamily.Cursive,
            textDecoration = TextDecoration.Underline,
            fontWeight = FontWeight.Bold
        )


        var expandedItem by remember {
            mutableStateOf(-1)
        }

        LazyColumn {
            items(contentList) { content ->
                ExpandableCard(content = content, expanded = expandedItem == content.id,
                    onClickExpanded = { id ->
                        expandedItem = if (expandedItem == id) {
                            -1
                        } else {
                            id
                        }
                    }
                )

            }
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
            animationSpec = tween(com.example.clubactivitytracker.ui.theme.pages.training.EXPANSION_ANIMATION_DURATION)
        ) + fadeIn(initialAlpha = .3f, animationSpec = tween(com.example.clubactivitytracker.ui.theme.pages.training.EXPANSION_ANIMATION_DURATION))
    }
    val exitTransition = remember {
        shrinkVertically (
            shrinkTowards = Alignment.Top,
            animationSpec = tween(com.example.clubactivitytracker.ui.theme.pages.training.EXPANSION_ANIMATION_DURATION)
        ) + fadeOut(animationSpec = tween(com.example.clubactivitytracker.ui.theme.pages.training.EXPANSION_ANIMATION_DURATION))
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
fun FirstAidScreenPreview() {
    ClubActivityTrackerTheme {
        FirstAidScreen(rememberNavController())
    }
}