package com.example.nytbooks.presentation.books

import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.nytbooks.R
import com.example.nytbooks.presentation.base.BaseActivity
import com.example.nytbooks.presentation.details.BookDetailsActivity
import kotlinx.android.synthetic.main.activity_books.*
import kotlinx.android.synthetic.main.include_toolbar.*
import java.util.*

open class BooksActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_books)

        setupToolbar(main_toolbar, R.string.books)

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
        viewModel.viewFlipperLiveData.observe(this, androidx.lifecycle.Observer {
            it?.let { viewFlipper ->
                main_view_flipper.displayedChild = viewFlipper.first

                viewFlipper.second?.let { errorMessageId ->
                    text_view_error.text = getString(errorMessageId)
                }
            }
        })
        viewModel.getBooks()
    }
}


