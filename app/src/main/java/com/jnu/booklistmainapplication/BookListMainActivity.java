package com.jnu.booklistmainapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class BookListMainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    MyAdapater myAdapater;
    List<Book> books = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycle_view_books);

        getListBooks();

        myAdapater = new MyAdapater();
        recyclerView.setAdapter(myAdapater);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
    }

    class MyAdapater extends RecyclerView.Adapter<MyViewHolder> {
        @NonNull
        @Override
        public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = View.inflate(BookListMainActivity.this, R.layout.item_layout, null);
            MyViewHolder myViewHolder = new MyViewHolder(view);
            return myViewHolder;
        }

        @SuppressLint("UseCompatLoadingForDrawables")
        @Override
        public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
            Book book = books.get(position);
            holder.tv.setText(book.getTitle());
            holder.iv.setImageDrawable(getResources().getDrawable(book.getCoverResourceId()));
        }

        @Override
        public int getItemCount() {
            return books.size();
        }
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tv;
        ImageView iv;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tv = itemView.findViewById(R.id.text_view_book_title);
            iv = itemView.findViewById(R.id.image_view_book_cover);
        }
    }

    public void getListBooks() {
        books.add(new Book("软件项目管理案例教程（第4版）", R.drawable.book_2));
        books.add(new Book("创新工程实践", R.drawable.book_no_name));
        books.add(new Book("信息安全数学基础（第2版）", R.drawable.book_1));
    }
}
class Book{
    public String title;
    public int id;
    public Book(String s, int i) {
        this.title=s;
        this.id=i;
    }
    public String getTitle(){
        return this.title;
    }
    public int getCoverResourceId(){
        return this.id;
    }
}