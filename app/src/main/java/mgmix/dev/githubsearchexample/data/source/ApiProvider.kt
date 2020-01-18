package mgmix.dev.githubsearchexample.data.source

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiProvider {

    private val gson =
        GsonBuilder()
            .setLenient()
            .create()

    private val provideGithubApi by lazy {
        Retrofit.Builder()
            .baseUrl("https://api.github.com")
            .client(provideOkHttp.build())
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    }


    private val provideOkHttp
    = OkHttpClient.Builder()
        .addInterceptor(HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        })


    val githubApi: GithubApi by lazy {
        provideGithubApi.create(GithubApi::class.java)
    }


//        .addInterceptor {
//            val requestHeader = it.request().newBuilder()
//                .header("Accept", "application/vnd.github.v3+json")
//            it.proceed(requestHeader.build())
//        }



}