package org.example.Service;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;
import org.example.Entity.Reservations;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;
@Service
public class ReservationService {


    private static final String COLLECTION_NAME = "reservations";

    public String saveReservation(Reservations reservation) throws ExecutionException, InterruptedException {

        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> collectionApiFuture =  dbFirestore.collection(COLLECTION_NAME).document().set(reservation);

        return collectionApiFuture.get().getUpdateTime().toString();

    }
}
