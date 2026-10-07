import java.util.Scanner;

public class Main {
        static Scanner scanner = new Scanner(System.in);

        public static void main(String[] args) {
            task_1();
            task_2();
            task_3();
            task_4();
            task_5();
        }

        static void task_1(){
            // таблица косинусов
            System.out.println("Задание №1 Таблица косинусов");
            for (int x = 0; x <= 90; x += 5) {
                double y = Math.cos(Math.toRadians(x));

                System.out.printf("cos(%d) = %.4f%n", x, y);
            }
        }

        static void task_2(){
            System.out.println("Задание №2 Значение выражения");
            System.out.print("Введите вещественное число X: ");
            double x = scanner.nextDouble();

            System.out.print("Введите целое число N (N > 0): ");
            int n = scanner.nextInt();

            double sum = 0.0;
            double term = x;

            for (int i = 0; i <= n; i++) {
                sum += term;
                // Вычисление следующего члена ряда по рекуррентной формуле:
                term = term * (-1 * x * x) / ((2 * i + 2) * (2 * i + 3));
            }

            System.out.println("Значение выражения: " + sum);
        }
        static void task_3(){
            System.out.println("Задание №3 Наличие цифры 2 в числе");
            System.out.print("Введите целое число N (N > 0): ");
            int n = scanner.nextInt();

            if (n <= 0) {
                System.out.println("N должно быть > 0");
                return;
            }

            while (n > 0) {
                int r = n % 10;
                if (r == 2) {
                    System.out.println("В числе есть цифра 2");
                    return;
                }
                n /= 10;
            }
            System.out.println(("В числе нет цифры 2"));
        }

        static void task_4(){
            System.out.println("Задание №4 Характеристика числа");
            System.out.print("Введите целое число: ");

            int a = scanner.nextInt();
            if (a > 0) {
                System.out.print(1);
            }
            if (a == 0) {
                System.out.print(0);
            } else {
               System.out.println(-1);
            }
        }

        static void task_5() {
            System.out.println("Задание №5 Меню");
            boolean isRunning = true;

            while (isRunning) {
                System.out.println("\n--- Главное меню ---");
                System.out.println("1. Выполнить расчёт");
                System.out.println("2. Информация о программе");
                System.out.println("3. Информация о разработчике");
                System.out.println("4. Выход");
                System.out.print("Выберите пункт меню: ");

                if (scanner.hasNextInt()) {
                    int choice = scanner.nextInt();
                    switch (choice) {
                        case 1 -> Calc(scanner);
                        case 2 -> printInformation();
                        case 3 -> printAbout();
                        case 4 -> {
                            System.out.println("Выход из программы. До свидания!");
                            isRunning = false;
                        }
                        default -> System.out.println("Неверный пункт меню. Пожалуйста, выберите от 1 до 4.");
            }
        } else {
                    System.out.println("Ошибка: пожалуйста, введите число (1-4).");
                    scanner.next();
                }
            }
            scanner.close();
        }

        public static void printInformation() {
            System.out.println("\n--- О программе ---");
            System.out.println("Привет, ты похоже решил положить деньги на вклад? Мы тебе поможем!");
            System.out.println("Это программа считает сложный процент для вкладов.");
            System.out.println("В конце ты получишь итоговую сумму денег, которая накопится к концу расчетного периода!");
        }

        public static void printAbout() {
            System.out.println("\n--- О разработчиках ---");
            System.out.println("Разработчики: Ефимов Дмитрий, Бабушкин Евгений, Кравченко Владислава.");
        }

        // Метод для расчёта вклада
        public static void Calc(Scanner scanner) {
            System.out.println("\n--- Расчёт вклада ---");

            double P = getValidInput(scanner, "Введите начальную сумму инвестиций:", "Сумма не может быть отрицательной!", true);
            double r = getValidInput(scanner, "Введите годовую процентную ставку (в десятичной дроби):", "Процентная ставка не может быть отрицательной!", true);
            double n = getValidInput(scanner, "Введите количество начислений процентов в год:", "Количество начислений должно быть строго больше 0!", false);
            double t = getValidInput(scanner, "Введите срок размещения вклада или инвестиций в годах:", "Срок вклада должен быть строго больше 0!", false);

            double A = P * Math.pow((1 + r / n), n * t);

            // Округляем вывод до 2 знаков после запятой для красоты
            System.out.printf("Ваши накопления через %.2f лет: %.2f\n", t, A);
        }

        public static double getValidInput(Scanner scanner, String prompt, String errorMessage, boolean allowZero) {
            while (true) {
                System.out.println(prompt);
                if (scanner.hasNextDouble()) {
                    double value = scanner.nextDouble();
                    // Если allowZero = true, то число должно быть >= 0
                    // Если allowZero = false, то число должно быть > 0
                    if (allowZero) {
                        if (value >= 0) {
                            return value;
                        }
                    } else {
                        if (value > 0) {
                            return value;
                        }
                    }
                    System.out.println(errorMessage);
                } else {
                    System.out.println("Ошибка: введите корректное число!");
                    scanner.next(); // Очистка буфера сканера
                }
            }
        }
    }
