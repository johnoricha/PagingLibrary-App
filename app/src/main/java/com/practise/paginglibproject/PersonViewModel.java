package com.practise.paginglibproject;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.paging.DataSource;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PagedList;

public class PersonViewModel extends AndroidViewModel {

    public LiveData<PagedList<Person>> personLiveData;

    public PersonViewModel(@NonNull Application application) {
        super(application);

        DataSource.Factory<Integer, Person> factory =
                PersonDatabase.getInstance(application).personDao().getAllPaged();

        LivePagedListBuilder<Integer, Person> livePagedListBuilder
                = new LivePagedListBuilder<>(factory, 5);
        this.personLiveData = livePagedListBuilder.build();
    }

    public LiveData<PagedList<Person>> getPersonLiveData() {
        return personLiveData;
    }
}
