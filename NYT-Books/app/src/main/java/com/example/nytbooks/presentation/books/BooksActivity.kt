package com.example.nytbooks.presentation.books

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.nytbooks.R
import com.example.nytbooks.presentation.details.BookDetailsActivity
import kotlinx.android.synthetic.main.activity_books.*
import java.util.*

class BooksActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_books)

        main_toolbar.title = getString(R.string.books_title)
        main_toolbar.setTitleTextColor(resources.getColor(R.color.white))
        setSupportActionBar(main_toolbar)


        val viewModel: BooksViewModel = ViewModelProviders.of(this).get(BooksViewModel::class.java)

        viewModel.booksLiveData.observe(this, androidx.lifecycle.Observer {
            it?.let { books ->
                with(main_recycler_view) {
                    layoutManager =
                        LinearLayoutManager(this@BooksActivity, RecyclerView.VERTICAL, false)
                    setHasFixedSize(true)
                    adapter = BooksAdapter(books) { book ->
                        val intent = BookDetailsActivity.init(
                            this@BooksActivity,
                            book.title,
                            book.description
                        )
                        startActivity(intent)
                    }
                }
            }
        })
        viewModel.getBooks()
    }
}


