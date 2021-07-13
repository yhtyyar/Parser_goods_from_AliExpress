package view;

import controller.GoodsController;
import repository.HttpConnector;
import repository.IOConnector;

import java.util.Scanner;

public class GoodsView {

    private static final Scanner scanner = new Scanner(System.in);
    private boolean interrupt;

    public void getView() {

        System.out.println("Напишите сколько товров вы хотите распарсить (круглое десятичное число или больше)\n" +
                "Если хотите выйти из программы напишите 0");

        while (!interrupt) {

            int console = scanner.nextInt();

            if (console > 0) {

                if (console % 10 == 0) {

                    HttpConnector httpConnector = new HttpConnector();
                    IOConnector ioConnector = new IOConnector();
                    GoodsController goodsController = new GoodsController(httpConnector, ioConnector);
                    goodsController.startParsing(console);

                } else {
                    System.out.println("Ошибка! Вводите круглое десятичное число");
                }

            } else if (console == 0) {

                System.exit(0);
                interrupt = true;

            } else {

                System.out.println("Введите положительное число");
                System.out.println("\n=========================================================\n");
                getView();
            }


        }
    }
}
