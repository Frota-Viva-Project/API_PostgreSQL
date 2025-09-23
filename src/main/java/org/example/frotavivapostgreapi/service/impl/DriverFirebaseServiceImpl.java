package org.example.frotavivapostgreapi.service.impl;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.Query;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.firebase.cloud.FirestoreClient;
import org.example.frotavivapostgreapi.model.DriverFirebase;
import org.example.frotavivapostgreapi.service.DriverFirebaseService;
import org.springframework.data.repository.query.Param;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class DriverFirebaseServiceImpl implements DriverFirebaseService {
    private static final String COLLECTION_NAME = "driver";

    @Override
    public List<DriverFirebase> getAllDrivers(@Param("enterprise_code") String enterpriseCode) throws ExecutionException, InterruptedException {
        Firestore dbFirestore = FirestoreClient.getFirestore();

        Query query = dbFirestore.collection(COLLECTION_NAME)
                .whereEqualTo("enterprise_code", enterpriseCode);

        ApiFuture<QuerySnapshot> future = query.get();

        List<QueryDocumentSnapshot> documents = future.get().getDocuments();

        List<DriverFirebase> drivers = new ArrayList<>();
        for (QueryDocumentSnapshot document : documents) {
            drivers.add(document.toObject(DriverFirebase.class));
        }

        return drivers;
    }
}
