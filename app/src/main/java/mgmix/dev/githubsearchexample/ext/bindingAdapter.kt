package mgmix.dev.githubsearchexample.ext

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

@BindingAdapter("setAvatar")
fun setAvatar(view: ImageView, url: String) {
    Glide.with(view.context)
        .load(url)
        .into(view)
}