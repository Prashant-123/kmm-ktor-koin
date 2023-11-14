package domain

import androidx.paging.PagingData
import data.InternshipApiModel
import kotlinx.coroutines.flow.Flow

interface Repository {
    fun streamInternships(): Flow<PagingData<InternshipApiModel.Internship>>
}