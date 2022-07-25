package ru.job4j.map2;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AnalyzeByMap {
    /**
     * метод возвращает среднее всех предметов всех учеников
     *
     * @param pupils - лист студентов
     * @return - double среднее всех оценок
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

    public static List<Label> averageScoreByPupil(List<Pupil> pupils) {
        List<Label> list = new ArrayList<>();
        for (Pupil pupil : pupils) {
            int allScore = 0;
            int count = 0;
            for (Subject subject : pupil.subjects()) {
                allScore += subject.score();
                count++;
            }
            list.add(new Label(pupil.name(), allScore / (double) count));
        }
        return list;
    }

    public static List<Label> averageScoreBySubject(List<Pupil> pupils) {
        List<Label> list = new ArrayList<>();
        pupils.stream()
                .map(Pupil::subjects).forEach(subjects ->
                        subjects.stream().collect(Collectors.toMap(Subject::name, Subject::score))
                );
        return list;
    }

    public static Label bestStudent(List<Pupil> pupils) {
        return null;
    }

    public static Label bestSubject(List<Pupil> pupils) {
        return null;
    }
}
