package org.example.samename1;


import lombok.Data;

@Data
public class SameName {
    private String message = "Это класс SameName из org.example.samename1";

    public void display() {
        System.out.println(message);
    }
}