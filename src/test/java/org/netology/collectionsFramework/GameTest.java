package org.netology.collectionsFramework;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameTest {

    @Test
    public void shouldWinPlayer1() {

        Game arbitrator = new Game();

        Player p1 = new Player(4, "Саб Зеро", 10);
        Player p2 = new Player(6, "Ермак", 8);
        Player p3 = new Player(1, "Скорпион", 10);
        Player p4 = new Player(5, "Рептилия", 9);
        Player p5 = new Player(2, "Смок", 7);
        Player p6 = new Player(3, "Рейн", 6);

        arbitrator.register(p1);
        arbitrator.register(p2);
        arbitrator.register(p3);
        arbitrator.register(p4);
        arbitrator.register(p5);
        arbitrator.register(p6);

        int expected = 1;
        int actual = arbitrator.round("Скорпион", "Рептилия");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldWinPlayer2() {

        Game arbitrator = new Game();

        Player p1 = new Player(4, "Саб Зеро", 10);
        Player p2 = new Player(6, "Ермак", 8);
        Player p3 = new Player(1, "Скорпион", 10);
        Player p4 = new Player(5, "Рептилия", 9);
        Player p5 = new Player(2, "Смок", 7);
        Player p6 = new Player(3, "Рейн", 6);

        arbitrator.register(p1);
        arbitrator.register(p2);
        arbitrator.register(p3);
        arbitrator.register(p4);
        arbitrator.register(p5);
        arbitrator.register(p6);

        int expected = 2;
        int actual = arbitrator.round("Смок", "Рептилия");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldDraw() {

        Game arbitrator = new Game();

        Player p1 = new Player(4, "Саб Зеро", 10);
        Player p2 = new Player(6, "Ермак", 8);
        Player p3 = new Player(1, "Скорпион", 10);
        Player p4 = new Player(5, "Рептилия", 9);
        Player p5 = new Player(2, "Смок", 7);
        Player p6 = new Player(3, "Рейн", 6);

        arbitrator.register(p1);
        arbitrator.register(p2);
        arbitrator.register(p3);
        arbitrator.register(p4);
        arbitrator.register(p5);
        arbitrator.register(p6);

        int expected = 0;
        int actual = arbitrator.round("Скорпион", "Саб Зеро");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldBePlayer1Unregistered() {

        Game arbitrator = new Game();

        Player p1 = new Player(4, "Саб Зеро", 10);
        Player p2 = new Player(6, "Ермак", 8);
        Player p3 = new Player(1, "Скорпион", 10);
        Player p4 = new Player(5, "Рептилия", 9);
        Player p5 = new Player(2, "Смок", 7);
        Player p6 = new Player(3, "Рейн", 6);

        arbitrator.register(p1);
        arbitrator.register(p2);
        arbitrator.register(p3);
        arbitrator.register(p4);
        arbitrator.register(p5);
        //arbitrator.register(p6); - не зарегистрирован

        NotRegisteredException exception = Assertions.assertThrows(NotRegisteredException.class, () -> arbitrator.round("Рейн", "Ермак"));

        String expected = "Игрок с именем Рейн - не зарегистрирован!";
        String actual = exception.getMessage();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldBePlayer2Unregistered() {

        Game arbitrator = new Game();

        Player p1 = new Player(4, "Саб Зеро", 10);
        Player p2 = new Player(6, "Ермак", 8);
        Player p3 = new Player(1, "Скорпион", 10);
        Player p4 = new Player(5, "Рептилия", 9);
        Player p5 = new Player(2, "Смок", 7);
        Player p6 = new Player(3, "Рейн", 6);

        arbitrator.register(p1);
        //arbitrator.register(p2); - не зарегистрирован
        arbitrator.register(p3);
        arbitrator.register(p4);
        arbitrator.register(p5);
        arbitrator.register(p6);

        NotRegisteredException exception = Assertions.assertThrows(NotRegisteredException.class, () -> arbitrator.round("Рейн", "Ермак"));

        String expected = "Игрок с именем Ермак - не зарегистрирован!";
        String actual = exception.getMessage();

        Assertions.assertEquals(expected, actual);
    }
}
