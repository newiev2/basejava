package com.bulavin.webapp.model;

import java.util.ArrayList;
import java.util.List;

public class ResumeTestData {

    public static void main(String[] args) {
        Resume resume = new Resume("Grigory Kislin");

        String phone = "Phone: +7(921) 855-0482";
        String skype = "skype: grigory.kislin";
        String email = "email: gkislin@yandex.ru";
        String linkedIn = "linkedIn";
        String gitHub = "GitHub";
        String stackOverflow = "StackOverflow";

        resume.setContact(ContactType.PHONE, phone);
        resume.setContact(ContactType.SKYPE, skype);
        resume.setContact(ContactType.EMAIL, email);
        resume.setContact(ContactType.LINKEDIN, linkedIn);
        resume.setContact(ContactType.GITHUB, gitHub);
        resume.setContact(ContactType.STACKOVERFLOW, stackOverflow);

        System.out.println("CONTACTS:");
        for (ContactType type: ContactType.values()) {
            System.out.println(resume.getContact(type));
        }

        Section objective = new TextSection("Objective",
                "Ведущий стажировок и корпоративного обучения по Java Web и Enterprise технологиям");

        Section personal = new TextSection("Personal",
                "Аналитический склад ума, сильная логика, креативность, инициативность. Пурист кода и архитектуры.");


        List<String> achievementsList = new ArrayList<>();
        achievementsList.add("Организация команды и успешная реализация Java проектов для сторонних заказчиков: приложения " +
                "автопарк на стеке Spring Cloud/микросервисы, система мониторинга показателей спортсменов на Spring " +
                "Boot, участие в проекте МЭШ на Play-2, многомодульный Spring Boot + Vaadin проект для комплексных " +
                "DIY смет");
        achievementsList.add("С 2013 года: разработка проектов \"Разработка Web приложения\",\"Java Enterprise\", " +
                "\"Многомодульный maven. Многопоточность. XML (JAXB/StAX). Веб сервисы (JAX-RS/SOAP). Удаленное " +
                "взаимодействие (JMS/AKKA)\". Организация онлайн стажировок и ведение проектов. Более 3500 " +
                "выпускников.");

        Section achievements = new ListSection("Achievements", achievementsList);

        List<String> qualificationsList = new ArrayList<>();
        qualificationsList.add("JEE AS: GlassFish (v2.1, v3), OC4J, JBoss, Tomcat, Jetty, WebLogic, WSO2");
        qualificationsList.add("DB: PostgreSQL(наследование, pgplsql, PL/Python), Redis (Jedis), H2, Oracle, MySQL, SQLite, MS " +
                "SQL, HSQLDB");

        Section qualification = new ListSection("Qualification", qualificationsList);

        List<Period> periods1 = new ArrayList<>();
        periods1.add(new Period("2020-01-01", "2020-02-01", "Manager", "123"));
        periods1.add(new Period("2020-03-01", "2020-04-01", "Developer", "456"));

        List<Period> periods2 = new ArrayList<>();
        periods2.add(new Period("2021-01-01", "2021-02-01", "Backend developer", "123"));
        periods2.add(new Period("2021-03-01", "2021-04-01", "Frontend developer", "456"));

        List<Company> companies1 = new ArrayList<>();
        companies1.add(new Company("Wrike", "www.wrike.com", periods1));
        companies1.add(new Company("Yota", "www.yota.ru", periods2));

        Section experience = new CompanySection("Experience", companies1);

        List<Period> periods3 = new ArrayList<>();
        periods3.add(new Period("2019-01-01", "2019-02-01", null, "'Functional " +
                "Programming Principles in Scala' by Martin Odersky"));

        List<Period> periods4 = new ArrayList<>();
        periods4.add(new Period("2018-01-01", "2018-02-01", null, "Курс " +
                "'Объектно-ориентированный анализ ИС. Концептуальное моделирование на UML.'"));

        List<Company> companies2 = new ArrayList<>();
        companies2.add(new Company("Coursera", "www.coursera.org", periods3));
        companies2.add(new Company("Luxoft", "www.luxoft.ru", periods4));

        Section education = new CompanySection("Education", companies2);

        resume.setSection(SectionType.OBJECTIVE, objective);
        resume.setSection(SectionType.PERSONAL, personal);
        resume.setSection(SectionType.ACHIEVEMENT, achievements);
        resume.setSection(SectionType.QUALIFICATIONS, qualification);
        resume.setSection(SectionType.EXPERIENCE, experience);
        resume.setSection(SectionType.EDUCATION, education);

        System.out.println("SECTIONS:");
        for (SectionType type : SectionType.values()) {
            System.out.println(resume.getSection(type));
        }
    }
}
