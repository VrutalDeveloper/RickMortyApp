package tech.vrutal.core.binding

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import coil.load

@BindingAdapter("bindImage")
fun loadImageUrl(view: ImageView, imageUrl: String) {
    view.load(imageUrl)
}