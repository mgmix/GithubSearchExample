package mgmix.dev.githubsearchexample.ui

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import mgmix.dev.githubsearchexample.R
import mgmix.dev.githubsearchexample.data.model.Item
import mgmix.dev.githubsearchexample.databinding.ItemUserBinding

class MainListAdapter: RecyclerView.Adapter<MainListAdapter.mainListHolder>() {

    var items: List<Item> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): mainListHolder
    = mainListHolder(DataBindingUtil.inflate(
        LayoutInflater.from(parent.context), R.layout.item_user, parent, false
    ))

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: mainListHolder, position: Int) {
        holder.bind(items[position])
    }


    class mainListHolder(private val binding: ItemUserBinding)
        : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Item) {
            binding.userItem = item
        }
    }

    companion object {
        private const val TAG = "MainListAdatper"
    }
}
