package dev.jahir.frames.ui.activities.base

import androidx.lifecycle.ViewModelProvider
import dev.jahir.frames.data.models.Wallpaper
import dev.jahir.frames.data.viewmodels.WallpapersDataViewModel

abstract class BaseFavoritesConnectedActivity : BaseSystemUIVisibilityActivity() {

    internal val wallpapersViewModel: WallpapersDataViewModel by lazy {
        ViewModelProvider(this).get(WallpapersDataViewModel::class.java)
    }

    internal fun addToFavorites(wallpaper: Wallpaper) {
        wallpapersViewModel.addToFavorites(this, wallpaper)
    }

    internal fun removeFromFavorites(wallpaper: Wallpaper) {
        wallpapersViewModel.removeFromFavorites(this, wallpaper)
    }

    override fun onDestroy() {
        super.onDestroy()
        wallpapersViewModel.destroy(this)
    }

    internal fun reloadData() {
        try {
            wallpapersViewModel.loadData(this)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}