package mgmix.dev.githubsearchexample.data.source

import mgmix.dev.githubsearchexample.data.model.searchUser
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface GithubApi {

    @GET("/search/users")
    fun getSearchUser(
        @Query("q") search: String
    ): Call<searchUser>
}