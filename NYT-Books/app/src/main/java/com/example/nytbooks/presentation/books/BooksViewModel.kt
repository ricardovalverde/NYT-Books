package com.example.nytbooks.presentation.books

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.nytbooks.data.ApiService
import com.example.nytbooks.data.model.Book
import com.example.nytbooks.data.response.BookBodyResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class BooksViewModel : ViewModel() {
    val booksLiveData: MutableLiveData<List<Book>> = MutableLiveData();

    fun getBooks() {
        //booksLiveData.value = createFakeBooks()
        ApiService.service.getBooks().enqueue(object : Callback<BookBodyResponse> {
            override fun onResponse(
                call: Call<BookBodyResponse>,
                response: Response<BookBodyResponse>
            ) {
                if (response.isSuccessful) {
                    val listBooks: MutableList<Book> = mutableListOf()

                    response.body()?.let { bookBodyResponse ->
                        for (result in bookBodyResponse.bookResult) {
                            val book = Book(
                                title = result.detailsResponse[0].title,
                                author = result.detailsResponse[0].author,
                                description = result.detailsResponse[0].description
                            )
                            listBooks.add(book)
                        }
                    }

                    booksLiveData.value = listBooks
                }
            }

            override fun onFailure(call: Call<BookBodyResponse>, t: Throwable) {

            }
        })
    }

    /*private fun createFakeBooks(): List<Book> {

        val books = ArrayList<Book>()
        for (n in 1..30) {
            books.add((Book("Titulo $n", "Autor $n")))
        }
        return books
    }*/
}





