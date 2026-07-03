package org.netology.collectionsFramework;

import java.util.ArrayList;

public class Game {

    ArrayList<Player> registeredPlayers = new ArrayList<>();

    // Метод регистрации игроков
    public void register(Player player) {
        registeredPlayers.add(player);
    }

    // Метод проверки регистрации игрока по его имени
    public Player checkingRegistrationPlayerByName(String playerName) {
        for (Player player : registeredPlayers) {
            if (player.getName().equals(playerName)) {
                return player;
            }
        }
        return null;
    }

    // Метод соревнования между двумя игроками
    public int round(String playerName1, String playerName2) {

        Player player1 = checkingRegistrationPlayerByName(playerName1);
        Player player2 = checkingRegistrationPlayerByName(playerName2);

        if (player1 == null) {
            throw new NotRegisteredException("Игрок с именем " + playerName1 + " - не зарегистрирован!");
        }
        if (player2 == null) {
            throw new NotRegisteredException("Игрок с именем " + playerName2 + " - не зарегистрирован!");
        }
        if (player1.getStrength() > player2.getStrength()) {
            return 1;
        } else if (player1.getStrength() < player2.getStrength()) {
            return 2;
        } else {
            return 0;
        }
    }
}