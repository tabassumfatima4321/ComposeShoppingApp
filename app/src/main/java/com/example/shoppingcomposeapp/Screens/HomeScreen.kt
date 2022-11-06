package com.example.shoppingcomposeapp.Screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.shoppingcomposeapp.R
import com.example.shoppingcomposeapp.ui.theme.BackgroundColor

@Composable
fun HomeScreen()
{
    Surface(color= BackgroundColor)
    {
        ConstraintLayout(modifier=Modifier.fillMaxSize())
        {
            val (navigationImage,profileImage)=createRefs()
            Image(painter = painterResource(id = R.drawable.ic_navigation)
            , contentDescription = "navigation_img",
            contentScale = ContentScale.Crop,
            modifier = Modifier.clip(CircleShape)
                .size(50.dp)
                .background(Color.White)
                .border(1.dp,Color.White, CircleShape)
                .constrainAs(navigationImage){
                    top.linkTo(parent.top,10.dp)
                    start.linkTo(parent.start,10.dp)
                }

            )
            Image(painter = painterResource(id = R.drawable.girl)
                , contentDescription = "navigation_img",
                contentScale = ContentScale.Crop,
                modifier = Modifier.clip(CircleShape)
                    .size(50.dp)
                    .background(Color.White)
                    .border(1.dp,Color.White, CircleShape)
                    .constrainAs(profileImage){
                        top.linkTo(parent.top,10.dp)
                        end.linkTo(parent.end,10.dp)
                    }

            )
        }
    }
}
