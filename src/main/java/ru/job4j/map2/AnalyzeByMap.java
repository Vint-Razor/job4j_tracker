package ru.job4j.map2;

import java.util.*;

/**
 * класс для подсчета статистики по аттестатам учеников.
 */
public class AnalyzeByMap {
    /**
     * метод возвращает среднее всех предметов всех учеников
     *
     * @param pupils лист студентов
     * @return double среднее всех оценок
     */
    public static double averageScore(List<Pupil> pupils) {
        int allScore = 0;
        int count = 0;
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                allScore += subject.score();
                count++;
            }
        }
        return allScore / (double) count;
    }

    /**
     * метод вычисляет обший бал по каждому ученику
     *
     * @param pupils список объектов типа Pupil
     * @return Возвращает список из объекта Label (имя ученика и средний балл).
     */
    public static List<Label> averageScoreByPupil(List<Pupil> pupils) {
        List<Label> list = new ArrayList<>();
        for (Pupil pupil : pupils) {
            int score = 0;
            int count = 0;
            for (Subject subject : pupil.subjects()) {
                score += subject.score();
                count++;
            }
            list.add(new Label(pupil.name(), score / (double) count));
        }
        return list;
    }

    /**
     * вычисляет средний балл по каждому предмету.
     *
     * @param pupils список объектов типа Pupil
     * @return Возвращает список из объектов Label (название предмета и средний балл).
     */
    public static List<Label> averageScoreBySubject(List<Pupil> pupils) {
        List<Label> list = new ArrayList<>();
        Map<String, Integer> map = new LinkedHashMap<>();
        int count = 0;
        for (Pupil pupil : pupils) {
            sumSubjScore(pupil, map);
            count++;
        }
        final double finalCount = count;
        map.forEach((k, v) -> list.add(new Label(k, v / finalCount)));
        return list;
    }

    /**
     * возвращает лучшего ученика. Лучшим считается ученик с наибольшим
     * суммарным баллом по всем предметам.
     *
     * @param pupils список объектов типа Pupil
     * @return Возвращает объект Label (имя ученика и суммарный балл).
     */
    public static Label bestStudent(List<Pupil> pupils) {
        List<Label> list = new ArrayList<>();
        for (Pupil pupil : pupils) {
            int score = 0;
            for (Subject subject : pupil.subjects()) {
                score += subject.score();
            }
            list.add(new Label(pupil.name(), score));
        }
        list.sort(Comparator.reverseOrder());
        return list.get(0);
    }

    /**
     * возвращает предмет с наибольшим баллом для всех студентов.
     *
     * @param pupils список объектов типа Pupil
     * @return Возвращает объект Label (имя предмета, сумма баллов
     * каждого ученика по этому предмету).
     */
    public static Label bestSubject(List<Pupil> pupils) {
        List<Label> list = new ArrayList<>();
        Map<String, Integer> map = new LinkedHashMap<>();
        for (Pupil pupil : pupils) {
            sumSubjScore(pupil, map);
        }
        map.forEach((k, v) -> list.add(new Label(k, v)));
        list.sort(Comparator.reverseOrder());
        return list.get(0);
    }

    private static void sumSubjScore(Pupil pupil, Map<String, Integer> map) {
        for (Subject subject : pupil.subjects()) {
            Integer score = map.putIfAbsent(subject.name(), subject.score());
            if (score != null) {
                map.put(subject.name(), subject.score() + score);
            }
        }
    }
}
