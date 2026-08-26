package com.ciphercore.controller;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import org.json.JSONObject;

import com.ciphercore.dao.UserDAO;
import com.ciphercore.model.Session;
import com.ciphercore.model.User;

public class LoginController {

    private final String API_KEY =
            "AIzaSyAtOlGblARQPdRvLruFCUqIl1cYZgaRUUs";

    private final UserDAO userDAO = new UserDAO();

    // =====================================================
    // LOGIN
    // =====================================================

    public boolean login(
            String email,
            String password,
            String selectedRole) {

        JSONObject payload = new JSONObject();

        payload.put("email", email);
        payload.put("password", password);
        payload.put("returnSecureToken", true);

        try {

            // -------------------------------------------------
            // STEP 1: Firebase Authentication
            // -------------------------------------------------

            HttpClient client =
                    HttpClient.newHttpClient();

            URI uri =
                    URI.create(
                            "https://identitytoolkit.googleapis.com/v1/accounts:signInWithPassword?key="
                                    + API_KEY
                    );

            HttpRequest request =
                    HttpRequest.newBuilder()
                            .uri(uri)
                            .header(
                                    "Content-Type",
                                    "application/json"
                            )
                            .POST(
                                    HttpRequest.BodyPublishers
                                            .ofString(
                                                    payload.toString()
                                            )
                            )
                            .build();

            HttpResponse<String> response =
                    client.send(
                            request,
                            HttpResponse.BodyHandlers.ofString()
                    );

            System.out.println(
                    "Authentication status: "
                            + response.statusCode()
            );

            System.out.println(
                    "Authentication response: "
                            + response.body()
            );

            // -------------------------------------------------
            // STEP 2: Authentication failed
            // -------------------------------------------------

            if (response.statusCode() != 200) {

                System.out.println(
                        "Invalid email or password."
                );

                return false;
            }

            // -------------------------------------------------
            // STEP 3: Get Firebase UID
            // -------------------------------------------------

            JSONObject result =
                    new JSONObject(
                            response.body()
                    );

            String uid =
                    result.getString("localId");

            System.out.println(
                    "Logged in UID: " + uid
            );

            // -------------------------------------------------
            // STEP 4: Get user from Firestore
            // -------------------------------------------------

            User user =
                    userDAO.getUserById(uid);

            if (user == null) {

                System.out.println(
                        "User data not found in Firestore."
                );

                return false;
            }

            // -------------------------------------------------
            // STEP 5: Check selected role
            // -------------------------------------------------

            if (!user.getRole().equalsIgnoreCase(selectedRole)) {

                System.out.println(
                        "Wrong role selected."
                );

                System.out.println(
                        "Account role: "
                                + user.getRole()
                );

                System.out.println(
                        "Selected role: "
                                + selectedRole
                );

                return false;
            }

            // -------------------------------------------------
            // STEP 6: Create session
            // -------------------------------------------------

            Session session =
                    new Session(
                            user.getUserId(),
                            user.getName(),
                            user.getEmail(),
                            user.getRole()
                    );

            System.out.println(
                    "Login successful."
            );

            System.out.println(
                    "Logged in user: "
                            + session.getName()
            );

            System.out.println(
                    "Role: "
                            + session.getRole()
            );

            return true;

        } catch (Exception e) {

            e.printStackTrace();

            return false;
        }
    }
}