package mgmix.dev.githubsearchexample.ui

import mgmix.dev.githubsearchexample.data.model.searchUser
import mgmix.dev.githubsearchexample.data.repository.GithubRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel {

    private val repository = GithubRepository()

    fun searchUsers(
        search: String,
        onResponse: (searchUser) -> Unit,
        onFailure: (Throwable) -> Unit
    ) {
        repository.getSearchUsers(search)
            .enqueue(object : Callback<searchUser> {
                override fun onFailure(call: Call<searchUser>, t: Throwable) {
                    onFailure(t)
                }

                override fun onResponse(call: Call<searchUser>, response: Response<searchUser>) {
                    onResponse(response.body() ?: searchUser(false, emptyList(), 0))
                }
            })
    }

}