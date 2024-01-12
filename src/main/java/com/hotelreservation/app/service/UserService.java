package com.hotelreservation.app.service;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;
import com.google.firebase.remoteconfig.User;
import com.hotelreservation.app.entity.Users;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;

@Service
@NoArgsConstructor
public class UserService {
    private static final String COLLECTION_NAME = "users";

    public String saveUser(Users user) throws ExecutionException, InterruptedException {

        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> collectionApiFuture =  dbFirestore.collection(COLLECTION_NAME).document(user.getId().toString()).set(user);

        return collectionApiFuture.get().getUpdateTime().toString();

    }

    public Users getUserDetails(Integer id) throws ExecutionException, InterruptedException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        DocumentReference documentReference =  dbFirestore.collection(COLLECTION_NAME).document(id.toString());

        ApiFuture<DocumentSnapshot> future = documentReference.get();

        DocumentSnapshot document = future.get();

        Users user = null;
        if(document.exists()) {
            user = document.toObject(Users.class);
            return user;
        }
        else {
            return null;
        }

    }

}
