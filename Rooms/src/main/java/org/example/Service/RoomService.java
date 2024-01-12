package org.example.Service;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import com.google.firebase.cloud.FirestoreClient;
import org.example.Entity.Rooms;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
@Service
public class RoomService {

    private static final String COLLECTION_NAME = "rooms";

    public List<Rooms> getAllRooms() throws ExecutionException, InterruptedException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        CollectionReference roomsCollection = dbFirestore.collection(COLLECTION_NAME);

        ApiFuture<QuerySnapshot> future = roomsCollection.get();

        List<Rooms> roomsList = new ArrayList<>();

        for (QueryDocumentSnapshot document : future.get().getDocuments()) {
            Rooms room = document.toObject(Rooms.class);
            roomsList.add(room);
        }

        return roomsList;
    }


    public Rooms getRoomDetails(Integer id) throws ExecutionException, InterruptedException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        DocumentReference documentReference =  dbFirestore.collection(COLLECTION_NAME).document(id.toString());

        ApiFuture<DocumentSnapshot> future = documentReference.get();

        DocumentSnapshot document = future.get();

        Rooms room = null;
        if(document.exists()) {
            room = document.toObject(Rooms.class);
            return room;
        }
        else {
            return null;
        }

    }
}
