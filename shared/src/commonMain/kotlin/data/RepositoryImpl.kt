package data

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import data.Service.getInternships
import domain.Repository
import domain.ResultPagingSource
import io.ktor.client.HttpClient
import kotlinx.coroutines.flow.Flow
import util.map

class RepositoryImpl(private val apiService: HttpClient) : Repository {
    override fun streamInternships(): Flow<PagingData<InternshipApiModel.Internship>> = Pager(
        config = PagingConfig(
            pageSize = 10,
            initialLoadSize = 10,
            enablePlaceholders = false,
        ),
        pagingSourceFactory = {
            ResultPagingSource { page, _ ->
                apiService.getInternships(page).map { it.internshipsMeta.values.toList() }
            }
        }
    ).flow
}