// Подумать над структурой класса Ноутбук для магазина техники - выделить поля и методы. Реализовать в java.
// Создать множество ноутбуков.
// Написать метод, который будет запрашивать у пользователя критерий (или критерии) фильтрации и выведет ноутбуки,
//  отвечающие фильтру. Критерии фильтрации можно хранить в Map. 
//  Например:
//  “Введите цифру, соответствующую необходимому критерию:	
//     1 - ОЗУ
// 	2 - Объем ЖД
// 	3 - Операционная система
// 	4 - Цвет …
// Далее нужно запросить минимальные значения для указанных критериев -
//  сохранить параметры фильтрации можно также в Map.
// Отфильтровать ноутбуки их первоначального множества и вывести проходящие по условиям.

package HW;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

;

public class Task1 {
    public static void main(String[] args) {

        Nout firstNout = new Nout("Gamer Xtreme VR Gaming PC", "CYBERPOWERPC",
                LocalDate.of(2019, 9, 1), 8, 1024,
                " Intel", "Core i5-9400F", " Nvidia",
                "GeForce GTX 1660", 6, "Windows 10 Home", "Black");

        Nout secondNout = new Nout("Pro Gaming PC (253i)", "iBUYPOWER",
                LocalDate.of(2022, 2, 17), 8, 480,
                " Intel", "Core i3-10105F", " AMD",
                "Radeon RX 6500XT", 4, "Windows 11 Home", "Black RGB");

        Nout thirdNout = new Nout("Element 9260", "iBUYPOWER",
                LocalDate.of(2019, 7, 19), 16, 1024,
                " Intel", "Core i7-9700F", " Nvidia",
                "GeForce GTX 1660 Ti", 6, "Windows 10 Home", "Black");

        Nout forthNout = new Nout("Pro Gaming PC (281i)", "iBUYPOWER",
                LocalDate.of(2022, 4, 8), 16, 500,
                " AMD", "Ryzen 5 5600G", " Nvidia",
                "Geforce RTX 3060", 12, "Windows 11 Home", "Black RGB");

        Scanner myScanner = new Scanner(System.in);
        Set<Nout> computers = new HashSet<>();
        Set<Nout> computersFil = new HashSet<>();

        Map<String, Object> filterdComp = new HashMap<>();

        computers.add(firstNout);
        computers.add(secondNout);
        computers.add(thirdNout);
        computers.add(forthNout);

        int menu;
        char menuOut = 's';

        while (menuOut == 's')

        {
            System.out.println();
            System.out.println("Выбирите вариант из меню: \n"
                    + "1. Показать все копмьютеры в наличии;\n" + "2. Отфильтровать компьютеры по параметрам;\n"
                    + "3. Закрыть программу;\n");
            System.out.print("-> ");
            menu = myScanner.nextInt();
            if (menu == 1)
                System.out.println(computers);
            else if (menu == 2) {
                filterdComp = filterParameters(computers);
                computersFil.addAll(filter(filterdComp, computers));
                System.out.println(computersFil);

            } else if (menu == 3)
                menuOut = 'o';
            else
                System.out.println("Вы ошиблись при выборе пункта меню, попробуйте заново.");
        }
        myScanner.close();
    }

    public static Map<String, Object> filterParameters(Set<Nout> myComputers) {

        Map<String, Object> tempFilterdComp = new HashMap<>();
        Scanner myScanner = new Scanner(System.in);
        String temp1;

        System.out.println("Введите параметры для фильтра: ");

        System.out.print("1. Введите дату позднее которой был производен комьютер,\n" +
                "в следующем формате [dd.MM.yyyy] или 0 чтоб пропустить: ");
        temp1 = myScanner.next();
        if (!temp1.equals("0")) {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy");
            LocalDate date = LocalDate.parse(temp1, dtf);
            tempFilterdComp.put("date ", date.format(dtf));
            temp1 = "1";
        }

        System.out.printf("2. Введите желаемый размер оперативной памяти (в GB) или 0 чтоб пропустить: ");
        Integer RAMSize = myScanner.nextInt();
        tempFilterdComp.put("RAM Size ", RAMSize);

        System.out.printf("3. Введите желаемый размер жесткого диска (в GB) или 0 чтоб пропустить: ");
        Integer hardDriveSize = myScanner.nextInt();
        tempFilterdComp.put("Hard drive size ", hardDriveSize);

        System.out.printf(
                "4. Выбирите производителя Центрального процессора (1- Intel, 2 - AMD) или 0 чтоб пропустить: ");
        Integer CPUManufacturer = myScanner.nextInt();
        if (CPUManufacturer != 0) {
            if (CPUManufacturer == 1)
                tempFilterdComp.put("CPU Manufacturer ", " Intel");
            else
                tempFilterdComp.put("CPU Manufacturer ", " AMD");
        }

        System.out.printf("5. Выбирите производителя видеокарты (1- Nvidia, 2 - AMD) или 0 чтоб пропустить: ");
        Integer GPUManufacturer = myScanner.nextInt();
        if (GPUManufacturer != 0) {
            if (GPUManufacturer == 1)
                tempFilterdComp.put("GPU Manufacturer ", " Nvidia");
            else
                tempFilterdComp.put("GPU Manufacturer ", " AMD");
        }

        System.out.printf("6. Введите желаемый размер  оперативной памяти видекарты (в GB) или 0 чтоб пропустить: ");
        Integer GPUMemorySize = myScanner.nextInt();
        tempFilterdComp.put("GPU Memory Size ", GPUMemorySize);

        return tempFilterdComp;
    }

    public static Set<Nout> filter(Map<String, Object> filterdCompNew, Set<Nout> computers) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        LocalDate tempDate = LocalDate.parse("01.01.2000", dtf);
        Set<Nout> computersNew = new HashSet<>();
        Integer tempRAMSize = Integer.parseInt(String.valueOf(filterdCompNew.get("RAM Size ")));
        Integer tempHDSize = Integer.parseInt(String.valueOf(filterdCompNew.get("Hard drive size ")));
        Integer tempGPUSize = Integer.parseInt(String.valueOf(filterdCompNew.get("GPU Memory Size ")));

        if (filterdCompNew.containsKey("date ")) {
            tempDate = LocalDate.parse((String.valueOf(filterdCompNew.get("date "))), dtf);
        }

        for (Nout nout : computers) {
            if (filterdCompNew.containsKey("CPU Manufacturer ") && filterdCompNew.containsKey("GPU Manufacturer ")) {
                if ((nout.getRAMSize().equals(tempRAMSize) || nout.getRAMSize() > tempRAMSize)
                        && (nout.getDateOfManufacture().equals(tempDate)
                                || nout.getDateOfManufacture().isAfter(tempDate))
                        && (nout.getHardDriveCapacity().equals(tempHDSize) || nout.getHardDriveCapacity().MAX_VALUE > tempHDSize)
                        && (nout.getHardDriveCapacity().equals(tempGPUSize)
                                || nout.getHardDriveCapacity().MAX_VALUE > tempGPUSize)
                        && (nout.getCPUManufacturer().equals(filterdCompNew.get("CPU Manufacturer ")))
                        && (nout.getGPUManufacturer().equals(filterdCompNew.get("GPU Manufacturer ")))) {

                    computersNew.add(nout);
                    System.out.println("1111");
                }
            } else if (!filterdCompNew.containsKey("CPU Manufacturer ") && filterdCompNew.containsKey("GPU Manufacturer ")) {
                if ((nout.getRAMSize().equals(tempRAMSize) || nout.getRAMSize().MAX_VALUE > tempRAMSize)
                        && (nout.getDateOfManufacture().equals(tempDate)
                                || nout.getDateOfManufacture().isAfter(tempDate))
                        && (nout.getHardDriveCapacity().equals(tempHDSize)
                                || nout.getHardDriveCapacity().MAX_VALUE > tempHDSize)
                        && (nout.getHardDriveCapacity().equals(tempGPUSize)
                                || nout.getHardDriveCapacity().MAX_VALUE > tempGPUSize)
                        && (nout.getGPUManufacturer().equals(filterdCompNew.get("GPU Manufacturer ")))) {

                    computersNew.add(nout);
                }
            } else if (!filterdCompNew.containsKey("GPU Manufacturer ")&& filterdCompNew.containsKey("CPU Manufacturer ")) {
                if ((nout.getRAMSize().equals(tempRAMSize) || nout.getRAMSize().MAX_VALUE > tempRAMSize)
                        && (nout.getDateOfManufacture().equals(tempDate)
                                || nout.getDateOfManufacture().isAfter(tempDate))
                        && (nout.getHardDriveCapacity().equals(tempHDSize)
                                || nout.getHardDriveCapacity().MAX_VALUE > tempHDSize)
                        && (nout.getHardDriveCapacity().equals(tempGPUSize)
                                || nout.getHardDriveCapacity().MAX_VALUE > tempGPUSize)
                        && (nout.getCPUManufacturer().equals(filterdCompNew.get("CPU Manufacturer ")))) {

                    computersNew.add(nout);
                    
                }
            } else {
                if ((nout.getRAMSize().equals(tempRAMSize) || nout.getRAMSize() > tempRAMSize)
                        && (nout.getDateOfManufacture().equals(tempDate)
                                || nout.getDateOfManufacture().isAfter(tempDate))
                        && (nout.getHardDriveCapacity().equals(tempHDSize)
                                || nout.getHardDriveCapacity()> tempHDSize)
                        && (nout.getHardDriveCapacity().equals(tempGPUSize)
                                || nout.getHardDriveCapacity() > tempGPUSize)) {
                    computersNew.add(nout);
                   
                }
            }

        }

        return computersNew;
    }

}
