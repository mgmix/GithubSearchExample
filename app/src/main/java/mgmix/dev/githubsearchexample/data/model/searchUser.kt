package mgmix.dev.githubsearchexample.data.model


import com.google.gson.annotations.SerializedName

data class searchUser(
    @SerializedName("incomplete_results")
    val incompleteResults: Boolean,
    @SerializedName("items")
    val items: List<Item>,
    @SerializedName("total_count")
    val totalCount: Int
)