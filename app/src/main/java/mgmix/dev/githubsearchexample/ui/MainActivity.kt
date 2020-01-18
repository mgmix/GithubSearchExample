package mgmix.dev.githubsearchexample.ui

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.core.view.isVisible
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import mgmix.dev.githubsearchexample.R
import mgmix.dev.githubsearchexample.databinding.ActivityMainBinding
import mgmix.dev.githubsearchexample.databinding.SearchContentsBinding
import mgmix.dev.githubsearchexample.databinding.SearchHeaderBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel by lazy {
        MainViewModel()
    }

    private val mainAdapter by lazy {
        MainListAdapter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.header.setUp()
        binding.contents.setUp()
    }

    private fun SearchHeaderBinding.setUp() {
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {

            var lastQuery = ""

            override fun onQueryTextSubmit(query: String?): Boolean {
                return true
            }

            override fun onQueryTextChange(q: String): Boolean {
                val query = q.trim()

                if (query.length < 3 && lastQuery == query) {
                    return false
                }
                lastQuery = query

                showLoading()
                viewModel.searchUsers(lastQuery,
                    {
                        hideLoading()
                        binding.noItem.isVisible = it.items.isEmpty()
                        mainAdapter.items = it.items
                    },
                    {
                        hideLoading()
                        Toast.makeText(this@MainActivity, it.message, Toast.LENGTH_SHORT).show()
                    }
                )
                return true
            }
        })
    }


    private fun SearchContentsBinding.setUp() {
        with(searchContents) {
            this.layoutManager = LinearLayoutManager(this@MainActivity)
                .apply {
                    this.orientation = LinearLayoutManager.VERTICAL
                }
            this.adapter = mainAdapter
        }
    }

    private fun showLoading() {
        binding.loading.visibility = View.VISIBLE
    }

    private fun hideLoading() {
        binding.loading.visibility = View.GONE
    }

}
