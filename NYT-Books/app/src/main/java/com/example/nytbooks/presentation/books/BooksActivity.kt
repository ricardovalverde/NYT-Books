package com.example.nytbooks.presentation.books

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.nytbooks.R
import com.example.nytbooks.data.model.Book
import kotlinx.android.synthetic.main.activity_books.*
import java.util.*

class BooksActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_books)

        main_toolbar.title = getString(R.string.books_title)
        main_toolbar.setTitleTextColor(resources.getColor(R.color.white))
        setSupportActionBar(main_toolbar)

        with(main_recycler_view) {
            layoutManager = LinearLayoutManager(this@BooksActivity, RecyclerView.VERTICAL, false)
            setHasFixedSize(true)
            adapter = BooksAdapter(getBooks())
        }
    }

    private fun getBooks(): List<Book> {

        val books = ArrayList<Book>()
        for (n in 1..30) {
            books.add((Book("Titulo $n", "Autor $n")))
        }
        return books
    }
}


