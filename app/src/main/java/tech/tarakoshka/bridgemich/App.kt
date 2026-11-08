package tech.tarakoshka.bridgemich

import android.app.Application
import coil.ImageLoader
import io.ktor.client.HttpClient
import io.ktor.client.engine.android.Android
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.serialization.json.Json

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        app = this
    }

    companion object {
        lateinit var app: Application

        val dataStore by lazy { DataStoreManager(app) }
        val client by lazy {
            HttpClient(Android) {
                install(HttpTimeout) {
                    requestTimeoutMillis = 15_000
                }
                install(ContentNegotiation) {
                    // Ignore fields the DTOs don't model. Immich v3 added
                    // fields to its responses (e.g. assets.nextCursor on
                    // search, always present), and ktor's default Json fails
                    // the whole decode on any unknown key, which left the
                    // picker empty. isLenient keeps the old tolerance for
                    // number-vs-string (v3 sends duration as a number).
                    json(Json {
                        ignoreUnknownKeys = true
                        isLenient = true
                        coerceInputValues = true
                    })
                }
                expectSuccess = true
            }
        }
    }
}
