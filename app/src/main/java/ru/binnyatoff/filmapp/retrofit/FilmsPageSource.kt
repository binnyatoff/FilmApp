package ru.binnyatoff.filmapp.retrofit

import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState
import retrofit2.HttpException
import ru.binnyatoff.filmapp.Constants
import ru.binnyatoff.filmapp.models.Films

class FilmsPageSource (private val filmService: FilmService) : PagingSource<Int, Films>() {
    override fun getRefreshKey(state: PagingState<Int, Films>): Int? {
        val anchorPosition = state.anchorPosition ?: return null
        val page = state.closestPageToPosition(anchorPosition) ?: return null
        return page.prevKey?.plus(Constants.PAGE_SIZE) ?: page.nextKey?.minus(Constants.PAGE_SIZE)
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Films> {
        try {
            val page: Int = params.key ?: 0
            val pageSize = Constants.PAGE_SIZE
            val response = filmService.getFilms(api_key = Constants.API_KEY, offset = page)

            if (response.isSuccessful) {
                val results = checkNotNull(response.body()).results

                val nextKey = if (results.size < pageSize) null else page + Constants.PAGE_SIZE
                val prevKey = if (page == 0) null else page - Constants.PAGE_SIZE
                Log.e("TAG", "is Succeful, $nextKey $prevKey $page $results")

                return LoadResult.Page(results, nextKey = nextKey, prevKey = prevKey)
            } else {
                return LoadResult.Error(HttpException(response))
            }
        } catch (e: Exception) {
            Log.e("TAG", "$e")
            return LoadResult.Error(e)
        }
    }
}
