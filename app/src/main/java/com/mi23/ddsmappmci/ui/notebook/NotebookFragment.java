package com.mi23.ddsmappmci.ui.notebook;

import Model.MessageNotebook;
import androidx.appcompat.widget.SearchView;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import io.realm.Realm;
import io.realm.RealmChangeListener;
import io.realm.RealmConfiguration;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.mi23.ddsmappmci.CustomAdapter.CustomAdapter;
import com.mi23.ddsmappmci.CustomAdapter.CustomRecycleAdapter;
import com.mi23.ddsmappmci.CustomHelper.CustomHelper;
import com.mi23.ddsmappmci.R;

public class NotebookFragment extends Fragment {

    private NotebookViewModel mViewModel;
    Button btnSave;
    EditText editMessage;
    Realm realm;
    RecyclerView recycleNotebook;
//    ListView listNotebook;
    CustomHelper helper;
    SearchView actionSearch;
    RealmChangeListener realmChangeListener;

    public static NotebookFragment newInstance() {
        return new NotebookFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Realm.init(getActivity());
        RealmConfiguration configuration = new RealmConfiguration.Builder().name("Realmdata.realm").build();
        Realm.setDefaultConfiguration(configuration);

        realm = Realm.getDefaultInstance();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.notebook_fragment, container, false);
        btnSave = view.findViewById(R.id.btnSave);
        editMessage = view.findViewById(R.id.editMessage);
        editMessage.clearFocus();
//        listNotebook = view.findViewById(R.id.listNotebook);
        recycleNotebook = view.findViewById(R.id.recycleNotebook);
        actionSearch = view.findViewById(R.id.actionSearch);
        actionSearch.clearFocus();
        actionSearch.setImeOptions(EditorInfo.IME_ACTION_DONE);


        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveData();
            }
        });

        helper = new CustomHelper(realm);
        helper.selectFromDB();

//        CustomAdapter adapter = new CustomAdapter(getActivity(), helper.justRefresh());
//        listNotebook.setAdapter(adapter);

        CustomRecycleAdapter adapter = new CustomRecycleAdapter(getActivity(), helper.justRefresh());

        recycleNotebook.setLayoutManager(new LinearLayoutManager(getActivity()));
        recycleNotebook.setAdapter(adapter);

        actionSearch.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                CustomRecycleAdapter adapter = new CustomRecycleAdapter(getActivity(), helper.justRefresh(newText));

                recycleNotebook.setLayoutManager(new LinearLayoutManager(getActivity()));
                recycleNotebook.setAdapter(adapter);
                return false;
            }
        });

        Refresh();

        return view;
    }

    private void saveData(){
        realm.executeTransactionAsync(new Realm.Transaction() {
            @Override
            public void execute(Realm bgRealm) {
                Number maxId = bgRealm.where(MessageNotebook.class).max("message_id");

                int newKey = (maxId == null) ? 1 : maxId.intValue()+1;

                MessageNotebook message = bgRealm.createObject(MessageNotebook.class, newKey);
                message.setMessage(editMessage.getText().toString());
            }
        }, new Realm.Transaction.OnSuccess() {
            @Override
            public void onSuccess() {
                Toast.makeText(getActivity(), "Success", Toast.LENGTH_LONG).show();
            }
        }, new Realm.Transaction.OnError() {
            @Override
            public void onError(Throwable error) {
                Toast.makeText(getActivity(), "Fail", Toast.LENGTH_LONG).show();
            }
        });
    }

    private void Refresh(){
        realmChangeListener = new RealmChangeListener(){
            @Override
            public void onChange(Object o){
//                CustomAdapter adapter;
//                adapter = new CustomAdapter(getActivity(), helper.justRefresh());
//                listNotebook.setAdapter(adapter);
                CustomRecycleAdapter adapter = new CustomRecycleAdapter(getActivity(), helper.justRefresh());
                recycleNotebook.setAdapter(adapter);
            }
        };
        realm.addChangeListener(realmChangeListener);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        realm.removeChangeListener(realmChangeListener);
        realm.close();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(NotebookViewModel.class);
        // TODO: Use the ViewModel
    }

}