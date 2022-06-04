package com.mi23.ddsmappmci.ui.notebook;

import Model.MessageNotebook;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import io.realm.Realm;
import io.realm.RealmConfiguration;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.mi23.ddsmappmci.R;

public class NotebookFragment extends Fragment {

    private NotebookViewModel mViewModel;
    Button btnSave;
    EditText editMessage;
    Realm realm;

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



        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveData();
            }
        });



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


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(NotebookViewModel.class);
        // TODO: Use the ViewModel
    }

}