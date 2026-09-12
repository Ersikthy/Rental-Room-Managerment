package com.ersikthy.rentalroom.controller.data;

import com.ersikthy.rentalroom.model.Admin;
import com.ersikthy.rentalroom.model.RentalRoom;
import com.ersikthy.rentalroom.model.Tenant;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import static com.ersikthy.rentalroom.controller.log.Output.*;

public class DataManager {
     private DataManager() {
     }

     ;

     public static List<RentalRoom> fetchRooms() {
          Gson gson = new GsonBuilder()
                  .setPrettyPrinting()
                  .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                  .create();
          String fileName = "data/RoomsData.json";
          Type listType = new TypeToken<List<RentalRoom>>() {
          }.getType();
          try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
               List<RentalRoom> roomList = gson.fromJson(reader, listType);
               success("Fetched rooms data successfully!");

               return roomList != null ? roomList : new ArrayList<>();
          } catch (IOException e) {
               e.printStackTrace();
               return new ArrayList<>();
          }
     }

     ;

     public static void saveRooms(ArrayList<RentalRoom> room) {
          Gson gson = new GsonBuilder()
                  .setPrettyPrinting()
                  .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                  .create();

          String fileName = "data/RoomsData.json";

          try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
               gson.toJson(room, writer);
               success("Save data to file " + fileName + " successfully!");
          } catch (IOException e) {
               e.printStackTrace();
          }
     }

     ;

     public static List<Tenant> fetchTenants() {
          Gson gson = new GsonBuilder()
                  .setPrettyPrinting()
                  .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                  .create();
          String fileName = "data/TenantsData.json";
          Type listType = new TypeToken<List<Tenant>>() {
          }.getType();
          try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
               List<Tenant> tenantList = gson.fromJson(reader, listType);
               success("Fetched tenants data successfully!");

               return tenantList != null ? tenantList : new ArrayList<>();
          } catch (IOException e) {
               e.printStackTrace();
               return new ArrayList<>();
          }
     }

     ;

     public static void saveTenants(ArrayList<Tenant> tenant) {
          Gson gson = new GsonBuilder()
                  .setPrettyPrinting()
                  .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                  .create();

          String fileName = "data/TenantsData.json";

          try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
               gson.toJson(tenant, writer);
               success("Save data to file " + fileName + " successfully!");
          } catch (IOException e) {
               e.printStackTrace();
          }
     }

     ;

     public static List<Admin> fetchAdmin() {
          Gson gson = new GsonBuilder()
                  .setPrettyPrinting()
                  .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                  .create();
          String fileName = "data/AdminData.json";
          Type listType = new TypeToken<List<Admin>>() {
          }.getType();
          try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
               List<Admin> adminList = gson.fromJson(reader, listType);
               success("Fetched admin data successfully!");

               return adminList != null ? adminList : new ArrayList<>();
          } catch (IOException e) {
               e.printStackTrace();
               return new ArrayList<>();
          }
     }

     ;

     public static void saveAdmin(ArrayList<Admin> admin) {
          Gson gson = new GsonBuilder()
                  .setPrettyPrinting()
                  .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                  .create();

          String fileName = "data/AdminData.json";

          try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
               gson.toJson(admin, writer);
               success("Save data to file " + fileName + " successfully!");
          } catch (IOException e) {
               e.printStackTrace();
          }
     }

     ;

}
