package com.ciphercore.config;

import java.io.InputStream;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;

public class DatabaseConfig {

    // =========================================================
    // FIREBASE INITIALIZATION
    // =========================================================

    static {

        getFirebaseConfig();

    }

    // =========================================================
    // GET FIREBASE CONFIG
    // =========================================================

    private static void getFirebaseConfig() {

        try {

            System.out.println(
                    "Starting Firebase initialization..."
            );

            // =================================================
            // LOAD java26.json FROM RESOURCES
            // =================================================

            InputStream serviceAccount =
                    DatabaseConfig.class
                            .getClassLoader()
                            .getResourceAsStream(
                                    "java26.json"
                            );

            // =================================================
            // CHECK FILE
            // =================================================

            if (serviceAccount == null) {

                throw new RuntimeException(
                        "java26.json not found! " +
                        "Put java26.json inside " +
                        "src/main/resources/"
                );
            }

            System.out.println(
                    "java26.json found."
            );

            // =================================================
            // FIREBASE OPTIONS
            // =================================================

            FirebaseOptions options =
                    new FirebaseOptions.Builder()
                            .setCredentials(
                                    GoogleCredentials.fromStream(
                                            serviceAccount
                                    )
                            )
                            .build();

            // =================================================
            // INITIALIZE FIREBASE
            // =================================================

            if (FirebaseApp.getApps().isEmpty()) {

                FirebaseApp.initializeApp(
                        options
                );

                System.out.println(
                        "Firebase initialized successfully."
                );

            } else {

                System.out.println(
                        "Firebase already initialized."
                );
            }

        } catch (Exception e) {

            System.out.println(
                    "Firebase initialization failed!"
            );

            e.printStackTrace();
        }
    }

    // =========================================================
    // GET FIRESTORE
    // =========================================================

    public static Firestore getFirestore() {

        return FirestoreClient.getFirestore();

    }
}