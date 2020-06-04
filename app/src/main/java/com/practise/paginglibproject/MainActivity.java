package com.practise.paginglibproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.paging.PagedList;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Adapter;

public class MainActivity extends AppCompatActivity {


    private PersonViewModel mPersonViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mPersonViewModel = new ViewModelProvider(this,
                new ViewModelProvider.AndroidViewModelFactory(getApplication()))
                .get(PersonViewModel.class);
        final PersonAdapter adapter = new PersonAdapter(new DiffUtil.ItemCallback<Person>() {
            @Override
            public boolean areItemsTheSame(@NonNull Person oldItem, @NonNull Person newItem) {
                return oldItem.getId() == newItem.getId();
            }

            @SuppressLint("DiffUtilEquals")
            @Override
            public boolean areContentsTheSame(@NonNull Person oldItem, @NonNull Person newItem) {
                return oldItem.equals(newItem);
            }
        });
        mPersonViewModel.getPersonLiveData().observe(this, new Observer<PagedList<Person>>() {
            @Override
            public void onChanged(PagedList<Person> people) {
                adapter.submitList(people);

            }
        });



        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view_person);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL,
                false));
        recyclerView.setAdapter(adapter);
    }
}
