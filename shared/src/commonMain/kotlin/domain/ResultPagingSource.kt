package domain

import androidx.paging.PagingSource
import androidx.paging.PagingState
import util.Result

open class ResultPagingSource<T : Any>(private val fetch: suspend (page: Int, pageSize: Int) -> Result<List<T>>) :
    PagingSource<Int, T>() {

    override fun getRefreshKey(state: PagingState<Int, T>): Int? = null

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, T> =
        (params.key ?: 1).let { _page ->
            try {
                fetch(_page, params.loadSize)
                    .run {
                        when (this) {
                            /* success state */
                            is Result.Success -> {
                                LoadResult.Page(
                                    data = value,
                                    /* no previous pagination int as page */
                                    prevKey = _page.takeIf { it > 1 }?.dec(),
                                    /* no pagination if no results found else next page as +1 */
                                    nextKey = _page.takeIf { value.size >= params.loadSize }?.inc()
                                )
                            }

                            /* error state */
                            is Error -> LoadResult.Error(this)

                            /* should not reach this point */
                            else -> LoadResult.Error(IllegalStateException("$this type of [Result] is not allowed here"))
                        }
                    }
            } catch (e: Exception) {
                LoadResult.Error(e)
            }
        }
}