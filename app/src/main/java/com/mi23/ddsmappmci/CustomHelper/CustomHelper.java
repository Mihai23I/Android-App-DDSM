package com.mi23.ddsmappmci.CustomHelper;

import android.os.Message;
import android.widget.Filter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import Model.MessageNotebook;
import io.realm.Realm;
import io.realm.RealmResults;

public class CustomHelper {
    Realm realm;
    RealmResults<MessageNotebook> message;

    public CustomHelper(Realm realm) {
        this.realm = realm;
    }

    public void selectFromDB(){
        message = realm.where(MessageNotebook.class).findAll();
    }

    public ArrayList<MessageNotebook> justRefresh(){
        ArrayList<MessageNotebook> listMessage = new ArrayList<>();
        for (MessageNotebook m: message){
            listMessage.add(m);
        }
        if (listMessage != null) {
            Collections.reverse(listMessage);
        }
//        ArrayList<MessageNotebook> listMessageFirst10 = new ArrayList<>();
//        for (int i = 0; i < 10; i = i + 1) {
//            listMessageFirst10.add(listMessage.get(i));
//        }
        return listMessage;
    }

    public ArrayList<MessageNotebook> justRefresh(String constraint){
        ArrayList<MessageNotebook> listMessage = new ArrayList<>();

        if (constraint == null || constraint.length() == 0) {
            for (MessageNotebook m: message){
                listMessage.add(m);
            }
        } else {
            String filterPattern = constraint.toString().toLowerCase();

            for (MessageNotebook item : message) {
                if (item.getMessage().toLowerCase().contains(filterPattern)) {
                    listMessage.add(item);
                }
            }
        }

        if (listMessage != null) {
            Collections.reverse(listMessage);
        }

        return listMessage;

//        ArrayList<MessageNotebook> listMessageFirst10 = new ArrayList<>();
//        for (int i = 0; i < 10; i = i + 1) {
//            listMessageFirst10.add(listMessage.get(i));
//        }
    }
}
