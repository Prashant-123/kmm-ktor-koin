package data

import io.ktor.client.HttpClient
import io.ktor.client.request.url
import io.ktor.http.HttpMethod
import util.fetch

object Service {
    suspend fun HttpClient.getInternships(page: Int = 1) =
        fetch<InternshipApiModel> {
            url("/json/internships/page-$page")
            method = HttpMethod.Get
        }
}