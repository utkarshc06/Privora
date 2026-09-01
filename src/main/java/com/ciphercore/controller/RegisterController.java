package com.ciphercore.controller;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import org.json.JSONObject;

import com.ciphercore.dao.UserDAO;
import com.ciphercore.model.User;

public class RegisterController {

    private final String API_KEY =
            "AIzaSyDtZdSWFusLsvWsKgST2qveoWUpX2wZCzw";

    private final UserDAO userDAO = new UserDAO();

    // =====================================================
    // REGISTER USER
    // =====================================================

    public boolean signUp(
            String name,
            String email,
            String mobile,
            String password,
            String role) {

        try {

            // -------------------------------------------------
            // STEP 1: Create Firebase Authentication payload
            // -------------------------------------------------

            JSONObject authPayload = new JSONObject();

            authPayload.put("email", email);
            authPayload.put("password", password);
            authPayload.put("returnSecureToken", true);

            // -------------------------------------------------
            // STEP 2: Create Firebase Authentication account
            // -------------------------------------------------

            HttpClient client =
                    HttpClient.newHttpClient();

            URI authUri =
                    URI.create(
                            "https://identitytoolkit.googleapis.com/v1/accounts:signUp?key="
                                    + API_KEY
                    );

            HttpRequest authRequest =
                    HttpRequest.newBuilder()
                            .uri(authUri)
                            .header(
                                    "Content-Type",
                                    "application/json"
                            )
                            .POST(
                                    HttpRequest.BodyPublishers
                                            .ofString(
                                                    authPayload.toString()
                                            )
                            )
                            .build();

            HttpResponse<String> authResponse =
                    client.send(
                            authRequest,
                            HttpResponse.BodyHandlers.ofString()
                    );

            System.out.println(
                    "Authentication status: "
                            + authResponse.statusCode()
            );

            System.out.println(
                    "Authentication response: "
                            + authResponse.body()
            );

            // -------------------------------------------------
            // STEP 3: Check authentication result
            // -------------------------------------------------

            if (authResponse.statusCode() != 200) {

                System.out.println(
                        "Firebase Authentication registration failed."
                );

                return false;
            }

            // -------------------------------------------------
            // STEP 4: Get Firebase UID
            // -------------------------------------------------

            JSONObject authResult =
                    new JSONObject(
                            authResponse.body()
                    );

            String uid =
                    authResult.getString("localId");

            System.out.println(
                    "Firebase UID: " + uid
            );

            // -------------------------------------------------
            // STEP 5: Create User object
            // -------------------------------------------------

            User user =
                    new User(
                            uid,
                            name,
                            email,
                            mobile,
                            null,
                            role
                    );

            // -------------------------------------------------
            // STEP 6: Save user information to Firestore
            // -------------------------------------------------

            boolean saved =
                    userDAO.saveUser(user);

            if (saved) {

                System.out.println(
                        "User data saved to Firestore."
                );

                System.out.println(
                        "Registered Role: " + role
                );

                return true;
            }

            System.out.println(
                    "Authentication account created, "
                            + "but Firestore data could not be saved."
            );

            return false;

        } catch (Exception e) {

            e.printStackTrace();

            return false;
        }
    }
}