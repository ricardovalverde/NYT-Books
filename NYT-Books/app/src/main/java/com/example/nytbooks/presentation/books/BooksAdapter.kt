package com.example.nytbooks.presentation.books

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.nytbooks.R
import com.example.nytbooks.data.model.Book
import kotlinx.android.synthetic.main.item_book.view.*

class BooksAdapter(val list_books: List<Book>) : RecyclerView.Adapter<BooksViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BooksViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_book, parent, false)
        return BooksViewHolder(view)
    }

    override fun onBindViewHolder(holder: BooksViewHolder, position: Int) {
        holder.bind(list_books[position])
    }

    override fun getItemCount() = list_books.count()
}

class BooksViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {


    private val title = itemView.title_book
    private val author = itemView.author_book

    fun bind(book: Book) {
        title.text = book.title
        author.text = book.author
    }
}
