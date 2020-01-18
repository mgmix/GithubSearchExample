package mgmix.dev.githubsearchexample.data.repository

import mgmix.dev.githubsearchexample.data.model.searchUser
import mgmix.dev.githubsearchexample.data.source.ApiProvider
import retrofit2.Call

class GithubRepository {

    private val api = ApiProvider.githubApi

    fun getSearchUsers(q: String): Call<searchUser> =
        api.getSearchUser(q)
}