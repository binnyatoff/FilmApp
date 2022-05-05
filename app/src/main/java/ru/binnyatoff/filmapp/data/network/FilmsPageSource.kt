package ru.binnyatoff.filmapp.data.network

import androidx.paging.PagingSource
import androidx.paging.PagingState
import retrofit2.HttpException
import ru.binnyatoff.filmapp.BuildConfig
import ru.binnyatoff.filmapp.Films
import ru.binnyatoff.filmapp.toFilms
import java.io.IOException

class FilmsPageSource (private val filmService: FilmService) : PagingSource<Int, Films>() {
    override fun getRefreshKey(state: PagingState<Int, Films>): Int? {
        val anchorPosition = state.anchorPosition ?: return null
        val page = state.closestPageToPosition(anchorPosition) ?: return null
        return page.prevKey?.plus(PAGE_SIZE) ?: page.nextKey?.minus(PAGE_SIZE)
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Films> {
        try {
            val page: Int = params.key ?: 0
            val pageSize = PAGE_SIZE
            val response = filmService.getFilms(api_key = BuildConfig.API_KEY, offset = page)

            return if (response.isSuccessful) {
               // val results = checkNotNull(response.body()).results
                val results = checkNotNull(response.body()).results.map{
                    it.toFilms()
                }
                val nextKey = if (results.size < pageSize) null else page + PAGE_SIZE
                val prevKey = if (page == 0) null else page - PAGE_SIZE
                LoadResult.Page(results, nextKey = nextKey, prevKey = prevKey)
            } else {
                LoadResult.Error(HttpException(response))
            }
        } catch (exception: IOException) {
            return LoadResult.Error(exception)
        } catch (exception: HttpException) {
            return LoadResult.Error(exception)
        }
    }
    companion object {
        const val PAGE_SIZE = 20
    }
}
