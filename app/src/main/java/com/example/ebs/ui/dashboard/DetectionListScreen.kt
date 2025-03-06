package com.example.ebs.ui.dashboard

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.ebs.ui.AppViewModelProvider
import com.example.ebs.ui.navigation.NavigationHandler
import dev.chrisbanes.haze.HazeState
import dev.chrisbanes.haze.materials.ExperimentalHazeMaterialsApi

@OptIn(ExperimentalMaterial3Api::class, ExperimentalHazeMaterialsApi::class)
@Composable
fun DetectionListScreen(
    navHandler: NavigationHandler,
    hazeState: HazeState,
    viewModel: DetectionListViewModel = viewModel(factory = AppViewModelProvider.Factory)
) {
//    when (detectionListUiState) {
//        is MarsUiState.Loading -> LoadingScreen(modifier = modifier.fillMaxSize())
//        is MarsUiState.Success -> PhotosGridScreen(marsUiState.photos, modifier)
//        else -> ErrorScreen(retryAction, modifier = modifier.fillMaxSize())
//    }
}
//
//@Composable
//fun LoadingScreen(modifier: Modifier = Modifier) {
//    Image(
//        modifier = modifier.size(200.dp),
//        painter = painterResource(R.drawable.loading_img),
//        contentDescription = stringResource(R.string.loading)
//    )
//}
//
//@Composable
//fun ErrorScreen(retryAction: () -> Unit, modifier: Modifier = Modifier) {
//    Column(
//        modifier = modifier,
//        verticalArrangement = Arrangement.Center,
//        horizontalAlignment = Alignment.CenterHorizontally
//    ) {
//        Image(
//            painter = painterResource(id = R.drawable.ic_connection_error), contentDescription = ""
//        )
//        Text(text = stringResource(R.string.loading_failed), modifier = Modifier.padding(16.dp))
//        Button(onClick = retryAction) {
//            Text(stringResource(R.string.retry))
//        }
//    }
//}
//
//@Composable
//fun ResultScreen(photos: String, modifier: Modifier = Modifier) {
//    Box(
//        contentAlignment = Alignment.Center,
//        modifier = modifier
//    ) {
//        Text(text = photos)
//    }
//}
//
//
//@Composable
//fun MarsPhotoCard(photo: MarsPhoto, modifier: Modifier = Modifier) {
//    Card(
//        modifier = modifier,
//        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
//    ) {
//        AsyncImage(
//            model = ImageRequest.Builder(context = LocalContext.current)
//                .data(photo.imgSrc)
//                .crossfade(true)
//                .build(),
//            error = painterResource(R.drawable.ic_broken_image),
//            placeholder = painterResource(R.drawable.loading_img),
//            contentDescription = stringResource(R.string.mars_photo),
//            contentScale = ContentScale.Crop,
//            modifier = Modifier.fillMaxWidth()
//        )
//    }
//}
//
//@Composable
//fun PhotosGridScreen(
//    photos: List<MarsPhoto>,
//    modifier: Modifier = Modifier,
//    contentPadding: PaddingValues = PaddingValues(0.dp),
//) {
//    LazyVerticalGrid(
//        columns = GridCells.Adaptive(150.dp),
//        modifier = modifier.padding(horizontal = 4.dp),
//        contentPadding = contentPadding,
//    ) {
//        items(items = photos, key = { photo -> photo.id }) {
//                photo ->
//            MarsPhotoCard(
//                photo,
//                modifier = modifier
//                    .padding(4.dp)
//                    .fillMaxWidth()
//                    .aspectRatio(1.5f)
//            )
//        }
//    }
//}